package Response;

import java.nio.charset.StandardCharsets;

public class Response {
    public byte[] HTTPResponse() {
        String response = "HTTP/1.1 200 OK\r\n\r\n";
        return response.getBytes(StandardCharsets.UTF_8);
    }

    public byte[] HTTPResponse(String message) {
        return message.getBytes(StandardCharsets.UTF_8);
    }
}
