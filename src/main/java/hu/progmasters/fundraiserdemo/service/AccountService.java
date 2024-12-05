package hu.progmasters.fundraiserdemo.service;

import hu.progmasters.fundraiserdemo.domain.Account;
import hu.progmasters.fundraiserdemo.dto.AccountDetails;
import hu.progmasters.fundraiserdemo.dto.AccountRegistrationCommand;
import hu.progmasters.fundraiserdemo.dto.TargetAccountOption;
import hu.progmasters.fundraiserdemo.exceptionhandling.AccountNotFoundByIpAddressException;
import hu.progmasters.fundraiserdemo.exceptionhandling.IpAddressAlreadyInUseException;
import hu.progmasters.fundraiserdemo.repository.AccountRepository;

import hu.progmasters.fundraiserdemo.util.AccountDetailsMapper;
import hu.progmasters.fundraiserdemo.util.AccountRegistrationMapper;
import hu.progmasters.fundraiserdemo.util.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void saveAccount(AccountRegistrationCommand command, String ipAddress) {
        if (accountRepository.ipAddressIsExists(ipAddress)) {
            throw new IpAddressAlreadyInUseException(ipAddress);
        } else {
            Account account = AccountRegistrationMapper.mapAccount(command, ipAddress);
            accountRepository.save(account);
        }
    }

    public AccountDetails getMyAccount(String ipAddress) {
        return AccountDetailsMapper.accountDetailsMapper(findByIpAddress(ipAddress));
    }

    public Account findByIpAddress(String ipAddress) {
        Optional<Account> accountOptional = accountRepository.findByIpAddress(ipAddress);
        if (accountOptional.isEmpty()) {
            throw new AccountNotFoundByIpAddressException(ipAddress);
        }
        return accountOptional.get();
    }

    public List<AccountDetails> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountDetailsMapper::accountDetailsMapper).collect(Collectors.toList());
    }


    public List<Account> getAllAccountsExceptMine(String remoteAddr) {
        return accountRepository.getAllAccountsExceptMine(remoteAddr);
    }
}
