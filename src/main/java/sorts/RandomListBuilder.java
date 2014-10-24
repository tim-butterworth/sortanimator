package sorts;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

@Singleton
public class RandomListBuilder {
  public List<Integer> makeRandomList(int max) {
    List<Integer> temp = new ArrayList<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    int i = 0;
    while(i<max){
      temp.add(new Integer(i));
      i++;
    }
    while(temp.size()>0){
      int random = (int)(Math.random()*(double)temp.size());
      result.add(temp.get(random));
      temp.remove(random);
    }
    return result;
  }
}
