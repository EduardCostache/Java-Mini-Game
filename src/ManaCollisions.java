import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * The class containing a CollisionListener for the Mana pickup.
 */
public class ManaCollisions implements CollisionListener
{
    private Player player;
    private Game game;

    /**
     * Initializing the Player and the Game for the Mana pickup collision.
     * @param game the Game.
     * @param player the Player.
     */
    public ManaCollisions(Player player, Game game)
    {
        this.player = player;
        this.game = game;
    }

    /**
     * A methjod called when a collision between the mana pickup and another object has been made.
     * @param e description of the ColisionEvent.
     */
    @Override
    public void collide(CollisionEvent e)
    {
        // Collision for the player and the Mana stars
        if (e.getOtherBody() == player)
        {
            e.getReportingBody().destroy();

            game.getPlayer().incrementMana();
        }
    }
}
