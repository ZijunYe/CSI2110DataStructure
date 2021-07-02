// ==========================================================================
// $Id: BubbleSort.java,v 1.1 2006/11/05 03:27:51 jlang Exp $
// CSI2110 Lab code; basic bubble sort 
// ==========================================================================
// (C)opyright:
//
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: unknown (Lab source without reference), adapted by J.Lang
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: BubbleSort.java,v $
// Revision 1.1  2006/11/05 03:27:51  jlang
// Added lab8 on sorting.
//
//
// ==========================================================================
/**
 * Implements bubble sort.
 */
public class BubbleSort<T extends Comparable> {

  public BubbleSort(T[] _seq ) {
    mergeSort(_seq, 0,_seq.length-1); 
  }

  private void mergeSort(T[] array, int start, int end)
    {
        // base case
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSort(array, start, middle); // sort first half
            mergeSort(array, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, start, middle, end);
        }
    }
  

  private void merge(T[] array, int start, int middle, int end){
    int leftSize= middle - start + 1; 
    int rightSize = end - middle; 

    T[] tmp1 = (T[])new Comparable[leftSize]; 
    T[] tmp2 = (T[])new Comparable[rightSize]; 
    //input value
    for(int i = 0; i < leftSize; i++){
      tmp1[i] = array[start+i]; 
    }
    for(int j = 0; j < rightSize; j++){
      tmp2[j] = array[middle +1 + j]; 
    }


    int i= 0, j = 0; 

    int k = start; 
    while(i < leftSize && j < rightSize){
      if(tmp1[i].compareTo(tmp2[j]) <= 0 ){
        array[k] = tmp1[i]; 
        i++; 
      }else{
        array[k] = tmp2[j]; 
        j++;
      }
      k++;
    }

    while(i < leftSize){
      array[k] = tmp1[i]; 
      i++; 
      k++; 
    }

    while(j < rightSize){
      array[k] = tmp2[j]; 
      j++; 
      k++; 
    }
  
  } 
}
