package com.cmcc.androidknowledge.desginpattern.observer;

public class Client {

     public static void main(String[] args){
         /**
          * TODO 观察者模式
          * 观察者模式又被称为发布-订阅模式，属于行为型设计模式的一种，是一个在项目中经常使用的模式，
          * 定义：定义对象间一种一对多的依赖关系，每当一个对象改变状态时，则所有依赖于它的对象都会到得到通知并且自动更新；
          * 使用场景：
          * 1.关联行为场景。需要注意的是，关联行为是可拆分的，而不是“组合”关系；
          * 2.事件多级触发场景；
          * 3.跨系统的消息交换场景，如消息队列、事件总线的处理机制；
          * 优点：
          * 1.观察者与被观察者之间是抽象耦合，容易扩展；
          * 2.方便建立一套触发机制；
          * 缺点：
          * 在应用观察者模式时需要考虑一下开发效率和运行效率的问题。程序中包括一个被观察者、多个观察者，开发、调试等内容会比较
          * 复杂，而且在java中消息的通知一般是顺序执行的，那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异
          * 步方式；
          */
         SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
         //创建微信用户
         WeiXinUser user1 = new WeiXinUser("杨影枫");
         WeiXinUser user2 = new WeiXinUser("月眉儿");
         WeiXinUser user3 = new WeiXinUser("紫轩");
         //订阅微信公众号
         subscriptionSubject.attach(user1);
         subscriptionSubject.attach(user2);
         subscriptionSubject.attach(user3);
         //公众号更新发出消息给订阅的微信用户
         subscriptionSubject.notify("我想你啦");
     }

}
