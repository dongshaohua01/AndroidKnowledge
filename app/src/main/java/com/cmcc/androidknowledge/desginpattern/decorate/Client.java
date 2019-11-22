package com.cmcc.androidknowledge.desginpattern.decorate;

public class Client {
    /**
     * 装饰器模式：动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活；
     * 使用场景：
     * 1.在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责；
     * 2.需要动态地给一个对象增加功能，这些功能可以动态的撤销；
     * 3.当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时；
     * 优点：
     * 1.通过组合而非继承的方式，动态地扩展一个对象的功能，在运行时选择不同的装饰器，从而实现不同的行为；
     * 2.有效避免了使用继承的方式扩展对象功能而带来的灵活性差、子类无线扩张的问题；
     * 3.具体组件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体组件类和具体装饰类，在使用时在对其进行组合，
     * 原有代码无须改变，符合“开放封闭原则”；
     * 缺点：
     * 1.因为所有对象均继承于Speciality，所以如果Speciality内部结构发生改变，则不可避免影响所有子类（装饰者和被装饰者）。
     * 如果基类改变，则势必影响对象的内部；
     * 2.比继承更加灵活机动的特性，也同时意味着装饰模式比继承更加易于出错，排错也很困难。对于多次装饰的对象，调试时寻找错误可能
     * 需要逐级排查，较为繁琐，所以，只在必要的时候使用装饰模式；
     * 3.装饰层数不能过多，否则会影响效率；
     */
    public static void main(String[] args){
        //创建小仙女
        Fairy fairy = new Fairy();
        //学习跳舞
        TeacherA teacherA = new TeacherA(fairy);
        teacherA.attackSpeciality();
        //学习弹钢琴
        TeacherB teacherB = new TeacherB(fairy);
        teacherB.attackSpeciality();
    }
}
