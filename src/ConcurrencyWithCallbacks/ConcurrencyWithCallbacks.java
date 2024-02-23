package ConcurrencyWithCallbacks;

import java.util.concurrent.CompletableFuture;

public class ConcurrencyWithCallbacks {

    // a boolean flag to denote if the data is fetched or not
    private static boolean isDataFetched = false;

    public static void main(String[] args) {

        CompletableFuture<Void> asyncLauncher = CompletableFuture.runAsync(() -> {
            // Asynchronous task
            System.out.println("Asynchronous task is running...");
            ServerCalls serverCalls = new ServerCalls(new Callback() {
                @Override
                public void onDataFetched(boolean isSuccessful, String productName) {
                    if (isSuccessful == true) {
                        //change the boolean flag to true
                        isDataFetched = true;
                        System.out.println("Product Name is : "+productName);
                    }
                }
            });
            //make the call to the server to fetch the product detail
            serverCalls.fetchProductDetail("ProductID-200");
        });

        //welcome message
        System.out.println("Welcome to concurrency concept with callbacks");

        //checking if the data fetch was successful or not inside while loop
        while (!isDataFetched) {
            //print message if fetch process is not yet completed
            System.out.println("Background task is still running...");
        }

        //closing the application
        System.out.println("Background task is completed");
        System.out.println("Shutting down application");
    }

}
