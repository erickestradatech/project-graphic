package modelo;

public class Articulo {
 private String coda;
 private double puni;
 private String noma;
 private int stock;

 
    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public double getPuni() {
        return puni;
    }

    public void setPuni(double puni) {
        this.puni = puni;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }
 
}
