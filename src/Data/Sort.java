/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import java.util.Arrays;
/**
 *
 * @author jt024
 */
public class Sort {

    private int intTempArray[] = new int[0];
    
 
    
    public int[] getIntArray(){
        return intTempArray;
    }
    
    
    
// <editor-fold defaultstate="collapsed" desc="**SORT METHODS**">    


    // <editor-fold defaultstate="collapsed" desc="**Bubble Sorts**">   
/**Method Comments*******************************************************
 * Name: intBubble()                                                    *
 * Description: Standard bubble sort method for a array of integers     *
 * Author: Johnny Trevino                                               *
 * Date: 6/2/2017                                                       *
 * @param arr                                                           *
 ************************************************************************/
    public void intBubble(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    
/**Method Comments*******************************************************
 * Name: intBubbleRec()                                                 *
 * Description: Recursive bubble sort method for a array of integers    *
 * Author: Johnny Trevino                                               *
 * Date: 8/12/2017                                                      *
 * @param arr                                                           *
 * @param n                                                             *
 ************************************************************************/    
    public void intBubbleRec(int arr[], int n) // Function to implement bubble sort
    {
        
        if (n == 1) // Base case
            return;
        
        for (int i=0; i<n-1; i++)           // One pass of bubble sort.
            if (arr[i] > arr[i+1])          // After this pass, the largest element
            {                               // is moved (or bubbled) to end.
                
                int temp = arr[i];          //
                arr[i] = arr[i+1];          // swap arr[i], arr[i+1]
                arr[i+1] = temp;            
            }
        intBubbleRec(arr, n-1); // Largest element is fixed.
                                // Call intBubbleRec() for remaining array.
    }   
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="**Insertion Sorts**">     
/**Method Comments*******************************************************
 * Name: intInsertion()                                                 *
 * Description: Standard insertion sort method for a array of integers  *
 * Author: Johnny Trevino                                               *
 * Date: 09/22/2017                                                     *
 * @param arr                                                           *
 ************************************************************************/
    public void intInsertion(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
/**Method Comments*******************************************************
 * Name: intInsertionRec()                                              *
 * Description: Recursive insertion sort method for a array of integers *
 * Author: Johnny Trevino                                               *
 * Date: 09/22/2017                                                     *
 * @param arr                                                           *
 * @param n
 ************************************************************************/    
    public void intInsertionRec(int arr[], int n)
    {
        intTempArray = arr;
        // Base case
        if (n <= 1)
            return;
      
        // Sort first n-1 elements
        intInsertionRec(arr, n-1 );
      
        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n-1];
        int j = n-2;
      
        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }    
    // </editor-fold>  
    
    
    
    
// </editor-fold>    
    
    
    
    
}
