public abstract class AbstractCell implements Cell {
  protected boolean alive;  // État de la cellule (vivante ou morte)

  @Override
  public boolean isAlive() {
    return alive;
  }

  @Override
  public void setAlive(boolean alive) {
    this.alive = alive;
  }
}
