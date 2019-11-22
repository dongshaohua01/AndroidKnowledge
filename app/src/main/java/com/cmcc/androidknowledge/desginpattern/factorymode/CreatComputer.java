package com.cmcc.androidknowledge.desginpattern.factorymode;

/**
 * 简单工厂模式(又叫作静态工厂方法模式)
 * 定义：简单工厂模式属于创建型模式，这是由一个工厂对象决定出哪一种产品类的实例
 * 使用场景：
 * 1.工厂类负责创建的对象比较少
 * 2.客户只需要传入工厂类的参数，而无需关心创建对象的逻辑
 * 优点：使用户根据参数获得对应类的实例，避免了直接实例化类降低了耦合性
 * 缺点：可实例化的类型在编译期间已经被确定。如果增加新类型，则需要修改工厂，这违背了开放封闭原则。
 * 简单工厂需要知道所有要生成的类型，其当子类过多或者子类层次过多时不适合使用。
 */
public class CreatComputer {

    public static void main(String[] args){
            ComputerFactory.createComputer("lenovo").start();
            //通过工厂方法模式获取产品对象
            GDComputerFactory gdComputerFactory = new GDComputerFactory();
            HpComputer hpComputer = gdComputerFactory.createComputer(HpComputer.class);
            hpComputer.start();
    }
}
