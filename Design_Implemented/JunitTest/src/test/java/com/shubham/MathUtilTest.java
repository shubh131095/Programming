package com.shubham;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance( TestInstance.Lifecycle.PER_CLASS )
class MathUtilTest
{

    MathUtil mt ;
/*    @BeforeAll
void beforeAll()
{
  System.out.println("here before all");
}*/
/*  @AfterAll
  void afterAll()
  {
    System.out.println("here after all");
  }*/
    @BeforeEach
    void inti()
    {
      mt = new MathUtil( 2,3 );
    }
  @Test
  @Tags( {@Tag( "ballu" ),@Tag( "imp" ) })
  void addNum()
  {
    assertEquals(5,mt.addNum(2,3),"invalid");
   mt.a = 3;
   mt.b=3;
    assertEquals(6,mt.addNum(),"invalid");
  }

  @Test
  void testAddNum()
  {
    assertEquals(5,mt.addNum(),"invalid");

  }
}