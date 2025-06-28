import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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


          OutputStream output = clientSocket.getOutputStream();

          Response response = new Response();
          byte[] http_response = response.HTTPResponse();

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
