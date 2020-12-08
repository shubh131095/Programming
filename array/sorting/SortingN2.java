package array.sorting;
// this class will handle the 3 quadratic time sorting tech.

// Bubble -> compare pair of index and swap if necessadry. in this at every pass the last element in array will be the biggest and so on. In this Technique right part remain sorted and left part remains unsorted.

// Selection -> in this you find the smallest element and then swap with the current index. less no of swaps but no best case in this(regarding time complexity). in this after every iteration, the array will be sorted from left side and right part is unsorted.

// Insertion -> its little trick.
// at every iteration u keep left hand sorted and right hand unsorted. and at each iteration you will find the sutitable place in the sorted list for the new element. we use this only fr small value of N.

public class SortingN2
{
  private static void swap( int[] arr,int i, int j )
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void doBubbleSort( int[] bubble )
  {
    for(int i=0;i<bubble.length;i++)
    {
      for(int j=i+1;j< bubble.length;j++)
      {
        if(bubble[i]>bubble[j])
        {
          swap(bubble,i,j);
        }
      }
    }
  }


  private static void doSelectionSort( int[] selection )
  {
    for( int i = 0; i < selection.length; i++ )
    {
      int index = i;
      for( int j = i + 1; j < selection.length; j++ )
      {
        if( selection[j] < selection[index] )
        {
          index = j;
        }
      }
      swap( selection, i, index );

    }
  }
  private static void doInsertionSort( int[] insertion )
  {
      for(int i=1;i<insertion.length;i++)
      {
        int temp = insertion[i];
        int curr_index=i;
        for(int j=i-1;j>=0;j--)
        {
          if(insertion[j]>temp)
          {
            insertion[curr_index]=insertion[j];
            curr_index--;
          }
          else
          {
            break;
          }
        }
        insertion[curr_index]=temp;
      }
  }
  public static void main( String[] args )
  {
    int [] bubble = {2,4,1,3,10,5,6,8};
    int [] selection = {2,4,1,3,10,5,6,8};
    int [] insertion = {2,4,1,3,10,5,6,8};
    doBubbleSort(bubble);
    doSelectionSort(selection);
    doInsertionSort(insertion);
    System.out.print("bubble ");
    for( int a : bubble )
    {
      System.out.print(a + " ");
    }
    System.out.println();
    System.out.print("selection ");
    for( int a : selection )
    {
      System.out.print(a + " ");
    }
    System.out.println();
    System.out.print("insertion ");
    for( int a : insertion )
    {
      System.out.print(a + " ");
    }
  }

}
