package multithread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private int n;
    private Semaphore semaphoreZero;
    private Semaphore semaphoreOdd;
    private Semaphore semaphoreEven;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.semaphoreZero = new Semaphore(1);
        this.semaphoreOdd = new Semaphore(0);
        this.semaphoreEven = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            this.semaphoreZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                this.semaphoreOdd.release();
            } else {
                this.semaphoreEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i++) {
            this.semaphoreEven.acquire();
            printNumber.accept(i);
            this.semaphoreZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            this.semaphoreOdd.acquire();
            printNumber.accept(i);
            this.semaphoreZero.release();
        }
    }
}
