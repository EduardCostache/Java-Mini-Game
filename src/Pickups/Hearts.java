package Pickups;

import city.cs.engine.*;

/**
 * The Hearts class for my game.
 */
public class Hearts extends DynamicBody
{
    // shape for the Hearts
    private static final Shape heartShape = new BoxShape(0.8f, 0.8f);

    /**
     * Initialize the Hearts' world and shape.
     * @param world the current world.
     */
    public Hearts(World world)
    {
        super(world, heartShape);
    }
}
