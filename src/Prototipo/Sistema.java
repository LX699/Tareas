package Prototipo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sistema {
    
    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Producto> productos = new ArrayList();
    private ArrayList<Registro> registros = new ArrayList();
    private final String archivo1 = "Archivo1.bin";
    private final String archivo2 = "Archivo2.bin";
    private final String archivo3 = "Archivo3.bin";
    private Usuario usuarioActivo;

    public Sistema(){
        
    }
    public void iniciarSistema(){
        cargarDatos();
        try {
            primerMenu();

        } catch (Exception e) {
            System.out.println("--Error Seguramente ingreso mal los datos--");
            guardarDatos();
            iniciarSistema();
        }
        try {
            segundoMenu();
        } catch (Exception e) {
            System.out.println("--Error Seguramente ingreso mal los datos--");
            guardarDatos();
            iniciarSistema();
        }
        
    }
    
    private void cargarDatos(){
        Guardado guardado = new Guardado();
        File directorio1 = new File(archivo1);
        File directorio2 = new File(archivo2);
        File directorio3 = new File(archivo3);
        
        if (directorio1.exists()) {
            usuarios = (ArrayList<Usuario>) guardado.recuperarObjeto(archivo1);
        }
        if (directorio2.exists()) {
            productos = (ArrayList<Producto>) guardado.recuperarObjeto(archivo2);
        }
        if (directorio3.exists()) {
            registros = (ArrayList<Registro>) guardado.recuperarObjeto(archivo3);
        }
    }
    
    private void guardarDatos(){
        Guardado guardado = new Guardado();
        
        guardado.guardarObjeto(archivo1, this.usuarios);
        guardado.guardarObjeto(archivo2, this.productos);
        guardado.guardarObjeto(archivo3, this.registros);
        
    }
    
    private void primerMenu() {
        Scanner intro = new Scanner(System.in);
        int opcion;
        String info;
        while(usuarioActivo == null){
            info = "\t--ingrese una de las  siguientes opciones-- \n";
            info+= "1- Crear nuevo usuario\n";
            info+= "2- iniciar sesion\n";
            info+= "3- Salir\n";
        
            System.out.println(info);
            opcion = intro.nextInt();
        
            switch (opcion){
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    guardarDatos();
                    System.exit(0);
                    break;
            }
        }
    }
    
    private void segundoMenu(){
        Scanner intro = new Scanner(System.in);
        int opcion;
        String info;
        do{
            info = "\t--ingrese una de las  siguientes opciones-- \n";
            info+= "1- Crear un producto\n";
            info+= "2- Modificar un producto-\n";
            info+= "3- Registro\n";
            info+= "4- volver Atras\n";
        
            System.out.println(info);
            opcion = intro.nextInt();
        
            switch (opcion){
                case 1:
                    crearProducto();
                    break;
                case 2:
                    tercerMenu();
                    break;
                case 3:
                    imprimirRegistros();
                    break;
                case 4:
                    guardarDatos();
                    this.usuarioActivo = null;
                    iniciarSistema();
                    break;
            }
        }while(opcion != 4);
    }
    
    private void tercerMenu(){
        if (!productos.isEmpty()) {
        Scanner intro = new Scanner(System.in);
            int opcion, indice, cantidad;
            String info;
            imprimirProductos();
            do{
                info = "\t--ingrese una de las  siguientes opciones-- \n";
                info+= "1- Agregar \n";
                info+= "2- Quitar  \n";
                info+= "3- cancelar \n";

                System.out.println(info);
                opcion = intro.nextInt();
                

                switch (opcion){
                    case 1:
                        System.out.println("-Elija sobre que producto quiere que se realice-");
                        indice = intro.nextInt();
                        System.out.println("-Ingrese la cantidad-");
                        cantidad = intro.nextInt();
                        modificarProducto(1, indice-1, cantidad);
                        break;
                    case 2:
                        System.out.println("-Elija sobre que producto quiere que se realice-");
                        indice = intro.nextInt();
                        System.out.println("-Ingrese la cantidad-");
                        cantidad = intro.nextInt();
                        modificarProducto(2, indice-1, cantidad);
                        break;
                    case 3:
                        guardarDatos();
                        break;
                }
            }while(opcion != 3);
            
        }else{
            System.out.println("\n--Aun no hay productos--\n");
        }
    }
    
    private void crearUsuario(){
        //falta cubrir mas ambitos para los posibles errores
        Scanner intro = new Scanner(System.in);
        String nombre, correo, clave;
        System.out.println("\n\t---Creacion Usuario---\n");
        System.out.println("-Ingrese el correo electronico-");
        correo = intro.next();
        if (!encontrar(3, correo, null)) {
            System.out.println("-Ingrese su nombre-");
            nombre = intro.next();
            System.out.println("-Ingrese su nueva contraseña-");
            clave = intro.next();

            Usuario usuario = new Usuario(nombre, correo, clave);
            this.usuarios.add(usuario);

            System.out.println("\n\t--Felicidades usuario creado con exito--\n");            
        }else{
            System.out.println("\n\t--El correro Electronico ya esta registrado--\n");
        }

        
    }
    
    private void iniciarSesion(){
        Scanner intro = new Scanner(System.in);
        String correo, contraseña;
        
        if(!usuarios.isEmpty()){
            System.out.println("\n\t---Inicio de session---\n");
            System.out.println("-Ingrese su correo electronico-");
            correo = intro.next();
            System.out.println("-Ingrese su contraseña-");
            contraseña = intro.next();
            
            if(encontrar(1, correo, contraseña)){
                System.out.println("\n\t--Sesion iniciada con exito--\n");
                System.out.println("\t<<Bienvenido " + usuarioActivo.getNombre() + ">>\n");
            }
        }else{
            System.out.println("\n\t--Aun no existen usuarios--\n");
            
        }
    }
    
    private void crearProducto(){
        Accion crear = new Accion("Creacion");
        Scanner intro = new Scanner(System.in);
        String nombre, descripcion = null;
        int cantidad = 0;
        
        System.out.println("\n\t---Creacion de Producto---\n");
        System.out.println("-Ingrese el nombre de el producto-");
        nombre = intro.next();
        
        if(!encontrar(2, nombre, null)){
            System.out.println("-Ingrese una Descripcion-");
            descripcion = intro.next();
            System.out.println("-Ingrese la cantidad-");
            cantidad = intro.nextInt();
            
            Producto producto = new Producto(nombre, descripcion, cantidad);
            productos.add(producto);
            Date fecha = new Date();
            Registro registro = new Registro(fecha, producto, this.usuarioActivo, crear, cantidad);
            registros.add(registro);
            
            System.out.println("\n\t--Producto ingresado Exitosamente--\n");
        }else{
            System.out.println("\n\t--Error, el nombre ya esta registrado--\n");
        }   
    }
    
    public boolean encontrar(int tipo, String buscado1, String buscado2){
        //ttipos : 
        //1 = para conprobar correo y contraseña a la hora de iniciar session
        //2 = para comprobar que no se generes 2 productos con el mismo nombre
        //3 = para comprobar que no se generen 2 usuarios con el mismo correo
        switch(tipo){
            case 1:
                for (int i = 0; i < usuarios.size(); i++) {
                    if(usuarios.get(i).getCorreo().equals(buscado1) && usuarios.get(i).getClave().equals(buscado2)){
                        //si es correcto el inicio de sesion se declara a este usuario como el usuario actual
                        usuarioActivo = usuarios.get(i);
                        return true;
                    }        
                }
                break;
            case 2:
                if (!productos.isEmpty()) {
                    for (int i = 0; i < productos.size(); i++) {
                        if(productos.get(i).getNombre().equals(buscado1));
                        return true;
                    }
                }else{
                    return false;
                }
                break;
            case 3:
                if(!usuarios.isEmpty()){
                    for (int i = 0; i < usuarios.size(); i++) {
                        if(usuarios.get(i).getCorreo().equals(buscado1))
                            return true;
                    }
                }
                break;
        }
        return false;
        
    }
    
    private void imprimirProductos(){
        System.out.println("\n\t--Inventario--");
        for (int i = 0; i < this.productos.size(); i++) {
            System.out.println("\t\t" + (i+1));
            System.out.println(productos.get(i));
        }
    }
    
    private void modificarProducto(int operacion,int indice,int cantidad){
        Accion suma = new Accion("Aumento");
        Accion resta = new Accion("disminucion");
        //Operaciones
        //1 = sumar a la cantidad actual
        //2 = restar a la cantidad actual
        Producto producto = productos.get(indice);
        if (operacion == 1 ) {
            producto.setCantidad(producto.getCantidad() + cantidad);
            System.out.println("\n\t--La cantidad fue actualizada--\n");
            
            Date fecha = new Date();
            Registro registro = new Registro(fecha, producto, usuarioActivo, suma, cantidad);
            registros.add(registro);
            
        }else if(operacion == 2 && producto.getCantidad() > cantidad){
            producto.setCantidad(producto.getCantidad() - cantidad);
            System.out.println("\n\t--La cantidad fue actualizada--\n");
            
            Date fecha = new Date();
            Registro registro = new Registro(fecha, producto, usuarioActivo, resta, cantidad);
            registros.add(registro);
            
        }else{
            System.out.println("\n\t--Error no se puede restar una cantidad superior a la disponible--\n");
        }
    }
    
    private void imprimirRegistros(){
        if(!this.registros.isEmpty()){
            
            System.out.println("\n\t--Registros--");
            for (int i = 0; i < this.registros.size(); i++) {
                System.out.println(registros.get(i));
            }
        }else{
            System.out.println("\n\t--Aun no existe ningun registro--\n");
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }
    
    
    
}
