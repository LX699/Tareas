package Prototipo;

import java.io.Serializable;


public class Producto implements Serializable{
    
    private String nombre;
    private String descripcion;
    private int cantidad;

    public Producto(String nombre, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }    

    @Override
    public String toString() {
        String info = "";
        info+= "Nombre              :\t" + this.nombre + "\n";
        info+= "Descripcion         :\t" + this.descripcion + "\n";
        info+= "Cantidad Disponible :\t" + this.cantidad + "\n";
        return info;
    }
    
    
}
