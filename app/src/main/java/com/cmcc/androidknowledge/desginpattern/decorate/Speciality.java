package com.cmcc.androidknowledge.desginpattern.decorate;

/**
 * 抽象组件
 * 举个学历特长的例子：小仙女本身会跳舞，有俩位老师又分别教了她唱歌和弹钢琴，
 * 这样小仙女除了会跳舞，还会唱歌和弹钢琴，俩位老师就起到了“装饰”小仙女的作用
 */
public abstract class Speciality {
    /**
     * 特长抽象方法
     */
    public abstract void attackSpeciality();
}
