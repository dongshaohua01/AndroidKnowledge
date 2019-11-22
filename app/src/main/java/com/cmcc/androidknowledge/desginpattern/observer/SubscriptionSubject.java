package com.cmcc.androidknowledge.desginpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者
 */
public class SubscriptionSubject implements Subject {

    //存储订阅公众号的微信的用户
    private List<Observer> weixinUserList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
          weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
         for(Observer observer : weixinUserList)
         {
             observer.update(message);
         }
    }
}
