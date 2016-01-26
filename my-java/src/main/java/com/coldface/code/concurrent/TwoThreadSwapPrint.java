package com.coldface.code.concurrent;

/**
 * 类TwoThreadSwapPrint.java的实现描述： 
 * 1.用java写两个线程，一个线程打印1-52，另一个线程打印字母A-Z。
 * 2.用java写两个线程，一个线程打印1,3,5,7...,另一个线程打印2,4,6,8...
 * 
 * @author coldface 2016年1月20日 上午9:59:51
 */
public class TwoThreadSwapPrint {
    public static void main(String[] args) {

        Object obj = new Object();

        //创建两个线程
        MyThread01 t1 = new MyThread01(obj);
        MyThread02 t2 = new MyThread02(obj);

        //t1.start();
        //t2.start();

        MyThread03 t3 = new MyThread03(obj, 1);
        MyThread04 t4 = new MyThread04(obj, 2);

        t3.start();
        t4.start();
    }

}

class MyThread01 extends Thread {
    private final Object obj;

    MyThread01(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        //加锁
        synchronized (obj) {
            //打印1-52
            for (int i = 1; i <= 52; i++) {
                System.out.print(i);
                if (i % 2 == 0) {
                    //唤醒其他线程
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block log.error("error message", e);
                    }
                }
            }

        }
    }
}

class MyThread02 extends Thread {
    private final Object obj;

    MyThread02(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            //打印A-Z
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                //唤醒其他线程
                obj.notify();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block log.error("error message", e);
                }
            }
        }
    }
}

class MyThread03 extends Thread {
    private final Object obj;
    private static int   num1 = 1;
    //state==1表示线程1开始打印，stat==2表示线程2开始打印
    private int          state;

    MyThread03(Object obj, int state) {
        this.obj = obj;
        this.state = state;
    }

    @Override
    public void run() {
        while (num1 < 10) {
            //两个线程都用obj对象作为锁，保证每次交替期间只有一个线程在打印
            synchronized (obj) {
                //如果state!=1，说明此时尚未轮到线程1打印，线程1将调用obj的wait()方法，知道下次被唤醒
                if (state != 1) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block log.error("error message", e);  
                    }
                }

                //当state==1时，轮到线程1打印数字
                System.out.println(Thread.currentThread().getName() + "======" + num1);
                num1 += 2;

                //线程1打印完成后，将state赋值为2，表示接下来将轮到线程2打印
                state = 2;
                //notifyAll()方法唤醒在obj上wait得线程2，同时线程1将推出同步代码块，释放obj锁
                obj.notifyAll();
            }
        }

    }
}

class MyThread04 extends Thread {
    private final Object obj;
    private static int   num2 = 2;
    //state==1表示线程1开始打印，stat==2表示线程2开始打印
    private int          state;

    MyThread04(Object obj, int state) {
        this.obj = obj;
        this.state = state;
    }

    @Override
    public void run() {
        while (num2 < 10) {
            synchronized (obj) {
                if (state != 2) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(Thread.currentThread().getName() + "======" + num2);
                num2 += 2;

                state = 1;
                obj.notify();

            }
        }

    }
}
