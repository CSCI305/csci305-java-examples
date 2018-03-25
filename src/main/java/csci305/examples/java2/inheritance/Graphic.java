package csci305.examples.java2.inheritance;

public class Graphic {
  protected int x, y;
  protected int width, height;

  public void move(int newX, int newY) {
    x = newX;
    y = newY;
  }
}
