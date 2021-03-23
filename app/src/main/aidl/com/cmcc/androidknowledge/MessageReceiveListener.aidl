// MessageReceiveListener.aidl
package com.cmcc.androidknowledge;
import com.cmcc.androidknowledge.entity.Message;
//消息监听
interface MessageReceiveListener {

         void onRecevieMessage(in Message message);
}
