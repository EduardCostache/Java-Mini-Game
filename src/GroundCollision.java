import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * A class containing collision code for the objects that make up the landscape in the game.
 */
public class GroundCollision implements CollisionListener
{
    /**
     * Called when a collision with the Ground has been made.
     * @param collisionEvent description of the CollisionEvent.
     */
    @Override
    public void collide(CollisionEvent collisionEvent)
    {
        // Collision between landscape and bullet.
        if (collisionEvent.getOtherBody() instanceof MagicBullet)
        {
            collisionEvent.getOtherBody().destroy();
        }
        if (collisionEvent.getOtherBody() instanceof WizardBullet)
        {
            collisionEvent.getOtherBody().destroy();
        }
    }
}
