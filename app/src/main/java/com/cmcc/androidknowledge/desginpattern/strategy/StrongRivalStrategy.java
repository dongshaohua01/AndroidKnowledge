package com.cmcc.androidknowledge.desginpattern.strategy;

public class StrongRivalStrategy implements FightingStrategy {
    @Override
    public void fighting() {
        System.out.println("遇到春节，小仙女唱歌");
    }
}
