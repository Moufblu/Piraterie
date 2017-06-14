package mediators;

import ships.Ship;
import utils.Point;

public class Fog extends AbstractMediator
{

   private final double CHANCE_TO_SUCCEED_MOVE = 30; // 30%

   public Fog(double speedZone, double sightModifier) {
      super(speedZone, sightModifier);

   }


   private Point nextPoint(Point p){

      return new Point(p.getX(),p.getY());
   }

   @Override
   void move(Ship s, Point destinationPosition) {

   }

}
