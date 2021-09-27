/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolás
 */
public class Torno {    //Esta clase seria la maquina real, quien trabaja.
    protected double unaTemp;   //y enviará su informacion a su respectivo adapter.
    protected String nombre, unidad;
    protected Fabrica fab;

    public Torno(String uni, String nomb, Fabrica fabr) {
        this.nombre = nomb;
        this.unidad = uni;
        this.fab = fabr;
        unaTemp = 0;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getUnidad(){
        return this.unidad;
    }

    public Fabrica getFabrica(){
        return this.fab;
    }

    public void rotarPieza(){
        System.out.println(Thread.currentThread().getName() + ": Estoy haciendo revolucionar la pieza!");
    }

    public void moverHerramienta(){
        System.out.println(Thread.currentThread().getName() + ": Estoy moviendo la herramienta!");
    }

    public double generarTemperaturaKelvin() { // Llamado por el adapter, devuelve la informacion a su manera (en Kelvin)
        double numero = (Math.random() * 4) + 1;
        unaTemp = numero + 273.15;
        return unaTemp;
    }
    /*diferentes maneras de obtener la temperatura:
        que el metodo obtener temperatura de la maquina celsius, lo haga mediante un trabajo X que genera temperatura...
        la empresa metio maquinas que hacen trabajos Y y Z (diferentes de X), y la forma de aumentar la temperatura sea diferente
    */
}