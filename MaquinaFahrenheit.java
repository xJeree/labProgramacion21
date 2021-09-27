/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolás
 */
public class MaquinaFahrenheit {    //Esta clase seria la maquina real, quien trabaja.
    private double unaTemp;         //y enviará su informacion a su respectivo adapter.
    private String nombre, unidad;
    private Fabrica fab;

    public MaquinaFahrenheit(String uni, String nomb, Fabrica fabr) {
        this.nombre = nomb;
        this.unidad = uni;
        this.fab = fabr;
        unaTemp = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getUnidad() {
        return this.unidad;
    }

    public Fabrica getFabrica() {
        return this.fab;
    }

    public double generarTemperaturaFahrenheit() { // Llamado por el adapter, devuelve la informacion a su manera (en Fahrenheit)
        double numero = (Math.random() * 4) + 1;
        unaTemp = (numero * 9/5)+32;
        return unaTemp;
    }


}