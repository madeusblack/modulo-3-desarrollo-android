package com.example.primeraappandroid

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    public void mostrarMensaje(View v){
        Toast.makeText(this, "Texto a Mostrar", Toast.LENGTH_LONG).show();
    }
}