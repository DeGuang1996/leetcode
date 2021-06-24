package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternativePrint {

    private volatile int num;
    private Lock lock;
    private Condition conditionA;
    private Condition conditionB;
    private Condition conditionC;

    public AlternativePrint() {
        num = 1;
        lock = new ReentrantLock();
        conditionA = lock.newCondition();
        conditionB = lock.newCondition();
        conditionC = lock.newCondition();
    }

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                conditionA.await();
            }
            System.out.println("A");
            num = 2;
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (num != 2) {
                conditionB.await();
            }
            System.out.println("B");
            num = 3;
            conditionC.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (num != 3) {
                conditionC.await();
            }
            System.out.println("C");
            num = 1;
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void start() {
        new Thread(() -> {
            try {
                while (true) {
                    printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        AlternativePrint alternativePrint = new AlternativePrint();
        alternativePrint.start();
    }
}
