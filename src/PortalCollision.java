import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * The collision for the portal. When conditions are met, colliding with this portal will take the player
 * to the next level.
 */
public class PortalCollision implements CollisionListener
{
    private Game game;

    /**
     * Initializing the Game for the Portal Collsion class.
     * @param game the Game.
     */
    public PortalCollision(Game game)
    {
        this.game = game;
    }

    /**
     * A method called when collsion between the portal and another specific objects has been made.
     * @param event description of the event for CollisionEvent.
     */
    @Override
    public void collide(CollisionEvent event)
    {
        // Collsion for the portal and the player
        Player player = game.getPlayer();
        if (event.getOtherBody() == player && game.levelCompleted())
        {
            System.out.println("Level Loading...");
            game.goNextLevel();
        }


    }
}
