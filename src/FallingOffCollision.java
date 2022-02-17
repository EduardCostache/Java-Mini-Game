import Enemies.SorcererEnemy;
import Enemies.ZombieEnemy;
import city.cs.engine.*;

/**
 * A class used for creating bounds within the map.
 */
public class FallingOffCollision implements CollisionListener
{

    private Player player;
    private Game game;

    /**
     * Initializing the Player and the Game for the class 'FallingOffCollision'.
     * @param player the Player.
     * @param game the Game.
     */
    public FallingOffCollision(Player player, Game game)
    {
        this.player = player;
        this.game = game;
    }

    /**
     * The Collision method.
     * @param e the CollisionEvent.
     */
    @Override
    public void collide(CollisionEvent e)
    {
        if (e.getOtherBody() == player)
        {
            game.getPlayer().setLife(0);
        }

        if (e.getOtherBody() instanceof MagicBullet)
        {
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof ZombieEnemy)
        {
            e.getOtherBody().destroy();
        }
        if (e.getOtherBody() instanceof SorcererEnemy)
        {
            e.getOtherBody().destroy();
        }
    }
}
