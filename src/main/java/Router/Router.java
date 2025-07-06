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
        switch (URLPath) {
            case "/" -> {
                return response.HTTPResponse("OK OK", 200, "OK");
            }
            default -> {
                return response.HTTPResponse("404 Error not found", 404, "Not Found");
            }
        }
    }

}
