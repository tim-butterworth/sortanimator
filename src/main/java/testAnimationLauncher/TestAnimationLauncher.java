package testAnimationLauncher;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import testAnimationLauncher.displayComponents.TestAnimationMainFrame;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestAnimationLauncher
{
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        CreateAndShowGui();
      }
    });
  }
  public static void CreateAndShowGui(){
    Injector injector = Guice.createInjector();
    JFrame mainFrame = injector.getInstance(TestAnimationMainFrame.class);
    
    mainFrame.setVisible(true);
  }
}
