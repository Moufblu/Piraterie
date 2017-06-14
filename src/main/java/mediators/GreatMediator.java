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

public class GreatMediator extends Observable {

   public enum ShipType {
        CORSAIR , MERCHANT , PIRATE
    }

   private List<AbstractMediator> mediators;
   private final List<List<Ship>> ships;

   private AbstractMediator[][] mediatorMatrix;

   public GreatMediator(List<AbstractMediator> mediators, PirateConstants.terrainType[][] terrain) {
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
      this.mediators = mediators;
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

   public void wantToDeposit(Ship ship) {
      deposit(ship);
   }

   public void wantToAttack(Pirate p) {
      attack(p, ShipType.MERCHANT);
   }

   public void wantToAttack(Corsair c) {
      attack(c, ShipType.PIRATE);
   }

    public void deposit(Ship s) {
        for (int i = 0; i < s.getSpeed(); i++) {
            move(s, s.getBase());
        }
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


    private void attack(RobbingShip s, ShipType shipTypeToAttack) {
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
}
