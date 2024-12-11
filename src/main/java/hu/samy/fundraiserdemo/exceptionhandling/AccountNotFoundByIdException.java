package hu.samy.fundraiserdemo.exceptionhandling;

public class AccountNotFoundByIdException extends RuntimeException {
    private Long accountId;

    public AccountNotFoundByIdException(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
