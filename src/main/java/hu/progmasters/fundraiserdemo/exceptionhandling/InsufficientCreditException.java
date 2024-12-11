package hu.progmasters.fundraiserdemo.exceptionhandling;


public class InsufficientCreditException extends RuntimeException {

    private Integer amount;

    public InsufficientCreditException(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

}
