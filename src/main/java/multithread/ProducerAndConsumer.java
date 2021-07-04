package multithread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ProducerAndConsumer {

    private Random random = new Random();
    private ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    public void producer() {
        int i = random.nextInt(100);
        try {
            arrayBlockingQueue.put(i);
        } catch (Exception e) {

        }
    }

    public void consumer() {
        try {
            System.out.println(arrayBlockingQueue.take());
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        new Thread(() -> {
            while (true) {
                producerAndConsumer.producer();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                producerAndConsumer.consumer();
            }
        }).start();
    }
}
