import city.cs.engine.*;

/**
 * The portal connecting levels together.
 */
public class Portal extends StaticBody
{
    /**
     * Initializing the World for the Portal.
     * @param world the World.
     */
    public Portal(World world)
    {
        super(world, new BoxShape(2f, 2f));
        addImage(new BodyImage("data/nature.gif", 5));
    }
}
