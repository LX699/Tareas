import Prototipo.*;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;


@DisplayName("testeo de clases soportadas")
public class sistemaTest {


    @Test
    public void incioSecionTestValido() {

        Usuario l = new Usuario("luchitoMaradona", "maradona4ever@lolito.cl", "sopaipa");
        Sistema s = new Sistema();
        s.getUsuarios().add(l);
        boolean resultadoObtenido = s.buscar(1, "maradona4ever@lolito.cl", "sopaipa");
        boolean resultadoEsperado = true;
        Assert.assertEquals(resultadoEsperado,resultadoObtenido);

    }
    @Test
    public void incioSecionTestInvalido() {

        Usuario l = new Usuario("luchitoMaradona", "maradona4ever@lolito.cl", "sopaipa");
        Sistema s = new Sistema();

        boolean resultadoObtenido = s.buscar(1, "maradona4ever@lolito.cl", "sopaipa");
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado,resultadoObtenido);

    }
    @Test
    public void creacionTestValido() {

        Producto p = new Producto("RedBull", "Alto contenido de Energia", 100);
        Sistema s = new Sistema();
        s.getProductos().add(p);
        boolean resultadoObtenido = s.buscar(2, "RedBull", null);
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado,resultadoObtenido);

    }
    @Test
    public void creacionTestInvalido() {

        Producto p = new Producto("RedBull", "Alto contenido de Energia", 100);
        Sistema s = new Sistema();

        boolean resultadoObtenido = s.buscar(2, "RedBull", null);
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado,resultadoObtenido);

    }
    @Test
    public void altearacionTestValido(){
        Producto p = new Producto("RedBull", "Alto contenido de Energia", 100);
        Sistema s = new Sistema();
        s.getProductos().add(p);
        s.alteracionP(1,0,70);
        s.alteracionP(2,0,40);
        int resultado=s.getProductos().get(0).getCantidad();
        int resultadoEsperado=130;
        Assert.assertEquals(resultadoEsperado,resultado);
    }
    @Test
    public void altearacionTestInvalido(){
        Producto p = new Producto("RedBull", "Alto contenido de Energia", 100);
        Sistema s = new Sistema();
        s.getProductos().add(p);
        s.alteracionP(1,0,70);
        s.alteracionP(2,0,40);
        int resultado=s.getProductos().get(0).getCantidad();
        int resultadoEsperado=120;
        Assert.assertEquals(resultadoEsperado,resultado);
    }@Test
    public void resgistroTestInvalido(){
        boolean resultado;
        Producto p = new Producto("RedBull", "Alto contenido de Energia", 100);
        Sistema s = new Sistema();
        Usuario l = new Usuario("luchitoMaradona", "maradona4ever@lolito.cl", "sopaipa");
        Accion c = new Accion("Creacion");
        Registro r= new Registro(new Date(),p,l,c,p.getCantidad());
        s.getRegistros().add(r);
        resultado= s.getRegistros().get(0).getUsuario() == l && s.getRegistros().get(0).getProducto() == p;
        boolean resultadoEsperado=true;
        Assert.assertEquals(resultadoEsperado,resultado);
    }


}
