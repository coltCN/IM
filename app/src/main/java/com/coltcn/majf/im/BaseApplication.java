package com.coltcn.majf.im;

import android.app.Application;
import android.util.Log;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by majf on 2014/12/19.
 */
public class BaseApplication extends Application {
    
    private final static String SERVER_IP="10.8.26.119";
    private final static int SERVER_PORT=8980;
    private Socket socket;
    
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("SYS","app created");
    }
    
    

    @Override
    public void onTerminate() {
        Log.i("SYS","app onTerminate");
        super.onTerminate();
    }
}
