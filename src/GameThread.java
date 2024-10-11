public class GameThread implements Runnable {
  private final LifeGamePanel gamePanel;
  private final GameGrid gameGrid;
  private boolean running = false;
  private final int delay;

  public GameThread(LifeGamePanel panel, GameGrid grid, int delay) {
    this.gamePanel = panel;
    this.gameGrid = grid;
    this.delay = delay;
  }

  public void start() {
    running = true;
    new Thread(this).start();
  }

  public void stop() {
    running = false;
  }

  @Override
  public void run() {
    while (running) {
      gameGrid.updateGrid();      // Mise à jour de la grille
      gamePanel.repaint();        // Redessiner l'interface
      try {
        Thread.sleep(delay);    // Pause entre les générations
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
