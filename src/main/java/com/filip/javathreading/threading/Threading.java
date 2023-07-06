package hr.sarda.backend.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class Threading {
    static final Logger LOG = LoggerFactory.getLogger(Threading.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //ExecutorService
        // - simplifies running tasks in asynchronous mode
        // - automatically provides a pool of threads and an API for assigning tasks to it

        //Create
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //Create alternative
        ExecutorService executorService1 = new ThreadPoolExecutor(
                1,1,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>()
        );

        //Returning void
        Runnable runnable = () -> {
            LOG.info("task 1");
            LOG.info("task 2");
        };

        //Has a non-void returning value
        Callable<String> callable = () -> {
            LOG.info("callable task 1");
            Thread.sleep(4000);
            return "Hello from callable";
        };

        //Executing runnable
        executorService.execute(runnable);

        Future<String> future = executorService.submit(callable);

        // BLOCKING call
        LOG.info(future.get());

        executorService.execute(() -> {
            LOG.info("task lambda 1");
            LOG.info("task lambda 2");
        });

        executorService.shutdown();
    }
}
