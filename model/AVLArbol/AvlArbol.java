package model.AVLArbol;

/**
 * 
 */

import model.AVLArbol.ArbolAVLException;

/**
 * 
 * @author GABRIEL GUZMÁN ALFARO
 * @version 01/07/2021
 * @param <T> 
 */
public class AvlArbol<T extends Comparable<T>> {

    //Atribute
    private AvlNode<T> raiz;

    /**
     * Constructor
     */
    public AvlArbol() {
    }

    /**
     * 
     * @param dato
     * @throws ArbolAVLException 
     */
    public void insertar(T dato) throws ArbolAVLException {
        raiz = insertar(dato, raiz);
    }

    /**
     * 
     * @param x
     * @param t
     * @return
     * @throws ArbolAVLException 
     */
    protected AvlNode<T> insertar(T x, AvlNode<T> t) throws ArbolAVLException {
        if (t == null) {
            t = new AvlNode<>(x);
        } else if (x.compareTo(t.getDato()) < 0) {
            t.setIzquierdo(insertar(x, t.getIzquierdo()));
            if(this.height(t.getIzquierdo()) - this.height(t.getDerecho()) == 2){
                if(x.compareTo(t.getIzquierdo().getDato())<0){
                    t = this.rotateWithLeftChild(t);
                }else{
                    t =this.doubleRotateWithLeftChild(t);
                }
            }
        } else if (x.compareTo(t.getDato()) > 0) {
            t.setDerecho(insertar(x, t.getDerecho()));
            if(this.height(t.getDerecho()) - this.height(t.getIzquierdo())==2){
                if(x.compareTo(t.getDerecho().getDato())>0){
                    t = this.rotateWithRightChild(t);
                }else{
                    t = this.doubleRotateWithRightChild(t);
                }
            }
        } else {
            throw new ArbolAVLException("Duplicado: " + x.toString());
        }
        t.setHeight(this.max(this.height(t.getIzquierdo()), this.height(t.getDerecho()))+1);
        return t;
    }

    /**
     * 
     * @return preOrden(raiz)
     */
    public String preOrden() {
        return preOrden(raiz);
    }

    /**
     * 
     * @param nodo
     * @return string
     */
    private String preOrden(AvlNode<T> nodo) {
        if (nodo == null) {
            return "";
        }
        return nodo.getDato() + "\n"
                + preOrden(nodo.getIzquierdo())
                + preOrden(nodo.getDerecho());
    }

    /**
     * 
     * @return postOrden(raiz)
     */
    public String postOrden() {
        return postOrden(raiz);
    }

    /**
     * 
     * @param nodo
     * @return string
     */
    private String postOrden(AvlNode<T> nodo) {
        if (nodo == null) {
            return "";
        }
        return postOrden(nodo.getIzquierdo())
                + postOrden(nodo.getDerecho())
                + nodo.getDato() + "\n";
    }

    /**
     * 
     * @return enOrden(raiz)
     */
    public String enOrden() {
        return enOrden(raiz);
    }

    /**
     * 
     * @param nodo
     * @return string
     */
    private String enOrden(AvlNode<T> nodo) {
        if (nodo == null) {
            return "";
        }
        return enOrden(nodo.getIzquierdo())
                + nodo.getDato() + "\n"
                + enOrden(nodo.getDerecho());
    }

    /**
     * 
     * @param t
     * @return t
     */
    private T elementAt(AvlNode<T> t) {//19.6 pag7 683
        return t == null ? null : t.getDato();
    }

    /**
     * 
     * @return elementAt
     */
    public T findMin() {
        return this.elementAt(findMin(raiz));
    }

    /**
     * 
     * @param t
     * @return t
     */
    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t != null) {
            while (t.getIzquierdo() != null) {
                t = t.getIzquierdo();
            }
        }
        return t;
    }

    /**
     * 
     * @return elementAt(findMax(raiz))
     */
    public T findMax() {
        return this.elementAt(findMax(raiz));
    }

    /**
     * 
     * @param t
     * @return t 
     */
    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t != null) {
            while (t.getDerecho() != null) {
                t = t.getDerecho();
            }
        }
        return t;
    }

    /**
     * 
     * @param x
     * @return elementAt(this.find(x, raiz))
     */
    public T find(T x) {
        return this.elementAt(this.find(x, raiz));
    }

    /**
     * 
     * @param x
     * @param t
     * @return t
     */
    private AvlNode<T> find(T x, AvlNode<T> t) {
        while (t != null) {
            if (x.compareTo(t.getDato()) < 0) {
                t = t.getIzquierdo();
            } else if (x.compareTo(t.getDato()) > 0) {
                t = t.getDerecho();
            } else {
                return t;
            }
        }
        return null;
    }

    /**
     * 
     * @param x
     * @throws ArbolAVLException 
     */
    public void remove(T x) throws ArbolAVLException {
        raiz = remove(x, raiz);
    }

    /**
     * 
     * @param x
     * @param t
     * @return
     * @throws ArbolAVLException 
     */
    private AvlNode<T> remove(T x, AvlNode<T> t) throws ArbolAVLException {
        if (t == null) {
            throw new ArbolAVLException("No se encontro el item");
        }
        //Si el dato es menor que el contenido en el nodo
        if (x.compareTo(t.getDato()) < 0) {
            t.setIzquierdo(remove(x, t.getIzquierdo()));
        } //Si el dato es menor que el contenido en el nodo
        else if (x.compareTo(t.getDato()) > 0) {
            t.setDerecho(remove(x, t.getDerecho()));
        } //Si tiene dos hijos
        else if (t.getIzquierdo() != null && t.getDerecho() != null) {
            t.setDato(findMin(t.getDerecho()).getDato());
            t.setDerecho(removeMin(t.getDerecho()));
        } else {
            t = ((t.getIzquierdo() != null) ? t.getIzquierdo() : t.getDerecho());
        }
        return t;
    }

    /**
     * 
     * @throws ArbolAVLException 
     */
    public void removeMin() throws ArbolAVLException {
        raiz = removeMin(raiz);
    }

    /**
     * 
     * @param t
     * @return
     * @throws ArbolAVLException 
     */
    private AvlNode<T> removeMin(AvlNode<T> t) throws ArbolAVLException {
        if (t == null) {
            throw new ArbolAVLException("No se encontro el nodo");
        } else if (t.getIzquierdo() != null) {
            t.setIzquierdo(removeMin(t.getIzquierdo()));
            return t;
        } else {
            return t.getDerecho();
        }
    }
    
    /**
     * 
     * @param k2
     * @return k1
     */
    private AvlNode rotateWithLeftChild (AvlNode k2) 
    {
        AvlNode k1 = k2.getIzquierdo();
        k2.setIzquierdo(k1.getDerecho());
        k1.setDerecho(k2);
        k2.setHeight(this.max(this.height(k2.getIzquierdo()), this.height(k2.getDerecho()))+1);
        k1.setHeight(this.max(this.height(k1.getIzquierdo()), k2.getHeight())+1);
        return k1;
    }

    /**
     * 
     * @param k1
     * @return k2
     */
    private AvlNode rotateWithRightChild(AvlNode k1) 
    {
        AvlNode k2 = k1.getDerecho();
        k1.setDerecho(k2.getIzquierdo());
        k2.setIzquierdo(k1);
        k1.setHeight(this.max(this.height(k1.getIzquierdo()), this.height(k1.getDerecho()))+1);
        k2.setHeight(this.max(this.height(k2.getDerecho()), k1.getHeight())+1);
        return k2;
    }
    
    /**
     * 
     * @param k3
     * @return rotateWithLeftChild(k3)
     */
    private AvlNode doubleRotateWithLeftChild(AvlNode k3){
        k3.setIzquierdo(this.rotateWithRightChild(k3.getIzquierdo()));
        return this.rotateWithLeftChild(k3);
    }
    
    /**
     * 
     * @param k1
     * @return rotateWithRightChild(k1)
     */
    private AvlNode doubleRotateWithRightChild(AvlNode k1){
        k1.setDerecho(this.rotateWithLeftChild(k1.getDerecho()));
        return this.rotateWithRightChild(k1);
    }
    
    /**
     * 
     * @param lhs
     * @param rhs
     * @return lhs > rhs ? lhs : rhs 
     */
    private int max (int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
    
    /**
     * 
     * @param t
     * @return t==null ? -1 : t.getHeight()
     */
    private int height(AvlNode t){
        return t==null ? -1 : t.getHeight();
    }
    
}
