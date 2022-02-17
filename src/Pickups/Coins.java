package Pickups;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * The Coin class for my game.
 */
public class Coins extends DynamicBody
{
    // Shape for the Coins
    private static final Shape coinShape = new BoxShape(0.8f, 0.8f);

    /**
     * Initialize the Coins' world and shape.
     * @param world the current world.
     */
    public Coins(World world)
    {
        super(world, coinShape);
    }

}
