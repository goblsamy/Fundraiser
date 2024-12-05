package hu.progmasters.fundraiserdemo.util;

import hu.progmasters.fundraiserdemo.domain.Account;
import hu.progmasters.fundraiserdemo.dto.AccountRegistrationCommand;

import static hu.progmasters.fundraiserdemo.util.AccountUtils.ACCOUNT_BASIC_BALANCE;
import static hu.progmasters.fundraiserdemo.util.AccountUtils.ACCOUNT_BASIC_FUND;

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
