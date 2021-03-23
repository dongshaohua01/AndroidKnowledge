package com.cmcc.androidknowledge.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.widget.Toast;

import com.cmcc.androidknowledge.IConnectService;
import com.cmcc.androidknowledge.IMessageService;
import com.cmcc.androidknowledge.IServiceManager;
import com.cmcc.androidknowledge.MessageReceiveListener;
import com.cmcc.androidknowledge.entity.Message;

import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RemoteService extends Service {


    //是否连接成功
    private boolean isConnect = false;
    private RemoteCallbackList<MessageReceiveListener> messageReceiveListeners = new RemoteCallbackList<>();

    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    private ScheduledFuture scheduledFuture;


    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            bundle.setClassLoader(Message.class.getClassLoader());
            Message message = bundle.getParcelable("message");

            Toast.makeText(RemoteService.this,String.valueOf(message.getConnect()),Toast.LENGTH_SHORT).show();

            try {
                //发送消息到客户端
                Message message1= new Message();
                message1.setConnect("data from aidl reply");
                bundle.putParcelable("aidlMessage",message1);
                Messenger clientMessenger = msg.replyTo;
                android.os.Message data = new android.os.Message();
                data.setData(bundle);
                clientMessenger.send(data);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

    //实现Messenger通信
    private Messenger messenger = new Messenger(handler);


  private IConnectService iServiceConnect = new IConnectService.Stub() {
      @Override
      public void connect() throws RemoteException {
          //连接中
          try {
              Thread.sleep(5000);
              isConnect = true;
              handler.post(new Runnable() {
                  @Override
                  public void run() {
                      Toast.makeText(RemoteService.this,"connect",Toast.LENGTH_SHORT).show();
                  }
              });
              scheduledFuture = scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
                  @Override
                  public void run() {
                      int size = messageReceiveListeners.beginBroadcast();
                      for(int i = 0; i < size;i++){
                          Message message = new Message();
                          message.setConnect("this message from remote");
                          try {
                              messageReceiveListeners.getBroadcastItem(i).onRecevieMessage(message);
                          } catch (RemoteException e) {
                              e.printStackTrace();
                          }
                      }
                      messageReceiveListeners.finishBroadcast();
                  }
              },5000,5000, TimeUnit.MILLISECONDS);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }

      @Override
      public void disConnect() throws RemoteException {
             //断开连接
          isConnect = false;
          scheduledFuture.cancel(true);
          handler.post(new Runnable() {
              @Override
              public void run() {
                  Toast.makeText(RemoteService.this,"disConnect",Toast.LENGTH_SHORT).show();
              }
          });
      }

      @Override
      public boolean isConnect() throws RemoteException {
          return isConnect;
      }
  };

   private IMessageService iMessageService = new IMessageService.Stub() {
       @Override
       public void sendMessage(final Message message) throws RemoteException {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(RemoteService.this,message.getConnect(),Toast.LENGTH_SHORT).show();
                }
            });
            if(isConnect)
            {
                message.setConnect(true);
            }else {
                message.setConnect(false);
            }
       }

       @Override
       public void regiesterMessageReceiveListener(MessageReceiveListener messageReceiverListener) throws RemoteException {
            if(messageReceiveListeners != null)
            {
                messageReceiveListeners.register(messageReceiverListener);
            }
       }

       @Override
       public void unRegiesterMessageReceiveListener(MessageReceiveListener messageReceiverListener) throws RemoteException {
            if (messageReceiveListeners != null)
            {
                messageReceiveListeners.unregister(messageReceiverListener);
            }
       }
   };

    IServiceManager iServiceManager = new IServiceManager.Stub() {
        @Override
        public IBinder getService(String serviceName) throws RemoteException {

            if(IConnectService.class.getSimpleName().equals(serviceName))
            {
                return  iServiceConnect.asBinder();
            } else if(IMessageService.class.getSimpleName().equals(serviceName))
            {
                return  iMessageService.asBinder();
            } else  if(Messenger.class.getSimpleName().equals(serviceName)){

                return messenger.getBinder();
            } else {
                return null;
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return iServiceManager.asBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    }
}
