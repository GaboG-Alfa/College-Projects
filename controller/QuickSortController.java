/*
 * Clase que se encarga de controllar el quicksort y el vector
 */
package controller;

import java.util.ArrayList;
import model.QuickSort.QuickSort;

/**
 *
 * @author GABRIEL GUZMÁN ALFARO
 */
public class QuickSortController<T extends Comparable<T>> {

    //Atributos
    T[] desordenado;
    QuickSort quick = new QuickSort();

    /**
     *
     * @param personaArray
     */
    public void insertar(ArrayList<T> personaArray) {

        this.desordenado = (T[]) new Comparable[personaArray.size()];

        for (int i = 0; i < desordenado.length; i++) {

                desordenado[i] = personaArray.get(i);

        }
    }

    /**
     * Metodo para ordenar el array con quick sort
     */
    public void ordenar() {

        T[] temp = desordenado;

        quick.quickSort(temp);

    }

    /**
     *
     * @param persona
     * @return busquedaBinaria
     */
    public T busquedaBinaria(T persona) {

        return busquedaBinaria(desordenado, 0, desordenado.length - 1, persona);

    }
    
    /**
     *
     * @param arr
     * @param l
     * @param r
     * @param x
     * @return busquedaBinaria
     */
    private T busquedaBinaria(T[] arr, int l, int r, T x) {
        
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid].compareTo(x) == 0) {
                return arr[mid];
            }

            if (arr[mid].compareTo(x) > 0) {
                return busquedaBinaria(arr, l, mid - 1, x);
            }

            return busquedaBinaria(arr, mid + 1, r, x);
        }

        return null;
    }
    

}
