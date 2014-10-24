package sorts;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import testAnimationLauncher.common.AnimationLabel;
import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;
import utils.AnimationUtilities;

import com.google.inject.Inject;

public class BubbleSort implements DisplaySort {

  private int pointerOne = 0;
  private int pointerTwo = 0;
  private List<Integer> toSort;
  boolean sorted = false;
  private RandomListBuilder randomListBuilder;
  private AnimationUtilities utilities;
  
  @Inject public BubbleSort(RandomListBuilder randomListBuilder, AnimationUtilities utilities){
    this.randomListBuilder = randomListBuilder;
    this.utilities = utilities;
    toSort = randomListBuilder.makeRandomList(20);
  }

  private void swap(int p1, int p2) {
    Integer temp = toSort.get(p1);
    toSort.set(p1, toSort.get(p2));
    toSort.set(p2, temp);
    pointerOne--;
    pointerTwo--;
  }

  public List<Integer> getToSort() {
    return toSort;
  }
  
  private DisplayFrame buildFrame() {
    List<AnimationLabel> labels = new ArrayList<AnimationLabel>();
    labels.add(new AnimationLabel("p1", pointerOne, Color.green));
    labels.add(new AnimationLabel("p2", pointerTwo, Color.blue));
    return new SortDisplayFrame(utilities.copyOf(toSort), labels);
  }

  public boolean isDone() {
    return (sorted && (pointerOne==0 && pointerTwo==0));
  }

  public DisplayFrame getNextFrame() {
    DisplayFrame result = buildFrame();
    if(!isDone()){
      notDoneYetMove();
    }
    return result;
  }

  private void notDoneYetMove() {
    if(!(pointerOne==pointerTwo)){
      standardMove();
    } else {
      sorted = true;
      pointerOne++;
    }
  }

  private void standardMove() {
    if(pointerOne<toSort.size()){
      int c = toSort.get(pointerOne).intValue();
      int l = toSort.get(pointerTwo).intValue();
      if(c<l){
        swap(pointerOne, pointerTwo);
        sorted = false;
      }
      pointerOne++;
      pointerTwo++;
    } else {
      pointerOne = 0;
      pointerTwo = 0;
    }
  }
}
