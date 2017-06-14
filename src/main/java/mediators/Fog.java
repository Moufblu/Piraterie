package mediators;

import constants.PirateConstants;
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
   public void move(Ship s, Position destination) {
      
      destination = new Position(PirateConstants.RANDOM.nextInt(PirateConstants.MAP_WIDTH),
              PirateConstants.RANDOM.nextInt(PirateConstants.MAP_HEIGHT));
      
      super.move(s, destination);
   }

}
