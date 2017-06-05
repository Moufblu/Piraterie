package mediators;

import ships.Corsair;
import ships.Merchant;
import ships.Pirate;

public abstract class AbstractMediator
{
   protected GreatMediator mediator;
   
   protected AbstractMediator(GreatMediator mediator)
   {
      this.mediator = mediator;
   }
   
   public abstract void wantToMove(Pirate pirate);
   public abstract void wantToMove(Corsair corsair);
   public abstract void wantToMove(Merchant merchant);
}
