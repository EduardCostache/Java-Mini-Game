import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * The Controller class is where I have all the controls for my game.
 */
public class Controller extends KeyAdapter
{
    // Declaring player Movement variables
    public static float JUMPING_SPEED = 25;
    public static float WALKING_SPEED = 10;

    // Declaring and initializing boolean for smoother animations
    private boolean lookingRight = true;
    private boolean moving = false;

    // Sound files
    private SoundClip fireball;

    private Walker player;
    private GameLevel world;
    private Game game;

    /**
     * Initialize the Walker, World and the Game of the Controller class.
     * @param world the World.
     * @param game the Game.
     * @param player the Player.
     */
    public Controller(Walker player, GameLevel world, Game game)
    {
        this.player = player;
        this.world = world;
        this.game = game;

        // Using try and catch to use the sound file for the coins
        try
        {
            fireball = new SoundClip("data/Sound/fireball_cast.wav");
            fireball.setVolume(0.06f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1)
        {
            System.out.println(e1);
        }
    }

    //=============================================Start Animations===================================================\\
    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        //-------------------------------------------------------------------------------------------Moving to the RIGHT
        if (code == KeyEvent.VK_D)
        {
            player.removeAllImages();
            lookingRight = true;
            moving = true;
            player.startWalking(WALKING_SPEED);
            player.addImage(new BodyImage("data/playerMovingRIGHT.gif", 5.6f));
        }

        //--------------------------------------------------------------------------------------------Moving to the LEFT
        if (code == KeyEvent.VK_A)
        {
            player.removeAllImages();
            lookingRight = false;
            moving = true;
            player.startWalking(-WALKING_SPEED);
            player.addImage(new BodyImage("data/playerMovingLEFT.gif", 5.6f));
        }

        //-------------------------------------------------------------------------------------------------------Jumping
        if (code == KeyEvent.VK_W)
        {
            player.removeAllImages();
            Vec2 velocity = player.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(velocity.y) < 0.01f)
            {
                player.jump(JUMPING_SPEED);
            }
            if (lookingRight)
            {
                player.addImage(new BodyImage("data/PlayerStandRIGHT.gif", 5.0f));

            }
            if (!lookingRight)
            {
                player.addImage(new BodyImage("data/PlayerStandLEFT.gif", 5.0f));

            }

        }

        //-----------------------------------------------------------------------------------------------------Attacking
        if (code == KeyEvent.VK_SPACE)
        {
            float x = game.getPlayer().getPosition().x;
            float y = game.getPlayer().getPosition().y;
            MagicBullet bullet = new MagicBullet(world);
            fireball.play();
            if (lookingRight)
            {
                bullet.setLinearVelocity(new Vec2(20, 0));
                bullet.setPosition(new Vec2(x, y));
            } else
            {
                bullet.setLinearVelocity(new Vec2(-20, 0));
                bullet.setPosition(new Vec2(x - 1, y));
            }

            game.getPlayer().decrementMana();

            if (game.getPlayer().isOutOfMana())
            {
                bullet.destroy();
                fireball.close();
            } else
            {
                fireball.resume();
            }
        }
    }


    //=============================================Stop Animations====================================================\\
    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        //-------------------------------------------------------------------------------------------Moving to the RIGHT
        if (code == KeyEvent.VK_D)
        {
            player.startWalking(0);
            player.removeAllImages();
            moving = false;
            player.addImage(new BodyImage("data/PlayerStandRIGHT.gif", 5.0f));
        }

        //--------------------------------------------------------------------------------------------Moving to the LEFT
        if (code == KeyEvent.VK_A)
        {
            player.startWalking(0);
            player.removeAllImages();
            moving = false;
            player.addImage(new BodyImage("data/PlayerStandLEFT.gif", 5.0f));
        }

        //-------------------------------------------------------------------------------------------------------Jumping

        if (code == KeyEvent.VK_W && lookingRight && moving)
        {
            player.removeAllImages();
            player.addImage(new BodyImage("data/PlayerMovingRIGHT.gif", 5.6f));
        }
        if (code == KeyEvent.VK_W && lookingRight && !moving)
        {
            player.removeAllImages();
            player.addImage(new BodyImage("data/PlayerStandRIGHT.gif", 5.0f));
        }

        if (code == KeyEvent.VK_W && !lookingRight && moving)
        {
            player.removeAllImages();
            player.addImage(new BodyImage("data/PlayerMovingLEFT.gif", 5.6f));
        }
        if (code == KeyEvent.VK_W && !lookingRight && !moving)
        {
            player.removeAllImages();
            player.addImage(new BodyImage("data/PlayerStandLEFT.gif", 5.0f));
        }
    }

    /**
     * A method for setting the Player and the World for the Controller class.
     * @param player the player.
     * @param world the world.
     */
    public void setWorld(Walker player, GameLevel world)
    {
        this.player = player;
        this.world = world;
    }

    /**
     * A setter for changing the 'JUMPING_SPEED' of the Player.
     * @param jumpingSpeed the jumping speed of the player.
     */
    public void setJumpingSpeed(int jumpingSpeed)
    {
        this.JUMPING_SPEED = jumpingSpeed;
    }

    /**
     * A setter for changing the 'WALKING_SPEED' of the Player.
     * @param walkingSpeed the walking speed of the player.
     */
    public void setWalkingSpeed(int walkingSpeed)
    {
        this.WALKING_SPEED = walkingSpeed;
    }
}
