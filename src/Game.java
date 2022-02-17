import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * The main class for the game. This is where the game is run and it contains
 * important code for things such as levels and the game world.
 */
public class Game
{
    // Stating the World
    private GameLevel world;

    // Stating the View
    private Background view;

    // Level
    private int level;

    // Controller
    private Controller controller;

    // Music
    private SoundClip gameMusic;

    // Tracker
    private Tracker tracker;

    // Death
    public boolean deathCheck = false;


    public Game()
    {
        // Making the world
        level = 1;
        //        world = new Level4_TestLevel();
        world = new Level1();
        world.createWorld(this);

        // Making the view
        view = new Background(this, world, 1100, 700);
        // Displaying the view in frames
        JFrame frame = new JFrame("Game with multiple levels");
        // GUI
        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.EAST);

        // Closing the game when exiting the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Character Controls
        controller = new Controller(world.getPlayer(), world, this);
        frame.addKeyListener(controller);
        // Adding the view to the frame
        frame.add(view);
        // Don't allow for resizing
        frame.setResizable(false);
        // Size the game window to fit the world view
        frame.pack();
        // Make the window visible
        frame.setVisible(true);
        // Get keyboard focus
        frame.requestFocus();

        // Tracking the player
        world.addStepListener(new Tracker(getPlayer(), this));
        // Adding Mouse Listener
        view.addMouseListener(new GiveFocus(frame));

        // The Debugging tool
        // JFrame debugView = new DebugViewer(world, 1100, 700);

        // Label
        JLabel versionLabel = new JLabel();
        versionLabel.setText("Version 1.0");
        frame.add(versionLabel, BorderLayout.NORTH);

        // Music
        try
        {
            gameMusic = new SoundClip("data/Sound/gameMusic.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.05f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            System.out.println(e);
        }


        // Start the World
        world.start();

        // Instructions
        System.out.println("");
        System.out.println("Instructions! Please read.");
        System.out.println("");
        System.out.println("Welcome to my game, the main objective is to get the key and avoid or kill the enemies on the way.");
        System.out.println("You can kill enemies with magic, be careful not to use too much mana or you will");
        System.out.println("have to avoid them by dodging. Also dont forget to collect coins on the way. Enjoy.");
        System.out.println("");
        System.out.println("You have " + getPlayer().getManaCount() + " mana!");
    }

    /**
     * A getter for the Player.
     * @return the Player.
     */
    public Player getPlayer()
    {
        return world.getPlayer();
    }

    /**
     * A getter for the View.
     * @return the View.
     */
    public UserView getView()
    {
        return view;
    }

    /**
     * A getter for the level completion boolean.
     * @return is the level completed?
     */
    public boolean levelCompleted()
    {
        return world.levelComplete();
    }

    /**
     * A method for going to the next level after finishing the current level.
     */
    public void goNextLevel()
    {
        world.stop();
        if (level == 1)
        {
            // increment level
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.createWorld(this);
            // Resetting mana
            getPlayer().setManaCount(3);
            // Reset Jumping speed
            controller.setJumpingSpeed(25);
            // switch the keyboard control to the new player
            controller.setWorld(world.getPlayer(), world);
            // show the new world in the view
            view.setWorld(world);

            // tracker
            world.addStepListener(new Tracker(getPlayer(), this));
            // Restart timer
            world.restartTimer();
            // Start World
            world.start();
        } else if (level == 2)
        {
            // increment level
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.createWorld(this);
            // Resetting mana
            getPlayer().setManaCount(3);
            // switch the keyboard control to the new player
            controller.setWorld(world.getPlayer(), world);
            // show the new world in the view
            view.setWorld(world);
            // Reset Jumping speed
            controller.setJumpingSpeed(25);
            // tracker
            world.addStepListener(new Tracker(getPlayer(), this));
            // Restart timer
            world.restartTimer();
            // Start World
            world.start();
        } else if (level == 3)
        {
            System.exit(0);
        }
    }

    // Buttons for the GUI on the Right of the screen and how they work.
    /**
     * A method that pauses the game.
     */
    public void pause()
    {
        world.stop();
    }

    /**
     * A method that starts the game.
     */
    public void start()
    {
        world.start();
    }

    /**
     * A method that gives the player 'GodMode' for entertaining purposes.
     */
    public void godMode()
    {
        getPlayer().setLife(100);
        System.out.println("Life + 100");
        controller.setJumpingSpeed(100);
        controller.setWalkingSpeed(50);
    }

    /**
     * A method that restarts the whole game.
     */
    public void restart()
    {
        world.stop();
        // get a new world
        // Reset level
        level = 1;
        world = new Level1();
        // fill it with bodies
        world.createWorld(this);
        // switch the keyboard control to the new player
        controller.setWorld(world.getPlayer(), world);
        // Rest Jumping Speed
        controller.setJumpingSpeed(25);
        // show the new world in the view
        view.setWorld(world);
        // tracker
        world.addStepListener(new Tracker(getPlayer(), this));
        //      // Start Level 2
        world.start();
    }

    /**
     * A method that is called when the player dies.
     */
    public void death()
    {
        world.stop();
    }

    /**
     * A getter that returns the level number.
     * @return the level number.
     */
    public int getLevel()
    {
        return level;
    }
    public void setLevel(int level)
    {
        this.level = level;
    }


    public void saveGame()
    {
        float xSave = getPlayer().getPosition().x;
        float ySave = getPlayer().getPosition().y;

        int coinsSave = getPlayer().getCoinCount();
        int lifeSave = getPlayer().getLife();
        int manaSave = getPlayer().getManaCount();
        int levelSave = getLevel();
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/Saves/saveFile.txt"));

            bw.write(""+xSave);
            bw.newLine();
            bw.write(""+ySave);
            bw.newLine();
            bw.write(""+coinsSave);
            bw.newLine();
            bw.write(""+lifeSave);
            bw.newLine();
            bw.write(""+manaSave);
            bw.newLine();
            bw.write(""+levelSave);

            bw.close();
        }
        catch(Exception e)
        {

        }
        getPlayer().setPosition(new Vec2(xSave,ySave));

        getPlayer().setCoinCount(coinsSave);
        getPlayer().setManaCount(lifeSave);
        getPlayer().setLife(manaSave);
        setLevel(levelSave);

        System.out.println("Game Saving... Game Saved!");
    }
    public void loadGame()
    {
        float xLoad = getPlayer().getPosition().x;
        float yLoad = getPlayer().getPosition().y;

        int coinsLoad = getPlayer().getCoinCount();
        int lifeLoad = getPlayer().getLife();
        int manaLoad = getPlayer().getManaCount();
        int levelLoad = getLevel();

        try{
            BufferedReader br = new BufferedReader(new FileReader("data/Saves/saveFile.txt"));

            xLoad = Float.parseFloat(br.readLine());
            yLoad = Float.parseFloat(br.readLine());

            coinsLoad = Integer.parseInt(br.readLine());
            lifeLoad = Integer.parseInt(br.readLine());
            manaLoad = Integer.parseInt(br.readLine());
            levelLoad = Integer.parseInt(br.readLine());

            br.close();
        }
        catch (Exception e){

        }
        getPlayer().setPosition(new Vec2(xLoad,yLoad));

        getPlayer().setCoinCount(coinsLoad);
        getPlayer().setManaCount(manaLoad);
        getPlayer().setLife(lifeLoad);
        setLevel(levelLoad);

        System.out.println("Loading Game.... Game Loaded!");
    }

    // Running the Game
    public static void main(String[] args)
    {
        new Game();
    }
}
