package com.hwxy.order.l1100.lc1114;

public class Foo {
    /**
     * 是否first完成了
     */
    private volatile boolean firstComplete;
    /**
     * 是否second完成了
     */
    private volatile boolean secondComplete;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        try {
            printFirst.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            firstComplete = true;
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!firstComplete) {
            Thread.sleep(5);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        try {
            printSecond.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            secondComplete = true;
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!secondComplete) {
            Thread.sleep(10);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
