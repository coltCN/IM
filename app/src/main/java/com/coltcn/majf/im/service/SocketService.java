package com.coltcn.majf.im.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by majf on 2014/12/26.
 */
public class SocketService extends Service {
    
    private final static String TAG = "SocketService";

    private final static String SERVER_IP="10.8.26.119";
    private final static int SERVER_PORT=8980;
    private Socket socket;
    private SocketBinder binder;
    
    class SocketBinder extends Binder{
        
        
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"service create");
        binder = new SocketBinder();
        new Thread(){
            @Override
            public void run() {
                connectServer();
            }
        }.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        closeConnect();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG,"onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onTrimMemory(int level) {
        Log.i(TAG,"onTrimMemory");
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        Log.i(TAG,"onLowMemory");
        closeConnect();
        super.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i(TAG,"onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }


    private void connectServer(){
        try{
            if(socket==null || socket.isClosed())
                socket = new Socket(SERVER_IP,SERVER_PORT);
            Log.i("conn","与服务器建立连接");
        }catch (Exception e){
            Log.e("conn","连接服务器失败！",e);
        }

    }
    
    private void closeConnect(){
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
       
    }
}
