package com.cmcc.androidknowledge.desginpattern.observer;

/**
 * 具体观察者
 */
public class WeiXinUser implements Observer{

    //微信用户名
    private String name;
    public WeiXinUser(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name+"-"+message);
    }
}
