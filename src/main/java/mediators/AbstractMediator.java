package mediators;

import java.awt.Point;
import ships.Attacker;
import ships.Corsair;
import ships.Pirate;
import ships.Ship;

public abstract class AbstractMediator {

   private final GreatMediator greatMediator;

   protected final double speedModifier;

   public AbstractMediator(GreatMediator greatMediator, double speedModifier) {
      this.greatMediator = greatMediator;
      this.speedModifier = speedModifier;
   }
   
   void wantToAttack(Pirate pirate){
      greatMediator.findClosest(ShipType);
   }
   
   void wantToAttack(Corsair corsair){
      
   }

   abstract void returnToBase(Point base);
}
