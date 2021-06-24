package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {

    private Lock lock;
    private Condition conditionNumber;
    private Condition conditionFizz;
    private Condition conditionBuzz;
    private Condition conditionFizzbuzz;

    private int n;
    private volatile int cur;

    public FizzBuzz(int n) {
        this.n = n;
        this.cur = 1;
        this.lock = new ReentrantLock();
        this.conditionNumber = this.lock.newCondition();
        this.conditionFizz = this.lock.newCondition();
        this.conditionBuzz = this.lock.newCondition();
        this.conditionFizzbuzz = this.lock.newCondition();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (cur <= n) {
            try {
                lock.lock();
                if (cur % 3 != 0) {
                    conditionFizz.await();
                }
                if (cur <= n) {
                    printFizz.run();
                    cur++;
                    conditionNumber.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (cur <= n) {
            try {
                lock.lock();
                if (cur % 5 != 0) {
                    conditionBuzz.await();
                }
                if (cur <= n) {
                    printBuzz.run();
                    cur++;
                    conditionNumber.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (cur <= n) {
            try {
                lock.lock();
                if (cur % 3 != 0 || cur % 5 != 0) {
                    conditionFizzbuzz.await();
                }
                if (cur <= n) {
                    printFizzBuzz.run();
                    cur++;
                    conditionNumber.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (cur <= n) {
            try {
                lock.lock();
                while (cur <= n && (cur % 3 == 0 || cur % 5 == 0 )) {
                    if (cur % 3 == 0 && cur % 5 == 0) {
                        conditionFizzbuzz.signalAll();
                    } else if (cur % 3 == 0) {
                        conditionFizz.signalAll();
                    } else {
                        conditionBuzz.signalAll();
                    }
                    conditionNumber.await();
                }
                if (cur <= n) {
                    printNumber.accept(cur);
                    cur++;
                }
            } finally {
                lock.unlock();
            }
        }
        try {
            lock.lock();
            conditionFizz.signalAll();
            conditionBuzz.signalAll();
            conditionFizzbuzz.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(6);

        new Thread(()-> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                fizzBuzz.number(value -> System.out.println(value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
