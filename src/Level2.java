import Pickups.Coins;
import Pickups.Hearts;
import Pickups.Jump_PowerUP;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * The Level 2 for the game
 */
public class Level2 extends GameLevel
{
    // Images
    private BodyImage CoingImg = new BodyImage("data/Coin.gif", 1.5f);
    private BodyImage HeartImg = new BodyImage("data/hearts.png", 1.5f);
    private BodyImage PowerUP = new BodyImage("data/PowerUP_Jump.png", 2);
    private BodyImage Level2_platformImage = new BodyImage("data/Level2_Platform.png", 10f);
    private BodyImage Level2_groundImage = new BodyImage("data/Level2_Ground.png", 10f);
    private BodyImage Level2_undergroundImage = new BodyImage("data/NewTexturesUnderground.png", 10f);
    private BodyImage Level2_LeftEdgeImage = new BodyImage("data/Level2_LeftEdge.png", 10f);
    private BodyImage Level2_RightEdgeImage = new BodyImage("data/Level2_RightEdge.png", 10f);

    // Shapes
    private Shape Level2_platformShapes = new PolygonShape(-2.8f, -0.28f, 2.78f, -0.3f, 2.78f, 1.02f, -2.78f, 1.02f);
    private Shape Level2_groundShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);
    private Shape Level2_undergroundShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);
    private Shape Level2_leftEdgeShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);
    private Shape Level2_rightEdgeShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);

    private static final int NUM_COINS = 10;

    /**
     * A method called for making the landscape and objects for Level 2.
     * @param game the game.
     */
    @Override
    public void createWorld(Game game)
    {
        super.createWorld(game);

        //====================================== MAKING THE LANDSCAPE ================================================\\
        //---------------------------------------------------------------------------------------- Making the first hill

        //Making the Left Edge
        Body Level2_edge1 = new StaticBody(this, Level2_leftEdgeShapes);
        Level2_edge1.addImage(Level2_LeftEdgeImage);
        Level2_edge1.setPosition(new Vec2(-50, 0f));

        // Making the Right edge
        Body Level2_edge1Hill1 = new StaticBody(this, Level2_rightEdgeShapes);
        Level2_edge1Hill1.addImage(Level2_RightEdgeImage);
        Level2_edge1Hill1.setPosition(new Vec2(-45.7f, 0f));

        // Making the underground for the first hill
        for (float i = 0; i < 18; i++)
        {
            for (float j = 0; j < 5; j += 4.3)
            {
                Body Level2_hill1Under = new StaticBody(this, Level2_undergroundShapes);
                Level2_hill1Under.setPosition(new Vec2(-50f + j, 0f + -i));
                Level2_hill1Under.addImage(Level2_undergroundImage);
                Level2_hill1Under.addCollisionListener(new GroundCollision());
            }
        }

        //--------------------------------------------------------------------------------------- Making the second hill
        for (float i = 0; i < 8.6; i += 4.3)
        {
            Body Level2_hill2 = new StaticBody(this, Level2_groundShapes);
            Level2_hill2.addImage(Level2_groundImage);
            Level2_hill2.setPosition(new Vec2(7.95f + i, 6f));
        }
        // Smoothness for walking
        Shape Level2_hill2_walkingPlatShape = new BoxShape(8.5f, 0.05f);
        Body Level2_hill2_walkingPlat = new StaticBody(this, Level2_hill2_walkingPlatShape);
        Level2_hill2_walkingPlat.setPosition(new Vec2(10f, 6.9f));
        Level2_hill2_walkingPlat.setFillColor(color);
        Level2_hill2_walkingPlat.setLineColor(color);
        Level2_hill2_walkingPlat.addCollisionListener(new GroundCollision());

        // Making the Left edge
        Body Level2_edge1Hill2 = new StaticBody(this, Level2_leftEdgeShapes);
        Level2_edge1Hill2.addImage(Level2_LeftEdgeImage);
        Level2_edge1Hill2.setPosition(new Vec2(3.65f, 6f));
        Level2_edge1Hill2.addCollisionListener(new GroundCollision());

        // Making the Right edge
        Body Level2_edge2Hill2 = new StaticBody(this, Level2_rightEdgeShapes);
        Level2_edge2Hill2.addImage(Level2_RightEdgeImage);
        Level2_edge2Hill2.setPosition(new Vec2(16.5f, 6f));
        Level2_edge2Hill2.addCollisionListener(new GroundCollision());

        // Coins
        for (float i = 0; i < 17.5; i += 2.5)
        {
            Body Level2_coin3 = new Coins(this);
            Level2_coin3.setPosition(new Vec2(18f + -i, 7.5f));
            Level2_coin3.addCollisionListener(new CoinCollisions(getPlayer()));
            Level2_coin3.addImage(CoingImg);
        }

        // Making the underground for the second hill
        for (float i = 0; i < 17; i++)
        {
            for (float j = 0; j < 15; j += 4.3)
            {
                Body Level2_hill2Under = new StaticBody(this, Level2_undergroundShapes);
                Level2_hill2Under.setPosition(new Vec2(3.65f + j, 6f + -i));
                Level2_hill2Under.addImage(Level2_undergroundImage);
                Level2_hill2Under.addCollisionListener(new GroundCollision());
            }
        }

        //-------------------------------------------------------------------------------------------- Making the ground
        for (float i = 0; i < 81.7; i += 4.3)
        {
            Body Level2_ground = new StaticBody(this, Level2_groundShapes);
            Level2_ground.addImage(Level2_groundImage);
            Level2_ground.setPosition(new Vec2(-45.7f + i, -16.5f));
        }
        // Smoothness for walking
        Shape Level2_Ground_walkingPlatShape = new BoxShape(43, 0.05f);
        Body Level2_Ground_walkingPlat = new StaticBody(this, Level2_Ground_walkingPlatShape);
        Level2_Ground_walkingPlat.setPosition(new Vec2(-5, -15.6f));
        Level2_Ground_walkingPlat.setFillColor(color);
        Level2_Ground_walkingPlat.setLineColor(color);
        Level2_Ground_walkingPlat.addCollisionListener(new GroundCollision());

        // Making the Right edge
        Body Level2_edge1Ground = new StaticBody(this, Level2_rightEdgeShapes);
        Level2_edge1Ground.addImage(Level2_RightEdgeImage);
        Level2_edge1Ground.setPosition(new Vec2(36f, -16.5f));

        //--------------------------------------------------------------------------------------- Making the underground
        for (float i = 0; i < 20; i++)
        {
            for (float j = 0; j < 90; j += 4.3)
            {
                Body Level2_underground = new StaticBody(this, Level2_undergroundShapes);
                Level2_underground.addImage(Level2_undergroundImage);
                Level2_underground.setPosition(new Vec2(-50 + j, -17.5f + -i));
                Level2_underground.addCollisionListener(new GroundCollision());
            }
        }

        //--------------------------------------------------------------------------------- Making the Jumping platforms
        //----------------------------------------------------------------1 size Platforms
        // Platform 0
        Body Level2_platform0 = new StaticBody(this, Level2_platformShapes);
        Level2_platform0.addImage(Level2_platformImage);
        Level2_platform0.setPosition(new Vec2(52, -16.5f));
        Level2_platform0.addCollisionListener(new GroundCollision());

        //----------------------------------------------------------------2 Size Platforms
        {
            // Platform 1
            Body Level2_platform1_1 = new StaticBody(this, Level2_rightEdgeShapes);
            Level2_platform1_1.addImage(Level2_RightEdgeImage);
            Level2_platform1_1.setPosition(new Vec2(-20, -9f));
            Body Level2_platform1_2 = new StaticBody(this, Level2_leftEdgeShapes);
            Level2_platform1_2.addImage(Level2_LeftEdgeImage);
            Level2_platform1_2.setPosition(new Vec2(-24.3f, -9f));
            Level2_platform1_2.addCollisionListener(new GroundCollision());

            // Coins
            for (int i = 0; i < 6; i += 2)
            {
                Body Level2_coin2 = new Coins(this);
                Level2_coin2.setPosition(new Vec2(-20f + -i, 1));
                Level2_coin2.addCollisionListener(new CoinCollisions(getPlayer()));
                Level2_coin2.addImage(CoingImg);
            }
        }

        {
            // Platform 2
            Body Level2_platform2_1 = new StaticBody(this, Level2_rightEdgeShapes);
            Level2_platform2_1.addImage(Level2_RightEdgeImage);
            Level2_platform2_1.setPosition(new Vec2(-7f, 0));
            Body Level2_platform2_2 = new StaticBody(this, Level2_leftEdgeShapes);
            Level2_platform2_2.addImage(Level2_LeftEdgeImage);
            Level2_platform2_2.setPosition(new Vec2(-11.3f, 0));

            // Coins
            for (int i = 0; i < 6; i += 2)
            {
                Body Level2_coin1 = new Coins(this);
                Level2_coin1.setPosition(new Vec2(-7f + -i, 1));
                Level2_coin1.addCollisionListener(new CoinCollisions(getPlayer()));
                Level2_coin1.addImage(CoingImg);
            }
        }

        // Making the hearts
        Body Level2_heart = new Hearts(this);
        Level2_heart.setPosition(new Vec2(25, 20));
        Level2_heart.addCollisionListener(new HeartCollisions(getPlayer()));
        Level2_heart.addImage(HeartImg);

        // Making Power Ups
        Body Level1_JumpPowerUP = new Jump_PowerUP(this);
        Level1_JumpPowerUP.setPosition(new Vec2(-40, -15f));
        Level1_JumpPowerUP.addCollisionListener(new Jump_PowerUPCollision(getPlayer()));
        Level1_JumpPowerUP.addImage(PowerUP);
    }

    @Override
    public Vec2 startPosition()
    {
        return new Vec2(-48, 0);
    }

    @Override
    public Vec2 portalPosition()
    {
        return new Vec2(52, -13.5f);
    }

    @Override
    public boolean levelComplete()
    {
        return getPlayer().getKeycollected();
    }

    @Override
    public Vec2 keyPosition()
    {
        return new Vec2(15, -15.5f);
    }

    @Override
    public Vec2 zombie_1_Position()
    {
        return new Vec2(-15, -15.5f);
    }

    @Override
    public Vec2 zombie_2_Position()
    {
        return new Vec2(0, -40);
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
        return new Vec2(12, -15.5f);
    }
}
