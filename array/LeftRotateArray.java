package array;

// one more approach apart from curremt implemenetd
// take a new aaray and one by one fill it using original aaray by getting their final position.
public class LeftRotateArray
{
  public static void reverseArray( int[] arr, int i, int j )
  {
    for( ; i < j; i++, j-- )
    {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  public static void main( String[] args )
  {
    int[] a = {1, 2, 3, 4, 5, 6};
    int k = 6;
    int size = a.length;
    if( k > size )
    {
      k = k - size;
    }
    else if( k == size ) return;

    reverseArray( a, 0, k - 1 );
    reverseArray( a, k, size - 1 );
    reverseArray( a, 0, size - 1 );

    for(int i=0;i<size;i++)
    {
      System.out.print( a[i] + " ");
    }
  }
}
