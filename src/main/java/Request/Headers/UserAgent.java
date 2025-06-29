package Request.Headers;

import Utils.Constants;

public class UserAgent {
    private UserAgentType agentType;

    public UserAgent(UserAgentType agentType){
        this.agentType = agentType;
    }

    public void printUserAgent(){
        System.out.println("User-Agent : " + agentType);
    }

    public  String getUserAgent(){
        return "User-Agent : " + agentType + Constants.CRLF;
    }
}
