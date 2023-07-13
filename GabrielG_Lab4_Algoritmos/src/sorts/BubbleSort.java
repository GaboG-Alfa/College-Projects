/*
 *Ordenar por método burbuja
 */
package sorts;

/**
 *
 * @author Gabriel Guzmán Alfaro
 * @version 24/05/2021s
 */
public class BubbleSort {

    /**
     * 
     * @param vector 
     * @return vector
     */
    public Integer[] bubble(Integer[] vector) {

        for (int a = 0; a < vector.length; a++) {
            for (int b = 0; b < vector.length -a-1; b++) {
                if(vector[b] < vector[b+1]){
                int temp;
                temp = vector[a];
                vector[a] = vector[a+1];
                temp = vector[a + 1];
                
                }
            }

        }
        
        return vector;
    }
    
    /**
     * 
     * @param vector
     * @return vector
     */
    public Integer[] bubbleOP(Integer[] vector){
        boolean ordenado = false;
        int cont = 0;
         for(int i = 0; i< vector.length-1; i++){
             if(vector[i]> vector[i+1]){
                 
                 int temp = vector[i];
                 vector[i] = vector[i+1];
                 vector[i+1] = temp;
                 ordenado = false;
             }
         }
         
         cont++;
         
         return vector;
    }

}
