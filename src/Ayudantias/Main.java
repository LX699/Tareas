package Ayudantias;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        
       pruebas();
        
        
    }
    
    public static void pruebas(){
        
        //Carrera
        Carrera carrera = new Carrera("Carrera", 10, "El director");
        System.out.println(carrera.toString());
        
        //Alumno
        Alumno alumno = new Alumno("Luis Sanhueza", "20.257.654-k", carrera);
        System.out.println(alumno.toString());
        
        //Horario
        Date fecha1 = new Date(120, 10, 25, 19, 30, 0);
        Date fecha2 = new Date(120, 10, 25, 21, 30, 0);
        Horario horario = new Horario(fecha1, fecha2);
        System.out.println(horario.toString());
        
        //Asignatura
        Asignatura asignatura = new Asignatura("Calculo", "El profe", horario);
        System.out.println(asignatura.toString());
        
        //Ayudante
        Ayudante ayudante = new Ayudante(alumno, asignatura);
        System.out.println(ayudante.toString());
        
        //Ayudantia
        Ayudantia ayudantia = new Ayudantia(asignatura, ayudante, horario);
        System.out.println(ayudantia.toString());
        
    }
    
}
