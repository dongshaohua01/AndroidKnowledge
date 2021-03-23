// IMessageService.aidl
package com.cmcc.androidknowledge;
import com.cmcc.androidknowledge.entity.Message;
import com.cmcc.androidknowledge.MessageReceiveListener;

//消息服务
interface IMessageService {

     void sendMessage(in Message message);

     void regiesterMessageReceiveListener(MessageReceiveListener messageReceiverListener);

     void unRegiesterMessageReceiveListener(MessageReceiveListener messageReceiverListener);
}
