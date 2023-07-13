/*
 * Clase que se encarga de ejecutar los algoritmos de ordenamiento y crear un csv
 */
package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import sorts.BubbleSort;
import sorts.InsertionSort;
import sorts.MergeSort;
import sorts.QuickSort;
import sorts.ShellSort;

/**
 *
 * @author Gabriel Guzmán Alfaro
 * @version 30/05/201
 */
public class AlgoritmosOrdenamientoTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //Instancias y variables
        int tamannoMax = 50000;
        String salidaArchivo = "";
        BubbleSort bubble = new BubbleSort();
        InsertionSort insert = new InsertionSort();
        ShellSort shell = new ShellSort();
        MergeSort merge = new MergeSort();
        QuickSort quick = new QuickSort();
        
        Integer[] desordenado;

        long tiempoInicio, tiempoFinal;
        
        salidaArchivo +="\nAleatorio\n";

        salidaArchivo += "Tamano;Burbuja;Burbuja Mejorado;Inserción;Shell;Merge;Quick\n";

        //Aleatorio
        for (int tamanno = 5000; tamanno <= tamannoMax; tamanno += 5000) {

            desordenado = new Integer[tamanno];

            for (int cont = 0; cont < desordenado.length; cont++) {

                desordenado[cont] = (int) (Math.random() * desordenado.length) + 1;

            }
            
            Integer[] temp = desordenado.clone();

            System.out.println("\n---Con "+ tamanno +" elementos ---");
            
            salidaArchivo+=tamanno+";";
            
            tiempoInicio = System.nanoTime();
            Integer ordenado[] = bubble.bubble(temp);
            tiempoFinal = System.nanoTime();
            
            System.out.println("\nTiempo burbuja: "+ (tiempoFinal-tiempoInicio));
            
            salidaArchivo+= (tiempoFinal-tiempoInicio)+";";
            
            temp=desordenado.clone();
            tiempoInicio= System.nanoTime();
            ordenado= bubble.bubbleOP(temp);
            tiempoFinal= System.nanoTime();
            
            System.out.println("\nTiempo burbuja mejorado: "+ (tiempoFinal-tiempoInicio));
            
            salidaArchivo+= (tiempoFinal-tiempoInicio)+";";
            
            temp=desordenado.clone();
            tiempoInicio= System.nanoTime();
            insert.insertion(temp);
            tiempoFinal= System.nanoTime();
            
            System.out.println("\nTiempo inserción mejorado: "+ (tiempoFinal-tiempoInicio));
            
            salidaArchivo+= (tiempoFinal-tiempoInicio)+";";
            
            temp=desordenado.clone();
            tiempoInicio= System.nanoTime();
            shell.shellSort(temp);
            tiempoFinal= System.nanoTime();
            
            System.out.println("\nTiempo shell sort: "+ (tiempoFinal-tiempoInicio)+";");
            
            salidaArchivo+= (tiempoFinal-tiempoInicio)+";";
            
            temp=desordenado.clone();
            tiempoInicio= System.nanoTime();
            merge.mergeSort(temp);
            tiempoFinal= System.nanoTime();
            
            System.out.println("\nTiempo merge sort: "+ (tiempoFinal-tiempoInicio));
            
            salidaArchivo+= (tiempoFinal-tiempoInicio)+";";
            
            temp=desordenado.clone();
            tiempoInicio= System.nanoTime();
            quick.quickSort(temp);
            tiempoFinal= System.nanoTime();
            
            System.out.println("\nTiempo quick sort: "+ (tiempoFinal-tiempoInicio));
            
            salidaArchivo+=(tiempoFinal-tiempoInicio)+ "\n";
                  
        }
        
        //Ascendente
        salidaArchivo +="\nAscendente\n";
        salidaArchivo += "Tamano;Burbuja;Burbuja Mejorado;Inserción;Shell;Merge;Quick\n";
        for (int tamanno = 5000; tamanno <= tamannoMax; tamanno += 5000) {

            desordenado = new Integer[tamanno];

            for (int cont = 0; cont < desordenado.length; cont++) {

                desordenado[cont] = cont;
            }

            Integer[] temp = desordenado.clone();

            System.out.println("\n---Con " + tamanno + " elementos ---");

            salidaArchivo += tamanno + ";";

            tiempoInicio = System.nanoTime();
            Integer ordenado[] = bubble.bubble(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo burbuja: " + (tiempoFinal - tiempoInicio));

            salidaArchivo +=(tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            ordenado = bubble.bubbleOP(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo burbuja mejorado: " + (tiempoFinal - tiempoInicio));

            salidaArchivo +=(tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            insert.insertion(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo inserción mejorado: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            shell.shellSort(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo shell sort: " + (tiempoFinal - tiempoInicio) + ";");

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            merge.mergeSort(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo merge sort: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            quick.quickSort(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo quick sort: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + "\n";

        }

        //Descendente
        salidaArchivo +="\nDescendente\n";
        salidaArchivo += "Tamano;Burbuja;Burbuja Mejorado;Inserción;Shell;Merge;Quick\n";
        for (int tamanno = 5000; tamanno <= tamannoMax; tamanno += 5000) {

            desordenado = new Integer[tamanno];

            for (int cont = 0; cont < desordenado.length; cont++) {

                desordenado[cont] = tamanno-cont;
               
            }

            Integer[] temp = desordenado.clone();

            System.out.println("\n---Con " + tamanno + " elementos ---");

            salidaArchivo +=tamanno + ";";

            tiempoInicio = System.nanoTime();
            Integer ordenado[] = bubble.bubble(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo burbuja: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            ordenado = bubble.bubbleOP(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo burbuja mejorado: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            insert.insertion(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo inserción mejorado: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            shell.shellSort(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo shell sort: " + (tiempoFinal - tiempoInicio) + ";");

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            merge.mergeSort(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo merge sort: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + ";";

            temp = desordenado.clone();
            tiempoInicio = System.nanoTime();
            quick.quickSort(temp);
            tiempoFinal = System.nanoTime();

            System.out.println("\nTiempo quick sort: " + (tiempoFinal - tiempoInicio));

            salidaArchivo += (tiempoFinal - tiempoInicio) + "\n";

        }
        
        
        //Imprimir como se ve el archivo
        System.out.println(salidaArchivo);

        try {
            String ruta = "Resultados.csv";
            File file = new File(ruta);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(salidaArchivo);
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
