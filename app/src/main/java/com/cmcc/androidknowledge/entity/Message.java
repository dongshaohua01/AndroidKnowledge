package com.cmcc.androidknowledge.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 消息实体类
 */
public class Message implements Parcelable {
    //消息内容
    private String connect;
    //判断消息是否发送成功
    private boolean isConnect;


    protected Message(Parcel in) {
        connect = in.readString();
        isConnect = in.readByte() != 0;
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public Message() {
    }

    public Message(String connect, boolean isConnect) {
        this.connect = connect;
        this.isConnect = isConnect;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(connect);
        dest.writeByte((byte) (isConnect ? 1 : 0));
    }
}
