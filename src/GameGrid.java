public class GameGrid {
  private final int rows;
  private final int cols;
  private Cell[][] cells;

  public GameGrid(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.cells = new Cell[rows][cols];
    initializeGrid();
  }

  // Initialiser la grille avec des cellules aléatoires (vivantes ou mortes)
  public void initializeGrid() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        cells[i][j] = new SimpleCell(Math.random() < 0.5);
      }
    }
  }

  // Mettre à jour la grille selon les règles du Jeu de la Vie
  public void updateGrid() {
    Cell[][] nextGeneration = new Cell[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        boolean alive = cells[i][j].isAlive();
        int liveNeighbors = countLiveNeighbors(i, j);

        if (alive && (liveNeighbors < 2 || liveNeighbors > 3)) {
          nextGeneration[i][j] = new SimpleCell(false);  // Mort par surpopulation ou isolement
        } else if (!alive && liveNeighbors == 3) {
          nextGeneration[i][j] = new SimpleCell(true);  // Naissance
        } else {
          nextGeneration[i][j] = new SimpleCell(alive);  // Survie
        }
      }
    }

    cells = nextGeneration;  // Mise à jour de la grille avec la nouvelle génération
  }

  // Compter le nombre de voisins vivants d'une cellule donnée
  private int countLiveNeighbors(int x, int y) {
    int count = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0) continue;
        int row = (x + i + rows) % rows;
        int col = (y + j + cols) % cols;
        if (cells[row][col].isAlive()) {
          count++;
        }
      }
    }
    return count;
  }

  public Cell getCell(int x, int y) {
    return cells[x][y];
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }
}
