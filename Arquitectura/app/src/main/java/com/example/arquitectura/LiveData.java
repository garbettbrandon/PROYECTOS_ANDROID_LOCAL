package com.example.arquitectura;

import static java.lang.Integer.MAX_VALUE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LiveData extends AppCompatActivity {

    Button bt1;
    TextView tv1;

    MutableLiveData<Integer> datoObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        bt1 = findViewById(R.id.button);
        tv1 = findViewById(R.id.textView);

        datoObservable = new MutableLiveData<Integer>(0);
        datoObservable.observe(this, dato -> {
            tv1.setText(dato.toString());
        });

        bt1.setOnClickListener(view -> {
            datoObservable.postValue(new Integer((int)Math.random()*MAX_VALUE));
        });
    }
}