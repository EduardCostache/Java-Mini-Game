import Pickups.Coins;
import Pickups.Hearts;
import Pickups.Jump_PowerUP;
import Pickups.Mana;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * The Level 1 for the game
 */
public class Level1 extends GameLevel
{
    // Images
    private BodyImage CoingImg = new BodyImage("data/Coin.gif", 1.5f);
    private BodyImage HeartImg = new BodyImage("data/hearts.png", 1.5f);
    private BodyImage PowerUP = new BodyImage("data/PowerUP_Jump.png", 2);
    private BodyImage Mana = new BodyImage("data/manaStars.png", 2f);
    private BodyImage Level1_platformImage = new BodyImage("data/Level1_Platform.png", 10f);
    private BodyImage Level1_groundImage = new BodyImage("data/Level1_Ground.png", 10f);
    private BodyImage Level1_undergroundImage = new BodyImage("data/NewTexturesUnderground.png", 10f);
    private BodyImage Level1_LeftEdgeImage = new BodyImage("data/Level1_LeftEdge.png", 10f);
    private BodyImage Level1_RightEdgeImage = new BodyImage("data/Level1_RightEdge.png", 10f);

    // Shapes
    private Shape Level1_platformShapes = new PolygonShape(-2.8f, -0.28f, 2.78f, -0.3f, 2.78f, 1.02f, -2.78f, 1.02f);
    private Shape Level1_groundShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);
    private Shape Level1_undergroundShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);
    private Shape Level1_leftEdgeShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);
    private Shape Level1_rightEdgeShapes = new PolygonShape(-2.18f, 0.88f, 2.18f, 0.88f, 2.18f, -0.3f, -2.18f, -0.32f);

    Color color = new Color(0, 0, 0, 0);

    /**
     * A Method that creates the landscape and objects for Level 1.
     * @param game the game.
     */
    @Override
    public void createWorld(Game game)
    {
        super.createWorld(game);

        //====================================== MAKING THE LANDSCAPE ================================================\\
        //---------------------------------------------------------------------------------------- Making the first hill
        for (float i = 0; i < 4.3; i += 4.3)
        {
            Body Level1_hill1 = new StaticBody(this, Level1_groundShapes);
            Level1_hill1.addImage(Level1_groundImage);
            Level1_hill1.setPosition(new Vec2(-0.7f + i, -9f));
            Level1_hill1.addCollisionListener(new GroundCollision());
        }
        // Smoothness for walking
        Shape Level1_hill1_walkingPlatShape = new BoxShape(5, 0.05f);
        Body Level1_hill1_walkingPlat = new StaticBody(this, Level1_hill1_walkingPlatShape);
        Level1_hill1_walkingPlat.setPosition(new Vec2(-2.15f, -8.1f));
        Level1_hill1_walkingPlat.setFillColor(color);
        Level1_hill1_walkingPlat.setLineColor(color);
        Level1_hill1_walkingPlat.addCollisionListener(new GroundCollision());

        //Making the Left Edge
        Body Level1_edge1Hill1 = new StaticBody(this, Level1_leftEdgeShapes);
        Level1_edge1Hill1.addImage(Level1_LeftEdgeImage);
        Level1_edge1Hill1.setPosition(new Vec2(-5, -9f));
        Level1_edge1Hill1.addCollisionListener(new GroundCollision());

        // Making the underground for the first hill
        for (float i = 0; i < 8; i++)
        {
            for (float j = 0; j < 5; j += 4.3)
            {
                Body Level1_hill1Under = new StaticBody(this, Level1_undergroundShapes);
                Level1_hill1Under.setPosition(new Vec2(-5 + j, -10f + -i));
                Level1_hill1Under.addImage(Level1_undergroundImage);
                Level1_hill1Under.addCollisionListener(new GroundCollision());
            }
        }

        //--------------------------------------------------------------------------------------- Making the second hill
        for (float i = 0; i < 8.6; i += 4.3)
        {
            Body Level1_hill2 = new StaticBody(this, Level1_groundShapes);
            Level1_hill2.addImage(Level1_groundImage);
            Level1_hill2.setPosition(new Vec2(7.95f + i, -3f));
        }
        // Smoothness for walking
        Shape Level1_hill2_walkingPlatShape = new BoxShape(8.6f, 0.05f);
        Body Level1_hill2_walkingPlat = new StaticBody(this, Level1_hill2_walkingPlatShape);
        Level1_hill2_walkingPlat.setPosition(new Vec2(10.15f, -2.1f));
        Level1_hill2_walkingPlat.setFillColor(color);
        Level1_hill2_walkingPlat.setLineColor(color);
        Level1_hill2_walkingPlat.addCollisionListener(new GroundCollision());

        // Making the Left edge
        Body Level1_edge1Hill2 = new StaticBody(this, Level1_leftEdgeShapes);
        Level1_edge1Hill2.addImage(Level1_LeftEdgeImage);
        Level1_edge1Hill2.setPosition(new Vec2(3.65f, -3f));
        Level1_edge1Hill2.addCollisionListener(new GroundCollision());

        // Making the Right edge
        Body Level1_edge2Hill2 = new StaticBody(this, Level1_rightEdgeShapes);
        Level1_edge2Hill2.addImage(Level1_RightEdgeImage);
        Level1_edge2Hill2.setPosition(new Vec2(16.55f, -3f));
        Level1_edge2Hill2.addCollisionListener(new GroundCollision());


        // Making the underground for the second hill
        for (float i = 0; i < 14; i++)
        {
            for (float j = 0; j < 15; j += 4.3)
            {
                Body Level1_hill2Under = new StaticBody(this, Level1_undergroundShapes);
                Level1_hill2Under.setPosition(new Vec2(3.65f + j, -4f + -i));
                Level1_hill2Under.addImage(Level1_undergroundImage);
                Level1_hill2Under.addCollisionListener(new GroundCollision());
            }
        }

        //---------------------------------------------------------------------------------------- Making the third hill
        for (float i = 0; i < 8.6; i += 4.3)
        {
            Body Level1_hill3 = new StaticBody(this, Level1_groundShapes);
            Level1_hill3.addImage(Level1_groundImage);
            Level1_hill3.setPosition(new Vec2(53.6f + i, -16.5f));
            Level1_hill3.addCollisionListener(new GroundCollision());
        }

        // Making the Left edge
        Body Level1_edge1Hill3 = new StaticBody(this, Level1_leftEdgeShapes);
        Level1_edge1Hill3.addImage(Level1_LeftEdgeImage);
        Level1_edge1Hill3.setPosition(new Vec2(49.3f, -16.5f));
        Level1_edge1Hill3.addCollisionListener(new GroundCollision());

        // Making the Right edge
        Body Level1_edge2Hill3 = new StaticBody(this, Level1_rightEdgeShapes);
        Level1_edge2Hill3.addImage(Level1_RightEdgeImage);
        Level1_edge2Hill3.setPosition(new Vec2(62.2f, -16.5f));
        Level1_edge1Hill3.addCollisionListener(new GroundCollision());


        // Making the underground for the second hill
        for (float i = 0; i < 14; i++)
        {
            for (float j = 0; j < 15; j += 4.3)
            {
                Body Level1_hill3Under = new StaticBody(this, Level1_undergroundShapes);
                Level1_hill3Under.setPosition(new Vec2(49.3f + j, -17.5f + -i));
                Level1_hill3Under.addImage(Level1_undergroundImage);
                Level1_hill3Under.addCollisionListener(new GroundCollision());
            }
        }

        //-------------------------------------------------------------------------------------------- Making the ground
        for (float i = 0; i < 81.7; i += 4.3)
        {
            Body Level1_ground = new StaticBody(this, Level1_groundShapes);
            Level1_ground.addImage(Level1_groundImage);
            Level1_ground.setPosition(new Vec2(-45.7f + i, -16.5f));
        }
        // Smoothness for walking
        Shape Level1_Ground_walkingPlatShape = new BoxShape(45, 0.05f);
        Body Level1_Ground_walkingPlat = new StaticBody(this, Level1_Ground_walkingPlatShape);
        Level1_Ground_walkingPlat.setPosition(new Vec2(-7, -15.6f));
        Level1_Ground_walkingPlat.setFillColor(color);
        Level1_Ground_walkingPlat.setLineColor(color);
        Level1_Ground_walkingPlat.addCollisionListener(new GroundCollision());

        // Making the Left edge
        Body Level1_edge4 = new StaticBody(this, Level1_leftEdgeShapes);
        Level1_edge4.addImage(Level1_LeftEdgeImage);
        Level1_edge4.setPosition(new Vec2(-50, -16.5f));

        // Making the Right edge
        Body Level1_edge5 = new StaticBody(this, Level1_rightEdgeShapes);
        Level1_edge5.addImage(Level1_RightEdgeImage);
        Level1_edge5.setPosition(new Vec2(36f, -16.5f));

        //--------------------------------------------------------------------------------------- Making the underground
        for (float i = 0; i < 20; i++)
        {
            for (float j = 0; j < 90; j += 4.3)
            {
                Body Level1_underground = new StaticBody(this, Level1_undergroundShapes);
                Level1_underground.addImage(Level1_undergroundImage);
                Level1_underground.setPosition(new Vec2(-50 + j, -17.5f + -i));
                Level1_underground.addCollisionListener(new GroundCollision());
            }
        }

        //--------------------------------------------------------------------------------- Making the Jumping platforms
        // Platform 1
        Body Level1_platform1 = new StaticBody(this, Level1_platformShapes);
        Level1_platform1.addImage(Level1_platformImage);
        Level1_platform1.setPosition(new Vec2(-8, 0));
        Level1_platform1.addCollisionListener(new GroundCollision());

        // Platform 2
        Body Level1_platform2 = new StaticBody(this, Level1_platformShapes);
        Level1_platform2.addImage(Level1_platformImage);
        Level1_platform2.setPosition(new Vec2(-15, 8));
        Level1_platform2.addCollisionListener(new GroundCollision());

        {
            // Platform 3
            Body Level1_platform3 = new StaticBody(this, Level1_platformShapes);
            Level1_platform3.addImage(Level1_platformImage);
            Level1_platform3.setPosition(new Vec2(-25, 14));
            Level1_platform3.addCollisionListener(new GroundCollision());

            // Coins for Platform 3
            Body Level1_coin2 = new Coins(this);
            Level1_coin2.setPosition(new Vec2(-26, 15));
            Level1_coin2.addCollisionListener(new CoinCollisions(getPlayer()));
            Level1_coin2.addImage(CoingImg);

            Body Level1_coin3 = new Coins(this);
            Level1_coin3.setPosition(new Vec2(-24, 15));
            Level1_coin3.addCollisionListener(new CoinCollisions(getPlayer()));
            Level1_coin3.addImage(CoingImg);
        }
        {
            // Platform 4
            Body Level1_platform4 = new StaticBody(this, Level1_platformShapes);
            Level1_platform4.addImage(Level1_platformImage);
            Level1_platform4.setPosition(new Vec2(-40, 20));
            Level1_platform4.addCollisionListener(new GroundCollision());


            // Coins for Platform 4
            Body Level1_coin2 = new Coins(this);
            Level1_coin2.setPosition(new Vec2(-42f, 21));
            Level1_coin2.addCollisionListener(new CoinCollisions(getPlayer()));
            Level1_coin2.addImage(CoingImg);

            Body Level1_coin3 = new Coins(this);
            Level1_coin3.setPosition(new Vec2(-39f, 21));
            Level1_coin3.addCollisionListener(new CoinCollisions(getPlayer()));
            Level1_coin3.addImage(CoingImg);
        }

        {
            // Platform 5
            Body Level1_platform5 = new StaticBody(this, Level1_platformShapes);
            Level1_platform5.addImage(Level1_platformImage);
            Level1_platform5.setPosition(new Vec2(-25, 25));
            Level1_platform5.addCollisionListener(new GroundCollision());


            // Coins for Platform 5
            Body Level1_coin2 = new Coins(this);
            Level1_coin2.setPosition(new Vec2(-26, 26));
            Level1_coin2.addCollisionListener(new CoinCollisions(getPlayer()));
            Level1_coin2.addImage(CoingImg);

            Body Level1_coin3 = new Coins(this);
            Level1_coin3.setPosition(new Vec2(-24, 26));
            Level1_coin3.addCollisionListener(new CoinCollisions(getPlayer()));
            Level1_coin3.addImage(CoingImg);
        }

        Body Level1_platform6 = new StaticBody(this, Level1_platformShapes);
        Level1_platform6.addImage(Level1_platformImage);
        Level1_platform6.setPosition(new Vec2(-10, 25));
        Level1_platform6.addCollisionListener(new GroundCollision());


        // Making the Coins
        for (int i = 0; i < 10; i++)
        {
            Body Level1_coin1 = new Coins(this);
            Level1_coin1.setPosition(new Vec2(-19 + (i * 3), 8));
            Level1_coin1.addCollisionListener(new CoinCollisions(getPlayer()));
            Level1_coin1.addImage(CoingImg);
        }

        // Making the hearts
        Body Level1_heart = new Hearts(this);
        Level1_heart.setPosition(new Vec2(-15, 20));
        Level1_heart.addCollisionListener(new HeartCollisions(getPlayer()));
        Level1_heart.addImage(HeartImg);

        // Making Power Ups
        Body Level1_JumpPowerUP = new Jump_PowerUP(this);
        Level1_JumpPowerUP.setPosition(new Vec2(13, 7));
        Level1_JumpPowerUP.addCollisionListener(new Jump_PowerUPCollision(getPlayer()));
        Level1_JumpPowerUP.addImage(PowerUP);

        // Making the Mana Crystals
        Body Level1_mana = new Mana(this);
        Level1_mana.setPosition(new Vec2(-40.5f, 22f));
        Level1_mana.addCollisionListener(new ManaCollisions(getPlayer(), game));
        Level1_mana.addImage(Mana);

        // Controls
        Shape Keys = new BoxShape(0, 0);

        Body WKey = new StaticBody(this, Keys);
        WKey.setPosition(new Vec2(-40, 0.5f));
        WKey.addImage(new BodyImage("data/W key.png", 2f));

        Body AKey = new StaticBody(this, Keys);
        AKey.setPosition(new Vec2(-41.5f, -2));
        AKey.addImage(new BodyImage("data/A key.png", 2f));

        Body DKey = new StaticBody(this, Keys);
        DKey.setPosition(new Vec2(-38.5f, -2));
        DKey.addImage(new BodyImage("data/D key.png", 2f));
    }

    @Override
    public Vec2 startPosition()
    {
        return new Vec2(-40, -15);
    }

    @Override
    public Vec2 portalPosition()
    {
        return new Vec2(59, -13.5f);
    }

    @Override
    public boolean levelComplete()
    {
        return getPlayer().getKeycollected();
    }

    @Override
    public Vec2 keyPosition()
    {
        return new Vec2(-10, 27);
    }


    @Override
    public Vec2 zombie_1_Position()
    {
        return new Vec2(-21, -16.5f);
    }

    @Override
    public Vec2 zombie_2_Position()
    {
        return new Vec2(-50, -16.5f);
    }

    @Override
    public float zombieSpeed()
    {
        return -3.5f;
    }

    @Override
    public Vec2 sorcererPosition()
    {
        return new Vec2(35, -5f);
    }

    @Override
    public Vec2 guardPosition()
    {
        return new Vec2(0, -40f);
    }
}
