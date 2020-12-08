package com.myImpl;

import java.util.List;

public class Column
{
  DataType dataType;
  List<Contstraint> constraintList;

  public void setDataType(DataType d)
  {
    dataType = d;
  }
  public DataType getDataType()
  {
    return dataType;
  }

  public void setConstraintList( List<Contstraint> list)
  {
    constraintList = list;
  }
  public List<Contstraint> getConstraintList()
  {
    return constraintList;
  }
}
