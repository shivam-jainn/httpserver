package Request.RequestLine;

public class HTTPMethod {
    private HTTPMethodTypes httpMethod;

    public HTTPMethod(HTTPMethodTypes httpMethod){
        this.httpMethod = httpMethod;
    }

    public String getHTTPMethod(){
        return this.httpMethod.name();
    }

    public void printHTTPMethod(){
        System.out.println(httpMethod.name());
    }
}
