import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The collision listener for my coins.
 */
public class CoinCollisions implements CollisionListener
{
    private Player player;

    // Pickup sound
    private SoundClip coinPickupSong;

    /**
     * Initialize the Player for the coin collision.
     * @param player the Player.
     */
    public CoinCollisions(Player player)
    {
        this.player = player;

        // Using try and catch to use the sound file for the coins
        try
        {
            coinPickupSong = new SoundClip("data/Sound/coinPickup.wav");
            coinPickupSong.setVolume(0.06f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1)
        {
            System.out.println(e1);
        }
    }

    @Override
    public void collide(CollisionEvent e)
    {
        // Collision between coins and player.
        if (e.getOtherBody() == player)
        {
            player.increaseCoinCount();
            e.getReportingBody().destroy();
            coinPickupSong.play();
        }
        if (e.getOtherBody() instanceof MagicBullet)
        {
            e.getOtherBody().destroy();
        }
    }


}
