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
import utils.Point;

public class GreatMediator {

   public enum ShipType {

      CORSAIR {
         public Point getDepositPosition() {
            return new Point(0, 0);
         }
      }, MERCHANT {
         public Point getDepositPosition() {
            return new Point(0, 0);
         }
      }, PIRATE {
         public Point getDepositPosition() {
            return new Point(0, 0);
         }
      };

      public abstract Point getDepositPosition();
   }

   List<AbstractMediator> mediators;
   List<List<Ship>> ships;

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

   public void deposit(Ship s, ShipType st) {
      Point p = s.getPosition();

      for (int i = 0; i < s.getSpeed(); i++) {
         mediatorMatrix[p.getX()][p.getY()].move(s, st.getDepositPosition());
      }
   }
}
