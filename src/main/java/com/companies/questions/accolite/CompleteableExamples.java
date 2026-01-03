package com.companies.questions.accolite;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompleteableExamples {

    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("Hello");

        int n = 5;
        ExecutorService executorService= Executors.newFixedThreadPool(n);
        List<CompletableFuture<Void>> futuresTasks = IntStream.range(1, n)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(5000);
                        System.out.println("Thread " + i + " Started");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, executorService))
                .collect(Collectors.toList());

        CompletableFuture
                .allOf(futuresTasks.toArray(new CompletableFuture[0]))
                .thenRun(() -> CompletableFuture.runAsync(() -> {
                    System.out.println("New Thread started");
                    try {
                        Thread.sleep(5000);

                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                })).join();

        executorService.shutdown();

    }
}
