package mediators;

import java.awt.Point;
import mediators.GreatMediator.ShipType;
import ships.Corsair;
import ships.Pirate;

public abstract class AbstractMediator {

   private final GreatMediator greatMediator;

   protected final double speedModifier;

   public AbstractMediator(GreatMediator greatMediator, double speedModifier) {
      this.greatMediator = greatMediator;
      this.speedModifier = speedModifier;
   }
   
   void wantToAttack(Pirate pirate){
      greatMediator.getClosest(pirate, ShipType.MERCHANT);
   }
   
   void wantToAttack(Corsair corsair){
      
   }

   abstract void returnToBase(Point base);
}
