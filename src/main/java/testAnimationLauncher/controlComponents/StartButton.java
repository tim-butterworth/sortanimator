package testAnimationLauncher.controlComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import testAnimationLauncher.displayComponents.intrfc.Toggler;
import testAnimationLauncher.sharedComponents.AnimationBuilder;

import com.google.inject.Inject;

public class StartButton extends JButton {

  @Inject public StartButton(final AnimationBuilder animationBuilder){
    setText("start");
    
    animationBuilder.registerToggleElement(new Toggler(){
      public void toggle(){
        setEnabled(!isEnabled());
      }
    });
    addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        animationBuilder.start();
        Thread t = new Thread(animationBuilder);
        t.start();
      }
    });
  }
}
