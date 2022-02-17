import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GiveFocus extends MouseAdapter
{
    private Component target;

    public GiveFocus(Component target)
    {
        this.target = target;
    }

    /**
     * Called when the mouse enters a component.
     *
     * @param e description of the mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e)
    {
        target.requestFocus();
    }
}