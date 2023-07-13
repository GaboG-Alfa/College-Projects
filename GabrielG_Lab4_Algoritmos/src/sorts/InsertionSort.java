/*
 * Ordenar por inserción 
 */
package sorts;

/**
 *
 * @author Gabriel Guzmán Alfaro
 * @version 30/5/2021
 */
public class InsertionSort  {
    
    /**
     * 
     * @param a
     * @return a
     */
    public Integer[] insertion(Integer[]a){
        
        for(int i =1; i<a.length;i++){
            
            Integer temp;
            temp=a[i];
            
            int j=i;
            
            for(;j>0 && temp.compareTo(a[j-1]) < 0;j--){
                
                a[j] = a[j-1]; 
            }
            
             a[j] = temp;
            
        }
        
        return a;
               
    }
    
}
