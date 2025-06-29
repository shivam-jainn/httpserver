package Request.Headers;

import Utils.Constants;

public class Host {
    private String address;
    private int port;

    // Constructor
    public Host(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public void printHost() {
        System.out.println("Host: " + address + ":" + port);
    }

    public String getHostString() {
        return "Host: " + address + ":" + port + Constants.CRLF;
    }

}
