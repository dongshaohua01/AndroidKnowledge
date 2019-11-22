package com.cmcc.androidknowledge.desginpattern.strategy;

/**
 * 具体策略实现
 */
public class WeakRivalStrategy implements FightingStrategy {
    @Override
    public void fighting() {
        System.out.println("遇到圣诞节，小仙女跳舞");
    }
}
