package Router;

import Response.Response;

import java.util.ArrayList;

public class Router {
    private ArrayList<String> urlPaths;

    public Router(){}

    public void route(String URLPath){
        this.urlPaths.add(URLPath);
    }

    public byte[] routing(String URLPath){
        Response response = new Response();

        String message = switch (URLPath){
            case "/" -> "OK OK";
            default -> "404 Error not found";
        };

        return response.HTTPResponse(message);
    }

}
