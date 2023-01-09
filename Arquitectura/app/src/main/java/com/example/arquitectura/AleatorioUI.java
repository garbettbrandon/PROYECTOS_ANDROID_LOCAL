package com.example.arquitectura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AleatorioUI extends AppCompatActivity {

    Button bt1;
    TextView tv1;
    LiveData<Integer> observableSoloTocar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        bt1 = findViewById(R.id.button);
        tv1 = findViewById(R.id.textView);

        AleatorioViewModel vm = new ViewModelProvider(this).get(AleatorioViewModel.class);
        observableSoloTocar = vm.getDatoAleatorio();
        observableSoloTocar.observe(this,(dato)->{
            tv1.setText(dato.toString());
        });

        bt1.setOnClickListener((v)->{
            tv1.setText("...");
            vm.nuevoAleatorio();
        });
    }
}