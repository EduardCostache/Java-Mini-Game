package Pickups;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 * A jump-powerUP pickup.
 */
public class Jump_PowerUP extends DynamicBody
{
    // The shape for the jump powerup
    private static final Shape powerUPShape = new BoxShape(1, 1);

    /**
     * Initialize the Power_UP's world and shape.
     * @param world the current world.
     */
    public Jump_PowerUP(World world)
    {
        super(world, powerUPShape);
    }

}
