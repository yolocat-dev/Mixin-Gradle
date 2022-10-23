package io.waterwave.client;

public class Client {

    private static Client INSTANCE;
    public static Client getInstance() {
        if(INSTANCE == null) INSTANCE = new Client();
        return INSTANCE;
    }

    public void init() {
    	System.out.println("++ INIT ++");
    }

}
