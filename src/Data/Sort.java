/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Random;

/**
 *
 * @author jt024
 */
public class Sort {

    private int[] numbers;
    private Random rand = new Random();
    StringBuilder sb = new StringBuilder();
    
    
    public Sort(int elements){
        numbers = new int[elements];
    }
    public Sort(int num[]){
        numbers = num;
    }
    public int[] getIntArray(){
        return numbers;
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
    public void insertionSort(int arr[])
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
    public void insertionSortRec(int arr[], int n)
    {
        numbers = arr;
        // Base case
        if (n <= 1)
            return;
      
        // Sort first n-1 elements
        insertionSortRec(arr, n-1 );
      
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

    // <editor-fold defaultstate="collapsed" desc="**Quick Sort**"> 
    
    public void QuickSort(int arr[], int l, int h)
    {
        numbers = arr;
        // create auxiliary stack
        int stack[] = new int[h-l+1];
 
        // initialize top of stack
        int top = -1;
 
        // push initial values in the stack
        stack[++top] = l;
        stack[++top] = h;
 
        // keep popping elements until stack is not empty
        while (top >= 0)
        {
            // pop h and l
            h = stack[top--];
            l = stack[top--];
 
            // set pivot element at it's proper position
            int p = partitionIterative(numbers, l, h);
 
            // If there are elements on left side of pivot,
            // then push left side to stack
            if ( p-1 > l )
            {
                stack[ ++top ] = l;
                stack[ ++top ] = p - 1;
            }
 
            // If there are elements on right side of pivot,
            // then push right side to stack
            if ( p+1 < h )
            {
                stack[ ++top ] = p + 1;
                stack[ ++top ] = h;
            }
       }
    }
    
    
    public void quickRecursiveSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            quickRecursiveSort(arr, low, pi-1);
            quickRecursiveSort(arr, pi+1, high);
        }
    }
    // used by quickSort()
    
    private int partitionIterative(int arr[], int l, int h)
    {
        int x = arr[h];
        int i = (l - 1);
 
        for (int j = l; j <= h- 1; j++)
        {
            if (arr[j] <= x)
            {
                i++;
                // swap arr[i] and arr[j]
                swap(arr,i,j);
            }
        }
        // swap arr[i+1] and arr[h]
        swap(arr,i+1,h);
        return (i + 1);
    }
    
    private void swap(int arr[],int i,int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    
    private int medianOf3(int left, int right){
        int center = (left+right)/2;
        if (numbers[left]>numbers[center]) {
            
        }
    }
    
    // </editor-fold>       

    // <editor-fold defaultstate="collapsed" desc="**Shell Sort**"> 
    
    public int shellSort(int arr[]){
        int n = arr.length;
 
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];
 
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
 
                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;        
    }
    
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="**Heap Sort**">     
    
    
    
    
    
// </editor-fold>

    
// </editor-fold>    
    
    
// <editor-fold defaultstate="collapsed" desc="**CLASS METHODS**">     
    public String elementsToString(){
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
            sb.append(",");
        }
        return sb.toString();
    }
    
    
    
// </editor-fold>      
}
