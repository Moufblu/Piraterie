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
import java.util.Observable;
import java.util.Optional;
import utils.Position;

public class GreatMediator extends Observable {

   public enum ShipType {

        CORSAIR {
            public Position getDepositPosition() {
                return new Position(0, 0);
            }
        }, MERCHANT {
            public Position getDepositPosition() {
                return new Position(0, 0);
            }
        }, PIRATE {
            public Position getDepositPosition() {
                return new Position(0, 0);
            }
        };

        public abstract Position getDepositPosition();
    }

   private List<AbstractMediator> mediators;
   private final List<List<Ship>> ships;

   AbstractMediator[][] mediatorMatrix;

   private BlackBeard blackBeard;
   private King king;

   public GreatMediator(List<AbstractMediator> mediators) {
      this.ships = new ArrayList<>(ShipType.values().length);

      ships.stream().forEach((ship) -> {
         ship = new LinkedList<>();
      });
   }

   public Optional<Ship> getClosest(Ship s, ShipType type) {
      return ships.get(type.ordinal())
              .stream()
              .sorted((a, b) -> a.distanceTo(s) - b.distanceTo(s))
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

   public void wantToDeposit(Merchant m) {
      deposit(m, ShipType.MERCHANT);
   }

   public void wantToDeposit(Corsair c) {
      deposit(c, ShipType.CORSAIR);
   }

   public void wantToDeposit(Pirate p) {
      deposit(p, ShipType.PIRATE);
   }

   public void wantToAttack(Pirate p) {
      attack(p, ShipType.MERCHANT);
   }

   public void wantToAttack(Corsair c) {
      attack(c, ShipType.PIRATE);
   }

    public void deposit(Ship s, ShipType st) {
        for (int i = 0; i < s.getSpeed(); i++) {
            move(s, st.getDepositPosition());
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
            } else {
                System.out.println("No ship to attack !");
                //move to a random position
                move(s,s.getBase());
            }
        }
    }
}
