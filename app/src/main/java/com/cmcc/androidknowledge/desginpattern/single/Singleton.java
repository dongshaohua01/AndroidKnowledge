package com.cmcc.androidknowledge.desginpattern.single;

/**
 * 懒汉模式
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton(){ }
    //线程不安全
    public static Singleton getInstance(){

        if(singleton == null)
        {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static  synchronized  Singleton getSingleton(){
        if(singleton==null)
        {
            singleton = new Singleton();
        }
        return singleton;
    }
}
