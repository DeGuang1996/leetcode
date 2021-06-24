package multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

    private volatile int hNum;
    private Lock lock;
    private Condition conditionH;
    private Condition conditionO;

    public H2O() {
        this.hNum = 0;
        this.lock = new ReentrantLock();
        this.conditionH = lock.newCondition();
        this.conditionO = lock.newCondition();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            lock.lock();
            while (hNum == 2) {
                conditionO.signal();
                conditionH.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hNum++;
            if (hNum == 2) {
                conditionO.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            lock.lock();
            while (hNum != 2) {
                conditionO.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            hNum = 0;
            conditionH.signal();
        } finally {
            lock.unlock();
        }
    }
}
