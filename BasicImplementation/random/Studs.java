package BasicImplementation.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Students
{
  String name;
  Integer marks;
  public Students(String name_,Integer marks_)
  {
    name = name_;
    marks = marks_;
  }
  public Integer getMarks()
  {
    return this.marks;
  }
  public String getName()
  {
    return this.name;
  }
}

public class Studs
{

  Map<Integer,Students> student;
   public Studs()
   {
     this.student = new HashMap<>();
   }

  public static void main( String[] args )
  {
    Scanner sc = new Scanner( System.in );
    Studs students = new Studs();
    int a =1;
    int more=1;
    do
    {
      System.out.println("Enter Name:- ");
      String name = sc.next();
      System.out.println("Enter Marks:- ");
      Integer marks = sc.nextInt();
      Students s = new Students( name,marks );
      students.student.put( a,s);
      a++;
      System.out.println("Wish to enter more :- 1 to enter 0 to leave");
      more= sc.nextInt();
    }while(more==1);
    double avgMarks =0.0;
    int maxMarks = Integer.MIN_VALUE;
    int minMarks =Integer.MAX_VALUE;
    for( Students s : students.student.values() )
    {
        avgMarks += s.getMarks();
        maxMarks = Math.max(maxMarks,s.getMarks());
        minMarks = Math.min(minMarks,s.getMarks());
    }
    avgMarks = avgMarks/(students.student.values().size());
    System.out.println("a" + avgMarks);
    System.out.println("min" + minMarks);
    System.out.println("max"+ maxMarks);
  }
}
