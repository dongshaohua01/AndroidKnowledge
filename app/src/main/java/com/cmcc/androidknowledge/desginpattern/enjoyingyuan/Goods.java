package com.cmcc.androidknowledge.desginpattern.enjoyingyuan;

/**
 * 具体的享元角色
 */
public class Goods implements IGoods {

    private String name;//名称
    private String version;//版本

    Goods(String name){
        this.name = name;
    }

    @Override
    public void showGoodsPrice(String version) {
        if(version.equals("64G")){
            System.out.println(name+" "+version+"价格为5499元");
        }else if(version.equals("128G")){
            System.out.println(name+" "+version+"价格为5999元");
        }
    }
}
