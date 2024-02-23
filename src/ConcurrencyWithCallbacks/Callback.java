package ConcurrencyWithCallbacks;

public interface Callback {
    // a method that can be called to notify that data is fetched
    void onDataFetched(boolean isSuccessful,String productName);
}
