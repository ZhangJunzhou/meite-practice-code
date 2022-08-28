package com.zjz.annotation0007;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static sun.security.krb5.internal.crypto.Nonce.value;

/**
 * @ClassName jinhang
 * @Author Junzhou Zhang
 * @Create 2022/8/28 17:23
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface jinhang {
    String value() default "---";
    int classId() default 0;
    String[] arrAr();
}
