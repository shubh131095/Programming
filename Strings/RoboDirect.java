package Strings;
// You have been given a String containing only GLR where G means go L means left and R means right.
// starting from anypoint , after following all instruction return if you're back at starting point.
// intial movement will be given in another char as U or L or R or D.
// you can only move in G instruction.
public class RoboDirect
{
  final static int N =0;
  final static int E =1;
  final static int S =2;
  final static int W =3;
  public static void main( String[] args )
  {
    String instrtuctions = "GRGRGGRGRG";
    int intialDirection = N;
    boolean ans = findDirection(instrtuctions,intialDirection);
    System.out.println(ans);
  }

  private static boolean findDirection( String ins, int initialDir)
  {
    boolean ans = true;
    int x=0;
    int y=0;
    int dir = initialDir;
    for(int i=0;i<ins.length();i++)
    {
      if(ins.charAt( i ) == 'R')
      {
        dir = (dir+1)%4;
      }
      else if(ins.charAt( i ) == 'L')
      {
        dir = (dir+3)%4;
      }
      else
      {
        if(dir==N) y++;
        else if(dir==E)x++;
        else if(dir==W) x--;
        else y--;
      }
    }
    if(x==0 &&y==0) return true;
    else return false;
  }
}
