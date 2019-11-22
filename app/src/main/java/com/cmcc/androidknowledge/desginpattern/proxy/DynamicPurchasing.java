package com.cmcc.androidknowledge.desginpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicPurchasing implements InvocationHandler {

    private Object obj;
    public DynamicPurchasing(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj,args);
        if(method.getName().equals("buy"))
        {
            System.out.println("My买买买买买买");
        }
        return result;
    }
}
