package com.hwxy.code.multiThread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import lombok.SneakyThrows;

/**
 * 交替输出问题
 * 用2个线程交替输出字母和数字
 * 类似1A2B3C4D...
 *
 * @author hwxy
 * @date 2022/07/09
 **/
public class Mt1 {
    public static void main(String[] args) {
        // LockSupportAns lockSupportAns = new LockSupportAns();
        // lockSupportAns.print();

        // ReentrantLockAns reentrantLockAns = new ReentrantLockAns();
        // reentrantLockAns.print();

        WaitNotifyAns waitNotifyAns = new WaitNotifyAns();
        waitNotifyAns.print();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


/**
 * 基本方法
 * 先调用t1然后调用t2
 */
abstract class BaseAns {
    protected final Thread t1;
    protected final Thread t2;

    BaseAns() {
        t1 = createPrintThread('0');
        t2 = createPrintThread('a');
    }

    protected abstract Thread createPrintThread(char c);

    public void print() {
        t1.start();
        t2.start();
    }

    protected void doPrint(char startChar, int i) {
        char output = (char) (startChar + i);
        System.out.println(output);
    }

    protected Thread getAnotherThread(Thread currentThread) {
        return currentThread.equals(t1) ? t2 : t1;
    }
}


/**
 * 使用LockSupport
 */
class LockSupportAns extends BaseAns {

    @Override
    protected Thread createPrintThread(char startChar) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                doPrint(startChar, i);
                LockSupport.unpark(getAnotherThread(Thread.currentThread()));
                LockSupport.park();
            }
        });
    }

}


/**
 * 使用ReentrantLock
 * 使用一个Condition就可以,注意方法名是await()不是wait()
 */
class ReentrantLockAns extends BaseAns {
    private final ReentrantLock lock;

    private final Condition charCondition;
    // private final Condition numberCondition;

    ReentrantLockAns() {
        lock = new ReentrantLock();
        charCondition = lock.newCondition();
        // numberCondition = lock.newCondition();
    }

    @Override
    protected Thread createPrintThread(char startChar) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    doPrint(startChar, i);
                    charCondition.signal();
                    charCondition.await();
                } catch (Exception e) {
                    System.err.println(Thread.currentThread().getName() + ":error,"
                            + Arrays.toString(e.getStackTrace()));
                } finally {
                    lock.unlock();
                }
            }
        }, startChar + "");
    }

    // private Condition getCurCondition(Thread thread) {
    // return t1.equals(thread) ? charCondition : numberCondition;
    // }
    //
    // private Condition getOpCondition(Thread thread) {
    // return t2.equals(thread) ? charCondition : numberCondition;
    // }
}


class WaitNotifyAns extends BaseAns {

    private final Object lock;

    WaitNotifyAns() {
        lock = new Object();
    }

    @Override
    protected Thread createPrintThread(char startChar) {
        return new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        doPrint(startChar, i);
                        lock.notify();
                        lock.wait();
                    }
                }
            }
        });
    }
}
