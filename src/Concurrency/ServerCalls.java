package Concurrency;

public class ServerCalls {

    public ServerCalls() {
        //empty constructor
    }

    public void fetchProductDetail(String productId) {
        String productName = getProductDetail("ProductID-1002");
        System.out.println("\nProduct Name is " + productName);
    }

    private String getProductDetail(String productId) {
        //a dummy method to simulate long-running network call
        try {
            //assume thread.sleep() was a call to server, and it took 100 milliseconds to get a response.
            Thread.sleep(100);
            //assume this is the value we got from server after waiting for 100 milliseconds.
            return "Samsung S23";
        } catch (InterruptedException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }

}
