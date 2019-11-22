package com.cmcc.androidknowledge.desginpattern.template;

/**
 * 举个例子：一个武侠要战斗的时候，也有一套固定的通用模式，那就是运行内功、
 * 开启经脉、准备武器和使用招式，我们把这些用代码表示；
 */
public abstract class AbstractSwordsman {

       //该方法为final，防止算法框架被复写
    public final  void finghting(){
        //运行内功
         neigong();
        //调整经脉
        meridian();
        //如果有武器，则准备武器
        if(hasWeapons())
        {
            weapons();
        }
        //使用招式
        moves();
        //使用钩子
        hook();
    }
    //空实现方法
    protected void hook(){}
    protected abstract void neigong();
    protected abstract void weapons();
    protected abstract void moves();
    protected void meridian(){
        System.out.println("开启正经与奇经");
    }
    /**
     * 是否有武器，默认是有武器的，钩子方法
     */
    protected boolean hasWeapons(){
        return true;
    }
}
