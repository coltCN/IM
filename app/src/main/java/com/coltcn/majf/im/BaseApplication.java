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
        new Thread(){
            @Override
            public void run() {
                connectServer();
            }
        }.start();
    }
    
    private void connectServer(){
        try{
            socket = new Socket(SERVER_IP,SERVER_PORT);
            Log.i("conn","与服务器建立连接");
        }catch (Exception e){
            Log.e("conn","连接服务器失败！",e);
        }
        
    }

    @Override
    public void onTerminate() {
        if (socket!=null &&!socket.isClosed()){
            try {
                socket.close();
                Log.i("conn","释放连接");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket = null;
        Log.i("SYS","app close");
        super.onTerminate();
    }
}
