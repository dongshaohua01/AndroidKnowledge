package com.cmcc.androidknowledge.desginpattern.builder;

/**
 * 客户端调用导演类
 */
public class CreatComputer {
    /**
     * 建造者模式：也被成生成器模式；
     * 定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示；
     * 使用场景：
     * 1.当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时；
     * 2.相同的方法，不同的执行顺序，缠身不同的事件结果时；
     * 3.多个部件或零件都可以被装配到一个对象中，但是产生的运行结果又不相同时；
     * 4.产品类非常复杂，或者产品类中的调用顺序不同而产生了不用的效能；
     * 5.在创建一些复杂的对象时，这些对象的内部组成构件间的建造顺序是稳定的，但是对象的内部组成构件面临着复杂的变化
     * 优点：
     * 1.使用建造者模式可以使客户端不必知道产品内部组成的细节；
     * 2.具体的建造者类之间是相互的独立的，容易扩展；
     * 3.由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对其他的模块产生任何影响
     * 缺点：
     * 产生多余的Build对象以及导演类；
     */
     public static void main(String[] arg){
         Builder builder = new MoonComputerBuilder();
         Director director = new Director(builder);
         //组装计算机
         director.CreateCoomputer("i7-6700","至尊玩家","华为笔记本");
     }
}
