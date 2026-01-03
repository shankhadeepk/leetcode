package com.companies.questions.morganstanley;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * There are set of tasks running parallely. Once all tasks are completed then start another task.
 *  https://www.youtube.com/watch?v=JoYFkYqE8S0
 * */

public class CompletableFutureMultipleThread {

    public static void main(String[] args) {

        int n = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(n);

        List<CompletableFuture<Void>> completableTasks = IntStream.rangeClosed(1, n)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    System.out.println("Task " + i + " Started");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Task " + i + " finished");
                }, executorService))
                .collect(Collectors.toList());

        CompletableFuture
                .allOf(completableTasks.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("After all tasks are done, new task has started");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).join();

        executorService.shutdown();

    }

}
