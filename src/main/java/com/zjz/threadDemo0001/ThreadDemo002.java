package com.zjz.threadDemo0001;

/**
 * @ClassName ThreadDemo002
 * @Author Junzhou Zhang
 * @Create 2022/8/13 12:48
 */
public class ThreadDemo002 extends Thread {
    private static final int count = 100;

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("ThreadDemo002-i:" + i);
        }
    }
}
