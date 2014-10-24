package sorts;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import sorts.common.Bounds;
import testAnimationLauncher.common.AnimationLabel;
import testAnimationLauncher.displayComponents.intrfc.DisplayFrame;
import utils.AnimationUtilities;

import com.google.inject.Inject;

public class QuickSort implements DisplaySort {

  private boolean sorted = true;
  private int pivot;
  private int leftBound;
  private int rightBound;
  private Bounds currentBounds;
  private List<Integer> toSort;
  private AnimationUtilities utilities;
  private boolean pivotSet = false;
  private boolean pivotMoved = false;
  private boolean boundsSet = false;
  private boolean outOfMoves = false;
  private List<Integer> inorder;
  
  Stack<Bounds> stack;
  
  @Inject public QuickSort(RandomListBuilder randomListBuilder, AnimationUtilities utilities, Stack<Bounds> stack, ArrayList<Integer> inorder){
    this.utilities = utilities;
    toSort = randomListBuilder.makeRandomList(50);
    this.stack = stack;
    this.stack.push(new Bounds(0, toSort.size()-1));
    this.inorder = inorder;
  }
  
  public boolean isDone() {
    return (sorted && stack.isEmpty());
  }

  public DisplayFrame getNextFrame() {
    DisplayFrame frame = buildFrame();
    if(!isDone()){
      itterate();
    }
    return frame;
  }
  
  private void itterate() {
    if(!boundsSet) setBounds();
    else if(!pivotSet) pickPivot();
    else if(!pivotMoved) movePivot();
    else if(!outOfMoves) sortMove();
    else setupNextBounds();
  }

  private void setupNextBounds() {
    Bounds leftBounds = new Bounds(currentBounds.getLeftBound(), pivot-1);
    Bounds rightBounds = new Bounds(pivot+1, currentBounds.getRightBound());
    if(validBounds(leftBounds)) stack.push(leftBounds);
    if(validBounds(rightBounds))stack.push(rightBounds);
    resetState();
  }

  private boolean validBounds(Bounds b) {
    return (b.getLeftBound()<b.getRightBound());
  }

  private void resetState() {
    currentBounds = null;
    pivotSet = false;
    pivotMoved = false;
    boundsSet = false;
    outOfMoves = false;
    sorted = true;
  }

  private void sortMove() {
    int pivotValue = toSort.get(pivot).intValue();
    int leftValue = toSort.get(leftBound).intValue();
    int rightValue = toSort.get(rightBound).intValue();
    if(leftBound==rightBound){
      if(outOfMoves){
        sorted = true;
      } else insertPivot();
    } else {
      if(leftValue<pivotValue) leftBound++;
      else {
        if(rightValue<pivotValue) swap(leftBound, rightBound);
        else rightBound--;
      }
    }
  }

  private void insertPivot() {
    outOfMoves = true;
    if(toSort.get(pivot).intValue()<=toSort.get(leftBound)) {
      swap(pivot, leftBound);
      pivot = leftBound;
      inorder.add(new Integer(pivot));
    }
  }

  private void swap(int index1, int index2) {
    Integer temp = toSort.get(index2);
    toSort.set(index2, toSort.get(index1));
    toSort.set(index1, temp);
  }

  private void setBounds() {
    sorted = false;
    boundsSet = true;
    currentBounds = stack.pop();

    leftBound = currentBounds.getLeftBound();
    rightBound = currentBounds.getRightBound();
  }

  private void movePivot() {
    pivotMoved = true;
    Integer temp = toSort.get(rightBound);
    toSort.set(rightBound, toSort.get(pivot));
    toSort.set(pivot, temp);
    pivot = rightBound;
    rightBound--;
  }

  private void pickPivot() {
    pivot = (int)(Math.random()*(double) (currentBounds.getRightBound()-currentBounds.getLeftBound()))+currentBounds.getLeftBound();
    pivotSet = true;
  }

  private DisplayFrame buildFrame() {
    List<AnimationLabel> labels = new ArrayList<AnimationLabel>();
    if(boundsSet){
      labels.add(new AnimationLabel("Lb", leftBound, Color.green));
      labels.add(new AnimationLabel("Rb", rightBound, Color.blue));
    }
    if(pivotSet) labels.add(new AnimationLabel("pivot", pivot, Color.red));
    for(Integer ordered:inorder) labels.add(new AnimationLabel("o", ordered.intValue(), Color.DARK_GRAY));
    return new SortDisplayFrame(utilities.copyOf(toSort), labels);
  }

  public List<Integer> getToSort() {
    return toSort;
  }
}
