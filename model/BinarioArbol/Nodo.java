/*
 * Clase que se encarga de contner la información del nodo
 */
package model.BinarioArbol;




/**
 *
 * @author GABRIEL GUZMÁN ALFARO
 * @version 10/06/2021
 */
public class Nodo <T extends Comparable<T>> {
    
    //Atributo
    private T dato;
    private Nodo<T> izquierda;
    private Nodo<T> derecha;

    /**
     * 
     * @param dato 
     */
    public Nodo(T dato) {
        this.dato = dato;
    }
    
    
    /**
     * 
     * @return dato 
     */
    public T getDato() {
        return dato;
    }

    /**
     * 
     * @param dato 
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * 
     * @return izquierda 
     */
    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    /**
     * 
     * @param izquierda 
     */
    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * 
     * @return derecha 
     */
    public Nodo<T> getDerecha() {
        return derecha;
    }

    /**
     * 
     * @param derecha 
     */
    public void setDerecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }
    
}
