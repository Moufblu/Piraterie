package utils;

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
   }

   public double distanceTo(Position s) {
      return Math.abs(x - s.x) + Math.abs(y - s.y);
   }
}
