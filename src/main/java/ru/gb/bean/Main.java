package ru.gb.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.bean.config.ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        ApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        System.out.println(context);
    }
}
