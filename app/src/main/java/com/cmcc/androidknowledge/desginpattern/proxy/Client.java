package com.cmcc.androidknowledge.desginpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 客户端类
 */
public class Client {

     public static void main(String[] args){
         /**
          * 代理模式：也被称为委托模式，它是结构型设计模式的一种。在现实生活中我们用到类似代理模式的场景有很多，
          * 比如代理上网、打官司等
          * 定义：为其他对象提供一种代理以控制对这个对象的访问；
          */
         IShop iShop = new My();
         IShop purching = new Purchasing(iShop);
         purching.buy();
         /**
          * 动态代理：在代码运行时通过反射来动态地生成代理类的对象，并确定道理来代理谁
          * 使用范围：
          * 1.远程代理：为一个对象在不同的地址空间提供局部代表，这样系统可以将Server部分实现隐藏；
          * 2.虚拟代理：使用一个代理对象表示一个十分耗费资源的对对象并在真正需要时才创建；
          * 3.安全代理：用来控制真实对象访问时的权限。一般用于真实对象有不同的访问权限时；
          * 4.智能指引：当调用真实的对象时，代理处理另外一些事，比如计算机真实对象的引用计数，当该对象没有引用时，可以自动释放它；
          * 或者访问一个实际对象时，检查是否已经能够锁定它，以确保其他对象不能改变它；
          * 优点：
          * 1.真实主题类就是实现实际的业务逻辑，不用关心其他非本职的工作；
          * 2.真实主题类随时都会发生变化，但是因为它实现了公共的接口，所以代理类可以不做任何修改能够使用；
          */
         //创建动态代理
         DynamicPurchasing dynamicPurchasing = new DynamicPurchasing(iShop);
         //创建My的ClassLoader
         ClassLoader classLoader = iShop.getClass().getClassLoader();
         //动态创建代理类
         IShop purchasing = (IShop) Proxy.newProxyInstance(classLoader,new Class[]{IShop.class},dynamicPurchasing);
         purchasing.buy();
     }
}
