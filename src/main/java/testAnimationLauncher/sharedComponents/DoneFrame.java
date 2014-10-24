package testAnimationLauncher.sharedComponents;

import java.awt.Color;
import java.awt.Graphics;

import testAnimationLauncher.common.Coordinate;
import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;

import com.google.inject.Singleton;

@Singleton
public class DoneFrame implements DisplayFrame {

  public void draw(Graphics g, Coordinate zeroZero, int w, int h) {
    g.setColor(Color.white);
    g.drawString("DONE", zeroZero.getX()+w/2, zeroZero.getY()+h/2);
  }
}
