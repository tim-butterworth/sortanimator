package sorts.common;

public class Bounds {
  private int leftBound;
  private int rightBound;
  public Bounds(int leftBound, int rightBound) {
    this.leftBound = leftBound;
    this.rightBound = rightBound;
  }
  public int getLeftBound() {
    return leftBound;
  }
  public int getRightBound() {
    return rightBound;
  }
}
