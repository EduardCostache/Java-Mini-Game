import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PrimitiveIterator;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton restartButton;
    private JButton startButton;
    private JButton godModeButton;
    private JButton loadButton;
    private JButton saveButton;

    private Game game;

    public ControlPanel(Game game) {
        this.game = game;

        // Quit Button
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(1);
            }
        });
        quitButton.setBackground(Color.BLACK);
        quitButton.setForeground(Color.WHITE);

        // Pause Button
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Game Paused");
                game.pause();
            }
        });
        pauseButton.setBackground(Color.BLACK);
        pauseButton.setForeground(Color.WHITE);

        // Restart File
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Game Restart");
                game.restart();
            }
        });
        restartButton.setBackground(Color.BLACK);
        restartButton.setForeground(Color.WHITE);

        // Start Button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                game.start();
                System.out.println("Game Resumed");
            }
        });
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);

        // God Mode Button
        godModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("");
                System.out.println("You have enabled God Mode, Have Fun!");
                game.godMode();
            }
        });
        godModeButton.setBackground(Color.BLACK);
        godModeButton.setForeground(Color.WHITE);
        godModeButton.setForeground(Color.WHITE);

        // Load Button
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                game.loadGame();
            }
        });
        loadButton.setBackground(Color.BLACK);
        loadButton.setForeground(Color.WHITE);

        // Save Button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                game.saveGame();
            }
        });
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
