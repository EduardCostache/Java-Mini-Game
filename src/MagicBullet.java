import city.cs.engine.*;
import city.cs.engine.Shape;

/**
 * The bullet which the player can shoot.
 */
public class MagicBullet extends DynamicBody
{
    // Bullet Image
    private BodyImage bulletImage = new BodyImage("data/explosion.gif", 4f);
    // Bullet Shape
    private static final Shape bulletShape = new BoxShape(0.5f, 0.5f);

    /**
     * Initializing the World for the MagicBullet.
     * @param world the World.
     */
    public MagicBullet(GameLevel world)
    {
        super(world, bulletShape);

        addImage(bulletImage);
        setGravityScale(0);
    }
}
