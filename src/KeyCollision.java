import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The collision listener for the key pickup.
 */
public class KeyCollision implements CollisionListener
{
    private Player player;
    private SoundClip KeySound;

    /**
     * Initializing a player for the Key pickup collision.
     * @param player the player.
     */
    public KeyCollision(Player player)
    {
        this.player = player;

        // Using try and catch for the sound of the key
        try
        {
            KeySound = new SoundClip("data/Sound/KeySound.wav");
            KeySound.setVolume(0.05f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Called when something collided with the Key.
     * @param collisionEvent description of the CollisionEvent.
     */
    @Override
    public void collide(CollisionEvent collisionEvent)
    {
        if (collisionEvent.getOtherBody() == player)
        {
            collisionEvent.getReportingBody().destroy();
            KeySound.play();
            player.keyCollected = true;
        }
    }
}
