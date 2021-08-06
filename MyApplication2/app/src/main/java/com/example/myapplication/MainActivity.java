package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText e1,e2;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.operador);
        e2=findViewById(R.id.operando);
        t1=findViewById(R.id.resultado);
    }
    public void sumar(View v){

        int valor1=Integer.parseInt(e1.getText().toString());
        int valor2=Integer.parseInt(e2.getText().toString());
        int suma=valor1+valor2;
        t1.setText("test"+suma);

    }


    public void mostrarMensaje(View v){
        Toast.makeText(this, "Texto a Mostrar", Toast.LENGTH_LONG).show();
    }
}