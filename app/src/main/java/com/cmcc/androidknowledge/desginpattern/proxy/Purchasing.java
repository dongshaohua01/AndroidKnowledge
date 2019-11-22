package com.cmcc.androidknowledge.desginpattern.proxy;

public class Purchasing implements IShop {

    private IShop iShop;

    public Purchasing(IShop iShop){
        this.iShop = iShop;
    }

    @Override
    public void buy() {
        iShop.buy();
    }
}
