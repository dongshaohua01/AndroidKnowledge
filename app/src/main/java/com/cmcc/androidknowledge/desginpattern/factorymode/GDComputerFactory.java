package com.cmcc.androidknowledge.desginpattern.factorymode;

/**
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪个类。
 * 工厂方法使一个类的实力延迟到其子类；
 */
public class GDComputerFactory extends ComputerFactoryA {
    @Override
    public <T extends Computer> T createComputer(Class<T> tClass) {
        Computer computer = null;
        String name = tClass.getName();
        try {
            computer = (Computer) Class.forName(name).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) computer;
    }
}
