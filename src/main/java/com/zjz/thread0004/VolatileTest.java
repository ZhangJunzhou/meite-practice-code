package com.zjz.thread0004;

class ThreadVolatileDemo extends Thread {
    public boolean flag = true;

    @Override
    public void run() {
        System.out.println("开始执行子线程....");
        while (flag) {
            System.out.println("running......");
        }
        System.out.println("线程停止");
    }

    public void setRuning(boolean flag) {
        this.flag = flag;
    }

}


/**
 * @ClassName VolatileTest
 * @Author Junzhou Zhang
 * @Create 2022/8/27 10:30
 */
public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        Thread.sleep(3000);

        threadVolatileDemo.setRuning(false);
        System.out.println("flag已经被置为false");
        System.out.println(threadVolatileDemo.flag);
    }

}
