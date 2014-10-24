package sorts;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class QuickSortTester {

    private QuickSort subject;
    
    @Before
    public void initialize(){
      Injector injector = Guice.createInjector();
      subject = injector.getInstance(QuickSort.class);
    }
    
    @Test
    public void testQuickSortSorts(){
      while(!subject.isDone()){
        subject.getNextFrame();
      }
      List<Integer> sorted = subject.getToSort();
      int i = 0;
      for(Integer integer:sorted){
        assertEquals(i,integer.intValue());
        i++;
      }
    }
}
