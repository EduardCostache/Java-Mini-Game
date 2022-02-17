package Enemies;

import city.cs.engine.*;

/**
 * The 'Guard' enemy for my game.
 */
public class GuardEnemy extends Walker
{
    // The shape for the 'Guard' enemy
    private static final Shape guardShape = new BoxShape(1.25f, 2.3f);

    /**
     * Initialize World and Shape for the 'Guard' enemy.
     * @param world the World of the enemy.
     */
    public GuardEnemy(World world)
    {
        super(world, guardShape);
    }

}

