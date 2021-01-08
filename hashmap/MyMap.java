package hashmap;

import java.util.LinkedList;
import java.util.List;

// this is my custom linked list.
class MyNode<K,V>
{
  K key;
  V value;
  MyNode<K,V> next;
  MyNode<K,V> prev;
  public MyNode( K key_, V value_ )
  {
    key = key_;
    value = value_;
  }

  @Override
  public String toString()
  {
    return "key=" + key +
           ", value=" + value
           ;
  }
}
public class MyMap<K,V>
{
  MyNode<K,V> buckets[] ;
  int size;
  int capacity;
  private static final double LOAD_FACTOR = 0.75;

  public MyMap()
  {
    this(10); // default size of map
  }

  public MyMap(int size)
  {
    this.size = size;
    this.buckets = new MyNode[size];
    this.capacity = 0;
  }

  // put value in Map
  private Boolean isKeyPresent( K key,int index )
  {
    if( buckets[index]==null) return false;
    MyNode curr = buckets[index];

    while( curr!=null)
    {
      if(curr.key.equals( key ))
      {
        return true;
      }
      curr = curr.next;
    }
    return false;

  }
  private void reIntilizeMap()
  {
    this.size = size*2;
    MyNode<K,V> newBuckets[] = buckets;
    buckets = new MyNode[size];

    // iterate through old buckets and put that in new bucket
    for(MyNode<K,V> indexes : newBuckets)
    {
      while(indexes!=null)
      {
        put( indexes.key,indexes.value );
        indexes = indexes.next;
      }
    }
  }
  public void put( K key,V value)
  {
    // first get the index of the key using hashcode and size
    int index = key.hashCode() % this.size;

    // 1.this can be first key for the respective bucket
    // 2.this can be nth key for the bucket
    // 3.this can be already existing key
    // only for 3rd case we dont incremnet capacity as the existing key value will be replaced
    // for 1 and 2nd we have to check whether current capacity increases load factor
    // if capacity is more than load factor, create new map copy value.

    if(isKeyPresent(key,index) )
    {
        MyNode newNode = buckets[index];
        while( newNode!=null)
        {
          if( newNode.key.equals( key ))
          {
            newNode.value = value;
            break;
          }
          newNode = newNode.next;
        }
    }
    else
    {
      capacity++;
      if( capacity >= (int) (LOAD_FACTOR * size) )
      {
          reIntilizeMap();
      }
      // just keeping the newNode to head of bucket and pusing everything back
      else
      {
        MyNode<K,V> newNode = new MyNode<>( key,value );
        if( buckets[index]==null)
        {
          buckets[index] = newNode;
        }
        else
        {
          buckets[index].prev = newNode;
          newNode.next= buckets[index];
          buckets[index]= newNode;
        }
      }
    }
  }


  // remove from map
  public MyNode<K,V> remove(K key)
  {
    // if key doesnt exist return null;
    // if key present remove that node and return it.

    int index = key.hashCode()% size;

    if( buckets[index]==null)
    {
      System.out.println("Key not present:-");
      return null;
    }
    else
    {
      MyNode<K,V> curr = buckets[index];
      while( curr!=null)
      {
        if( curr.key.equals( key ))
        {
          capacity--;
          curr.prev.next = curr.next;
          curr.next.prev = curr.prev;
          return curr;
        }
        curr = curr.next;
      }
      System.out.println("Key not present:-");
      return null;
    }
  }

  // get from map based on key
    public V get(K key)
    {
      int index = key.hashCode()%size;
      if( buckets[index]==null)
      {
        System.out.println("Key not present:-");
        return null;
      }
      else
      {
        MyNode<K,V> curr = buckets[index];
        while( curr!=null)
        {
          if( curr.key.equals( key ))
          {
            return curr.value;
          }
          curr = curr.next;
        }
        System.out.println("Key not present:-");
        return null;
      }

    }
  // conatinsKey check
  public boolean containsKey(K key)
  {
    int index = key.hashCode()%size;
    return isKeyPresent( key,index );
  }
  // size( basically capacity)
  // print all elements
  public void printAll()
  {
    for(MyNode<K,V> index : buckets)
    {
      while( index !=null )
      {
        System.out.println(index);
        index = index.next;
      }
    }
  }
  public static void main( String[] args )
  {
    MyMap<Integer,Integer> map = new MyMap<>();
    map.put( 1,1 );
    map.put(2,1);
    map.put(11,1);
    map.put(1,2);
    map.put(2,1);

  map.printAll();
  }
}
