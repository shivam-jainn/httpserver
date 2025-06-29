package Request.Headers;

public class Headers {
    private Host host;
    private UserAgent userAgent;
    private Accept accept;

    public Headers(Host host,UserAgent userAgent,Accept mimeType){
        this.host = host;
        this.userAgent = userAgent;
        this.accept = mimeType;
    }

    public String printHeaders(){
        return host.getHostString() + userAgent.getUserAgent() +  accept.printAccept();
    }
}
