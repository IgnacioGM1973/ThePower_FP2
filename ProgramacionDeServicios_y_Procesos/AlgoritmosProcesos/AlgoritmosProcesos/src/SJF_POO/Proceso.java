package SJF_POO;

public class Proceso {
    private int llegada;
    private int rafaga;
    private int finalizacion;
    private int retorno;
    private int espera;
    private boolean completado = false;

    public Proceso(int llegada, int rafaga){
        this.llegada=llegada;
        this.rafaga= rafaga;
    }

    //Getter y setters


    public int getLlegada() {
        return llegada;
    }

    public int getRafaga() {
        return rafaga;
    }

    public int getFinalizacion() {
        return finalizacion;
    }

    public int getRetorno() {
        return retorno;
    }

    public int getEspera() {
        return espera;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setFinalizacion(int finalizacion){
        this.finalizacion = finalizacion;
        this.retorno = finalizacion - llegada;
        this.espera = retorno - rafaga;
        this.completado = true;

    }
}
