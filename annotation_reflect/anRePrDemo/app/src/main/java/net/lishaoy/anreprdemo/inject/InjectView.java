package net.lishaoy.anreprdemo.inject;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class InjectView {

    public static void init(Activity activity) {
        // 获取 activity 的 class 对象
        Class<? extends Activity> aClass = activity.getClass();
        // 获取 activity 的所以成员变量
        Field[] declaredFields = aClass.getDeclaredFields();
        // 变量所以成员变量
        for (Field field: declaredFields) {
            // 判断属性是否加上了 @BindView 注解
            if(field.isAnnotationPresent(BindView.class)){
                // 获取注解 BindView 对象
                BindView bindView = field.getAnnotation(BindView.class);
                // 获取注解类型元素 id
                int id = bindView.value();
                // 通过资源 id 找到对应的 view
                View view = activity.findViewById(id);
                // 设置可以访问私有字段
                field.setAccessible(true);
                try {
                    // 给字段赋值
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
