package com.cmcc.androidknowledge.desginpattern.template;

/**
 * 模板方法模式：在软件开发中，有事会遇到类似的情况：某个方法的实现需要多个步骤，其中有些步骤
 * 是固定的；而有些步骤并不固定，存在可变性。为了提高代码的复用性和系统的灵活性，可以使用模板
 * 方法来应对这类情况；
 */
public class Client {
    /**
     * TODO 模板方法模式
     * 定义：定义一个操作中的算法框架，而将一些步骤延迟到子类中，是的子类不改变一个算法的结构即可
     * 重新定义算法的某些特定步骤；
     * 使用场景：
     * 1.多个子类有共有的方法，并且逻辑基本相同时；
     * 2.面对重要、复杂的算法，可以把核心算法设计为模板方法，周边相关细节功能则由各个子类实现；
     * 3.需要通过子类来决定父类算法中的某个步骤是否执行，实现子类对父类的反向控制；
     * 优点：
     * 1.模板方法模式通过把不变的行为搬移到超类，去除了子类中的重复代码；
     * 2.子类实现算法的某些细节，有助于算法的扩展；
     * 缺点：
     *  每个不同的实现都需要定义一个子类，这会导致类的个数的增加，设计更加抽象；
     */
    public static void main(String[] args){
        ZhangWuJi zhangWuJi = new ZhangWuJi();
        zhangWuJi.finghting();
        ZhangSanFeng zhangSanFeng = new ZhangSanFeng();
        zhangSanFeng.finghting();
    }
}
