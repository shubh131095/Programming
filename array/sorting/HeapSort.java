package array.sorting;


import java.util.Arrays;
import java.util.Optional;

class MaxHeap
{
  int[] heap;
  int size;
  private int heap_size;

  // if no value is provided then intial size will be 10;
  public MaxHeap( Optional<Integer> intial_size )
  {
    heap_size = intial_size.orElse( 10 );
    heap = new int[heap_size];
    //size=0;
  }

  private void swap( int child, int parent, int[] heap )
  {
    int temp = heap[child];
    heap[child] = heap[parent];
    heap[parent] = temp;
  }

  public void insert( int value )
  {
    // todo
    // if current_size = heap_size , create new array with more size and copy cotents. // or use list.

    int curr = size;
    heap[size++] = value;
    if( size == 1 ) return; // first element no need to heapify.
    while( heap[curr] > heap[(curr - 1) / 2] )
    {
      swap( curr, (curr - 1) / 2, heap );
      curr = (curr - 1) / 2;
    }
  }

  public void heapify( int pos )
  {
    // if leaf node return;
    if( pos >= (size / 2) ) return;
    if( heap[pos] < heap[(pos * 2) + 1] || heap[pos] < heap[(pos * 2) + 2] )
    {
      if( heap[(pos * 2) + 1] > heap[(pos * 2) + 2] )   // if left value > right value
      {
        swap( pos, (pos * 2) + 1, heap );
        heapify( (pos * 2) + 1 );
      }
      else
      {
        swap( pos, (pos * 2) + 2, heap );
        heapify( (pos * 2) + 2 );
      }
    }
  }

  public void heapSort()
  {
    size--; // since size will be +1 the element as element are stored from index 0;
    while( size >= 0 )
    {
      swap( 0, size, heap );
      size--;    // after reducing size by 1 , youre keeping last element(biggest from anymore oprn)
      heapify( 0 );
    }
  }

  // all the methods below this are extra for optimization, heap sort can be done by using above method also
  public void createMaxHeap( int[] a ) // n-> size of a
  {
    for( int i = heap_size / 2; i >= 0; i-- )
    {
      maxHeapify( a, i );
    }
  }

  private void maxHeapify( int[] a, int pos )
  {
    if( pos >= (heap_size / 2) ) return;
    int left_child = (pos * 2) + 1;
    int right_child = (pos * 2) + 2;
    int largest = pos;

    // check left
    if( left_child < heap_size && left_child >= 0 && a[left_child] > a[largest] )
    {
      largest = left_child;
    }
    // check right
    if( right_child < heap_size && right_child >= 0 && a[right_child] > a[largest] )
    {
      largest = right_child;
    }

    if( largest != pos ) // means LC or RC exist and greater than current index
    {
      swap( pos, largest, a );
      maxHeapify( a, largest );
    }

  }

  public void doHeapSort( int a[] )
  {
    heap_size--; // indexing start from 0
    while( heap_size >= 0 )
    {
      swap( 0, heap_size, a );
      heap_size--;
      maxHeapify( a, 0 );
    }
  }
}

public class HeapSort
{
  // this soln can be more optimized as, we should not create heap[] inside class, we should create heap using input aaray
  // and later sort that.
  public static void main( String[] args )
  {
    int [] ip_array = {2,4,1,0,22,9,5,6};
 /*   MaxHeap mHeap = new MaxHeap( Optional.of( ip_array.length ) );
   for(int i=0;i<ip_array.length;i++)
   {
      mHeap.insert( ip_array[i] );
   }
    mHeap.heapSort(); // will sort the heap aaray
    Arrays.stream( mHeap.heap ).forEach( System.out::println );*/

    MaxHeap heap = new MaxHeap( Optional.of( ip_array.length ) );
    heap.createMaxHeap( ip_array );
    heap.doHeapSort( ip_array );
    Arrays.stream(ip_array ).forEach( System.out::println );
  }
}
