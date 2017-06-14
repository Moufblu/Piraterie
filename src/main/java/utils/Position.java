package utils;

import constants.PirateConstants;

/**
 *
 */
public class Position {

   private double x, y;

   public Position(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public int getX()  { return (int) x; }

   public double getXDouble() {
      return x;
   }

   public int getY() {
      return (int) y;
   }

   public double getYDouble() {
      return y;
   }

   public void move(double distX, double distY){
      x += distX;
      y += distY;
      
      if(x < 0){
         x = 0;
      }
      
      if(y < 0){
         y = 0;
      }
      
      if(x >= PirateConstants.MAP_WIDTH){
         x = PirateConstants.MAP_WIDTH - 1;
      }
      
      if(y >= PirateConstants.MAP_HEIGHT){
         y = PirateConstants.MAP_HEIGHT - 1;
      }
      
   }
   
   public double distanceTo(Position s) {
      return Math.abs(x - s.x) + Math.abs(y - s.y);
   }

   @Override
   public boolean equals(Object obj)
   {
      return getX() == ((Position)obj).getX() && getY() == ((Position)obj).getY();
   }
   
   
}
