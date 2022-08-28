package com.zjz.annotation0007.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName SetProperty
 * @Author Junzhou Zhang
 * @Create 2022/8/28 17:38
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {
    String name();
    int length();
}
