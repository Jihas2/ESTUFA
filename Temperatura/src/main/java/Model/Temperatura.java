package Model;

public class Temperatura {
    private double valor;
    private int hora;

    public Temperatura(double valor, int hora) {
        this.valor = valor;
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}