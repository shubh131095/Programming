package test.com.shubham.Piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shubham.Board;
import com.shubham.Box;
import com.shubham.Piece.Piece;

import static org.junit.jupiter.api.Assertions.*;

// in this class i will not test the abstract method can move, as it will be taken care by all implementation of piece
class DummyPieceImpl extends Piece
{

  public DummyPieceImpl( Boolean isWhite )
  {
    super( isWhite );
  }

  @Override
  public boolean canMove( Board board, Box start, Box end )
  {
    return false;
  }
}
@DisplayName( "Testing for Piece" )
class PieceTest
{

  DummyPieceImpl dtWhite;
  DummyPieceImpl dtBlack;

  @BeforeEach
  void init()
  {
    dtWhite = new DummyPieceImpl( true ); // white piece
    dtBlack = new DummyPieceImpl( false ); // black piece
  }

  @Test
  @DisplayName( "Color test" )
  void isWhite()
  {
    assertAll(
      () -> assertEquals(true,dtWhite.isWhite(), "Something wrong with method\""  ),
      () ->assertEquals(false,dtBlack.isWhite(), "Something wrong with method\""  )
    );


  }

  @Test
  void isUnderBoundary()
  {
    Box box1 = new Box( dtWhite,0,0 );
    Box box2 = new Box(dtBlack,3,4);
    Box box3 = new Box(dtWhite,9,8);
    assertAll(
      () -> assertEquals(true,dtWhite.isUnderBoundary(box1,box2), "Something wrong with method"  ),
      () ->assertEquals(false,dtBlack.isUnderBoundary(box2,box3), "Something wrong with method" ),
      () ->assertEquals(false,dtBlack.isUnderBoundary(box3,box1), "Something wrong with method" )
    );

  }

  @Test
  void isSameTeamPiece()
  {
    // implement likewise
  }
}