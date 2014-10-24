package testAnimationLauncher.displayComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import testAnimationLauncher.common.Coordinate;
import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;

import com.google.inject.Inject;

public class ContainerPanel extends JPanel {
  @Inject public ContainerPanel(DiplayPanel display, ControlPanel control, GridBagLayout layout, GridBagConstraints c) {
    setLayout(layout);
    
    c.fill=c.BOTH;
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 0.5;
    c.weighty = 8.0;
    
    add(display, c);
    
    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 0.5;
    c.weighty = 0.5;
    
    add(control, c);
  }
}
