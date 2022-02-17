import city.cs.engine.UserView;
import city.cs.engine.World;

import java.awt.*;
import java.nio.file.WatchKey;

/**
 * The Background class for my game. This class replaces the UserView class.
 */
public class Background extends UserView
{
    // Declaring all Images
    Image level1Background, level2Background, level3Background;
    Image coins;
    Image hearts;
    Image snow;
    Image coins1, coins2;
    Image congrats;
    Image gameOver;
    Image gameOverBackground;
    Image star;

    // Declaring some variables
    int first;
    int second;
    private Game game;

    /**
     * Initialize the Game, World, Height and Width of the Background.
     * @param w the current world.
     * @param game the game.
     * @param height the height of the screen.
     * @param width the width of the screen.
     */
    public Background(Game game, World w, int height, int width)
    {
        super(w, height, width);
        this.game = game;

        // Image files
        level1Background = Toolkit.getDefaultToolkit().createImage("data/background_1.png");
        level2Background = Toolkit.getDefaultToolkit().createImage("data/background_2.png");
        level3Background = Toolkit.getDefaultToolkit().createImage("data/background_3.png");
        coins = Toolkit.getDefaultToolkit().createImage("data/CoinValue.png");
        hearts = Toolkit.getDefaultToolkit().createImage("data/LifesTotal.gif");
        snow = Toolkit.getDefaultToolkit().createImage("data/Level2_Snowing.gif");
        congrats = Toolkit.getDefaultToolkit().createImage("data/CongratulationsGIF.gif");
        gameOver = Toolkit.getDefaultToolkit().createImage("data/GameOver.png");
        gameOverBackground = Toolkit.getDefaultToolkit().createImage("data/GameOverBackground.png");
        star = Toolkit.getDefaultToolkit().createImage("data/manaStars.png");
    }

    /**
     * Draw in the background of the view.
     */
    @Override
    public void paintBackground(Graphics2D background)
    {
        // Different Levels have different backgrounds.
        if (game.getLevel() == 1)
        {
            // The background for Level 1
            background.drawImage(level1Background, 0, 0, this);
        }
        if (game.getLevel() == 2)
        {
            // The background for Level 2
            background.drawImage(level2Background, 0, 0, this);
            // The Snow for level 2
            background.drawImage(snow, 0, 0, this);
            background.drawImage(snow, 0, 300, this);
            background.drawImage(snow, 0, 600, this);
            background.drawImage(snow, 400, 0, this);
            background.drawImage(snow, 400, 300, this);
            background.drawImage(snow, 400, 600, this);
            background.drawImage(snow, 800, 0, this);
            background.drawImage(snow, 800, 300, this);
            background.drawImage(snow, 800, 600, this);
        }
        if (game.getLevel() == 3)
        {
            // The background for Level 3
            background.drawImage(level3Background, 0, 0, this);
        }
    }

    /**
     * Draw in the foreground of the view.
     */
    @Override
    public void paintForeground(Graphics2D background)
    {

        // Top left GUI
        // Coin icon
        background.drawImage(coins, 0, 0, this);
        // Coins
        background.drawImage(coins1, 55, 0, this);
        background.drawImage(coins2, 85, 0, this);

        first = game.getPlayer().getCoinCount()/10;
        if (game.getPlayer().getCoinCount() >= 10)
        {
            second = game.getPlayer().getCoinCount() - 10;
        }
        else if (game.getPlayer().getCoinCount() >= 20)
        {
            second = game.getPlayer().getCoinCount() - 20;
        }
        else if (game.getPlayer().getCoinCount() >= 30)
        {
            second = game.getPlayer().getCoinCount() - 30;
        }
        else
        {
            second = game.getPlayer().getCoinCount();
        }

        coins1 = Toolkit.getDefaultToolkit().createImage("data/Numbers/Pixel " + first + ".png");
        background.drawImage(coins1, 55, 0, this);
        coins2 = Toolkit.getDefaultToolkit().createImage("data/Numbers/Pixel " + second + ".png");
        background.drawImage(coins2, 85, 0, this);


        // Hearts GUI
        if (game.getPlayer().getLife() == 4)
        {
            background.drawImage(hearts, 0, 45, this);
            background.drawImage(hearts, 35, 45, this);
            background.drawImage(hearts, 70, 45, this);
            background.drawImage(hearts, 105, 45, this);
        }
        if (game.getPlayer().getLife() == 3)
        {
            background.drawImage(hearts, 0, 45, this);
            background.drawImage(hearts, 35, 45, this);
            background.drawImage(hearts, 70, 45, this);
        }
        if (game.getPlayer().getLife() == 2)
        {
            background.drawImage(hearts, 0, 45, this);
            background.drawImage(hearts, 35, 45, this);
        }
        if (game.getPlayer().getLife() == 1)
        {
            background.drawImage(hearts, 0, 45, this);
        }

        // Mana GUI
        if (game.getPlayer().getManaCount() == 4)
        {
            background.drawImage(star, 0, 90, this);
            background.drawImage(star, 35, 90, this);
            background.drawImage(star, 70, 90, this);
            background.drawImage(star, 105, 90, this);
        }
        if (game.getPlayer().getManaCount() == 3)
        {
            background.drawImage(star, 0, 90, this);
            background.drawImage(star, 35, 90, this);
            background.drawImage(star, 70, 90, this);
        }
        if (game.getPlayer().getManaCount() == 2)
        {
            background.drawImage(star, 0, 90, this);
            background.drawImage(star, 35, 90, this);
        }
        if (game.getPlayer().getManaCount() == 1)
        {
            background.drawImage(star, 0, 90, this);
        }

        if (game.levelCompleted())
        {
            background.drawImage(congrats, 190, 450, this);
        }

        if (game.getPlayer().getLife() <= 0)
        {
            background.drawImage(gameOverBackground, 0, 0, this);
            background.drawImage(gameOver, 350, 290, this);

            game.deathCheck = true;
        }
    }

}
