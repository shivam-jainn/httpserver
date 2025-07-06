import Parsers.Parser;
import Parsers.RequestParser;
import Request.RequestBody;
import Router.Router;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.rmi.server.ExportException;

public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

    // Uncomment this block to pass the first stage

    try {
      ServerSocket serverSocket = new ServerSocket(4221);
    

      // Since the tester restarts your program quite often, setting SO_REUSEADDR
      // ensures that we don't run into 'Address already in use' errors
      serverSocket.setReuseAddress(true);

      while(true){
        try(Socket clientSocket = serverSocket.accept()){
          System.out.println("accepted new connection");

          InputStream inputStream = clientSocket.getInputStream();
          Parser<RequestBody> requestParser = new RequestParser();
          BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
          StringBuilder sb = new StringBuilder();
          String line;
          while ((line = reader.readLine()) != null && !line.isEmpty()) {
            sb.append(line).append("\r\n");
          }
          String requestString = sb.toString();
          RequestBody request = requestParser.parse(requestString);
          Router router = new Router();

          byte[] http_response  = router.routing(request.getRequestLine().getURLPath());

          OutputStream output = clientSocket.getOutputStream();

          output.write(http_response);

          output.flush();
        }catch (Exception E){
          System.out.println("Well that's awkward : "+E);
          E.printStackTrace();
        }

      }
    } catch (Exception e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}
