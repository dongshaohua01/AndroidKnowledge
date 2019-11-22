package com.cmcc.androidknowledge.desginpattern.strategy;

/**
 *策略模式
 * 当我们写代码时总会遇到一种情况，就是我们会有很多的选择，由此衍生出很多的if...else或者case，如果
 * 每个条件语句中包含了一个简单的逻辑，那还比较容易处理；但如果在一个条件语句中又包含了多个条件语句，
 * 就会使得代码变得臃肿，维护的成本也会加大，这显然违背了开放封闭原则。
 * 定义：定义一系列的算法，报每一个算法封装起来，并且使它们相互替换。策略模式使得算法可独立于使用它的
 * 客户而独立变化；
 */
public class Client {
    /**
     * TODO 策略模式
     * 使用场景：
     * 1.对客户隐藏具体策略（算法）的实现细节，彼此完全独立；
     * 2.针对同一类型问题的多种处理方式，仅仅是具体行为有差别时；
     * 3.在一个类中定义了很多行为，而且这些行为在这个类里的操作以多个条件语句的形式出现；
     * 策略模式将相关的条件分支移入他们各自的Strategy类中，以代替这些条件语句；
     * 优点：
     * 1.使用策略模式可以避免使用多重条件语句。多重条件语句不移维护，而且容易出错；
     * 2.易于拓展，当需要添加一个策略时，只需要实现接口就可以了
     * 缺点：
     * 1.每一个策略都是一个类，复用性小。如果策略过多，类的数量会增加；
     * 2.上层模块必须知道有哪些策略，才能够使用这些策略，这与迪米特原则相违背；
     */
    public static void main(String[] args){
        Context context;
        //遇到圣诞节，小仙女跳舞
        context = new Context(new WeakRivalStrategy());
        context.finghting();
        //遇到元旦，小仙女弹琴
        context = new Context(new CommonRivalStrategy());
        context.finghting();
        //遇到春节，小仙女唱歌
        context = new Context(new StrongRivalStrategy());
        context.finghting();
    }
}
