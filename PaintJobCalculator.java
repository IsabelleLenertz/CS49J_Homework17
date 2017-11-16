public class PaintJobCalculator
{
   private double radius;
   private double height;

   public static final int SQ_FT_PER_SQ_YARD = 9;
   public static final double COST_PER_GALLON_OF_PAINT = 95.5;
   public static final double SQUARE_FEET_PER_GALLON = 40;
   public static final double LABOR_COST_PER_SQUARE_YARD = 100.0;
   
   public PaintJobCalculator(double theHeight, double theRadius)
   {
       height = theHeight;
       radius = theRadius;
   }

   public double getSurfaceArea()
   {
       double cylinderSurfaceArea = 2 * Math.PI * radius * height;
       double domeSurfaceArea = 2 * Math.PI * radius * radius;
       return cylinderSurfaceArea + domeSurfaceArea;
   }

   public double getPaintCost() 
   {
       double paintCost = getSurfaceArea() 
          / SQUARE_FEET_PER_GALLON * COST_PER_GALLON_OF_PAINT;
       return paintCost;
   }


   public double getLaborCharge()
   {
       double squareYards = getSurfaceArea() / SQ_FT_PER_SQ_YARD;
       return squareYards * LABOR_COST_PER_SQUARE_YARD;
   }

   public double getCustomerPrice()
   {
       return getPaintCost() + getLaborCharge();
   }
   

    public void setHeight(double theHeight)
    {
        height = theHeight;
    }

    public void setRadius(double theRadius)
    {
        radius = theRadius;
    }

}