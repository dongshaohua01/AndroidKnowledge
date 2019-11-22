package com.cmcc.androidknowledge.desginpattern.builder;
/**
 * 创建Builder类规范产品的创建
 */
public abstract class Builder{

    public abstract void buildCpu(String cpu);
    public abstract void buildMainboard(String mainboard);
    public abstract void buildRam(String ram);
    public abstract Computer create();
}
