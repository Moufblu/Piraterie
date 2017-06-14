package constants;

import java.awt.*;

public final class PirateConstants {
    public static int MAP_WIDTH = 800;
    public static int MAP_HEIGHT = 600;
    public static enum terrainType { DEEP_WATER, SHALLOW_WATER, START_COAST, END_COAST, PIRATE_BAY, FOG};
    public static final int DEEP_WATER_COLOUR = new Color(0,148,255).getRGB();
    public static final int SHALLOW_WATER_COLOUR = new Color(73,255,255).getRGB();
    public static final int START_COAST_COLOUR = new Color(0,255,33).getRGB();
    public static final int END_COAST_COLOUR = new Color(255,106,0).getRGB();
    public static final int PIRATE_BAY_COLOUR = new Color(0,0,0).getRGB();
    public static final int FOG_COLOUR = new Color(255,255,255).getRGB();


}
