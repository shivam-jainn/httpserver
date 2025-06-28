public class Response {
    public byte[] HTTPResponse(){
        String response = "HTTP/1.1 200 OK\r\n\r\n";
        return response.getBytes();
    }
}
