package hu.progmasters.fundraiserdemo.exceptionhandling;

public class AccountNotFoundByIpAddressException extends RuntimeException {

    private final String ipAddress;

    public AccountNotFoundByIpAddressException(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
