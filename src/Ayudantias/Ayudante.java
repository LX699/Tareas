package Ayudantias;

import java.util.ArrayList;

public class Ayudante {
    private Alumno alumno;
    private ArrayList<Asignatura> asignaturas = new ArrayList();

    public Ayudante(Alumno alumno, Asignatura asignatura) {
        this.alumno = alumno;
        this.asignaturas.add(asignatura);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    private String returAsignaturas(){
        String info = "\n";
        for (int i = 0; i < this.asignaturas.size(); i++) {
            info += (i+1) + " : " + this.asignaturas.get(i).getNombre() + "\n";
        }
        
        return info;
    }

    @Override
    public String toString() {
        String info;
        info = "\n";
        info+= "Nombre del Ayudante = " + this.alumno.getNombre() + "\n";
        info+= "Asignaturas en las que es ayudante:";
        info+= returAsignaturas();
        return info;
    }
    
    
    
        
}
