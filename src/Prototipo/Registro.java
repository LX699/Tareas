package Prototipo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro implements Serializable{
    
    private Date fecha;
    private Producto producto;
    private Usuario usuario;
    private Accion accion;
    private int cantidad;

    public Registro(Date fecha, Producto producto, Usuario usuario, Accion accion, int cantidad) {
        this.fecha = fecha;
        this.producto = producto;
        this.usuario = usuario;
        this.accion = accion;
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        String horaFormateada = formatoFecha.format(this.fecha);
        String info ="";
        info+= "Producto :\t" + this.producto.getNombre() + "\n";
        info+= "Usuario  :\t" + this.usuario.getNombre() + "\n";
        info+= "Accion   :\t" + this.accion.getNombre() + "\n";
        info+= "Cantidad :\t" + this.cantidad +"\n";
        info+= "Fecha    :\t" + horaFormateada + "\n";
        
        
        return info;
    }
    
    
    
    
}
