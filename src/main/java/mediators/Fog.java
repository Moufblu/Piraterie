package mediators;

import constants.PirateConstants;
import ships.Ship;
import utils.Position;

public class Fog extends AbstractMediator
{

   private final double CHANCE_TO_FAIL_MOVE = 10; // 30%

   public Fog(double speedZone, double sightModifier) {
      super(speedZone, sightModifier);

   }


   private Position nextPoint(Position p){

      return new Position(p.getX(),p.getY());
   }

   @Override
   public void move(Ship s, Position destination) {
      
      int chance = PirateConstants.RANDOM.nextInt(100);
      
      if(chance < CHANCE_TO_FAIL_MOVE){
         destination = new Position(PirateConstants.RANDOM.nextInt(PirateConstants.MAP_WIDTH),
              PirateConstants.RANDOM.nextInt(PirateConstants.MAP_HEIGHT));
      }
      super.move(s, destination);
   }

}
