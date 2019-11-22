package com.cmcc.androidknowledge.desginpattern.template;

public class ZhangSanFeng extends AbstractSwordsman{
    @Override
    protected void neigong() {
        System.out.println("运行纯阳无极功");
    }

    @Override
    protected void weapons() {
        System.out.println("使用真武剑");
    }

    @Override
    protected void moves() {
      System.out.println("使用招式神门十三剑");
    }

    /**
     * 张三丰突然肚子不舒服，所以就实现了钩子方法hook，用来处理一些自定义的逻辑
     */
    @Override
    protected void hook() {
        System.out.println("突然肚子不舒服，老夫先去上个厕所");
    }
}
