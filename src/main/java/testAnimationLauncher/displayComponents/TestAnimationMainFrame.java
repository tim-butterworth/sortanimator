package testAnimationLauncher.displayComponents;

import javax.swing.JFrame;

import com.google.inject.Inject;

public class TestAnimationMainFrame extends JFrame {

  @Inject public TestAnimationMainFrame(ContainerPanel container) {
    add(container);
    setTitle("Test Animation");
    setSize(1000,1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
}
