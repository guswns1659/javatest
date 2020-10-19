package com.titanic.javatest.reflection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {

    String value();
}
