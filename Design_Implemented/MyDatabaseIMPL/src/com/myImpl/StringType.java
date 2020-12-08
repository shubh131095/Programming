package com.myImpl;

public class StringType implements DataType
{
  public boolean isValid( String type )
  {
    try
    {
      if( type.length() <=20) return true;
      else return false;
    }
    catch( Exception e )
    {
      return false;
    }
  }
}
