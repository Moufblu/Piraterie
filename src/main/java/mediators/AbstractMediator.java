package mediators;

import ships.RobbingShip;
import ships.Ship;
import utils.Position;

public abstract class AbstractMediator {

   protected final double speedZone;
   protected final double sightModifier;

   public AbstractMediator(double speedZone, double sightModifier) {
      this.speedZone = speedZone;
      this.sightModifier = sightModifier;
   }

   public void move(Ship s, Position destination){
      double signX = Math.signum(destination.getXDouble()- s.getPosition().getXDouble());      
      double signY = Math.signum(destination.getYDouble()- s.getPosition().getYDouble());
      
      s.getPosition().move(signX * speedZone, signY * speedZone);
      
      if(signX * s.getPosition().getXDouble() > signX * destination.getXDouble()
              || signY * s.getPosition().getYDouble() > signY * destination.getYDouble()){
         s.setPosition(destination);
      }
   }

   boolean isInRange(RobbingShip s, Ship shipToAttack) {
      return (s.distanceTo(shipToAttack) * sightModifier < s.getRangeView());
   }

   void attack(RobbingShip s, Ship shipToAttack) {
      shipToAttack.setHp(shipToAttack.getHp() - s.getATTACK());
   }
}
