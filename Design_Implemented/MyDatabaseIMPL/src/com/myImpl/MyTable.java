package com.myImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MyTable
{
  // column name with column
  Map<String,Column> columns;
  String tableName;
  // one  row will contains values for all column, and there can be many rows
  List<List<Object>> rows;

  public Map<String, Column> getColumns()
  {
    return columns;
  }

  public void setColumns( Map<String, Column> columns_ )
  {
    columns = columns_;
  }

  public String getTableName()
  {
    return tableName;
  }

  public void setTableName( String tableName_ )
  {
    tableName = tableName_;
  }

  public List<List<Object>> getRows()
  {
    return rows;
  }

  public void setRows( List<List<Object>> rows_ )
  {
    rows = rows_;
  }

  // rows will be combintaion of columname(string) and its value(Object)
  // check whether all the required columns are present or not in provided values.
  // check whether the value is already present or not.
  public void insertRows(String tableName,Map<String,Object> row)
  {
    // this will contains the verified columns value and in the end will be added to rows.
    List<Object> rowList = new ArrayList<>();
    Boolean isValidEntry = Boolean.TRUE;

    for(Map.Entry<String,Column> columns : columns.entrySet())
    {
      String columnName = columns.getKey();
      Column col =  columns.getValue();
      String keyValue = null;
      if(row.containsKey( columnName ))
      {
       keyValue = String.valueOf( row.get( columnName ));
      }
      // by this we will verify each column is following constraints.
      // if any column is there with mandatory cons and not present in input it wll fail.
        if(col.getConstraintList()!=null)
        {
          for(Contstraint contstraint : col.getConstraintList())
          {
            if(!contstraint.isValidFiled( keyValue))
            {
              isValidEntry=Boolean.FALSE;
              // sout statement
              break;
            }
          }
        }
        // verify that the data is following the constraints or not
        if(isValidEntry)
        {
          DataType dt = col.getDataType();
          if(!dt.isValid( keyValue ))
          {
            isValidEntry = Boolean.FALSE;
            //sout statment
            break;
          }
          else
          {
            rowList.add( keyValue );
          }
        }
      }
    // this check if this is the first row we are entering
    if(isValidEntry)
    {
      if(rows==null)
      {
        rows = new ArrayList<>();
      }
      rows.add( rowList );
    }
  }

  public void displayAll()
  {
    rows.stream().forEach( System.out::println );
  }

  public void findByColumn(String columnName , Object value)
  {
    if(!columns.containsKey( columnName ))
    {
      System.out.println("invalid column name");
      return;
    }
      for(List<Object> listOfValues : rows)
      {

      }
  }
}
