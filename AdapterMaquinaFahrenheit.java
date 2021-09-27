
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolás
 */
public class AdapterMaquinaFahrenheit extends Maquina { //funciona de interfaz para que una MaquinaFahrenheit se pueda utilizar como Máquina
    MaquinaFahrenheit maquina;

    public AdapterMaquinaFahrenheit(MaquinaFahrenheit maquina) {
        super(maquina.getNombre(), maquina.getUnidad(), maquina.getFabrica());
        this.maquina = maquina;
    }

    @Override
    public double getTemperatura() {
        return pasajeCelsius(this.maquina.generarTemperaturaFahrenheit());        //Pide la temperatura a la maquinaFahrenheit
    }                                                               //y lo adapta a Celsius, que es la unidad
                                                                    //con la que trabaja la fabrica.

    private double pasajeCelsius(double f) {
        return ((f - 32)*(5 / 9));// formula pasaje Fahrenheit a Celsius
    }

}
