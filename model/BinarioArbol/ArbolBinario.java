package model.BinarioArbol;

/*
 * Clase que se encarga de ordenar el arbol binario
 */
/**
 *
 * @author GABRIEL GUZMÁN ALFARO
 * @version 30/05/2021
 */
public class ArbolBinario <T extends Comparable<T>> {

    //Attributes
    private Nodo<T> raiz;

    /**
     * Insertar un dato
     *
     * @param dato
     */
    public void insertar(T dato) throws ArbolBinarioException {
        raiz = insertar(dato, raiz);
    }

    /**
     * Retornar recursivamente el nodo
     *
     * @param dato
     * @param nodo
     * @return nodo
     */
    private Nodo<T> insertar(T dato, Nodo<T> temp) throws ArbolBinarioException {

        if (temp == null) {
            temp = new Nodo(dato);
        } else if (dato.compareTo(temp.getDato()) < 0) {
            temp.setIzquierda(insertar(dato, temp.getIzquierda()));
        } else if (dato.compareTo(temp.getDato()) > 0) {
            temp.setDerecha(insertar(dato, temp.getDerecha()));
        } else {
            throw new ArbolBinarioException("dato duplicado");
        }

        return temp;
    }

    /**
     * Recorre en preorden
     */
    public String preOrden() {

        return preOrden(raiz);
    }

    /**
     * Recursión
     *
     * @param nodo
     */
    private String preOrden(Nodo temp) {

        if (temp != null) {
            return temp.getDato() + "\n" + preOrden(temp.getIzquierda()) + preOrden(temp.getDerecha());
        }

        return "";

    }

    /**
     * Recorre en postorden
     */
    public String postOrden() {

        return postOrden(raiz);
    }

    /**
     * Recursión
     *
     * @param nodo
     */
    private String postOrden(Nodo temp) {

        if (temp != null) {
            return postOrden(temp.getIzquierda()) + postOrden(temp.getDerecha()) + temp.getDato()+"\n";
        }

        return "";
    }

    /**
     * Recorre en orden
     */
    public String enOrden() {

        return enOrden(raiz);
    }

    /**
     * Recursión
     *
     * @param nodo
     */
    private String enOrden(Nodo temp) {

        if (temp != null) {
            return enOrden(temp.getIzquierda())+ temp.getDato()+"\n"+enOrden(temp.getDerecha());
        }

        return "";
    }

    /**
     * Find min
     *
     * @return elementAt
     */
    public T findMin() {

        return elementAt(findMin(raiz));
    }

    /**
     * Find max
     *
     * @return elemntAt
     */
    public T findMax() {

        return elementAt(findMax(raiz));
    }

    /**
     * Recursion del elemento
     *
     * @param nodo
     * @return elementAt
     */
    private T elementAt(Nodo<T> temp) {
        return temp == null ? null : temp.getDato();
    }

    /**
     * Recursion del min
     *
     * @param nodo
     * @return nodo
     */
    private Nodo<T> findMin(Nodo<T> temp) {

        if (temp != null) {
            while (temp.getIzquierda() != null) {
                temp = temp.getIzquierda();
            }
        }

        return temp;
    }

    /**
     * Recursion del max
     *
     * @param nodo
     * @return nodo
     */
    private Nodo<T> findMax(Nodo<T> temp) {

        if (temp != null) {
            while (temp.getDerecha() != null) {
                temp = temp.getDerecha();
            }
        }

        return temp;
    }

    /**
     * Imprime el dato
     *
     * @param dato
     */
    private void imprimir(T dato) {

        System.out.println("dato: " + dato);
    }

    /**
     * Busca un dato y retorna el nodo
     *
     * @param dato
     * @param nodo
     * @return nodo
     */
    private Nodo<T> find(T dato, Nodo<T> temp) throws ArbolBinarioException {

        while (temp != null) {

            if (dato.compareTo(temp.getDato()) < 0) {
                temp = temp.getIzquierda();
            } else if (dato.compareTo(temp.getDato()) > 0) {
                temp = temp.getDerecha();
            } else {
                return temp;
            }
        }

        return null;
    }

    /**
     * Find a data
     *
     * @param dato
     * @return
     * @throws ArbolBinarioException
     */
    public T find(T dato) throws ArbolBinarioException {
        return elementAt(find(dato, raiz));
    }

    /**
     * removeMin
     *
     * @param temp
     * @return temp
     * @throws ArbolBinarioException
     */
    private Nodo<T> removeMin(Nodo<T> temp) throws ArbolBinarioException {

        if (temp == null) {
            throw new ArbolBinarioException("Item no encontrado");
        } else if (temp.getIzquierda() != null) {
            temp.setIzquierda(removeMin(temp.getIzquierda()));
            return temp;
        } else {
            return temp.getDerecha();
        }
    }

    /**
     *
     * @return raiz
     */
    public Nodo<T> removeMin() throws ArbolBinarioException {
        return raiz = removeMin(raiz);
    }

    /**
     * remove
     *
     * @param dato
     * @param temp
     * @return
     * @throws ArbolBinarioException
     */
    private Nodo<T> remove(T dato, Nodo<T> temp) throws ArbolBinarioException {

        if (temp == null) {
            throw new ArbolBinarioException("Item no encontrado");
        }

        if (dato.compareTo(temp.getDato()) < 0) {
            temp.setIzquierda(remove(dato, temp.getIzquierda()));
        } else if (dato.compareTo(temp.getDato()) > 0) {
            temp.setDerecha(remove(dato, temp.getDerecha()));
        } else if (temp.getIzquierda() != null && temp.getDerecha() != null) {
            temp.setDato(findMin(temp.getDerecha()).getDato());
            temp.setDerecha(removeMin(temp.getDerecha()));
        } else {
            temp = (temp.getIzquierda() != null) ? temp.getIzquierda() : temp.getDerecha();
        }

        return temp;
    }

    /**
     * remove
     *
     * @param dato
     * @throws ArbolBinarioException
     */
    public void remove(T dato) throws ArbolBinarioException {
        raiz = remove(dato, raiz);
    }
}
