package com.myImpl;

public class MandatoryConstraint implements Contstraint
{
  @Override
  public boolean isValidFiled( String s )
  {
   if(s==null|| s.isBlank() || s.isEmpty()  ) return false;
   else return true;
  }
}
