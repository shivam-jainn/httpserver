package Parsers;

import Request.Headers.*;
import Request.RequestBody;
import Request.RequestLine.HTTPMethod;
import Request.RequestLine.HTTPMethodTypes;
import Request.RequestLine.RequestLine;
import Utils.Constants;

public class RequestParser implements Parser<RequestBody> {

    public static RequestLine requestLineParser(String requestLineBody){
        String[] requestLine = requestLineBody.split(" ");
        String _HTTPMethod = requestLine[0];
        String URLPath = requestLine[1];
        String HTTPVersion = requestLine[2];

        HTTPMethod httpMethod = new HTTPMethod(HTTPMethodTypes.valueOf(_HTTPMethod));

        return new RequestLine(httpMethod,URLPath,HTTPVersion);
    }

    public static Host hostLineParser(String hostLineBody){
        String hostPart = hostLineBody.strip().replace("Host:", "").strip();
        String[] parts = hostPart.split(":");
        String address = parts[0].strip();
        int port = Integer.parseInt(parts[1].strip());

        return new Host(address,port);
    }

    public static UserAgent userAgentParser(String userAgentBody) {
        String agentPart = userAgentBody.strip().replace("User-Agent:", "").strip();

        UserAgentType type;

        agentPart = agentPart.toLowerCase();
        if (agentPart.startsWith("curl")) {
            type = UserAgentType.CURL;
        } else if (agentPart.contains("chrome")) {
            type = UserAgentType.CHROME;
        } else if (agentPart.contains("firefox")) {
            type = UserAgentType.FIREFOX;
        } else {
            throw new IllegalArgumentException("Unsupported User-Agent: " + agentPart);
        }

        return new UserAgent(type);
    }

    public static Accept acceptParser(String acceptBody) {
        String acceptPart = acceptBody.strip().replace("Accept:", "").strip();

        AcceptTypes type = switch (acceptPart) {
            case "*/*" -> AcceptTypes.WILDCARD;
            case "application/json" -> AcceptTypes.JSON;
            case "text/html" -> AcceptTypes.HTML;
            case "application/xml" -> AcceptTypes.XML;
            default -> throw new IllegalArgumentException("Unsupported Accept type: " + acceptPart);
        };

        return new Accept(type);
    }

    public static Headers headersParser(String hostLineBody, String userAgentBody, String acceptBody) {
        Host host = hostLineParser(hostLineBody);
        UserAgent userAgent = userAgentParser(userAgentBody);
        Accept accept = acceptParser(acceptBody);

        return new Headers(host, userAgent, accept);
    }


    public RequestBody parse(String messageBody) {
        messageBody = messageBody.replace("\\r\\n", "\r\n");
        String[] splitMessageBody = messageBody.split("\r\n");

        String requestLineBody = splitMessageBody[0];
        RequestLine requestLine = requestLineParser(requestLineBody);

        Headers headers = headersParser(
                splitMessageBody[1],
                splitMessageBody[2],
                splitMessageBody[3]
        );

        return new RequestBody(requestLine, headers, null);
    }
}
