package mediators;

import ships.Ship;
import utils.Point;

public abstract class AbstractMediator {

   protected final double speedModifier;

   public AbstractMediator(double speedModifier) {
      this.speedModifier = speedModifier;
   }

   abstract void move(Ship s, Point destinationPosition);
}
