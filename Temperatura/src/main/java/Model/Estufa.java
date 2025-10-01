package Model;

public class Estufa {
    private double temperaturaMinima;
    private double temperaturaMaxima;
    private Temperatura[] temperaturas;
    private int totalHoras;

    public Estufa(double temperaturaMinima, double temperaturaMaxima, int totalHoras) {
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.totalHoras = totalHoras;
        this.temperaturas = new Temperatura[totalHoras];
    }

    public void adicionarTemperatura(int hora, double valor) {
        temperaturas[hora] = new Temperatura(valor, hora);
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Temperatura[] getTemperaturas() {
        return temperaturas;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public boolean estaDentroDoPadrao(double temperatura) {
        return temperatura >= temperaturaMinima && temperatura <= temperaturaMaxima;
    }

    public boolean estaAcimaDoMaximo(double temperatura) {
        return temperatura > temperaturaMaxima;
    }

    public boolean estaAbaixoDoMinimo(double temperatura) {
        return temperatura < temperaturaMinima;
    }

    public double calcularMedia() {
        double soma = 0;
        for (int i = 0; i < totalHoras; i++) {
            soma += temperaturas[i].getValor();
        }
        return soma / totalHoras;
    }

    public double obterMenorTemperatura() {
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < totalHoras; i++) {
            if (temperaturas[i].getValor() < menor) {
                menor = temperaturas[i].getValor();
            }
        }
        return menor;
    }

    public double obterMaiorTemperatura() {
        double maior = Double.MIN_VALUE;
        for (int i = 0; i < totalHoras; i++) {
            if (temperaturas[i].getValor() > maior) {
                maior = temperaturas[i].getValor();
            }
        }
        return maior;
    }

    public int contarTemperaturasAcimaMaximo() {
        int contador = 0;
        for (int i = 0; i < totalHoras; i++) {
            if (estaAcimaDoMaximo(temperaturas[i].getValor())) {
                contador++;
            }
        }
        return contador;
    }

    public int contarTemperaturasAbaixoMinimo() {
        int contador = 0;
        for (int i = 0; i < totalHoras; i++) {
            if (estaAbaixoDoMinimo(temperaturas[i].getValor())) {
                contador++;
            }
        }
        return contador;
    }

    public int contarTemperaturasDentroDoPadrao() {
        int contador = 0;
        for (int i = 0; i < totalHoras; i++) {
            if (estaDentroDoPadrao(temperaturas[i].getValor())) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularVariacaoTermica() {
        return obterMaiorTemperatura() - obterMenorTemperatura();
    }
}