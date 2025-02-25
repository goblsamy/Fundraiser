package hu.samy.fundraiserdemo.util;

import hu.samy.fundraiserdemo.domain.Account;
import hu.samy.fundraiserdemo.dto.AccountDetails;

import java.util.stream.Collectors;

public class AccountDetailsMapper {

    public static AccountDetails accountDetailsMapper(Account account) {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setId(account.getId());
        accountDetails.setUsername(account.getUsername());
        accountDetails.setFund(account.getFunds());
        accountDetails.setBalance(account.getBalance());
        accountDetails.setGoal(account.getGoal());
        accountDetails.setOutgoingTransfers(account.getOutgoingTransfers().stream()
                .map(TransferListItemMapper::transferListItemMap).collect(Collectors.toList()));
        accountDetails.setIncomingTransfers(account.getIncomingTransfers().stream()
                .map(TransferListItemMapper::transferListItemMap).collect(Collectors.toList()));
        return accountDetails;
    }
}
