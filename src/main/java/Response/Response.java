package Response;

import java.nio.charset.StandardCharsets;

public class Response {

    public byte[] HTTPResponse() {
        String response = "HTTP/1.1 200 OK\r\n\r\n";
        return response.getBytes(StandardCharsets.UTF_8);
    }

    public byte[] HTTPResponse(String body,int statusCode,String statusText) {
        String statusLine = "HTTP/1.1 " + statusCode + " " + statusText + "\r\n" ;
        String contentType =  "Content-Type: text/plain\r\n" +
                "Content-Length: " + body.getBytes(StandardCharsets.UTF_8).length + "\r\n" +
                "\r\n" + body;

        String finalConstructedMessage = statusLine + contentType;
        return finalConstructedMessage.getBytes(StandardCharsets.UTF_8);
    }
}
