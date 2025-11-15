package SJF_POO;

import java.util.List;

public class PlanificadorSJF {

    public void ejecutar(List<Proceso> procesos) {
        int tiempo = 0;
        int completados = 0;
        int n = procesos.size();

        while (completados < n) {
            Proceso elegido = null;
            int menorRafaga = Integer.MAX_VALUE;

            // Seleccionar el proceso disponible con menor ráfaga
            for (Proceso p : procesos) {
                if (!p.isCompletado() &&
                        p.getLlegada() <= tiempo &&
                        p.getRafaga() < menorRafaga) {

                    elegido = p;
                    menorRafaga = p.getRafaga();
                }
            }

            // Si ninguno está disponible, avanzar tiempo
            if (elegido == null) {
                tiempo++;
                continue;
            }

            // Ejecutar
            tiempo += elegido.getRafaga();
            elegido.setFinalizacion(tiempo);
            completados++;
        }
    }
}
