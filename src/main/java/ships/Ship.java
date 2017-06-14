package ships;

import java.util.Calendar;
import java.util.Random;
import mediators.GreatMediator;
import utils.Point;

public abstract class Ship
{
   protected final int MAX_HP;
   protected int hp;
   private Point position;
   private final GreatMediator mediator;

   protected final int CAPACITY;
   
   protected int speed;
   protected int rangeView;
   protected Point position;
   
   protected AbstractMediator mediator;
   
   private static final Random rand = new Random();
   
   protected Ship(GreatMediator mediator, Point position)
   {
      MAX_HP = randomBetween(1, getMaxHP());
      hp = MAX_HP;
      CAPACITY = randomBetween(1, getMaxCapacity());
      this.speed = randomBetween(1, getMaxSpeed());
      this.rangeView = randomBetween(1, getMaxRangeView());
      this.mediator = mediator;
      this.position = position;
   }
   
   public int distanceTo(Ship s){
      return position.distanceTo(s.position);
   }

   protected static int randomBetween(int min, int max)
   {
      return rand.nextInt(max - min) + min;
   }
   
   abstract void move();
   public abstract void run();
   public abstract int getMaxHP();
   public abstract int getMaxCapacity();
   public abstract int getMaxSpeed();
   public abstract int getMaxRangeView();

   public int getHp()
   {
      return hp;
   }

   public int getSpeed()
   {
      return speed;
   }

   public int getRangeView()
   {
      return rangeView;
   }

   public int getCAPACITY()
   {
      return CAPACITY;
   }
   
   public Point getPosition()
   {
      return position;
   }
   
   
}
