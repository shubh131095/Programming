package BasicImplementation.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingAnagrams
{
  public static void main( String[] args )
  {
    List<String> list = Arrays.asList("bac","abc","ccd","cdc","cba","dcc");

   List<String> sorted =  list.stream()
                          .map( i -> i.toCharArray())
                          .map( i ->
                          { Arrays.sort( i );
                             return new String(i);}
                             ).collect( Collectors.toList());

        var map = new HashMap<String,List<Integer>>();
        int a = 0;

        for( var entry : map.entrySet())
        {
          System.out.println( entry.getKey() + " " + entry.getValue());
        }
  }
}
