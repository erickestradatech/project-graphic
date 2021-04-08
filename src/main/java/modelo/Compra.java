
package modelo;

public class Compra extends Articulo{
    private int cantidad;
    public double total(){
        return super.getPuni()*cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
