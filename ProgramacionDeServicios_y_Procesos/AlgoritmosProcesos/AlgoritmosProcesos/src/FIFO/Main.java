package FIFO;

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

        // Entrada de datos proceso a proceso

        for (int i = 0; i < n; i++) {

            System.out.println("\nProceso " + (procesoMapeado++) + ": ");
            System.out.println("Tiempo de llegada: ");
            llegada[i] = scn.nextInt();
            System.out.println("Tiempo de ráfaga: ");
            rafaga[i] = scn.nextInt();

        }
        // Cálculo de tiempos de finalización
        finalizacion[0] = llegada[0] + rafaga[0];

        for (int i =1; i < n; i++){
            if(llegada[i] > finalizacion[i-1]){
                finalizacion[i] =llegada[i] + rafaga[i];

            }else{
                finalizacion[i] = finalizacion[i-1] + rafaga[i];
            }
        }
        for (int i = 0;i < n;i++){
            retorno[i] = finalizacion[i] - llegada[i];
            espera[i] = retorno[i] - rafaga[i];
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