
package utils;

import ships.Ship;

/**
 *
 */

public class Point{
   private int x, y;

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

   public void setX(int x) {
      this.x = x;
   }

   public void setY(int y) {
      this.y = y;
   }

   public int distanceTo(Point s){
      return Math.abs(x - s.x) + Math.abs(y - s.y);
   }
   public Point nextPoint(Point destination){
      double newX = Math.min(x, destination.getX());
      return new Point(0,0);
   }
}
