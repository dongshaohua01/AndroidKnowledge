package com.cmcc.androidknowledge.desginpattern;

/**
 * 单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点
 * 饿汉模式
 */
public class SingleCase {

    private static SingleCase singleCase = new SingleCase();
    private SingleCase(){

    }
    public static SingleCase getInstance(){
        return singleCase;
    }
}
