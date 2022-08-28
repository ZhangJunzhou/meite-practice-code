package com.zjz.threadDemo0001;

/**
 * @ClassName ThreadDemo004
 * @Author Junzhou Zhang
 * @Create 2022/8/13 13:09
 */
public class ThreadDemo004 {

    private static final int count = 10;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    System.out.println("new Thread-i: " + i);
                    System.out.println("getName(): " + Thread.currentThread().getName()  + "------" +
                    "getId(): + " + Thread.currentThread().getId()
                    );
                }
            }
        }).start();
        System.out.println("main线程------");
    }
}
