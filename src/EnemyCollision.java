import Enemies.SorcererEnemy;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The EnemyCollision is the class that contains CollisionEvents when the enemies collide with the player,
 * or other objects in the game.
 */
public class EnemyCollision implements CollisionListener
{
    private Player player;
    private SoundClip HurtSound;

    private SorcererEnemy sorcererEnemy;

    /**
     * Initializing the Player and Enemy for the 'EnemyCollision' class.
     * @param player the player.
     * @param sorcererEnemy the enemy.
     */
    public EnemyCollision(Player player, SorcererEnemy sorcererEnemy)
    {
        this.player = player;
        this.sorcererEnemy = sorcererEnemy;

        // Using try and catch to use the sound file for the player getting hurt
        try
        {
            HurtSound = new SoundClip("data/Sound/HurtSound.wav");
            HurtSound.setVolume(0.2f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            System.out.println(e);
        }
    }

    /**
     * The Collision method.
     * @param e the CollisionEvent.
     */
    @Override
    public void collide(CollisionEvent e)
    {
        // Collision between the Enemies and the player. Also the collision for the bullet and the enemy.
        if (e.getOtherBody() == player)
        {
            player.decrementLife();
            HurtSound.play();
        }
        if (e.getOtherBody() instanceof MagicBullet)
        {
            if (e.getReportingBody() instanceof SorcererEnemy)
        {
            sorcererEnemy.setAlive(false);
        }
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
        }
    }


}
