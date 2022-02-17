import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The collision listener for the jump-powerIP pickup.
 */
public class Jump_PowerUPCollision implements CollisionListener
{
    private Player player;
    private Controller controller;
    private SoundClip PowerSound;

    /**
     * Initializing a Player for the Jump_powerUP pickup.
     * @param player the player.
     */
    public Jump_PowerUPCollision(Player player)
    {
        this.player = player;

        // Using try and catch in order to play a very recognisable sound effect when picking up the powerup.
        try
        {
            PowerSound = new SoundClip("data/Sound/PowerUpSound.wav");
            PowerSound.setVolume(0.1f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Called when the collision with the powerup has been made.
     * @param e description of the CollsionEvent.
     */
    @Override
    public void collide(CollisionEvent e)
    {
        // Collision between the player and the powerup
        if (e.getOtherBody() == player)
        {
            e.getReportingBody().destroy();
            controller.JUMPING_SPEED += 3.8;
            System.out.println("Jump Increased +");
            PowerSound.play();
        }
    }
}

