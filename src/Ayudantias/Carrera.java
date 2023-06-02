package Ayudantias;

public class Carrera {
    private String nombre;
    private int semestres;
    private String director;

    public Carrera(String nombre, int semestres, String director) {
        this.nombre = nombre;
        this.semestres = semestres;
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestres() {
        return semestres;
    }

    public void setSemestres(int semestres) {
        this.semestres = semestres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        String info;
        info = "Nombre de la carrera   = " + this.nombre + "\n";
        info+= "Duracion de la carrera = " + this.semestres +" semestres \n";
        info+= "Director de carrera    = " + this.director + "\n";
        
        return info;
        
    }
    
    

    
    
     
    
    
    
    
    
}
