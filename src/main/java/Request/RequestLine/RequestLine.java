package Request.RequestLine;

public class RequestLine {
    private HTTPMethod httpMethod;
    private String URLPath;
    private String HTTPVersion;

    public RequestLine(HTTPMethod httpMethod,String URLPath,String HTTPVersion){
        this.httpMethod = httpMethod;
        this.URLPath = URLPath;
        this.HTTPVersion = HTTPVersion;
    }

    public String getURLPath() {
        return URLPath;
    }
}
