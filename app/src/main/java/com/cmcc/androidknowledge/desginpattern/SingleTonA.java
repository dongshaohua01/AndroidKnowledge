package com.cmcc.androidknowledge.desginpattern;

/**
 * 双重检查模式(DCL)
 * 虽然在一定程度上解决了资源的消耗和多余的同步、线程安全等问题，
 * 但其还是在某些情况下会出现失效的问题，也就是DCL失效
 */
public class SingleTonA {

     private static SingleTonA singleTonA;

     private SingleTonA(){

     }

     public static SingleTonA getInstance(){
          if(singleTonA == null)
               synchronized (SingleTonA.class)
               {
                    if(singleTonA == null)
                    {
                         singleTonA = new SingleTonA();
                    }
               }
       return singleTonA;
     }


}
