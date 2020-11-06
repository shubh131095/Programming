package hashmap;
// youre given a hashmap with keys and value. sort the hash map based on their values.

// 2 appraoches

// approach1
// create a arraylist of all the entries of hashmap.
// sort the list using comparator
// create new linkedhashmap which will preserve the order.

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//apporach2
// do all the above apporach using streams.
public class SortValue
{
  public static void main( String[] args )
  {
    Map<Integer,Integer> map = new HashMap<>();
    map.put(1,2);
    map.put(2,6);
    map.put(3,1);
    map.put(4,0);
    map.put(5,90);
    map.put(6,-1);
    map = sortMapByValue(map);
    List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
    System.out.println(list);
    map.clear();
    map.put(1,2);
    map.put(2,6);
    map.put(3,1);
    map.put(4,0);
    map.put(5,90);
    map.put(6,-1);

    map=sortMapByValueStream(map);
    List<Map.Entry<Integer,Integer>> list1 = new LinkedList<>(map.entrySet());
    System.out.println(list1);
  }
  private static Map<Integer,Integer> sortMapByValue( Map<Integer, Integer> map )
  {
    List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
    Map<Integer,Integer> sortedMap = new LinkedHashMap<>();

    Collections.sort( list, new Comparator<Map.Entry<Integer,Integer>>()
    {
      public int compare( Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2)
      {
        return o1.getValue().compareTo( o2.getValue() );
      }
    });

    // or same as above
    /*Collections.sort( list, (i,j) -> {
        return i.getValue().compareTo( j.getValue() );
      } );
*/
    //or
    // Collections.sort( list, Comparator.comparing( Map.Entry::getValue ) );



    for( Map.Entry<Integer,Integer> entry : list)
    {
      sortedMap.put(entry.getKey(), entry.getValue() );
    }
    return sortedMap;
    }

    private static Map<Integer,Integer> sortMapByValueStream( Map<Integer, Integer> map)
  {
    HashMap<Integer,Integer> sortedMap = map.entrySet().stream()
      .sorted( Map.Entry.comparingByValue())
      .collect(Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue,
        (e1, e2) -> e1, LinkedHashMap::new));

    return sortedMap;
  }
}
