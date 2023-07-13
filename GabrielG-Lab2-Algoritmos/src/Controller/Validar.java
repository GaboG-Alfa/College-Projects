/*
 * La clase que se encarga de balancear la fórmula
 */
package Controller;

import Model.Pila;
import Model.PilaException;

/**
 *
 * @author Gabriel Guzmán Alfaro
 */
public class Validar {

    //Atributo
    private Pila pila;
    private boolean balanceo;

    /*
     *Constructor
     */
    public Validar() {

        pila = new Pila();
        balanceo = false;

    }

    /**
     * 
     * @param formula
     * @return boolean
     */
    public boolean recorrerString(String formula) {

        for (char caracter : formula.toCharArray()) {
            balanceo = this.validar(caracter);
              
            if(balanceo == false){
                return false;
            }
            
          }
        
         if (pila.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Valida el ingreso
     *
     * @param caracter
     * @return boolean
     * @throws PilaException
     */
    private boolean validar(char caracter) {

        if (pila.isEmpty()) {

            if ((caracter == ')' || caracter == ']' || caracter == '}')) {
                return false;
            }

        }

        return this.balancearFormula(caracter);
    }

    /**
     *
     * @param caracter
     * @return boolean
     */
    private boolean balancearFormula(char caracter) {

        if (caracter == '(' || caracter == '[' || caracter == '{') {

            pila.push(caracter);

        } else {

            if (caracter == ')') {
                if (pila.pop() != '(') {
                    return false;
                }
            } else {
                if (caracter == ']') {
                    if (pila.pop() != '[') {
                        return false;
                    }
                } else {
                    if (caracter == '}') {
                        if (pila.pop() != '{') {
                            return false;
                        }
                    }
                }
            }

        }

        return true;
    }

    /**
     * Vaciar la pila si ingresa otra
     */
    public void vaciarPila() {

        pila.eliminar();
    }

}
