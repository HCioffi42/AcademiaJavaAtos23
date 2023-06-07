package DebugEx;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        Log meuLogger = new Log("Log.txt");
        meuLogger.logger.setLevel(Level.FINE);
        meuLogger.logger.info("Log de informação");
        meuLogger.logger.warning("Log de Aviso");
        meuLogger.logger.severe("Log Severo");

        try (Scanner leitura = new Scanner(System.in)) {
            Calculadora c = new Calculadora();
            float a = 0, b = 0, resultado = 0;
            String operador;
            System.out.println("Calculadora");
            do {
                System.out.println("Insira o operador +, -, *, /");
                operador = leitura.nextLine();
                meuLogger.logger.info("Operador  "+ operador + " utilisado.");
            } while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
                    || operador.contains("/")));

            System.out.println("Insira o 1o valor");
            a = leitura.nextFloat();
            meuLogger.logger.info("Número "+ a + " inserido");
            System.out.println("Insira o 2o valor");
            b = leitura.nextFloat();
            meuLogger.logger.info("Número "+ b + " inserido");

            resultado = c.calcular(a, b, operador.charAt(0));
            if (a < b && operador.contains("-")) {
                System.out.println("O resultado de " + b + " " + operador + " " + a + " é:" + resultado);
            } else {
                System.out.println("O resultado de " + a + " " + operador + " " + b + " é:" + resultado);
            }
            meuLogger.logger.info("Resultado final foi: "+ resultado);
        }

    }

}
