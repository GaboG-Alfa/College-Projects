
package model.AVLArbol;


public class AvlNode <T extends Comparable<T>>{
    private T dato;
    private AvlNode<T> izquierdo, derecho;
    private Integer height;

    public AvlNode() {
        this.height=0;
    }

    public AvlNode(T dato) {
        this.dato = dato;
        this.height=0;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public AvlNode<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(AvlNode<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public AvlNode<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(AvlNode<T> derecho) {
        this.derecho = derecho;
    }
    
    
    
    
}
