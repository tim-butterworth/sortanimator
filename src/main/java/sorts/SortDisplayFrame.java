package sorts;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import testAnimationLauncher.common.AnimationLabel;
import testAnimationLauncher.common.Coordinate;
import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;

public class SortDisplayFrame
    implements DisplayFrame
{

  private List<Integer> toSort;
  private int p1;
  private int p2;
  private List<AnimationLabel> animationLabels;
  private Map<Integer, Color> colorMap;
  
  public SortDisplayFrame(List<Integer> copyOf, List<AnimationLabel> labels) {
    toSort = copyOf;
    animationLabels = labels;
    this.colorMap = new HashMap<Integer, Color>();
    for(AnimationLabel label:animationLabels){
      colorMap.put(new Integer(label.getLocation()), label.getColor());
    }
  }
  public void draw(Graphics g, Coordinate zeroZero, int w, int h) {
    int padding = w/10;
    g.setColor(Color.white);
    int n = toSort.size();
    int step = (w-padding*2)/(n-1);

    int start = zeroZero.getX()+padding;
    int bottom = h-zeroZero.getY();
    int i = 0;
    int maxHeight = 0;
    while(i<n){
      int height = (toSort.get(i).intValue()+1)*10;
      if(height>maxHeight) maxHeight = height;
      Color labeledColor = getLabeledColor(i);
      g.setColor(labeledColor);
      g.drawLine(start+step*i, bottom, start+step*i, bottom-height);
      i++;
    }
    int baseHeight = 200;
    for(AnimationLabel label:animationLabels){
      drawPointers(label.getLocation()*step+start, label.getColor(), label.getLabel(), h-maxHeight-(h-maxHeight)/2, baseHeight, g);
      baseHeight = baseHeight+24;
    }
  }
  private Color getLabeledColor(int i) {
    Color result = colorMap.get(new Integer(i));
    if(result==null) result = Color.white;
    return result;
  }
  private void drawPointers(int location, Color color, String label, int maxHeight, int height, Graphics g) {
     drawLabeledArrow(location, label, maxHeight+20, height, color, g);
  }
  private void drawLabeledArrow(int x, String label, int y, int h, Color color, Graphics g) {
    g.setColor(color);
    g.drawLine(x, y, x, y-h);
    g.drawString(label, x, y-h-12);
  }
}
