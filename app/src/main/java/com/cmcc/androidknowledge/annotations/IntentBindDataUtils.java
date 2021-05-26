package com.cmcc.androidknowledge.annotations;

import android.app.Activity;
import android.content.Intent;

import java.lang.reflect.Field;

public class IntentBindDataUtils {


    public static void inIntentDate(Activity activity) {

        Intent intent = activity.getIntent();

        Class<? extends Activity> aClass = activity.getClass();

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(IntentBindData.class)) {
                IntentBindData annotation = declaredField.getAnnotation(IntentBindData.class);
                Class<?> type = declaredField.getType();
                if (type.equals(String.class)) {
                    String stringExtra;
                    if (annotation.value().isEmpty()) {
                        stringExtra = intent.getStringExtra(declaredField.getName());
                    } else {
                        stringExtra = intent.getStringExtra(annotation.value());
                    }
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(activity, stringExtra);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else if (type.equals(int.class)) {
                    int intExtra=0;
                    if (annotation.value().isEmpty()) {
                        intExtra = intent.getIntExtra(declaredField.getName(),0);
                    } else {
                        intExtra = intent.getIntExtra(annotation.value(),0);
                    }
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(activity, intExtra);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else if (type.equals(float.class)) {

                }else
                {

                }

            }
        }

    }
}
