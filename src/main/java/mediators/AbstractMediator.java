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

    private Point getNextPointRandom(Ship s) {
        double bool = random.nextInt(1);
        double sign = random.nextInt(1)*-1;
        double newX = s.getPosition().getX() + (bool * sign);
        double newY = s.getPosition().getY() + (1-bool)*sign;
        return new Point(newX, newY);
    }
}
