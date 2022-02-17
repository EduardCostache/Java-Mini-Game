import city.cs.engine.*;

/**
 * The collision for the hearts and the player.
 */
public class HeartCollisions implements CollisionListener
{
    private Player player;

    /**
     * Initializing the Player for the Heart collision.
     * @param player the Player.
     */
    public HeartCollisions(Player player)
    {
        this.player = player;
    }

    /**
     * Calls when a collision has been made with the Heart.
     * @param e description of the CollisionEvent.
     */
    @Override
    public void collide(CollisionEvent e)
    {
        // Collision between the player and the hearts
        if (e.getOtherBody() == player)
        {
            player.incrementLife();
            e.getReportingBody().destroy();
        }
    }
}

