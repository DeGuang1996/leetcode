package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {

    private int n;
    private Lock lock;
    private Condition condition1;
    private Condition condition2;
    private int num;

    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.condition1 = lock.newCondition();
        this.condition2 = lock.newCondition();
        this.num = 1;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (num != 1) {
                    condition1.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                num = 2;
                condition2.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (num != 2) {
                    condition2.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                num = 1;
                condition1.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
