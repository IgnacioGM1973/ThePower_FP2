package SJF;

import java.lang.classfile.AnnotationValue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n;
        int procesoMapeado = 1;
        System.out.println("Introduzca el número de procesos: ");
        n = scn.nextInt();  //Lee cuantos procesos vas a gestionar.

        // Creamos Arrays para  n procesos.

        int [] llegada = new int[n];// tiempo de llegada de cada proceso
        int [] rafaga = new int[n];// tiempo de CPU que necesita un proceso
        int [] finalizacion = new int[n]; // Instante de finalización de un proceso
        int [] retorno = new int[n];// ráfaga  - llegada
        int [] espera = new int[n]; // tiempo que espera un proceso - tiempo de llegada
        boolean[] completado = new boolean[n];//para marcar procesos terminados.

        // Entrada de datos proceso a proceso

        for (int i = 0; i < n; i++) {

            System.out.println("\nProceso " + (procesoMapeado++) + ": ");
            System.out.println("Tiempo de llegada: ");
            llegada[i] = scn.nextInt();
            System.out.println("Tiempo de ráfaga: ");
            rafaga[i] = scn.nextInt();

        }

        int tiempo = 0;
        int procesosCompletados = 0;

        while (procesosCompletados < n) {
            int idx = -1;
            int menorRafaga = Integer.MAX_VALUE;

            // Buscar proceso disponible de menor ráfaga
            for (int i = 0; i < n; i++) {
                if (!completado[i] && llegada[i] <= tiempo && rafaga[i] < menorRafaga) {
                    menorRafaga = rafaga[i];
                    idx = i;
                }
            }

            // Si no hay ninguno disponible, avanzamos tiempo
            if (idx == -1) {
                tiempo++;
                continue;
            }

            // Ejecutamos el proceso seleccionado
            tiempo += rafaga[idx];
            finalizacion[idx] = tiempo;
            retorno[idx] = finalizacion[idx] - llegada[idx];
            espera[idx] = retorno[idx] - rafaga[idx];
            completado[idx] = true;
            procesosCompletados++;
        }


        //Salida
        System.out.println("\n----------------------------------------------------");
        System.out.println("Proceso\tLLegada\tRafaga\tFinal\tRetorno\tEspera");
        System.out.println("\n----------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println("P" +(i+1)+ "\t\t   "+llegada[i]+"\t  "+rafaga[i]+"\t\t"+finalizacion[i]+"\t\t"+retorno[i]+"\t\t"+espera[i]);

        }
        //Cálculo de promedio
        double promRetorno = 0, promEspera = 0;
        for (int i = 0; i < n; i++) {
            promRetorno += retorno[i];
            promEspera += espera[i];

        }

        System.out.printf("\nTiempo medio de retorno: %.2f", promRetorno / n);
        System.out.printf("\nTiempo medio de espera: %.2f", promEspera / n);


    }
}
