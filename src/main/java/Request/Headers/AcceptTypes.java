package Request.Headers;

public enum AcceptTypes {
    WILDCARD("*/*"),
    JSON("application/json"),
    HTML("text/html"),
    XML("application/xml");

    private final String mimeType;

    AcceptTypes(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }
}
