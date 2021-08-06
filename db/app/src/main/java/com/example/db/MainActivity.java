package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edCodigo,edNombre,edPrecio;
    private Spinner sp1;
    ArrayList<String> listaProductos;
    ArrayList<Producto> productosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edCodigo=findViewById(R.id.producto);
        edPrecio=findViewById(R.id.precio);
        edNombre=findViewById(R.id.nombre);
        sp1=findViewById(R.id.spinner);
        consultarListaProductos();
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listaProductos);
        sp1.setAdapter(adaptador);

    }
    public void consultarListaProductos(){
        Adminbd admin= new Adminbd (this,"Productos",null,1);
        SQLiteDatabase base=admin.getWritableDatabase();
        Producto p1=null;
        productosList = new ArrayList<Producto>();
        Cursor fila = base.rawQuery("select * from producto",null);
        while(fila.moveToNext()){
            p1=new Producto();
            p1.setCodigo(fila.getInt(0));
            p1.setNombre(fila.getString(1));
            p1.setPrecio(fila.getInt(2));
            productosList.add(p1);
        }
        Toast.makeText(this,"termina while", Toast.LENGTH_LONG).show();
        obtenerProductos();
        base.close();
    }
    public void obtenerProductos(){
        listaProductos = new ArrayList<String>();
        for(int i=0; i<productosList.size();i++){
            listaProductos.add(productosList.get(i).getCodigo()+" - "
            + productosList.get(i).getNombre()+" - "+productosList.get(i).getPrecio());
        }
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
                Toast.makeText(this,"no Existe el Producto",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"debe ingresar el codigo del producto",Toast.LENGTH_LONG).show();
        }
    }
    public void modificar(View v){
        Adminbd admin = new Adminbd(this,"Productos",null,1);
        SQLiteDatabase base=admin.getWritableDatabase();
        String codigo = edCodigo.getText().toString();
        String nombre = edNombre.getText().toString();
        String precio = edPrecio.getText().toString();
        if(!codigo.isEmpty() &&!nombre.isEmpty() &&!precio.isEmpty()) {
            ContentValues modificar = new ContentValues();
            modificar.put("codigo",codigo);
            modificar.put("nombre",nombre);
            modificar.put("precio",precio);
            base.update("producto",modificar,"codigo="+codigo,null);
            base.close();
            Toast.makeText(this,"Registro Modificado", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Debe llenar todos los campos", Toast.LENGTH_LONG).show();

        }
        }
    public void eliminar(View v){
        Adminbd admin = new Adminbd(this,"Productos",null,1);
        SQLiteDatabase base=admin.getWritableDatabase();
        String codigo=edCodigo.getText().toString();
        if(!codigo.isEmpty()) {

            base.delete("producto","codigo="+codigo,null);
            base.close();
            Toast.makeText(this,"Registro eliminado", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"debe ingresar el codigo del producto",Toast.LENGTH_LONG).show();

        }
    }
}