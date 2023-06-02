package Ayudantias;

public class Alumno {
    private String nombre;
    private String rut;
    private Carrera carrera;
    
    public Alumno(String nombre, String rut, Carrera carrera) {
        this.nombre = nombre;
        this.rut = rut;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        String info;
        info = "\n";
        info+= "Nombre del alumno = " + this.nombre + "\n";
        info+= "Rut de el alumno  = " + this.rut +"\n";
        info+= "Carrera           = " + this.carrera.getNombre() + "\n";
        return info;
    }
    
    
    


}
