package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    RadioButton sumar, restar, div, multi;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.etNum1);
        num2 = findViewById(R.id.etNum2);
        sumar = findViewById(R.id.rSuma);
        restar = findViewById(R.id.rResta);
        multi = findViewById(R.id.rMulti);
        div = findViewById(R.id.rDiv);
        calcular = findViewById(R.id.btnCalcular);

        String operacion = "";
        if (sumar.isChecked()){
            operacion = String.valueOf(sumar);
        }else if (restar.isChecked()){
            operacion = String.valueOf(restar);
        }else if (multi.isChecked()){
            operacion = String.valueOf(multi);
        }else if (div.isChecked()){
            operacion = String.valueOf(div);
        }

        String finalOperacion = operacion;

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (num1.getText().equals("") || num2.getText().equals("") || finalOperacion.equals("")){
                        //Toast.makeText(this ,"Has dejado un numero vacio",Toast.LENGTH_LONG).show();
                    }
                    lanzarActivity(num1.getText(), num2.getText(), finalOperacion);
                }
            }
        );
    }
    private void lanzarActivity(Editable num1, Editable num2, String operacion) {
        Intent lanzar = new Intent(this,ResultadoActivity.class);
        startActivity(lanzar);
    }
}