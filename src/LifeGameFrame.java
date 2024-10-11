import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeGameFrame extends JFrame {
  private final LifeGamePanel gamePanel;
  private final GameThread gameThread;

  public LifeGameFrame() {
    setTitle("Jeu de la Vie - TP Java");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    GameGrid grid = new GameGrid(50, 50);  // Grille de 50x50
    gamePanel = new LifeGamePanel(grid, 10);  // Chaque cellule fait 10 pixels

    // Thread pour gérer l'évolution du jeu
    gameThread = new GameThread(gamePanel, grid, 100);  // Mise à jour toutes les 100 ms

    // Ajouter des boutons pour démarrer et arrêter le jeu
    JButton startButton = new JButton("Démarrer");
    JButton stopButton = new JButton("Arrêter");

    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        gameThread.start();
      }
    });

    stopButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        gameThread.stop();
      }
    });

    JPanel controlPanel = new JPanel();
    controlPanel.add(startButton);
    controlPanel.add(stopButton);

    add(gamePanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.SOUTH);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new LifeGameFrame());
  }
}
