package com.myImpl;

public class IntegerType implements DataType
{
  @Override
  public boolean isValid( String type )
  {
    try
    {
      Integer number = Integer.valueOf( type );
      if( number < -1024 || number > 1024 )
        return false;
      else
        return true;
    }
    catch( Exception e )
    {
      return false;
    }
  }
}
