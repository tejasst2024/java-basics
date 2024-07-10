package com.java.basics.threadpool;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class ThreadPoolExecutorImpl extends ThreadPoolExecutor {

    public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public ThreadPoolExecutorImpl(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void afterExecute(Runnable runnable, Throwable t) {
        if(t != null) {
            System.out.println(t);
            throw new RuntimeException(t);
        }
    }
}
public class ThreadPoolExecutors {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1);
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.MILLISECONDS, queue);

        Callable<Integer> callable = () -> {
            System.out.println(Thread.currentThread().getName());
//            System.out.println(4/0);
//            Thread.sleep(500);
            return 1;
        };
        IntStream.range(1, 100).forEach(i -> {
            System.out.println(i + " call");
            System.out.println("Pool size : " + threadPoolExecutor.getPoolSize());
            System.out.println("Core pool size : " + threadPoolExecutor.getCorePoolSize());
            System.out.println("Max pool size : " + threadPoolExecutor.getMaximumPoolSize());
            System.out.println("Active threads : " + threadPoolExecutor.getActiveCount());
            System.out.println("Queue size : " + threadPoolExecutor.getQueue().size());
            System.out.println("Completed : " + threadPoolExecutor.getCompletedTaskCount());
            System.out.println("Task count : " + threadPoolExecutor.getTaskCount());
            System.out.println("Thread pool executor : " + threadPoolExecutor);
            List<Future<Integer>> futureList = new ArrayList<>();
            futureList.add(threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
//            System.out.println(4/0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 1;
            }));
            futureList.forEach(future -> {
                try {
                    future.get(1,TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }
            });
//           Future<Integer> future = new CompletableFuture<>();
//            try {
//                System.out.println(future.get(1, TimeUnit.SECONDS));
//            } catch (InterruptedException | ExecutionException | TimeoutException | ArithmeticException e) {
//                System.out.println("Exception for i : " + i + e);
//            }
        });
    }
}
