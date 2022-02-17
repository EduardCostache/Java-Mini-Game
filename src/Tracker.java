import city.cs.engine.*;

/**
 * A tracker class for the character. Tracks the character around the game.
 */
public class Tracker implements StepListener
{
    // This class makes sure that the player is being followed by the view.
    private Player player;
    private Game game;
    private GameLevel gameLevel;

    /**
     * Initializing the Player and the Game for the Tracker class.
     * @param game the Game.
     * @param player the Player.
     */
    public Tracker(Player player, Game game)
    {
        this.player = player;
        this.game = game;
    }

    @Override
    public void preStep(StepEvent e)
    {
    }

    @Override
    public void postStep(StepEvent e)
    {
        game.getView().setCentre(game.getPlayer().getPosition());
    }

}
