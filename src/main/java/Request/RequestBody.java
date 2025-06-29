package Request;

import Request.Headers.Headers;
import Request.RequestLine.RequestLine;

import java.util.Optional;

public class RequestBody {
    private Headers headersBody;
    private RequestLine requestLine;
    private Optional<Object> requestBody;
    public  RequestBody(RequestLine requestLine, Headers headers, Optional<Object> requestBody){
        this.headersBody = headers;
        this.requestLine = requestLine;
        this.requestBody = requestBody;
    }
}
