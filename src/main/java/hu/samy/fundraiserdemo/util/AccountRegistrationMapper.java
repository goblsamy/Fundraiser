package hu.samy.fundraiserdemo.util;

import hu.samy.fundraiserdemo.domain.Account;
import hu.samy.fundraiserdemo.dto.AccountRegistrationCommand;

import static hu.samy.fundraiserdemo.util.AccountUtils.ACCOUNT_BASIC_BALANCE;
import static hu.samy.fundraiserdemo.util.AccountUtils.ACCOUNT_BASIC_FUND;

public class AccountRegistrationMapper {

    public static Account mapAccount(AccountRegistrationCommand command, String ipAddress) {
        Account account = new Account();
        account.setUsername(command.getUsername());
        account.setGoal(command.getGoal());
        account.setFunds(ACCOUNT_BASIC_FUND);
        account.setBalance(ACCOUNT_BASIC_BALANCE);
        account.setIpAddress(ipAddress);
        return account;

    }
}
