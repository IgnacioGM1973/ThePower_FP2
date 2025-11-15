package FIFO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n;
        System.out.println("Introduzca el número de procesos: ");
        n = scn.nextInt();  //Lee cuantos procesos vas a gestionar.

        // Creamos Arrays para  n procesos.

        int [] llegada = new int[n];// tiempo de llegada de cada proceso
        int [] rafaga = new int[n];// tiempo de CPU que necesita un proceso
        int [] finalizacion = new int[n]; // Instante de finalización de un proceso
        int [] retorno = new int[n];// ráfaga  - llegada
        int [] espera = new int[n]; // tiempo que espera un proceso - tiempo de llegada

        // Entrada de datos proceso.









        for (int i = 1; i <= n; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}