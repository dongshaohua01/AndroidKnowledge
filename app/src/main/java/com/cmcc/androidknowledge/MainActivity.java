package com.cmcc.androidknowledge;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cmcc.androidknowledge.aidl.RemoteService;
import com.cmcc.androidknowledge.databinding.ActivityMainBinding;
import com.cmcc.androidknowledge.databinding.ActivityRecyclerBinding;
import com.cmcc.androidknowledge.entity.Message;
import com.cmcc.androidknowledge.mvvm.ObFSwordsman;
import com.cmcc.androidknowledge.mvvm.Swordsman;
import com.cmcc.androidknowledge.mvvm.SwordsmanAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityRecyclerBinding binding;

    //服务管理
    private IServiceManager iServiceManager;
    //连接服务
    IConnectService iConnectService;
    //发送消息服务
    IMessageService iMessageService;
    //Messenger通信
    Messenger messengerProxy;

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);

            //接收其他进程传来的值
            Bundle bundle = msg.getData();
            bundle.setClassLoader(Message.class.getClassLoader());
            final Message message = bundle.getParcelable("aidlMessage");

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this,message.getConnect(),Toast.LENGTH_SHORT).show();
                }
            },3000);
        }
    };

    //客户端用于接收的Messenger
    private Messenger clientMessager = new Messenger(handler);

    //消息监听
    MessageReceiveListener messageReceiveListener = new MessageReceiveListener.Stub() {
        @Override
        public void onRecevieMessage(final Message message) throws RemoteException {
          new Handler(Looper.getMainLooper()).post(new Runnable() {
              @Override
              public void run() {
                  Toast.makeText(MainActivity.this,message.getConnect(),Toast.LENGTH_SHORT).show();
              }
          });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("tag-->","A --- onCreate()");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler);
        initRecyclerView();

        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iServiceManager = IServiceManager.Stub.asInterface(service);
                try {
                    iConnectService = IConnectService.Stub.asInterface(iServiceManager.getService(IConnectService.class.getSimpleName()));
                    iMessageService = IMessageService.Stub.asInterface(iServiceManager.getService(IMessageService.class.getSimpleName()));
                    messengerProxy = new Messenger(iServiceManager.getService(Messenger.class.getSimpleName()));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);

        //连接
        binding.btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iConnectService.connect();

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
              //  startActivity(new Intent(MainActivity.this,BActivity.class));
            }
        });


        //断开连接
        binding.btDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iConnectService.disConnect();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //获取连接状态
        binding.btIsconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   boolean isConnect =  iConnectService.isConnect();
                    Toast.makeText(MainActivity.this,String.valueOf(isConnect),Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //发送消息
        binding.btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.setConnect("this from remote");
                try {
                    iMessageService.sendMessage(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //注册
        binding.btRegiest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iMessageService.regiesterMessageReceiveListener(messageReceiveListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //取消注册
        binding.btUnregiest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iMessageService.unRegiesterMessageReceiveListener(messageReceiveListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        //Messenger通信
        binding.btMessenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.setConnect("send from main ");

                android.os.Message data = new android.os.Message();
                //设置通信接收的Messenger
                data.replyTo = clientMessager;
                Bundle bundle = new Bundle();
                bundle.putParcelable("message",message);
                data.setData(bundle);
                try {
                    //通过Messenger建立通信
                    messengerProxy.send(data);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tag-->","A --- onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("tag-->","A --- onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("tag-->","A --- onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("tag-->","A --- onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("tag-->","A --- onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("tag-->","A --- onDestroy()");
    }

    private void initRecyclerView(){
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        binding.recycler.setLayoutManager(manager);
        SwordsmanAdapter adapter = new SwordsmanAdapter(getList());
        binding.recycler.setAdapter(adapter);
    }

    private List<Swordsman> getList(){
        List<Swordsman> list = new ArrayList<>();
        list.add(new Swordsman("xxxx","111"));
        list.add(new Swordsman("aaa","222"));
        return list;
    }
}
