package com.zjz.threadCommunication0003;


class JoinThread implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---i:" + i);
        }
    }
}


/**
 * @ClassName JoinTest006
 * @Author Junzhou Zhang
 * @Create 2022/8/23 0:32
 */
public class JoinTest006 {
    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread();
        Thread t1 = new Thread(joinThread);
        Thread t2 = new Thread(joinThread);
        t1.start();
//        t2.start();
        try {
            //其他线程变为等待状态，等t1线程执行完成之后才能执行join方法。
            t1.join();
        } catch (Exception e) {

        }
        for (int i = 0; i < 100; i++) {
            System.out.println("main ---i:" + i);
        }
    }

}
