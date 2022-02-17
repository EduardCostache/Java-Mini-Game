package Pickups;

import city.cs.engine.*;

/**
 * The Mana class for my game.
 */
public class Mana extends StaticBody
{
    // shape for Mana Stars
    private static final Shape manaShape = new BoxShape(1f, 1f);

    /**
     * Initialize the Mana's world and shape.
     * @param world the current world.
     */
    public Mana(World world)
    {
        super(world, manaShape);
    }
}
