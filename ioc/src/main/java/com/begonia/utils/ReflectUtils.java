package com.begonia.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/28 4:31 PM
 */
public class ReflectUtils {

    public static Object newInstance(Class<?> clazzType) {
        try {
            // 默认获取的是无参构造
            Constructor<?> constructor = clazzType.getConstructor();
            Object bean = constructor.newInstance();
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setProperty(Object bean, String name, Object valueToUse) {
        try {
            Class<?> aClass = bean.getClass();
            Field field = aClass.getDeclaredField(name);
            field.setAccessible(true);
            field.set(bean, valueToUse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethod(Object bean, String initMethod) {
        try {
            Class<?> clazzType = bean.getClass();
            Method method = clazzType.getMethod(initMethod);
            method.invoke(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class resolveClassType(String clazzName) {
        try {
            return Class.forName(clazzName);
        }catch (Exception e){
            e.printStackTrace();
        }

        return  null;

    }

    public static Class resolveTargetType(Class<?> clazzType, String name) {
        try {
            Field field = clazzType.getDeclaredField(name);
            return field.getType();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
