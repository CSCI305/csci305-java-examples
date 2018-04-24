package concurrent.prodcons;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

    public void process(int numThreads, int p1, int p2, int c1, int c2) {
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        ExecutorService exService = Executors.newFixedThreadPool(numThreads);
        Producer prod1 = new Producer(transferQueue, "1", p1);
        Producer prod2 = new Producer(transferQueue, "2", p2);
        Consumer cons1 = new Consumer(transferQueue, "1", c1);
        Consumer cons2 = new Consumer(transferQueue, "2", c2);

        // when
        exService.execute(prod1);
        exService.execute(prod2);
        exService.execute(cons1);
        exService.execute(cons2);

        // then
        try {
            exService.awaitTermination(5000, TimeUnit.MILLISECONDS);
            exService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {

    private TransferQueue<String> jobQ;

    private String name;

    private int messagesToProduce;

    private AtomicInteger messagesProduced = new AtomicInteger();

    public Producer(TransferQueue<String> jobQ, String name, int messagesToProduce) {
        this.jobQ = jobQ;
        this.name = name;
        this.messagesToProduce = messagesToProduce;
    }

    @Override
    public void run() {
        for (int i = 0; i < messagesToProduce; i++) {
            try {
                String msg = "Message-" + name + "-" + i;
                boolean added
                        = jobQ.tryTransfer("Message-" + name + "-" + i, 4000, TimeUnit.MILLISECONDS);
                if(added){
                    messagesProduced.incrementAndGet();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private TransferQueue<String> jobQ;

    private String name;

    private int jobsToConsume;

    private AtomicInteger jobsConsumed = new AtomicInteger();

    public Consumer(TransferQueue<String> jobQ, String name, int jobsToConsume) {
        this.jobQ = jobQ;
        this.name = name;
        this.jobsToConsume = jobsToConsume;
    }

    @Override
    public void run() {
        for (int i = 0; i < jobsToConsume; i++) {
            try {
                String element = jobQ.take();
                ProdConVis.getInstance().update(element, name);
                longProcessing(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void longProcessing(String element)
            throws InterruptedException {
        jobsConsumed.incrementAndGet();
        Thread.sleep(50);
    }
}
