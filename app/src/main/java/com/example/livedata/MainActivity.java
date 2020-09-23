package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.TextView;

import com.example.livedata.app.DataController;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        LiveData<String> liveData = DataController.getInstance().getData();

        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String value) {
                textView.setText(value);
            }
        });
    }
}
