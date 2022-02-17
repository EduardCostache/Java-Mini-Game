import city.cs.engine.*;
import city.cs.engine.Shape;
import city.cs.engine.BodyImage;

/**
 * The bullet which the sorcerer shoots.
 */
public class WizardBullet extends DynamicBody
{
    private static final Shape shape = new BoxShape(0.5f, 0.5f);
    private static final BodyImage image = new BodyImage("data/ice.gif", 5f);

    /**
     * Initializing the World for the bullet that the Sorcerer shoots.
     * @param world the World.
     */
    public WizardBullet(World world)
    {
        super(world, shape);
        setGravityScale(0);
        addImage(image);
    }


}
