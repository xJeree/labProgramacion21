/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Nicolás
 */
public class Fabrica {

    private ReentrantReadWriteLock lock;
    private double tempMaxima, tempActual;
    private Lock writeLock, readLock;
    private Condition condWrite;

    public Fabrica() {
        tempMaxima = 35;
        tempActual = 0;

        lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();

        condWrite = writeLock.newCondition();
    }

    public double getMaxima() {
        return this.tempMaxima;
    }

    private boolean caluroso() {
        boolean caluroso;
        readLock.lock();
        try {
            caluroso = (tempActual >= tempMaxima); // La temperatura se paso del maximo. Hay que esperar
        } finally {
            readLock.unlock();
        }
        return caluroso;
    }

    public void trabajar(double temp) throws InterruptedException {
        writeLock.lock();
        try {
            while (caluroso()) {
                // si esta muy caluroso, hay que esperar
                condWrite.await();
            }
            System.out.println("\n"+Thread.currentThread().getName() + " --> esta funcionando!!!! "); // la maquina ya se
                                                                                                 // puso a trabajar
            tempActual += temp; // temp de la maquina que esta trabajando
        } finally {
            writeLock.unlock();
        }
    }

    public void frenarTrabajo() throws InterruptedException {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " --> Frena su trabajo.\n");
            condWrite.signalAll();
        } finally {
            writeLock.unlock();
        }
    }

    public double pedirTemperatura() throws InterruptedException {
        readLock.lock();
        try {
            System.out.println(
                    "   \n\t\t     (controlador)        TEMPERATURA ACTUAL DE LA FABRICA: " + tempActual + " grados");
            return tempActual;
        } finally {
            readLock.unlock();
        }
    }

    public void reiniciarTemp() throws InterruptedException {
        writeLock.lock();
        try {
            System.out.println("            \t\tEnfriando fabrica......");
            Thread.sleep(10000);
            System.out.println("            \t\tSE REINICIA LA TEMP A 0 \n");
            tempActual = 0.0;
            condWrite.signalAll();
        } finally {
            writeLock.unlock();
        }
    }
}
