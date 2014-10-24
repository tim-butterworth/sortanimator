package sorts;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BubleSortTester {

  private BubbleSort subject;

  @Before
  public void initialize(){
    Injector injector = Guice.createInjector();
    subject = injector.getInstance(BubbleSort.class);
  }
  
  @Test
  public void verifyRandomOrderList(){
    List<Integer> list = subject.getToSort();
    int max = list.size();
    int i = 0;
    while(i<max){
      System.out.println(list.get(i));
      assertTrue(list.contains(new Integer(i)));
      i++;
    }
  }
  
  @Test
  public void verifySortingHappensList(){
    while(!subject.isDone()){
      subject.getNextFrame();
    }
    int i = 0;
    while(i<subject.getToSort().size()){
      assertTrue(i==subject.getToSort().get(i).intValue());
      i++;
    }
  }
}
