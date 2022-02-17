import city.cs.engine.*;

/**
 * The player for the game.
 */
public class Player extends Walker
{
    // Making the shape for the character
    private static final Shape shape = new PolygonShape(-1.25f, -2.46f, 0.93f, -2.46f, 0.93f, 1.36f, -1.25f, 1.36f);

    // Declaring important variables
    private int coinCount;
    private int lifeCount;
    private World world;
    private Game game;
    public boolean keyCollected;
    private int mana;
    private boolean outOfMana = false;

    /**
     * Initializing the World and Game for the Player class.
     * @param game the Game.
     * @param world The World.
     */
    public Player(World world, Game game)
    {
        super(world, shape);

        this.game = game;

        // Initializing variables
        coinCount = 0;
        lifeCount = 3;
        mana = 3;
        keyCollected = false;

        // Default player image
        addImage(new BodyImage("data/PlayerStandRIGHT.gif", 5.0f));
    }

    //--------------------------------Mana
    /**
     * A method for increasing the Player's mana.
     */
    public void incrementMana()
    {
        mana++;
    }

    /**
     * A method for decreasing the Player's mana.
     */
    public void decrementMana()
    {
        mana--;
        if (mana >= 0)
        {
            outOfMana = false;
            System.out.println("You have " + mana + " mana!");
        }
        if (mana < 0)
        {
            setManaCount(0);
            outOfMana = true;
            System.out.println("You have no more mana!");
        }
    }

    /**
     * A getter for a boolean which is true when mana reacher 0.
     * @return is the player out of mana?
     */
    public boolean isOutOfMana()
    {
        return outOfMana;
    }

    //-----------------------------------Life
    /**
     * A method for increasing Player's life.
     */
    public void incrementLife()
    {
        lifeCount++;
        System.out.println("Life Increased Life +1: " + lifeCount);
    }

    /**
     * A method for decreasing Player's life.
     */
    public void decrementLife()
    {
        lifeCount--;
        System.out.println("Life Left: " + lifeCount);
        if (lifeCount <= 0)
        {
            game.death();
            game.deathCheck = true;
        }
    }

    //-------------------------------------Coins
    /**
     * A method for increasing Player's Coins.
     */
    public void increaseCoinCount()
    {
        coinCount++;
        System.out.println("Coins: " + coinCount);
    }

    //=======================================================SETTERS==================================================\\
    //-------------------------------------Coins
    /**
     * A setter for the amount of Coins the Player has.
     * @param coinCount tre number of coins.
     */
    public void setCoinCount(int coinCount)
    {
        this.coinCount = coinCount;
    }

    //-----------------------------------Mana
    /**
     * A setter for the amount of Mana the Player has.
     * @param mana the amount of mana.
     */
    public void setManaCount(int mana)
    {
        this.mana = mana;
    }

    //--------------------------------Life
    /**
     * A setter for the amount of Life the Player has.
     * @param lifeCount the amount of life.
     */
    public void setLife(int lifeCount)
    {
        this.lifeCount = lifeCount;
    }

    //=======================================================GETTERS==================================================\\
    //-------------------------------------Coins
    /**
     * A getter returning the amount of Coins the Player has.
     * @return number of coins.
     */
    public int getCoinCount()
    {
        return coinCount;
    }

    //-----------------------------------Mana
    /**
     * A getter returning the amount of Mana the Player has.
     * @return number of mana.
     */
    public int getManaCount()
    {
        return mana;
    }

    //-----------------------Key
    /**
     * A getter returning a boolean is the Key has been collected.
     * @return has the player collected the key?
     */
    public boolean getKeycollected()
    {
        return keyCollected;
    }

    //--------------------------------Life
    /**
     * A getter returning the amount of Life the Player has.
     * @return the Player's life amount.
     */
    public int getLife()
    {
        return lifeCount;
    }
}
