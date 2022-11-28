import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

class startsWithA implements StringChecker{
    
    public boolean checkString(String s) {
        if (s.substring(0, 1).equals("a") || s.substring(0, 1).equals("A")) {
            return true;
        }
        return false;
    }

}

public class TestListExamples {

  // Write your grading tests here!

  @Test(timeout = 1000)
  public void testFilter() {
        List<String> list1 = new ArrayList<>();
        startsWithA aStart = new startsWithA();
        list1.add("apple");
        list1.add("ball");
        list1.add("cat");
        list1.add("ant");
        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("ant");

        assertEquals(list2, ListExamples.filter(list1, aStart));
       
    }

    @Test(timeout = 1000)
    public void testFilterEmptyResult() {
        List<String> list1 = new ArrayList<>();
        startsWithA aStart = new startsWithA();
        list1.add("banana");
        list1.add("melon");
        list1.add("pineapple");
          
        List<String> list2 = new ArrayList<>();
        assertEquals(list2, ListExamples.filter(list1, aStart));
      }

    @Test (timeout = 1000)
    public void testMerge() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        list1.add("a");
        list1.add("d");
        list1.add("e");
        list2.add("b");
        list2.add("c");
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("d");
        expected.add("e");
        
        assertEquals(expected, ListExamples.merge(list1, list2));
    }

    @Test (timeout = 1000)
    public void testMergeEmptyList() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        list1.add("a");
        list1.add("d");
        list1.add("e");
        expected.add("a");
        expected.add("d");
        expected.add("e");
        
        assertEquals(expected, ListExamples.merge(list1, list2));
    }
}
