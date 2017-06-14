
package utils;

import ships.Ship;

/**
 *
 */

public class Position{
   private int x, y;

   public Position(int x, int y) {
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

   public int distanceTo(Position s){
      return Math.abs(x - s.x) + Math.abs(y - s.y);
   }
   public Position nextPoint(Position destination){
      double newX = Math.min(x, destination.getX());
      return new Position(0,0);
   }
}
