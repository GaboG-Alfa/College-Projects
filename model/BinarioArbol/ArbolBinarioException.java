/*
 * Clase que se encarga de lanzar excepciones al arbol binario
 */
package model.BinarioArbol;

/**
 *
 * @author GABRIEL GUZMÁN ALFARO
 * @version 10/06/2021
 */
public class ArbolBinarioException extends Exception {
    
    /**
     * 
     * @param exception 
     */
    public ArbolBinarioException(String exception){
        super(exception);
    }
}
