package testAnimationLauncher.displayComponents;

import javax.swing.JPanel;

import testAnimationLauncher.controlComponents.StartButton;
import testAnimationLauncher.controlComponents.StopButton;

import com.google.inject.Inject;

public class ControlPanel extends JPanel {
  
  @Inject public ControlPanel(StartButton start, StopButton stop){
    add(start);
    add(stop);
  }
}
