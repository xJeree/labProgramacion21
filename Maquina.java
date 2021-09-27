/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolás
 */
public class Maquina implements Runnable {
    protected String nombre, unidad;
    protected double temperatura;
    protected Fabrica fab;

    public Maquina(String nombre, String unidad, Fabrica fabr) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.temperatura = 0;
        this.fab = fabr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getTemperatura() {
        double numero = (Math.random() * 4) + 1;
        temperatura = numero;
        return temperatura;
    }

    public void agujerear(){
        System.out.println(Thread.currentThread().getName() + ": ESTOY TALADRANDO!" );
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public void run() { /*
                         * run simula el trabajo que hacen las maquinas, el trabajo hace que su
                         * temperatura aumente
                         */
        while (true) {
            try {
                fab.trabajar(getTemperatura());
                this.agujerear();
                Thread.sleep((int) (Math.random() * 9000));
                // reiniciarTemperatura();
                fab.frenarTrabajo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
