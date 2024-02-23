package WithoutConcurrency;

public class WithoutConcurrency {

    public static void main(String[] args) {

        ServerCalls serverCalls = new ServerCalls();
        //make the call to the server to fetch the product detail
        serverCalls.fetchProductDetail("ProductID-200");

        //welcome message
        System.out.println("Welcome to synchronous programming");

        //closing the application
        System.out.println("Shutting down application");

    }

}
