package Prototipo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Guardado {
    //Esta clase es utilizada para guardar y recuperar datos

    public Guardado() {
    }
    
        public void guardarObjeto(String nombreArchivo,Object objeto){
        try {
            //OutputStream output = new FileOutputStream(nombreArchivo);
            //ObjectOutputStream objput = new ObjectOutputStream(output);
            //Estas 2 lienas se pueden resumir como la siguiente
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            
            ficheroSalida.writeObject(objeto);
            ficheroSalida.close();
            
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
    
    public Object recuperarObjeto(String nombreArchivo){
        Object objeto = null;
        try {
            ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
            
            objeto = ficheroEntrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error : " + e.getMessage());
        }
        return objeto;
        
    }
}
