/*
 * La clase que ordena por método shell 
 */
package sorts;

/**
 *
 * @author Gabriel Guzmán Alfaro
 */
public class ShellSort {

    /**
     * 
     * @param a
     * @return 
     */
    public Integer[] shellSort(Integer[] a) {

        for (int gap = a.length / 2; gap > 0; gap = gap== 2 ? 1 : (int) (gap / 2.2)) {

            for (int i = gap; i < a.length; i++) {

                Integer temp = a[i];

                int j = i;

                for (; j >= gap && temp.compareTo(a[j - gap]) < 0; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = temp;

            }
            
        }
        
         return a;

    }
}
