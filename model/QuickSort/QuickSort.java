/*
 * La clase que se encarga de ordenar por quick  
 */
package model.QuickSort;


/**
 *
 * @author GABRIEL GUZMÁN ALFARO
 * @version 30/05/2021
 */
public class QuickSort <T extends Comparable<T>> {
    
    //Atributos
    private static int CutOff = 50;
    
    /**
     * 
     * @param a 
     */
    public void quickSort(T[] a){
        quickSort(a,0,a.length-1);
    }
    
    /**
     * 
     * @param a
     * @param low
     * @param high 
     */
    private void quickSort(T[]a,int low, int high){
        
        if(low + CutOff > high ){
            insertionSort(a,low,high);
        }else{
           
            int middle= (low+high)/2;
            
            if(a[middle].compareTo(a[low])<0){
                
                swapReferences(a,low,middle);
                
            }
            
            if(a[high].compareTo(a[low])<0){
                
                swapReferences(a,low,high);
            }
            
            if(a[high].compareTo(a[middle])<0){
                
                swapReferences(a,low,high);
            }
            
            swapReferences(a,middle,high-1);
            
            T pivot = a[high-1];
            
            int i,j;
            
            for(i=low,j=high-1;;){
            
                while(a[++i].compareTo(pivot)<0);
            
                while(pivot.compareTo(a[--j])<0);
                
                if(i>=j){
                    break;
                }
                
                swapReferences(a,i,j);
            }
            
            swapReferences(a,i,high-1);
            
            quickSort(a,low,i-1);
            
            quickSort(a,i+1,high);
            
        }
        
    }
    
    /**
     * 
     * @param a
     * @param low
     * @param high 
     */
    private void insertionSort(T[] a,int low, int high){
        
        for(int p=low +1; p<=high ; p++){
            
            T temp = a[p];
            
            int j;
            
            for(j=p;j> low && temp.compareTo(a[j-1])<0;j--){
                
                a[j] = a[j-1];
            }
            
            a[j] = temp;
            
        }
        
    }
    
    /**
     * 
     * @param a
     * @param index1
     * @param index2 
     */
    private void swapReferences(T[] a, int index1, int index2){
        
        T temp = a[index1];
        a[index1] = a [index2];
        a[index2] = temp;
        
    }
    
}
