package com.cmcc.androidknowledge.desginpattern.strategy;

/**
 * 上下文角色
 */
public class Context {

     private FightingStrategy fightingStrategy;
     public Context(FightingStrategy fightingStrategy){
         this.fightingStrategy = fightingStrategy;
     }

     public void finghting(){
         fightingStrategy.fighting();
     }
}
