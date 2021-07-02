/*
 * Clase que se encarga de lanzar excepciones al arbol avl 
 */
package model.AVLArbol;

/**
 *
 * @author GABRIEL GUZMÁN ALFARO
 * @version 10/06/2021
 */
public class ArbolAVLException extends Exception {
    
    /**
     * 
     * @param exception 
     */
    public ArbolAVLException(String exception){
        super(exception);
    }
}
