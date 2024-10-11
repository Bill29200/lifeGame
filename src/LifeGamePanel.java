import javax.swing.*;
import java.awt.*;

public class LifeGamePanel extends JPanel {
  private final GameGrid grid;
  private final int cellSize;

  public LifeGamePanel(GameGrid grid, int cellSize) {
    this.grid = grid;
    this.cellSize = cellSize;
    setPreferredSize(new Dimension(grid.getCols() * cellSize, grid.getRows() * cellSize));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < grid.getRows(); i++) {
      for (int j = 0; j < grid.getCols(); j++) {
        if (grid.getCell(i, j).isAlive()) {
          g.setColor(Color.BLACK);
        } else {
          g.setColor(Color.WHITE);
        }
        g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
        g.setColor(Color.GRAY);  // Pour la grille
        g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
      }
    }
  }
}
