/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolás
 */
public class AdapterTorno extends Maquina{      //funciona de interfaz para que una MaquinaKelvin se pueda utilizar como Máquina
    Torno maquina;                              
        public AdapterTorno(Torno maquina){
            super(maquina.getNombre(), maquina.getUnidad(), maquina.getFabrica());
            this.maquina = maquina;
    }
@Override
    public double getTemperatura(){
        return pasajeCelsius(this.maquina.generarTemperaturaKelvin());        //Pide la temperatura a la maquinaKelvin
    }                                                               //y lo adapta a Celsius, que es la unidad
                                                                    //con la que trabaja la fabrica.
    private double pasajeCelsius(double k){  
        return (k-273.15);  //formula pasaje Kelvin a Celsius         
    }

    @Override
    public void agujerear(){ //el adapter utiliza las dos funciones del torno para hacer agujeros, cosa que el taladro hace nativamente. Hace override del metodo de su padre Maquina
        System.out.println(Thread.currentThread().getName() + "     <-- USA EL ADAPTADOR");
        this.maquina.rotarPieza();
        this.maquina.moverHerramienta();
    }
    
}
