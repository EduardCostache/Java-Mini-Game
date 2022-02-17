import Pickups.Coins;
import Pickups.Hearts;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * The Level 3 for the game
 */
public class Level3 extends GameLevel
{
    // Images
    private BodyImage CoingImg = new BodyImage("data/Coin.gif", 1.5f);
    private BodyImage HeartImg = new BodyImage("data/hearts.png", 1.5f);
    private BodyImage Level3_groundImage = new BodyImage("data/Level3_Platform.png", 10f);
    private BodyImage Level3_undergroundImage = new BodyImage("data/NewTexturesUnderground.png", 10f);

    // Shapes
    private Shape Level3_groundShapes = new PolygonShape(-2.4f, -0.72f, 2.4f, -0.72f, 2.4f, 0.68f, -2.4f, 0.68f);
    private Shape Level3_undergroundShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.3f);

    private static final int NUM_COINS = 10;

    /**
     * A method called for creating the landscape and the objects for Level 3.
     * @param game the game.
     */
    @Override
    public void createWorld(Game game)
    {
        super.createWorld(game);
        //====================================== MAKING THE LANDSCAPE ================================================\\
        //---------------------------------------------------------------------------------------- Making the first hill
        for (float i = 0; i < 21.6; i += 4.3)
        {
            Body Level3_ground = new StaticBody(this, Level3_groundShapes);
            Level3_ground.addImage(Level3_groundImage);
            Level3_ground.setPosition(new Vec2(-49.8f + i, -16.5f));
        }
        // Smoothness for walking
        Shape Level3_ground_walkingPlatShape = new BoxShape(13f, 0.05f);
        Body Level3_ground_walkingPlat = new StaticBody(this, Level3_ground_walkingPlatShape);
        Level3_ground_walkingPlat.setPosition(new Vec2(-39f, -15.8f));
        Level3_ground_walkingPlat.setFillColor(color);
        Level3_ground_walkingPlat.setLineColor(color);
        Level3_ground_walkingPlat.addCollisionListener(new GroundCollision());

        // Making the underground for the first hill
        for (float i = 0; i < 20; i++)
        {
            for (float j = 0; j < 21.8; j += 4.3)
            {
                Body Level3_underground = new StaticBody(this, Level3_undergroundShapes);
                Level3_underground.addImage(Level3_undergroundImage);
                Level3_underground.setPosition(new Vec2(-50 + j, -17.5f + -i));
                Level3_underground.addCollisionListener(new GroundCollision());
            }
        }

        for (int i = 0; i < 20; i++)
        {
            Body Level3_underground = new StaticBody(this, Level3_undergroundShapes);
            Level3_underground.addImage(Level3_undergroundImage);
            Level3_underground.setPosition(new Vec2(-28.1f, -17.5f + -i));
            Level3_underground.addCollisionListener(new GroundCollision());
        }

        //--------------------------------------------------------------------------------------- Making the second hill
        for (float i = 0; i < 21.6; i += 4.3)
        {
            Body Level3_ground = new StaticBody(this, Level3_groundShapes);
            Level3_ground.addImage(Level3_groundImage);
            Level3_ground.setPosition(new Vec2(5 + i, -16.5f));
        }
        // Smoothness for walking
        Shape Level3_ground1_walkingPlatShape = new BoxShape(13f, 0.05f);
        Body Level3_ground1_walkingPlat = new StaticBody(this, Level3_ground1_walkingPlatShape);
        Level3_ground1_walkingPlat.setPosition(new Vec2(15.6f, -15.8f));
        Level3_ground1_walkingPlat.setFillColor(color);
        Level3_ground1_walkingPlat.setLineColor(color);
        Level3_ground1_walkingPlat.addCollisionListener(new GroundCollision());

        // Making the underground for the second hill
        for (float i = 0; i < 20; i++)
        {
            for (float j = 0; j < 21.8; j += 4.3)
            {
                Body Level3_underground = new StaticBody(this, Level3_undergroundShapes);
                Level3_underground.addImage(Level3_undergroundImage);
                Level3_underground.setPosition(new Vec2(4.8f + j, -17.5f + -i));
                Level3_underground.addCollisionListener(new GroundCollision());
            }
        }

        for (int i = 0; i < 20; i++)
        {
            Body Level3_underground = new StaticBody(this, Level3_undergroundShapes);
            Level3_underground.addImage(Level3_undergroundImage);
            Level3_underground.setPosition(new Vec2(26.7f, -17.5f + -i));
            Level3_underground.addCollisionListener(new GroundCollision());
        }

        //----------------------------------------------------------------------------------- Making objects in the game


        // Making the hearts
        Body Level3_heart = new Hearts(this);
        Level3_heart.setPosition(new Vec2(5, 5));
        Level3_heart.addCollisionListener(new HeartCollisions(getPlayer()));
        Level3_heart.addImage(HeartImg);

        // Platforms
        {
            // Platform 1
            Body Level3_platform1 = new StaticBody(this, Level3_groundShapes);
            Level3_platform1.addImage(Level3_groundImage);
            Level3_platform1.setPosition(new Vec2(-15f, -16.5f));
            Body Level3_platform2 = new StaticBody(this, Level3_groundShapes);
            Level3_platform2.addImage(Level3_groundImage);
            Level3_platform2.setPosition(new Vec2(-10.7f, -16.5f));
            Level3_platform2.addCollisionListener(new GroundCollision());

            // Coins
            for (int i = 0; i < 6; i += 2)
            {
                Body Level1_coin1 = new Coins(this);
                Level1_coin1.setPosition(new Vec2(-12 + -i, -15.5f));
                Level1_coin1.addCollisionListener(new CoinCollisions(getPlayer()));
                Level1_coin1.addImage(CoingImg);
            }
        }

        {
            // Platform 2
            Body Level3_platform3 = new StaticBody(this, Level3_groundShapes);
            Level3_platform3.addImage(Level3_groundImage);
            Level3_platform3.setPosition(new Vec2(35, -16.5f));
            Body Level3_platform4 = new StaticBody(this, Level3_groundShapes);
            Level3_platform4.addImage(Level3_groundImage);
            Level3_platform4.setPosition(new Vec2(39.3f, -16.5f));
            Level3_platform4.addCollisionListener(new GroundCollision());

            // Coins
            for (int i = 0; i < 6; i += 2)
            {
                Body Level1_coin2 = new Coins(this);
                Level1_coin2.setPosition(new Vec2(37 + i, -15.5f));
                Level1_coin2.addCollisionListener(new CoinCollisions(getPlayer()));
                Level1_coin2.addImage(CoingImg);
            }
        }

        Body Level3_platform5 = new StaticBody(this, Level3_groundShapes);
        Level3_platform5.addImage(Level3_groundImage);
        Level3_platform5.setPosition(new Vec2(45, -13.5f));
    }

    @Override
    public Vec2 startPosition()
    {
        return new Vec2(-50, -0);
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
        return new Vec2(-40, -15.5f);
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
