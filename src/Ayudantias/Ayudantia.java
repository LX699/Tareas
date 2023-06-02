package Ayudantias;

import java.util.ArrayList;

public class Ayudantia {
    
    private Asignatura asignatura;
    private Ayudante ayudante;
    private Horario horario;
    private ArrayList<Alumno> alumnos = new ArrayList();

    public Ayudantia(Asignatura asignatura, Ayudante ayudante, Horario horario) {
        this.asignatura = asignatura;
        this.ayudante = ayudante;
        this.horario = horario;
    }

   

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Ayudante getAyudante() {
        return ayudante;
    }

    public void setAyudante(Ayudante ayudante) {
        this.ayudante = ayudante;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    private String returAlumnos(){
        String info = "\n";
        for (int i = 0; i < this.alumnos.size(); i++) {
            info += (i+1) + " : " + this.alumnos.get(i).getNombre() + "\n";
        }
        return info;
    }
    
    @Override
    public String toString() {
        String info;
        info = "\n";
        info+= "--Ayudantia--\n";
        info+= "Asignatura de la cual tratara : " + this.asignatura.getNombre() + "\n";
        info+= "Ayudante a cargo              : " + this.ayudante.getAlumno().getNombre()+ "\n";
        info+= this.horario.toString(1);
        info+= "\n--Alumnos inscritos--";
        info+= returAlumnos();
         
        return info;
    }
    
    
    
    
    
    
    
}
