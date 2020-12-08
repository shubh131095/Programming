package com.myImpl;
// a little incomplete
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main
{
  public static void main( String[] args )
  {
    MyTable table = new MyTable();

    Column name = new Column();
    StringType string = new StringType();
    MandatoryConstraint constraint = new MandatoryConstraint();
    name.setConstraintList( Collections.singletonList( constraint ) );
    name.setDataType( string );

    Column age = new Column();
    IntegerType integerType = new IntegerType();
    age.setDataType( integerType );

    Map<String,Column> column = new HashMap<>();
    column.put( "Name",name );
    column.put( "Age",age );

    table.setColumns( column );
    table.setTableName( "student" );

    Map<String,Object> row1 = new HashMap<>();
    row1.put("Name","shubham");
    row1.put( "Age",23 );
    table.insertRows( table.tableName, row1 );


    Map<String,Object> row2 = new HashMap<>();
    row2.put( "Age",33 );
    row2.put("Name","ballu");
    table.insertRows( table.tableName, row2 );

    Map<String,Object> row3 = new HashMap<>();
    row3.put("Name","kaka");
    table.insertRows( table.tableName, row3 );

    Map<String,Object> row4 = new HashMap<>();
    row4.put("Age",999);
    table.insertRows( table.tableName, row4 );

    Map<String,Object> row5 = new HashMap<>();

    row5.put("Name","Wrong Age");
    row5.put("Age",9999);
    table.insertRows( table.tableName, row5);

    Map<String,Object> row6 = new HashMap<>();
    row6.put("Age",11);
    row6.put("Name","Correct age but the name is very long so it should not take this value at all");
    table.insertRows( table.tableName, row6);

    table.displayAll();
  }
}
