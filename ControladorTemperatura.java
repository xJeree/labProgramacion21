/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Nicolás
 */
public class ControladorTemperatura {

    private final Fabrica fabrica;

    public ControladorTemperatura(Fabrica fab) {
        fabrica = fab;
    }

    ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1); // Se crea el scheduler, que espera un
                                                                             // hilo.
    private double temp;

    public void andar() {
        final Runnable controlador = new Runnable() { // Se crea un hilo controlador (NO SE EJECUTA AÚN)
            public void run() {
                while (true) {
                    /*
                     * el while true es para que cada 5 segundos se pregunte la temperatura. Se
                     * podia hacer con scheduler.scheduleAtFixedRate(controlador, 5, 5,
                     * TimeUnit.SECONDS);
                     */
                    try {
                        temp = fabrica.pedirTemperatura(); // se pide la temp a la fabrica, el encargado de chequear es
                                                           // el hilo controlador
                        if (temp >= fabrica.getMaxima()) {
//                            System.out.println("        (controlador)       Se supero la temp maxima, se alerta!");
                            fabrica.reiniciarTemp(); // se reinicia la temperatura y en unos segundos se le avisa a las
                                                     // maquinas que pueden volver a trabajar
                        }
                        Thread.sleep(7000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };

        // scheduler.scheduleAtFixedRate(controlador, 5, 5, TimeUnit.SECONDS);
        // scheduler.schedule(controlador, 5, TimeUnit.SECONDS);
        scheduler.submit(controlador); // Cuando el scheduler lo pide, se ejecuta el hilo controlador creado mas
                                       // arriba.
        /*
         * El metodo submit() envia una tarea Runnable a un ExecutorService y devuelve
         * un resultado del tipo Future pero null en el caso de Runnable.
         */
        scheduler.shutdown();
        /*
         * El metodo shutdown() no causa la destruccion inmediata del executorService,
         * si no que esperará a que terminen todos los hilos para ello.
         */
    }
}
