package mediators;

import java.awt.Point;
import java.util.List;
import ships.Attacker;
import ships.BlackBeard;
import ships.Corsair;
import ships.King;
import ships.Merchant;
import ships.Pirate;
import ships.Ship;

public abstract class AbstractMediator {

   protected List<Corsair> corsairs;
   protected List<Merchant> merchants;
   protected List<Pirate> pirates;
   protected BlackBeard blackBeard;
   protected King king;

   static GreatMediator greatMediator;

   static {
      greatMediator = new GreatMediator();
   }

   public AbstractMediator(List<Corsair> corsairs, List<Merchant> merchants, List<Pirate> pirates) {
      this.corsairs = corsairs;
      this.merchants = merchants;
      this.pirates = pirates;
      
   }
   
   
   
   double getSpeedModifier() {
      return 1.0;
   }

   abstract void move(Ship ship);

   abstract void wantToAttack(Attacker attacker);

   abstract void returnToBase(Point base);

}
