package mediators;

import ships.Ship;
import utils.Position;

public class Fog extends AbstractMediator
{

   private final double CHANCE_TO_SUCCEED_MOVE = 30; // 30%

   public Fog(double speedZone, double sightModifier) {
      super(speedZone, sightModifier);

   }


   private Position nextPoint(Position p){

      return new Position(p.getX(),p.getY());
   }

   @Override
   void move(Ship s, Position destinationPosition) {

   }

}
