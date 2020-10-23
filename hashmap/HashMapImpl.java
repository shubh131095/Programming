package hashmap;

public class HashMapImpl<K,V>
{
 Node<K,V> arrayOfNodes[] = null;
 int index;

 private Node<K,V> findArrayEle(K key)
 {
   if(arrayOfNodes==null)
   {
     System.out.println("key not present");
     return null;
   }
   for(Node<K,V> listOfNodes : arrayOfNodes)
   {
     if( (listOfNodes.key.hashCode()) == (key.hashCode()) )
     {
       return listOfNodes;
     }
   }
   return null;
 }
 void add(K key,V value)
 {
   if( arrayOfNodes == null )
   {
     Node<K, V> arrayOfNodes[] = new Node[7];

   }
   Node<K, V> newNode = findArrayEle( key );
     if( newNode == null )
     {
       Node<K, V> startNode=newNode;
       startNode.key = key;
       newNode=arrayOfNodes[index++] = startNode;
     }

   addToList(newNode,key,value);
 }

  private void addToList( Node<K,V> newNode, K key, V value )
  {
    Node<K,V> node = newNode;
    node.key=key;
    node.value=value;
    if(newNode.next==null)
    {
      newNode.next=node;
      node.prev = newNode;
    }
    else
    {
      while(newNode.next!=null)
      {
        newNode=newNode.next;
      }
      newNode.next = node;
      node.prev = newNode;
    }
  }
  public V get(K key)
  {
    Node<K,V> startOfNodes=findArrayEle( key );
    if(startOfNodes !=null)
    {
      Node<K,V> traverseNode= startOfNodes.next;
      while(traverseNode.next!=null)
      {
        if(traverseNode.key.equals( key ))
        {
          return traverseNode.value;
        }
        else
        {
          traverseNode=traverseNode.next;
        }
      }
    }
    return null;
  }
}
