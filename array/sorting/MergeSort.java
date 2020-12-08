package array.sorting;

import java.util.Arrays;

public class MergeSort
{
  public static void main( String[] args )
  {
    int [] ip_array = {2,4,1,0,22,9,5,6};
    doMergeSort(ip_array,0,ip_array.length-1);
    Arrays.stream( ip_array ).forEach( System.out::println );
  }

  private static void doMergeSort( int[] a, int low, int end )
  {
    if(low>=end)
    {
      return;
    }
    int middle = (low+end)/2;
    doMergeSort( a,low,middle );
    doMergeSort( a,middle+1,end );
    doMerge(a,low,middle,end);

  }

  private static void doMerge( int[] a, int low, int middle, int end )
  {
    int temp1Size = (middle-low)+1;
    int temp2Size = (end-middle);
    int temp1[] = new int[temp1Size];
    int temp2[] = new int[temp2Size];
    for(int x=0;x<temp1Size;x++)
    {
      temp1[x] = a[x+low];
    }
    for(int x=0;x<temp2Size;x++)
    {
      temp2[x] = a[x+middle+1];
    }

    int i=0,j=0,k=low;
    while( i < temp1Size && j<temp2Size)
    {
      if(temp1[i] < temp2[j])
      {
        a[k] = temp1[i];
        i++;
      }
      else
      {
        a[k] = temp2[j];
        j++;
      }
      k++;
    }
    while(i<temp1Size)
    {
      a[k] = temp1[i];
      i++;
      k++;
    }
    while(j<temp2Size)
    {
      a[k] = temp2[j];
      j++;
      k++;
    }
  }
}
