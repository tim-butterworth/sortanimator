package testAnimationLauncher.common;

import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;
import testAnimationLauncher.displayComponents.intrfc.DrawElement;

public class DefaultDrawElement implements DrawElement {

  public void draw(DisplayFrame frame) {
    System.out.println("This is the default draw... nothing cool happens");
  }

}
