package org.example.empltest.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MyReflection {

    public static void main(String[] args) {
        try {
            Class<Type> clazz = Type.class;

            Constructor<Type> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Type type = constructor.newInstance();
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(type, "this is my name");
            Field idField = clazz.getDeclaredField("id");
            idField.setAccessible(true);
            idField.setInt(type, 123);

            System.out.println("type🔜🔜🔜: " + type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
