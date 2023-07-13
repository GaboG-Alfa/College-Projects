/*
 * Clase con estructura de pila
 */
package Model;

/**
 *
 * @author Gabriel Guzmán Alfaro
 */
public class Pila {

    //Atributos
    private Nodo cima;
    private int cantidadElementos;

    /**
     * Constructor
     */
    public Pila(){
        
        cantidadElementos = 0;
        cima = null;
    }

    /**
     * 
     * @return cantidad de elementos
     */
    public int size() {
        return cantidadElementos;
    }

    /**
     * 
     * @param caracter
     * @return caracter
     */
    public char push(char caracter){

        Nodo nuevo = new Nodo();
        nuevo.setCaracter(caracter);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        cantidadElementos++;

        return caracter;
    }

    /**
     * 
     * @return tmp
     */
    public int pop(){
        
        int tmp = cima.getCaracter();
        cima = cima.getSiguiente();
        cantidadElementos--;

        return tmp;
    }

    /**
     * 
     * @return cima caracter
     * @throws PilaException 
     */
    public int top() throws PilaException {

        if (cima == null) {
            throw new PilaException("La pila no puede estar vacía");
        }

        return cima.getCaracter();

    }

    /**
     * 
     * @return boolean
     */
    public boolean isEmpty() {

        return cima == null;
    }
    
    /**
     * Elimina la pila
     */
    public void eliminar(){
        // Elimina el valor y la referencia a los demas nodos.
        cima = null;
        // Reinicia el contador a 0.
        cantidadElementos = 0;
    }

    /**
     * 
     * @return textoNuevo
     */
    public String imprimir() {

        String texto ="";
        String textoNuevo = "Fórmula ";

        Nodo temp;

        for (temp = cima; temp != null; temp = temp.getSiguiente()) {

            texto += temp.getCaracter()+" ";
        }
        
        for (int x=texto.length()-1;x>=0;x--){
            
            textoNuevo+= texto.charAt(x);
        }

        return textoNuevo;

    }

}
