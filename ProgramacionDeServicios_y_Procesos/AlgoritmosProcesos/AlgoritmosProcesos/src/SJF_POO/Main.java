package SJF_POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de procesos: ");
        int n = sc.nextInt();

        List<Proceso> listaProcesos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nProceso " + (i + 1));
            System.out.print("Tiempo de llegada: ");
            int llegada = sc.nextInt();

            System.out.print("Tiempo de ráfaga: ");
            int rafaga = sc.nextInt();

            listaProcesos.add(new Proceso(llegada, rafaga));
        }

        // Ejecutar SJF
        PlanificadorSJF planificador = new PlanificadorSJF();
        planificador.ejecutar(listaProcesos);

        // SALIDA
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Proceso\tLlegada\tRafaga\tFinal\tRetorno\tEspera");
        System.out.println("-----------------------------------------------------------");

        double totalRetorno = 0, totalEspera = 0;

        for (int i = 0; i < listaProcesos.size(); i++) {
            Proceso p = listaProcesos.get(i);

            System.out.println("P" + (i + 1) + "\t\t" +
                    p.getLlegada() + "\t\t" +
                    p.getRafaga() + "\t\t" +
                    p.getFinalizacion() + "\t\t" +
                    p.getRetorno() + "\t\t" +
                    p.getEspera());

            totalRetorno += p.getRetorno();
            totalEspera += p.getEspera();
        }

        System.out.printf("\nTiempo medio de retorno: %.2f\n", totalRetorno / n);
        System.out.printf("Tiempo medio de espera: %.2f\n", totalEspera / n);
    }
}


