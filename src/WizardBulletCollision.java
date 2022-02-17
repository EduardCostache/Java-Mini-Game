import Enemies.GuardEnemy;
import Enemies.SorcererEnemy;
import Enemies.ZombieEnemy;
import Pickups.Key;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The collision for the sorcerer's bullet.
 */
public class WizardBulletCollision implements CollisionListener
{
    private Player player;
    private SoundClip HurtSound;
    private SoundClip explosion;

    /**
     * Initializing the Player for the WizardBulletCollision class.
     *
     * @param player the Player.
     */
    public WizardBulletCollision(Player player)
    {
        this.player = player;

        // Using try and catch to use the sound file for the player getting hurt
        try
        {
            HurtSound = new SoundClip("data/Sound/HurtSound.wav");
            explosion = new SoundClip("data/Sound/explosion.wav");
            explosion.setVolume(0.2f);
            HurtSound.setVolume(0.2f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void collide(CollisionEvent collisionEvent)
    {
        if (collisionEvent.getOtherBody() instanceof Player)
        {
            HurtSound.play();
            player.decrementLife();
            collisionEvent.getReportingBody().destroy();
        }
        if (collisionEvent.getOtherBody() instanceof Key || collisionEvent.getOtherBody() instanceof ZombieEnemy || collisionEvent.getOtherBody() instanceof GuardEnemy)
        {
            collisionEvent.getReportingBody().destroy();
        }
        if (collisionEvent.getOtherBody() instanceof MagicBullet)
        {
            collisionEvent.getReportingBody().destroy();
            collisionEvent.getOtherBody().destroy();
            explosion.play();
        }
    }
}
