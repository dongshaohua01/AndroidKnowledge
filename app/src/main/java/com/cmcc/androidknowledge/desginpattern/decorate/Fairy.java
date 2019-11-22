package com.cmcc.androidknowledge.desginpattern.decorate;

/**
 * 组件具体实现类
 */
public class Fairy extends Speciality{

    @Override
    public void attackSpeciality() {
      System.out.println("仙女跳舞");
    }
}
