package com.zjz.threadDemo0001;

/**
 * @ClassName ThreadDemo001
 * @Author Junzhou Zhang
 * @Create 2022/8/13 12:45
 */
public class ThreadDemo001 {
    public static void main(String[] args) {
        System.out.println("main-开始创建新线程");
        ThreadDemo002 threadDemo002 = new ThreadDemo002();
        threadDemo002.start();

        Thread thread = new Thread(new ThreadDemo003());
        thread.start();
        System.out.println("main-创建新线程结束");
    }
}
