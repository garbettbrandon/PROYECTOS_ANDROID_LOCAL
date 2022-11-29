package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView header, resultado;
    Button volver, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        header = findViewById(R.id.tvHeader);
        resultado = findViewById(R.id.tvResultado);
        volver = findViewById(R.id.btnVolver);
        reset = findViewById(R.id.btnReset);

        resultado.setText("0");

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivity();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActivity();
            }
        });
    }

    private void lanzarActivity() {
        Intent lanzar = new Intent(this,MainActivity.class);
        startActivity(lanzar);
    }
}