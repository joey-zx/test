package Thread;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(new mm());

        System.out.println("Other Business Logic");

        System.out.println(future.get());

    }
}

class mm implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += i;
        }

        Thread.sleep(1000);

        return sum;
    }
}

