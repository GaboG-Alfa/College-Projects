/*
 * La clase que se encarga de hacer el ordenamiento por mezcla
 */
package sorts;

/**
 *
 * @author Gabriel Guzmán Alfaro
 * @version 30/05/2021
 */
public class MergeSort {
    
    /**
     * 
     * @param a 
     */
    public void mergeSort(Integer[] a){
        
        Integer[] tempArray = (Integer[]) new Integer[a.length];
        
        mergeSort(a,tempArray,0,a.length-1);
        
    }

    /**
     * 
     * @param a
     * @param tempArray
     * @param left
     * @param right 
     */
    private void mergeSort(Integer[] a, Integer[] tempArray, int left, int right){
        
        if(left < right){
            
            int center = (left + right)/2;
            
            mergeSort(a,tempArray,left,center);
            
            mergeSort(a,tempArray,center+1,right);
            
            merge(a, tempArray,left,center+1,right);
            
        }
       
    }
    
    /**
     * 
     * @param a
     * @param tempArray
     * @param leftPos
     * @param rightPos
     * @param rightEnd 
     */
    private void merge (Integer[]a,Integer[] tempArray,int leftPos, int rightPos, int rightEnd){
        
        int leftEnd = rightPos -1;
        int tempPos = leftPos;
        int numElements = rightEnd -leftPos +1;
        
        while(leftPos <= leftEnd && rightPos <= rightEnd){
            
            if(a[leftPos].compareTo(a[rightPos]) <= 0){
                
                tempArray[tempPos++] = a[leftPos++];
                
            }else{
                
                tempArray[tempPos++] = a[rightPos++];
                
            }
            
           
        }
        
         while(leftPos <= leftEnd){
                
                tempArray[tempPos++] = a[leftPos++];
                
            }
         
         while(rightPos <= rightEnd){
             
             tempArray[tempPos++] = a[rightPos++];
         }
            
            for(int i=0;i < numElements; i++,rightEnd--)
                a[rightEnd] = tempArray[rightEnd];
     
    }
    
}
