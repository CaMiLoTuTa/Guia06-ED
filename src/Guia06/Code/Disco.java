package Guia06.Code;

public class Disco {
    private int tamaño;
    private String forma;

    public Disco(int tamaño, String forma) {
        this.tamaño = tamaño;
        this.forma = forma;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

}
