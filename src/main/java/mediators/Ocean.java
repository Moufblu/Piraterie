package mediators;

import ships.Corsair;
import ships.Merchant;
import ships.Pirate;

public class Ocean extends AbstractMediator
{
   public Ocean(GreatMediator mediator)
   {
      super(mediator);
   }

   @Override
   public void wantToMove(Pirate pirate)
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void wantToMove(Corsair corsair)
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void wantToMove(Merchant merchant)
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
}
