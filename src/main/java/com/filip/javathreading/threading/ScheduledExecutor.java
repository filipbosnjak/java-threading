package hr.sarda.backend.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class ScheduledExecutor {

    static final Logger LOG = LoggerFactory.getLogger(ScheduledExecutor.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("asd");

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        Callable<String> callable = () -> "Hello from callable";

        Runnable runnable = () -> {
            System.out.println("Hello from runnable");
        };

        Future<String> future = scheduledExecutorService.schedule(callable, 3, TimeUnit.SECONDS);

        System.out.println(future.get());

        // Runs every second with initial delay of 1 second
        scheduledExecutorService.scheduleAtFixedRate(runnable, 2, 1, TimeUnit.SECONDS);
    }
}
