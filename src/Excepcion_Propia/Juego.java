package Excepcion_Propia;


import Excepcion_Propia.exception;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//este juego tratara de ordenar de menor a mayor un array  que contiene n digitos
public class Juego {
    private static ArrayList<Integer> digitos = new ArrayList();
    private  int cantidad;

    public Juego() {
        
    }
    
    private void llenarArrays(){
        Random rand = new Random();
        digitos.add(rand.nextInt(cantidad)+1);
        for (int i = 0; i < cantidad-1; i++) {
            int numero = rand.nextInt(cantidad)+1;
            
            if(isDuplicado(numero)){
                i--;
            }else{
                digitos.add(numero);
            }
        }
    }
    
    private boolean isDuplicado(int num){
        int numerin;
        for (int i = 0; i < digitos.size(); i++) {
            numerin = digitos.get(i);
            if(num == numerin ){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
    
    private void intercambiar(int numero1, int numero2){
        if(numero1 <= cantidad && numero1 > 0 && numero2 <= cantidad && numero2 > 0){
            int num1 = digitos.get(numero1-1);
            int num2 = digitos.get(numero2-1);
        
            digitos.set(numero1-1, num2);
            digitos.set(numero2-1, num1);
        }else{
            throw new exception("-Una  de las posiciones seleccionadas estaba fuera del rango correcto-");
        }
        
        
    }
    private boolean isWin(){
        int contador = 0;
        for (int i = 0; i < cantidad; i++) {
            int numero = digitos.get(i);
            if(numero == i+1)
                contador++;
        }
        if(contador == cantidad){
            System.out.println("Weeeena Ganaste");
            return true;
        }else{
            return false;
        }
    }
    
    private void imprimir(){
        System.out.println("\n----------------");
        digitos.forEach(e ->{
            System.out.println(e.toString());
        });
        System.out.println("--------------\n");
        
    }
    
    public void jugar(){
        Scanner intro = new Scanner(System.in);
        System.out.println("--Este juego trata sobre  ordenar de mayor a menor los numeros--");
        System.out.println("--Primero que nada se te preguntara la cantidad de numeros los cuales quieres ordenar--");
        System.out.println("-ingrese cantidad de numeros--");
        cantidad = intro.nextInt();
        llenarArrays();
        try{
            do{
            imprimir();
            System.out.println("--Ingrese ahora los numero de los cuales desea intercambiar posicion--");
            System.out.println("Numero 1 \n -");
            int num1 = intro.nextInt();
            System.out.println("Numero 2 \n -");
            int num2 = intro.nextInt();
            intercambiar(num1, num2);
            
            }while(isWin()==false);
        }catch(exception e){
            System.out.println("--una de las posiciones seleccionadas era incorrecta--");
        }
        
        
}
    
}
