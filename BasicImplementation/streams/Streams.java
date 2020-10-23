package BasicImplementation.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams
{

  public static void main( String[] args ) throws IOException
  {
    /*IntStream.range( 1,10 ).forEach( i -> System.out.print(i) ); //1
    System.out.println();

    IntStream.range(1,10).forEach(System.out::print); //2
    System.out.println();

    int [] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
     IntStream s = Arrays.stream( arr );
    s.forEach(System.out::print ); //3
    System.out.println();

    String[] str = {"abc","def","mine" , "yours"};
    Stream s2 = Stream.of( str );
    s2.forEach( i-> System.out.print(i));//4
    System.out.println();*/

   Stream<String> files = Files.lines( Paths.get( "src\\BasicImplementation\\streams\\data.txt" ) );
   /*files.forEach( System.out::println );
   System.out.println(); //5
*/
    files.map( x -> x.split(",") ).filter( x->x.length == 3 ).filter( x -> Integer.parseInt( x[2]) > 300).forEach(
      x -> System.out.println( x[0] + " " + x[1] + " " + x[2])
    );
  }
}
