package Request.Headers;

import Utils.Constants;

public class Accept {
    private AcceptTypes mimeType;

    public Accept(AcceptTypes mimeType){
        this.mimeType = mimeType;
    }

    public void printAccept(){
        System.out.println("Accept: " + mimeType.getMimeType());
    }

    public String getAccept(){
        return "Accept: " + mimeType.getMimeType() + Constants.CRLF;
    }
}
