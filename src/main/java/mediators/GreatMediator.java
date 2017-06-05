package mediators;

import java.util.List;
import ships.BlackBeard;
import ships.Corsair;
import ships.King;
import ships.Merchant;
import ships.Pirate;

public class GreatMediator {

   public enum ShipType{
      Pirate
   }
   
   // trouver moyen de récupérer la bonne liste à partir du type de bateau
   
   private List<Corsair> corsairs;
   private List<Merchant> merchants;
   private List<Pirate> pirates;
   private BlackBeard blackBeard;
   private King king;

   public GreatMediator(List<Corsair> corsairs, List<Merchant> merchants, List<Pirate> pirates) {
      this.corsairs = corsairs;
      this.merchants = merchants;
      this.pirates = pirates;

   }
}
