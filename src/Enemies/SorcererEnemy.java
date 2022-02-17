package Enemies;

import city.cs.engine.*;

/**
 * The 'Sorcerer' enemy for my game.
 */
public class SorcererEnemy extends Walker
{
    // Shape for the sorcerer
    private static final Shape sorcererShape = new PolygonShape(-1.86f, -2.28f, 1.08f, -2.24f, 1.1f, 2.24f, -1.54f, 2.24f);

    private boolean alive = true;

    /**
     * Initialize World and Shape for the 'Sorcerer' enemy.
     * @param world the World of the enemy.
     */
    public SorcererEnemy(World world)
    {
        super(world, sorcererShape);
    }

    /**
     * A Getter method that returns the boolean 'alive'.
     * @return the boolean 'alive'
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Set the boolean 'alive'.
     * @param alive a boolean to determine whether the enemy is alive or not.
     */
    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }
}

