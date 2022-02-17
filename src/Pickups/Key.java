package Pickups;

import city.cs.engine.*;

/**
 * The Key class for my game.
 */
public class Key extends DynamicBody
{
    // shape for the Key
    private static final Shape keyShape = new BoxShape(1f, 2f);

    /**
     * Initialize the Key's world and shape.
     * @param world the current world.
     */
    public Key(World world)
    {
        super(world, keyShape);
    }
}
