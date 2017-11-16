import java.awt.Rectangle;

public class ProcessRectangle
{

   public static void main(String[] args)
   {
      Rectangle rec;
      
      rec = new Rectangle(100, 200, 80, 50);
      rec.translate(20,  25);
      System.out.println(rec.getX() + ", " + rec.getY() );
      rec.grow(10,0);
      
      System.out.println(rec);
      
   }

}