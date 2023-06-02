package Ayudantias;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Horario {
    
    private Date inicio;
    private Date termino;

    public Horario(Date inicio, Date termino) {
        this.inicio = inicio;
        this.termino = termino;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
    private String formatHorario(Date hora,int tipo){
        if (tipo == 1){
            SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd HH:mm");
            String horaFormateada = formatoFecha.format(hora);
            return horaFormateada;
            
        }else if(tipo == 2){
            SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
            String horaFormateada = formatoFecha.format(hora);
            return horaFormateada;
        }
        return "Error elija tipo 1 o 2";
    }

    public String toString(int tipo) {
        String info;
        if(tipo == 1){
            info = "\n--Horario--\n";
            info+= "Inicio  = " + formatHorario(this.inicio,1)  + "\n";
            info+= "Termino = " + formatHorario(this.termino,1) + "\n";
            return info;
        }else if(tipo == 2){
            info = "\n--Horario--\n";
            info+= "Inicio  = " + formatHorario(this.inicio , 2)  + "\n";
            info+= "Termino = " + formatHorario(this.termino , 2) + "\n";
            return info;
        }
        return "Error elija  tipo 1 o 2";
        
    }
    
    
    
    
    
    
    
}
