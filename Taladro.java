/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolás
 */
public class Taladro extends Maquina{
    public Taladro(String uni, String nomb, Fabrica fabr){ //esta funciona de manera "nativa", sin necesidad de adapter
        super(nomb,uni,fabr);                                       //Utiliza el constructor de maquina
    }
}
