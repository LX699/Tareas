package Ayudantias;

public class Asignatura {
    
    private String nombre;
    private String Profesor;
    private Horario Horario;

    public Asignatura(String nombre, String Profesor, Horario Horario) {
        this.nombre = nombre;
        this.Profesor = Profesor;
        this.Horario = Horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String Profesor) {
        this.Profesor = Profesor;
    }

    public Horario getHorario() {
        return Horario;
    }

    public void setHorario(Horario Horario) {
        this.Horario = Horario;
    }

    @Override
    public String toString() {
        String info;
        info = "\n";
        info+= "Nombre de la Asinatura  = " + this.nombre + "\n";
        info+= "Profesor que la imparte = " + this.Profesor +"\n";
        info+= this.Horario.toString(2);
        
        return info;
    }
    
    
    
    
    
     
    
    
}
