package BasicImplementation.random;

public class FillColor
{
  // x-new i
  //y- new j
  // newcolor - newcolour

  public static void fillColor(int x,int y,int newColor,int arr[][])
  {
   if(arr.length<1) return;
   if(x>arr.length-1 || y>arr[0].length-1) return;
   updateColor(arr[x][y],newColor,x,y,arr);
  }

  private static void updateColor( int currentColor, int newColor, int x, int y, int[][] arr )
  {
    if(x <0 || y<0 || x>arr.length-1 || y > arr[0].length-1) return;
    if(arr[x][y] != currentColor) return;
    arr[x][y] = newColor;
    updateColor(currentColor,newColor,x-1,y,arr);
    updateColor(currentColor,newColor,x+1,y,arr);
    updateColor(currentColor,newColor,x,y-1,arr);
    updateColor(currentColor,newColor,x,y+1,arr);
  }
}
