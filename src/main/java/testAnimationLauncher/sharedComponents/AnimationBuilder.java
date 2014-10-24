package testAnimationLauncher.sharedComponents;

import java.util.ArrayList;
import java.util.List;

import sorts.DisplaySort;
import sorts.QuickSort;
import testAnimationLauncher.common.DefaultDrawElement;
import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;
import testAnimationLauncher.displayComponents.intrfc.DrawElement;
import testAnimationLauncher.displayComponents.intrfc.Toggler;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AnimationBuilder implements Runnable {

  private boolean go = false;
  private int sleepValue = 200;
  private List<Toggler> togglers = new ArrayList<Toggler>();
  private DrawElement drawer = new DefaultDrawElement();
  private int x = 0;
  private int y = 0;
  int i = 0;
  private DisplaySort displaySort;
  private DisplayFrame doneFrame;
  
  @Inject public AnimationBuilder(QuickSort bubbleSort, DoneFrame doneFrame){
    displaySort = bubbleSort;
    this.doneFrame = doneFrame;
  }
  public void run() {
   
    while(go){
      System.out.println("Making new animation");
      drawer.draw(createFrame());
      try
      {
        Thread.sleep(sleepValue);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  private DisplayFrame createFrame() {
    DisplayFrame result = null;
    if(!displaySort.isDone()){
      result = displaySort.getNextFrame();
    }else {
      result = doneFrame;
    }
    return result;
  }

  public void setSpeed(int i){
    sleepValue = i;
  }
  public void start() {
    go = true;
    for(Toggler toggle:togglers) toggle.toggle();
  }

  public void registerToggleElement(Toggler toggler) {
    togglers.add(toggler);
  }

  public void registerDrawElement(DrawElement drawer){
    this.drawer = drawer;
  }
  public void stop() {
    go = false;
    for(Toggler toggle:togglers) toggle.toggle();
  }
}
