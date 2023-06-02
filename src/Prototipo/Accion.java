package Prototipo;

import java.io.Serializable;


public class Accion implements Serializable{
    
    private String nombre;

    public Accion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
