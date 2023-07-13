/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gabriel Guzmán Alfaro
 */
public class Nodo {
    
    private char caracter;
    private Nodo siguiente;

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
