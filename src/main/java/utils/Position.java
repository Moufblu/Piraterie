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

   public int getX() {
      return (int) x;
   }

   public double getXDouble() {
      return x;
   }

   public int getY() {
      return (int) y;
   }

   public double getYDouble() {
      return y;
   }

   public void goUp(double distance) {
      y -= distance;
   }

   public void goDown(double distance) {
      y += distance;
   }

   public void goLeft(double distance) {
      x -= distance;
   }

   public void goRight(double distance) {
      x += distance;
   }

   public double distanceTo(Position s) {
      return Math.abs(x - s.x) + Math.abs(y - s.y);
   }
}
