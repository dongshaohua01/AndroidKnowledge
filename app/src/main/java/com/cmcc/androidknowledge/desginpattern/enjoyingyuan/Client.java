package com.cmcc.androidknowledge.desginpattern.enjoyingyuan;

/**
 * 客户端调用
 * 享元模式简单实现：
 * 某著名网上商城卖商品，如果每个用户下单都生成商品对象，这显然会耗费很多资源。如果赶上“双11”，
 * 那恐怖的订单量会生成很多商品对象，更何况商城卖的商品种类繁多，这样就极易产生“Out Of Memory”。
 * 因此，我们采用享元模式来对商品的创建进行优化；
 */
public class Client {
    /**
     *  TODO 享元模式
     *  享元模式是池技术的重要实现方式，它可以减少应用程序创建的对象，降低程序内存的占用，提高程序的性能；
     *  定义：使用共享对象有效地支持大量细粒度的对象；
     *  使用场景：
     *  1.系统中存在大量的相似对象；
     *  2.需要缓冲池的场景；
     */
    public static void main(String[] args){

        Goods goods1 = GoodsFactory.getGoods("iphone11");
        goods1.showGoodsPrice("64G");
        Goods goods2 = GoodsFactory.getGoods("iphone11");
        goods2.showGoodsPrice("64G");
        Goods goods3 = GoodsFactory.getGoods("iphone11");
        goods3.showGoodsPrice("128G");
    }
}
