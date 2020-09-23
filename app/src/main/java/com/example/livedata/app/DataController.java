package com.example.livedata.app;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DataController extends Application {

    private static DataController instance;
    private MutableLiveData<String> liveData = new MutableLiveData<>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static DataController getInstance() {
        return instance;
    }

    public LiveData<String> getData() {
        return liveData;
    }

    /**
     *     Метод setValue должен быть вызван из UI потока.
     *     Для обновления данных из других потоков используйте метод postValue.
     *     Он перенаправит вызов в UI поток.
     *     Соответственно, подписчики всегда будут получать значения в основном потоке.
     * @param newValue
     */
    public void setData(String newValue) {
        this.liveData.setValue(newValue);
    }
}
