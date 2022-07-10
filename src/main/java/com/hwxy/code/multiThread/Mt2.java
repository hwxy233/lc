package com.hwxy.code.multiThread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 生产者消费者问题
 *
 * @author hwxy
 * @date 2022/07/09
 **/
public class Mt2 {
    public static void main(String[] args) {
        Mt2 mt2 = new Mt2();
        mt2.produceConsume();
    }

    /**
     * 有界的buffer
     */
    private final static Object ELEMENT = new Object();
    public static final int BUFFER_SIZE = 10;
    private final Queue<Object> buffer;
    /**
     * 需要2个条件变量
     */
    private final ReentrantLock lock;
    private final Condition notFull;
    private final Condition notEmpty;

    Mt2() {
        buffer = new ArrayDeque<>(BUFFER_SIZE);
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    /**
     * 生产者等待notFull
     * 通知notEmpty
     */
    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (buffer.size() == BUFFER_SIZE) {
                        notFull.await();
                    }
                    buffer.offer(ELEMENT);
                    System.out.println("offer:" + buffer.size());
                    notEmpty.signalAll();
                    notFull.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * 消费者等待notEmpty
     * 通知notFull
     */
    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (buffer.isEmpty()) {
                        notEmpty.await();
                    }
                    buffer.poll();
                    System.out.println("poll:" + buffer.size());
                    notFull.signalAll();
                    notEmpty.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void produceConsume() {
        IntStream.range(0, 10).forEach(i -> {
            Producer producer = new Producer();
            producer.start();
        });

        IntStream.range(0, 10).forEach(i -> {
            Consumer consumer = new Consumer();
            consumer.start();
        });

    }
}
