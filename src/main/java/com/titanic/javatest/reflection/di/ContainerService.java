package com.titanic.javatest.reflection.di;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    /** Inject 어노테이션을 통해 필드 injection을 지원하는 메서드
     * ====로직====
     * 파라미터로 넘어온 클래스의 인스턴스를 생성한 후에 @Inject가 붙은 필드를 찾는다.
     * @Inject필드의 인스턴스를 주입해준다
     */
    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            if (f.getAnnotation(Inject.class) != null) {
                Object fieldInstance = createInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(instance, fieldInstance);
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
    public static <T> T createInstance(Class<T> classType)  {
        // 해당 클래스로 접근할 수 없기 때문에 리플랙션으로 해당 인스턴스를 반환
        try {
            return classType.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
