package com.cmcc.androidknowledge.desginpattern.strategy;

public class CommonRivalStrategy implements FightingStrategy{
    @Override
    public void fighting() {
        System.out.println("遇到元旦，小仙女弹琴");
    }
}
