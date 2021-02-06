package com.example.demo.day.day07;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 8:18
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> componentClass = Class.forName("com.example.demo.day.day07.UpperCaseComponent");
        if (componentClass.isAnnotationPresent(Component.class)) {
            Component component = (Component) componentClass.getAnnotation(Component.class);
            String identifier = component.identifier();
            System.out.println(String.format("Identifier for "
                    + "com.example.demo.day.day07.UpperCaseComponent is ' %s '", identifier));
        } else {
            System.out.println("com.example.demo.day.day07.UpperCaseComponent is not annotated by"
            + " com.example.demo.day.day07.UpperCaseComponent");
        }
    }
}
