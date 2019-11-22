package com.cmcc.androidknowledge.desginpattern.enjoyingyuan;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class GoodsFactory {

     private static Map<String,Goods> pool = new HashMap<String,Goods>();

     public static Goods getGoods(String name){
         if(pool.containsKey(name))
         {
             return pool.get(name);
         }else {
             Goods goods = new Goods(name);
             pool.put(name,goods);
             System.out.println("创建商品，Key为："+name);
             return goods;
         }
     }

}
