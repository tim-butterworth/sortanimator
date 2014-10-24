package testAnimationLauncher.common;

import java.awt.Color;

public class AnimationLabel {
  private String label;
  private int location;
  private Color color;
  
  public AnimationLabel(String label, int location, Color color) {
    this.label = label;
    this.location = location;
    this.color = color;
  }

  public String getLabel() {
    return label;
  }

  public int getLocation() {
    return location;
  }

  public Color getColor() {
    return color;
  }
  
}
