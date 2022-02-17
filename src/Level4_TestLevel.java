import Pickups.Coins;
import Pickups.Hearts;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * This is the test level. It is not part of the playable levels and I
 * created this level for testing new game features.
 */
public class Level4_TestLevel extends GameLevel
{
    // Images
    private BodyImage CoingImg = new BodyImage("data/Coin.gif", 1.5f);
    private BodyImage HeartImg = new BodyImage("data/hearts.png", 1.5f);
    private BodyImage Level3_groundImage = new BodyImage("data/Level3_Platform.png", 10f);
    private BodyImage Level3_undergroundImage = new BodyImage("data/NewTexturesUnderground.png", 10f);

    // Shapes
    private Shape Level3_groundShapes1 = new PolygonShape(-2.42f, -0.72f, 2.4f, -0.72f, 2.4f, 0.68f, -2.38f, 0.68f);
    private Shape Level3_undergroundShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);

    private Shape Level3_groundShapes = new BoxShape(2.40f, 0.70f);

    private static final int NUM_COINS = 10;

    @Override
    public void createWorld(Game game)
    {
        super.createWorld(game);
        //====================================== MAKING THE LANDSCAPE ================================================\\
        //---------------------------------------------------------------------------------------- Making the first hill
        for (float i = 0; i < 48; i += 4.8)
        {
            Shape testShape = Level3_groundShapes;
            Body test = new StaticBody(this, testShape);
            test.setPosition(new Vec2(0 + i, -30));
            test.addImage(Level3_groundImage);
        }

        Body test2 = new StaticBody(this, Level3_groundShapes);
        test2.setPosition(new Vec2(0, -30));
        test2.addImage(Level3_groundImage);
    }

    @Override
    public Vec2 startPosition()
    {
        return new Vec2(0, -0);
    }

    @Override
    public Vec2 portalPosition()
    {
        return new Vec2(45, -10.5f);
    }

    @Override
    public boolean levelComplete()
    {
        return getPlayer().getKeycollected();
    }

    @Override
    public Vec2 keyPosition()
    {
        return new Vec2(20, 0);
    }

    @Override
    public Vec2 zombie_1_Position()
    {
        return new Vec2(-40, -16.5f);
    }

    @Override
    public Vec2 zombie_2_Position()
    {
        return new Vec2(-40, -16.5f);
    }

    @Override
    public float zombieSpeed()
    {
        return -1.5f;
    }

    @Override
    public Vec2 sorcererPosition()
    {
        return new Vec2(35, -5f);
    }

    @Override
    public Vec2 guardPosition()
    {
        return new Vec2(17, 0f);
    }

}
