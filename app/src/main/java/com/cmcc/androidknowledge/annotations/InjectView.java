package com.cmcc.androidknowledge.annotations;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SOURCE：保存注解到源码级别
 * CLASS：保存到.class文件，但不会保存到jvm
 * RUNTIME：保存到jvm虚拟机，在运行时可以使用
 *
 * 源码:在编译期能够获取注解与注解声明的类包括类中所有成员信息，一般用于额外生成的辅助类。
 * 字节码:在编译出Class后，通过修改Class数据以实现修改代码逻辑目的。对于是否需要修改的区分
 * 或者修改为不同逻辑的判断可以使用注解；
 * 运行时:在程序运行期间，通过反射技术动态获取注解与其元素，从而完成不同的逻辑判定；
 *
 * javac 编译到.class
 * 控件绑定
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectView {

    @IdRes int value();
}
