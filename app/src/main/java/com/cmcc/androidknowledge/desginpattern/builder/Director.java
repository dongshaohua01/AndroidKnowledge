package com.cmcc.androidknowledge.desginpattern.builder;

/**
 * 用导演类来同一组装过程
 */
public class Director {
    Builder mBuilder = null;

    public Director(Builder mBuilder){
        this.mBuilder = mBuilder;
    }

    public Computer CreateCoomputer(String cpu,String mainboard,String ram){
         mBuilder.buildCpu(cpu);
         mBuilder.buildMainboard(mainboard);
         mBuilder.buildRam(ram);
         return  mBuilder.create();
    }
}
