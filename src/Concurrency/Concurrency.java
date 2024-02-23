package Concurrency;

import java.util.concurrent.CompletableFuture;

public class Concurrency {

    public static void main(String[] args) {

        CompletableFuture<Void> asyncLauncher = CompletableFuture.runAsync(() -> {
            // Asynchronous task
            System.out.println("Asynchronous task is running...");
            ServerCalls serverCalls = new ServerCalls();
            //make the call to the server to fetch the product detail
            serverCalls.fetchProductDetail("ProductID-200");
        });

        //welcome message
        System.out.println("Welcome to concurrency concept");

        //checking if the data fetch was successful or not inside while loop
        while (!asyncLauncher.isDone()) {
            //print message if fetch process is not yet completed
            System.out.println("Background task is still running...");
        }

        //closing the application
        System.out.println("Background task is completed");
        System.out.println("Shutting down application");
    }

}
