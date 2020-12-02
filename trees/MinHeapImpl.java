package trees;
// in this we are implementating Min heap, for converting into max heap will be easy.
import java.util.ArrayList;
import java.util.List;

class MinHeap
{

  private List<Integer> list;// this is the actual heap which will contain elements.
  private int size; // heap size;
  private static final int FRONT =1; // the 1st element;

 // constructor to intilize heap.
  public MinHeap()
  {
    size=0;
    list = new ArrayList<>();
    list.indexOf( Integer.MIN_VALUE );

  }

  // to get parent of given node
  private int getParent(int pos)
  {
    return (int)pos/2;
  }
  // to get Left Child of given node
  private int getLeftChild(int pos)
  {
    return pos*2;
  }
  // to get Right Child of given node
  private int getRightChild(int pos)
  {
    return (pos*2)+1;
  }
  // to check whether the given node is leaf or nor
  private boolean isLeaf(int pos)
  {
    if( pos>(size/2) || pos<=size) return true;
    else return false;
  }
  // function to swap 2 nodes
  private void swap(int fpos,int lpos)
  {
    int temp = list.get( fpos );
    list.add( fpos,lpos );
    list.add( lpos,temp );
  }

  // function to heapify

  private void heapify(int pos)
  {
    // if non leaf node , or current node value is greater than left or right child,then only heppify required.
    if(!isLeaf( pos ))
    {
      if(list.get( pos ) > list.get( getLeftChild( pos ) ) || list.get( pos) > list.get( getRightChild( pos ) ))
      {
       if(list.get( getLeftChild( pos ) ) > list.get( getRightChild( pos ) ))
       {
         swap( pos,getLeftChild(  pos) );
         heapify( getLeftChild( pos ) );
       }
       else
       {
         swap( pos,getRightChild(  pos) );
         heapify( getRightChild( pos ) );
       }
      }
    }
  }
  // insert element in heap;
  public void insert(int ele)
  {
    // since we are using a list we dont have size constraint,but if u want to restrict, you can keep check here
    list.add( ele );
    size++;
    int cur = size;
    // we will insert the new element at last, and will check from its current paremt till root,wherever it fits
    if(size==1) return;
    while(list.get( cur ) < list.get( getParent( cur ) ))
    {
      swap( cur,getParent( cur ) );
      cur = getParent( cur );
    }
  }
  public void doMinHeap()
  {
    for(int i =size/2;i>=1;i--)
    {
      heapify( i );
    }
  }


  // this is to remove a number at particular index.
  public int remove(int pos)
  {
    if(pos>size) return -1;
    int temp = list.remove( size );
    size--;
    int remove = list.get( pos );
    list.add( pos,temp );
    heapify( pos );
    return remove;
  }
  // to remove the top node/getmin
  // since our first node i.e index 0 is a custom inserted number we willget 1s node.
  public int remove()
  {
    int temp = list.get( FRONT );
    list.add(FRONT,size);
    list.remove( size );
    size--;
    heapify( FRONT );
    return temp;
  }
  public void print()
  {
    for(int i=0;i<size/2;i++)
    {
      System.out.print( "Current Node , Parent :-" + list.get( i )
                        + " , Current Node Left Child :-" + list.get( getLeftChild( i ) )
                        + " , Current Node Right Child :-" + list.get( getRightChild( i ) ));
    }
  }
}
public class MinHeapImpl
{
  public static void main( String[] args )
  {

  }
}
