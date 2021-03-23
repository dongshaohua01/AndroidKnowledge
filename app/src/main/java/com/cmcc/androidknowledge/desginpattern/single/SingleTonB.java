package com.cmcc.androidknowledge.desginpattern.single;

/**
 * 静态内部类单例模式
 * 不仅能够保证线程安全，也能够保证类的唯一性；
 * 推荐使用静态内部类单例模式
 */
public class SingleTonB {

    private SingleTonB(){}

    public static SingleTonB getInstance(){
        return SingleTonHolder.singleTonB;
    }

    private static class SingleTonHolder{
        private static final SingleTonB singleTonB = new SingleTonB();
    }
}
