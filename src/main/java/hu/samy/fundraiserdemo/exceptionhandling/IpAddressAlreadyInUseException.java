package hu.samy.fundraiserdemo.exceptionhandling;

public class IpAddressAlreadyInUseException extends RuntimeException {

    private String ipAddress;

    public IpAddressAlreadyInUseException(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
