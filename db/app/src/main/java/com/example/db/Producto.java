package com.example.db;

public class Producto {
    private int codigo;
    private String nombre;
    private int precio;

    public Producto (int codigo, String nombre,int precio){
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
    }

    public Producto() {

    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
