package mediators;

import ships.Ship;
import utils.Point;

import java.util.Random;

public abstract class AbstractMediator {

    protected final double speedZone;
    protected final double sightModifier;
    protected final static Random random = new Random();

    public AbstractMediator(double speedZone, double sightModifier) {
        this.speedZone = speedZone;
        this.sightModifier = sightModifier;
    }

    abstract void move(Ship s, Point destinationPosition);
}
