package testAnimationLauncher.displayComponents;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import testAnimationLauncher.common.Coordinate;
import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;
import testAnimationLauncher.displayComponents.intrfc.DrawElement;
import testAnimationLauncher.sharedComponents.AnimationBuilder;

import com.google.inject.Inject;

public class DiplayPanel extends JPanel {
  
  private DisplayFrame frame;
  
  @Inject public DiplayPanel(final AnimationBuilder animationBuilder){
    animationBuilder.registerDrawElement(new DrawElement(){
      public void draw(DisplayFrame frame) {
        setDisplayFrame(frame);
        repaint();
      }
    });
  }
  
  @Override
  public void paint(Graphics g) {
    g.setColor(Color.DARK_GRAY);

    int border = 3;
    int w = getWidth()-2*border;
    int h = getHeight()-2*border;

    g.fillRect(border, border, w, h);
    Coordinate zeroZero = new Coordinate(border,border);
    if(frame!=null) {
      frame.draw(g, zeroZero, w, h);
    }
  }
  
  public void setDisplayFrame(DisplayFrame frame){
    this.frame = frame;
    repaint();
  }
}
