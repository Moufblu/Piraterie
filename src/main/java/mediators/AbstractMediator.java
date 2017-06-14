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

    void move(Ship s, Position destinationPosition){

    }

    boolean isInRange(RobbingShip s, Ship shipToAttack) {
        return (s.distanceTo(shipToAttack)*sightModifier < s.getRangeView());
    }
    void attack(RobbingShip s, Ship shipToAttack){
        shipToAttack.setHp(shipToAttack.getHp()-s.getAttack());
    }


}
