package com.titanic.javatest.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        // 인스턴스가 생성 안됐을 때
        Class<Book> bookClass = Book.class;

        Book book = new Book();

        System.out.println(MyBook.class.getSuperclass());
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
        System.out.println("=============================");

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });
    }
}
