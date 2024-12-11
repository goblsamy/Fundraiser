package hu.progmasters.fundraiserdemo.service;

import hu.progmasters.fundraiserdemo.domain.Account;
import hu.progmasters.fundraiserdemo.domain.Transfer;
import hu.progmasters.fundraiserdemo.dto.TargetAccountOption;
import hu.progmasters.fundraiserdemo.dto.TransferCreateCommand;
import hu.progmasters.fundraiserdemo.dto.TransferInitData;
import hu.progmasters.fundraiserdemo.dto.TransferListItem;
import hu.progmasters.fundraiserdemo.exceptionhandling.InsufficientCreditException;
import hu.progmasters.fundraiserdemo.repository.TransferRepository;
import hu.progmasters.fundraiserdemo.util.TransferListItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransferService {

    private TransferRepository transferRepository;
    private AccountService accountService;

    @Autowired
    public TransferService(TransferRepository transferRepository, AccountService accountService) {
        this.transferRepository = transferRepository;
        this.accountService = accountService;
    }

    public List<TransferListItem> getAllTransfers() {
        return transferRepository.findAll().stream()
                .map(TransferListItemMapper::transferListItemMap)
                .collect(Collectors.toList());
    }

    public TransferInitData getNewTransferData(String remoteAddr) {
        Account account = accountService.findByIpAddress(remoteAddr);
        List<TargetAccountOption> targetAccountOptions = accountService.getAllAccountsExceptMine(remoteAddr).stream()
                .map(TargetAccountOption::new)
                .collect(Collectors.toList());
        return new TransferInitData(account.getUsername(), targetAccountOptions, account.getBalance());
    }

    public void saveTransfer(TransferCreateCommand command, String remoteAddr) {
        Account source = accountService.findByIpAddress(remoteAddr);
        Account target = accountService.getAccountById(command.getTarget());

        if (command.getAmount() <= source.getBalance() && command.getAmount() >= 50 && command.getAmount() <= 1000) {
            Transfer transfer = new Transfer();
            transfer.setAmount(command.getAmount());
            transfer.setSource(source);
            transfer.setTarget(target);
            transfer.setTimestamp(LocalDateTime.now());

            source.setBalance(source.getBalance() - command.getAmount());
            target.setBalance(target.getBalance() + command.getAmount());

            transferRepository.save(transfer);

        } else {
             throw new InsufficientCreditException(source.getBalance());
        }
    }
}
