package Enemies;

import city.cs.engine.*;

/**
 * The 'Zombie' enemy for my game.
 */
public class ZombieEnemy extends Walker
{
    // Shape for the zombie
    private static final Shape zombieShape = new BoxShape(1f, 2.1f);

    /**
     * Initialize World and Shape for the 'Zombie' enemy.
     * @param world the World of the enemy.
     */
    public ZombieEnemy(World world)
    {
        super(world, zombieShape);
    }

}
