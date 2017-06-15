package mediators;

import java.util.ArrayList;
import java.util.List;

import constants.PirateConstants;
import ships.*;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Optional;
import utils.Position;

import static constants.PirateConstants.terrainType.*;

public class GreatMediator {

   public enum ShipType {
        CORSAIR , MERCHANT , PIRATE
    }

   private int merchantTreasure;
   private int pirateTreasure;
   
   private final List<List<Ship>> ships;

   private AbstractMediator[][] mediatorMatrix;

   public GreatMediator(List<AbstractMediator> mediators, PirateConstants.terrainType[][] terrain) {
      this.pirateTreasure = 0;
      this.merchantTreasure = 0;
       mediatorMatrix = new AbstractMediator[terrain.length][terrain[0].length];
       for( int i = 0; i < terrain.length; i++ ) {
           for (int j = 0; j < terrain[0].length; j++) {
               switch (terrain[i][j]){
                   case FOG :
                       mediatorMatrix[i][j] = mediators.get(0);
                       break;

                   case DEEP_WATER:
                       mediatorMatrix[i][j] = mediators.get(1);
                       break;

                   default:
                       mediatorMatrix[i][j] = mediators.get(2);
               }
           }
       }
      this.ships = new ArrayList<>();
      for (int i = 0; i < ShipType.values().length; i++){
         ships.add(new ArrayList<>());
      }
   }

   public Optional<Ship> getClosest(Ship s, ShipType type) {
      return ships.get(type.ordinal())
              .stream()
              .sorted((a, b) -> (int) (a.distanceTo(s) - b.distanceTo(s)))
              .findFirst();
   }

   public List<List<Ship>> getShips() {
      return ships;
   }

   public void add(Pirate p) {
      ships.get(ShipType.PIRATE.ordinal()).add(p);
   }

   public void add(Merchant m) {
      ships.get(ShipType.MERCHANT.ordinal()).add(m);
   }

   public void add(Corsair c) {
      ships.get(ShipType.CORSAIR.ordinal()).add(c);
   }

   public void wantToDeposit(Corsair ship) {
      deposit(ship);
   }
   
   public void wantToDeposit(Merchant ship) {
      if(deposit(ship)){
         merchantTreasure += ship.getCapacity();
      }
   }
   
   public void wantToDeposit(Pirate ship) {
      if(deposit(ship)){
         pirateTreasure += ship.getTreasure();
         ship.setTreasure(0);
      }
   }

   public void wantToAttack(Pirate p) {
      attack(p, ShipType.MERCHANT);
   }

   public void wantToAttack(Corsair c) {
      attack(c, ShipType.PIRATE);
   }

    public boolean deposit(Ship s) {
        for (int i = 0; i < s.getSpeed(); i++) {
            move(s, s.getBase());
            if(s.getPosition().distanceTo(s.getBase()) < s.getRangeView()){
               s.setPosition(s.getSpawn());
               return true;
            }
        }
        return false;
    }

    //Tell the corresponding mediator to move ship in the direction of point
    private void move(Ship ship, Position point) {
        mediatorMatrix[ship.getPosition().getX()][ship.getPosition().getY()].move(ship, point);
    }

    /**
     * @param s the ship attacking
     * @param shipToAttack the ship to attack
     * @return true if s and shipToAttack are in range
     */
    private boolean isInRange(RobbingShip s, Ship shipToAttack){
        return mediatorMatrix[s.getPosition().getX()][s.getPosition().getY()].isInRange(s,shipToAttack);
    }


    private void    attack(RobbingShip s, ShipType shipTypeToAttack) {
        Optional<Ship> shipToAttackOpt = getClosest(s, shipTypeToAttack);
        for (int i = 0; i < s.getSpeed(); i++) {
            if (shipToAttackOpt.isPresent()) {
                Ship shipToAttack = shipToAttackOpt.get();
                //S'il est a porté, on l'attaque
                if (isInRange(s,shipToAttack)) {
                    //attaque une fois et passe son tour
                    mediatorMatrix[s.getPosition().getX()][s.getPosition().getY()].attack(s,shipToAttack);
                    break;
                } else { //Sinon on se dirige vers lui
                    move(s,shipToAttack.getPosition());
                }
            } else { //no ship to attack
                move(s,s.getBase());
            }
        }
    }
    
    public int getMerchantTreasure()
   {
      return merchantTreasure;
   }

   public int getPirateTreasure()
   {
      return pirateTreasure;
   }
}
