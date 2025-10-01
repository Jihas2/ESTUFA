package Controller;

import Model.Estufa;
import View.EstufaView;
import java.util.Scanner;

public class EstufaController {
    private Estufa estufa;
    private EstufaView view;
    private Scanner scanner;

    public EstufaController(EstufaView view) {
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        view.exibirCabecalho();

        double temperaturaMinima = solicitarTemperaturaMinima();
        double temperaturaMaxima = solicitarTemperaturaMaxima();

        while (temperaturaMinima >= temperaturaMaxima) {
            view.exibirErroLimites();
            temperaturaMinima = solicitarTemperaturaMinima();
            temperaturaMaxima = solicitarTemperaturaMaxima();
        }

        estufa = new Estufa(temperaturaMinima, temperaturaMaxima, 24);
        view.exibirLimites(temperaturaMinima, temperaturaMaxima);

        coletarTemperaturas();

        gerarRelatorios();

        scanner.close();
    }

    private double solicitarTemperaturaMinima() {
        System.out.print("Digite a temperatura MÍNIMA ideal (°C): ");
        return scanner.nextDouble();
    }

    private double solicitarTemperaturaMaxima() {
        System.out.print("Digite a temperatura MÁXIMA ideal (°C): ");
        return scanner.nextDouble();
    }

    private void coletarTemperaturas() {
        view.exibirInicioColeta();

        for (int hora = 0; hora < estufa.getTotalHoras(); hora++) {
            System.out.print("Hora " + String.format("%02d", hora) + ":00 - Temperatura (°C): ");
            double temperatura = scanner.nextDouble();

            estufa.adicionarTemperatura(hora, temperatura);

            if (estufa.estaAcimaDoMaximo(temperatura)) {
                view.exibirAlertaAcimaMaximo();
            } else if (estufa.estaAbaixoDoMinimo(temperatura)) {
                view.exibirAlertaAbaixoMinimo();
            } else {
                view.exibirTemperaturaOk();
            }

            System.out.println();
        }
    }

    private void gerarRelatorios() {
        view.exibirRelatorioFinal(estufa);
        view.exibirDiagnostico(estufa);
        view.exibirAnaliseMedia(estufa);
        view.exibirAnaliseVariacao(estufa);
        view.exibirRodape();
    }
}