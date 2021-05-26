package com.cmcc.androidknowledge.annotations;

import android.app.Activity;
import android.view.View;

import com.cmcc.androidknowledge.R;

import java.lang.reflect.Field;

public class InjectUtils {

    public static void injectView(Activity activity){

        Class<? extends Activity> cls = activity.getClass();

        //获得此类的所有成员
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields){
            //判断属性是否被injectView注解声明
            if(field.isAnnotationPresent(InjectView.class)){
                InjectView injectView = field.getAnnotation(InjectView.class);
                //获得了注解中设置的id
                int id = injectView.value();
                View view = activity.findViewById(id);
                //反射设置属性的值
                field.setAccessible(true);//设置访问权限，允许操作private属性
                try {
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
