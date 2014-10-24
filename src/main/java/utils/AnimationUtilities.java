package utils;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

@Singleton
public class AnimationUtilities {

  public List<Integer> copyOf(List<Integer> lst) {
    List<Integer> copy = new ArrayList<Integer>();
    for(Integer i:lst) copy.add(i);
    return copy;
  }

}
