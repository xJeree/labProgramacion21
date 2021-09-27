/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolás
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread[] hiloCelsius = new Thread[3];
        Thread[] hiloKelvin = new Thread[4];
        // Thread[] hiloFahrenheit = new Thread[2];
        Fabrica fabrica = new Fabrica();

        ControladorTemperatura control = new ControladorTemperatura(fabrica); // creacion del controlador de
                                                                              // temperaturas

        
        // creacion de los hilos
        int n=1,m=1;
        for (int i = 0; i < n; i++) {
            hiloCelsius[i] = new Thread(new Taladro("CELSIUS " + i, "Celsius", fabrica),
                    "Taladro" + (i + 1));
        }
        for (int i = 0; i < m; i++) {
            AdapterTorno aux = new AdapterTorno(new Torno("-KELVIN " + i, "Kelvin", fabrica));
            hiloKelvin[i] = new Thread(aux, "Torno" + (i + 1));
        }
        // for (int i = 0; i < m; i++) {
        //     AdapterMaquinaFahrenheit aux = new AdapterMaquinaFahrenheit(
        //     new MaquinaFahrenheit("--FAHRENHEIT " + i, "Fahrenheit", fabrica));
        //     hiloFahrenheit[i] = new Thread(aux, "MaquinaFahrenheit" + (i + 1));
        // }
        // hacemos andar los hilos
        control.andar();
        for (int i = 0; i < n; i++) {
            hiloCelsius[i].start();
        }
        for (int i = 0; i < m; i++) {
            hiloKelvin[i].start();
        }
        // for (int i = 0; i < m; i++) {
        //     hiloFahrenheit[i].start();
        // }
    }
}

