package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var edad : Int
        var nota : Float = 6.6f
        var nota2 : Double = 5.4
        var letra : Char = 'f'
        var nombre : String = "Madeus"
        var check : Boolean = false
        edad = 35
        var edad2 : Int = 35
        Toast.makeText(this, "la edad es "+edad , Toast.LENGTH_LONG).show()
        val edad3 : Int = 36
        calcular
    }
    fun funcionPrueba(v : View){
        Toast.makeText(this, "hola " , Toast.LENGTH_LONG).show()

    }
}