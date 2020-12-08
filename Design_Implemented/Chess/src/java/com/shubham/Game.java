package java.com.shubham;

import java.com.shubham.Piece.CamelPiece;
import java.com.shubham.Piece.ElephantPiece;
import java.com.shubham.Piece.KingPiece;
import java.com.shubham.Piece.KnightPiece;
import java.com.shubham.Piece.PawnPiece;
import java.com.shubham.Piece.Piece;
import java.com.shubham.Piece.QueenPiece;

// this is our main class and from here only the game will be played.
// considering player1 is white and will start the game
// considering white will start from top and black will start from bottom
public class Game
{
  public Boolean gameDone;
  private Board board;
  int playerTurn;
  Player[] player;

  public Game()
  {
    gameDone = Boolean.FALSE;
   initializeBoard();

   player = new Player[]
     {
     new Player(true),
     new Player( false )
     };
   playerTurn=0;
  }
  // if player makes a valid move return 1 else -1;
  public int makeMove( Player player_, Box start, Box end, Piece piece )
  {
    if( player_ != player[playerTurn]) return -1;
    else
    {
      if( !piece.canMove( board,start,end )) return -1;
      else
      {
          start.setPiece( null );
          if(end.getPiece()!=null)
          {
            Integer current_count;
            if(player_.getPlayerName().equalsIgnoreCase( "white" ))
            {
               current_count=player[1].getPieceCount();
              player[1].setPieceCount( current_count-1 );
            }
            else
            {
               current_count=player[0].getPieceCount();
              player[0].setPieceCount( current_count-1 );
            }
            if(current_count-1 ==0)
            {
              System.out.println("Game Finished and won by" + player_.getPlayerName()) ;
              System.exit(1);
            }
          }
          end.setPiece( piece );
        System.out.println("Game not finished please continue");
          nextMove();
          return 1;
        }
      }
    }


  public void nextMove()
  {
    if(playerTurn==0) playerTurn=1;
    else
      playerTurn=0;
  }

  private void initializeBoard()
  {
    // setting white
    Box[][] box = new Box[8][8];
    box[0][0] = new Box( new ElephantPiece( true ),0,0 );
    box[0][7] = new Box( new ElephantPiece( true ),0,7 );
    box[0][1] = new Box( new KnightPiece( true ),0,1 );
    box[0][6] = new Box( new KnightPiece( true ),0,6 );
    box[0][2] = new Box( new CamelPiece( true ),0,2 );
    box[0][5] = new Box( new CamelPiece( true ),0,5 );
    box[0][3] = new Box( new QueenPiece( true ),0,3 );
    box[0][4] = new Box( new KingPiece( true ),0,4 );
    for(int i=0;i<8;i++)
    {
      box[1][i] = new Box( new PawnPiece( true ),1,i );
    }

    //setting black

    box[7][0] = new Box( new ElephantPiece( false ),7,0 );
    box[7][7] = new Box( new ElephantPiece( false ),7,7 );
    box[7][1] = new Box( new KnightPiece( false ),7,1 );
    box[7][6] = new Box( new KnightPiece( false ),7,6 );
    box[7][2] = new Box( new CamelPiece( false ),7,2 );
    box[7][5] = new Box( new CamelPiece( false ),7,5 );
    box[7][3] = new Box( new KingPiece( false ),7,3 );
    box[7][4] = new Box( new QueenPiece( false ),7,4 );
    for(int i=0;i<8;i++)
    {
      box[6][i] = new Box( new PawnPiece( false ),6,i );
    }
  }
}
