package BasicImplementation.lambda.expression;

public class Person
{
  private String fName;
  private String lName;
  private int age;

  public Person( String fName_, String lName_, int age_ )
  {
    fName = fName_;
    lName = lName_;
    age = age_;
  }

  public String getfName()
  {
    return fName;
  }

  public void setfName( String fName_ )
  {
    fName = fName_;
  }

  public String getlName()
  {
    return lName;
  }

  public void setlName( String lName_ )
  {
    lName = lName_;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge( int age_ )
  {
    age = age_;
  }

  @Override
  public String toString()
  {
    return "Person{" +
           "fName=" + fName +
           ", lName=" + lName +
           ", age=" + age +
           '}';
  }


}
