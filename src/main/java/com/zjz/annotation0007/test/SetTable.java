package com.zjz.annotation0007.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ClassName SetTable 表的别名
 * @Author Junzhou Zhang
 * @Create 2022/8/28 17:35
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {
    String value();
}