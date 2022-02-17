import Enemies.GuardEnemy;
import Enemies.SorcererEnemy;
import Enemies.ZombieEnemy;
import Pickups.Key;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An abstract class for creating the levels in the game. Any code typed here will take effect of all of the
 * levels witin the game.
 */
public abstract class GameLevel extends World implements ActionListener
{
    private Player player;
    private SorcererEnemy sorcerer;
    private ZombieEnemy zombie;
    private GuardEnemy guard;
    private Game game;
    private Key key;

    // Global timer
    private Timer timer = new Timer(3000, this);

    /**
     * A getther for the Player class.
     * @return the Player.
     */
    public Player getPlayer()
    {
        return player;
    }

    Color color = new Color(0, 0, 0, 0);

    /**
     * A method that populates all levels with objects.
     *
     * @param game the Game.
     */
    public void createWorld(Game game)
    {
        // Creating the Player
        player = new Player(this, game);
        player.setPosition(startPosition());
        player.setGravityScale(4f);

        // Creating the exit gate
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalCollision(game));

        // Making the wizard enemy
        sorcerer = new SorcererEnemy(this);
        sorcerer.addImage(new BodyImage("data/enemySorcerer.gif", 5f));
        sorcerer.setPosition(sorcererPosition());
        sorcerer.addCollisionListener(new EnemyCollision(getPlayer(), sorcerer));

        // Making the zombie enemy
        zombie = new ZombieEnemy(this);
        zombie.addImage(new BodyImage("data/enemy2Left.gif", 5f));
        zombie.setPosition(zombie_1_Position());
        zombie.addCollisionListener(new EnemyCollision(getPlayer(), sorcerer));
        // Zombie Moving
        zombie.startWalking(zombieSpeed());

        // Making the guard enemy
        guard = new GuardEnemy(this);
        guard.addImage(new BodyImage("data/guardStandLeft.gif", 5f));
        guard.setPosition(guardPosition());
        guard.addCollisionListener(new EnemyCollision(getPlayer(), sorcerer));

        //Making the key
        key = new Key(this);
        key.setPosition(keyPosition());
        key.addImage(new BodyImage("data/key.gif", 4f));
        key.addCollisionListener(new KeyCollision(getPlayer()));

        // Creating the end of the world
        Shape Level_bottomLineShape = new BoxShape(60, 1);
        Body level_bottomLine = new StaticBody(this, Level_bottomLineShape);
        level_bottomLine.setFillColor(color);
        level_bottomLine.setLineColor(color);
        level_bottomLine.setPosition(new Vec2(0, -40));
        level_bottomLine.addCollisionListener(new FallingOffCollision(game.getPlayer(), game));

        Shape Level_rightLineShape = new BoxShape(1, 40, new Vec2(70, 40));
        SolidFixture Level_rightLine = new SolidFixture(level_bottomLine, Level_rightLineShape);

        Shape Level_leftLineShape = new BoxShape(1, 40, new Vec2(-60, 40));
        SolidFixture Level_leftLine = new SolidFixture(level_bottomLine, Level_leftLineShape);

        Shape Level_topLineShape = new BoxShape(60, 1);
        Body level_topLine = new StaticBody(this, Level_topLineShape);
        level_topLine.setFillColor(color);
        level_topLine.setLineColor(color);
        level_topLine.setPosition(new Vec2(0, 60));
        level_topLine.addCollisionListener(new FallingOffCollision(game.getPlayer(), game));

        // Wizard Shooting
        timer.setInitialDelay(100);
        timer.start();
    }

    public void restartTimer()
    {
        timer.restart();
    }

    /**
     * A method for the Action performed each time the Timer ticks.
     * @param ae hte ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        float x = sorcerer.getPosition().x;
        float y = sorcerer.getPosition().y;

        float y1 = getPlayer().getPosition().y;
        WizardBullet enemyBullet = new WizardBullet(this);
        enemyBullet.setPosition(new Vec2(x - 1, y));
        enemyBullet.setLinearVelocity(new Vec2(-15, y1 - y));
        enemyBullet.addCollisionListener(new WizardBulletCollision(getPlayer()));
        if (!sorcerer.isAlive())
        {
            enemyBullet.destroy();
        }
    }

    /**
     * An abstract class for the start position of the player in each level.
     * @return the start position of the Player for every level.
     */
    public abstract Vec2 startPosition();

    /**
     * An abstract class for the position of the Portal on each level.
     * @return the Portal position in each level.
     */
    public abstract Vec2 portalPosition();

    /**
     * An abstract class for the requirements of a level to be completed.
     * @return is the level complete?
     */
    public abstract boolean levelComplete();

    /**
     * An abstract class for the position of the 1st zombie.
     * @return the start position for the 1st Zombie.
     */
    public abstract Vec2 zombie_1_Position();

    /**
     * An abstract class for the position of the 2nd zombie.
     * @return the start position for the 2nd Zombie.
     */
    public abstract Vec2 zombie_2_Position();

    /**
     * An abstract class for the speed at which the zombies move on each level.
     * @return the speed of the Zombie.
     */
    public abstract float zombieSpeed();

    /**
     * An abstract class for the position of the Sorcerer enemy.
     * @return the position of the Sorcerer enemy.
     */
    public abstract Vec2 sorcererPosition();

    /**
     * An abstract class for the position of the Guard Enemy.
     * @return the position of the Guard enemy.
     */
    public abstract Vec2 guardPosition();

    /**
     * An abstract class for the position of the Key for each level.
     * @return the position of the Key for each level.
     */
    public abstract Vec2 keyPosition();

}
