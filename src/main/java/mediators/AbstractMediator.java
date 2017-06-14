package mediators;

import ships.Ship;
import utils.Point;

public abstract class AbstractMediator {

    protected final double speedModifier;
    protected final double sightModifier;

    public AbstractMediator(double speedModifier, double sightModifier) {
        this.speedModifier = speedModifier;
        this.sightModifier = sightModifier;
    }

    abstract void move(Ship s, Point destinationPosition);
}
