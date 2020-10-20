package com.titanic.javatest.reflection.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        /**
         * 해당 인스턴스의 필드를 조회하며 Inject 어노테이션을 가진 필드에 주입
         */
        Arrays.stream(instance.getClass().getDeclaredFields()).forEach(field -> {
            // inject 어노테이션을 가지고 있다면
            if(field.getAnnotation(Inject.class) != null) {
                Object fieldInstance = createInstance(field.getType());
                // private 필드에도 주입 가능하게 도와줌
                field.setAccessible(true);
                try {
                    // setter 역할 (해당 인스턴스, 주입할 인스턴스 객체)
                    field.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance;
    }

    /**
     * 파라미터로 받은 클래스타입의 인스턴스를 반환하는 메서드
     * 리플랙션으로 접근해 인스턴스를 반환
     */
    public static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
