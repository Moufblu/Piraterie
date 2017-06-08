package mediators;

import java.util.ArrayList;
import java.util.List;
import ships.BlackBeard;
import ships.Corsair;
import ships.King;
import ships.Merchant;
import ships.Pirate;
import ships.Ship;
import java.util.LinkedList;
import java.util.Optional;

public class GreatMediator {

   public enum ShipType {
      CORSAIR, MERCHANT, PIRATE
   }
   List<List<Ship>> ships;

   private BlackBeard blackBeard;
   private King king;

   public GreatMediator() {
      this.ships = new ArrayList<>(ShipType.values().length);
      
      for (List<Ship> ship : ships) {
         ship = new LinkedList<>();
      }
   }
   
   public Optional<Ship> getClosest(Ship s, ShipType type){
      return ships.get(type.ordinal())
              .stream()
              .sorted((a, b) -> a.distanceTo(s) - b.distanceTo(s))
              .findFirst();
   }
   
   public void add(Pirate p){
      ships.get(ShipType.PIRATE.ordinal()).add(p);
   }
   
   public void add(Merchant m){
      ships.get(ShipType.MERCHANT.ordinal()).add(m);
   }
   
   public void add(Corsair c){
      ships.get(ShipType.CORSAIR.ordinal()).add(c);
   }
}
