package com.cmcc.androidknowledge.desginpattern.proxy;

public class My implements IShop {
    @Override
    public void buy() {
        System.out.println("购买");
    }
}
