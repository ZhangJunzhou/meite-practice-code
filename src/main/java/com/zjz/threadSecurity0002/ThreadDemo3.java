package com.zjz.threadSecurity0002;

/**
 *  模拟线程不安全问题
 * @ClassName ThreadDemo1
 * @Author Junzhou Zhang
 * @Create 2022/8/13 20:56
 */
class ThreadTest3 implements Runnable {
    // 这是货票总票数,多个线程会同时共享资源
    private static int trainCount = 100;

    private Object oj = new Object();

    @Override
    public void run() {
        while (trainCount > 0) {
            sale();
        }
    }

    public static synchronized void sale(){
        try{
            Thread.sleep(40);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (trainCount > 0) {
            System.out.println(Thread.currentThread().getName() + "------" + "出售第" + (100 - trainCount + 1) + "张票");
            trainCount--;
        }

    }
}

public class ThreadDemo3{
    public static void main(String[] args) {
        ThreadTest3 threadTest = new ThreadTest3();
        new Thread(threadTest).start();
        new Thread(threadTest).start();
    }
}
