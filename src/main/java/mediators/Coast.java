package mediators;

import ships.Ship;
import utils.Position;


public class Coast extends AbstractMediator
{

   public Coast(double speedZone,double sightModifier) {
      super( speedZone,sightModifier);
   }

   @Override
   public void move(Ship s, Position destination)
   {
      s.setPosition(s.getSpawn());
   }
   
   
}
