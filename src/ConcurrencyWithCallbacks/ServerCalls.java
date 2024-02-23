package ConcurrencyWithCallbacks;

public class ServerCalls {

    private Callback callback;
    public ServerCalls(Callback callback) {
        //empty constructor
        this.callback = callback;
    }

    public void fetchProductDetail(String productId) {
        getProductDetail("ProductID-1002");
    }

    private void getProductDetail(String productId) {
        //a dummy method to simulate long-running network call
        try {
            //assume thread.sleep() was a call to server, and it took 100 milliseconds to get a response.
            Thread.sleep(100);
            //assume this is the value we got from server after waiting for 100 milliseconds.
            String productName = "Samsung S23";
            // using the callback to notify that the fetch was successful and to pass the product name
            callback.onDataFetched(true,productName);
        } catch (InterruptedException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }

}
