package com.example.groupbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {
    private EditText edCodigo,edNombre,edPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        edCodigo=findViewById(R.id.codigoProducto);
        edPrecio=findViewById(R.id.precio2);
        edNombre=findViewById(R.id.nombre2);
    }


    public void crear (View v){
        Adminbd admin= new Adminbd (this,"Productos",null,1);
        SQLiteDatabase base=admin.getWritableDatabase();
        String codigo = edCodigo.getText().toString();
        String nombre = edNombre.getText().toString();
        String precio = edPrecio.getText().toString();

        if(!codigo.isEmpty() &&!nombre.isEmpty() &&!precio.isEmpty()){
            ContentValues crear= new ContentValues();
            crear.put("codigo",codigo);
            crear.put("nombre",nombre);
            crear.put("precio",precio);
            base.insert("Producto",null,crear);
            base.close();
            edNombre.getText().clear();
            edPrecio.getText().clear();
            edCodigo.getText().clear();
            Toast.makeText(this,"Producto Creado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
    public void buscar(View v){
        Adminbd admin = new Adminbd(this,"Productos",null,1);
        SQLiteDatabase base=admin.getWritableDatabase();
        String codigo=edCodigo.getText().toString();
        if(!codigo.isEmpty()){
            Toast.makeText(this,"entro en if ",Toast.LENGTH_LONG).show();
            Cursor fila=base.rawQuery("select nombre,precio from Producto where codigo ="+ codigo,null);
            Toast.makeText(this,"paso cursor ",Toast.LENGTH_LONG).show();

            if(fila.moveToFirst()) {
                edNombre.setText(fila.getString(0));
                edPrecio.setText(fila.getString(1));
                base.close();
            }else {
                Toast.makeText(this,"no Existe el PRoducto",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"debe ingresar el codigo del producto",Toast.LENGTH_LONG).show();
        }
    }
}