package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE


    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> list1 = new AListNoResizing<Integer>();
        BuggyAList<Integer> list2 = new BuggyAList<Integer>();

        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);


        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);


        Assert.assertEquals(list1.getLast(), list2.getLast());
        list1.removeLast();
        list2.removeLast();
        Assert.assertEquals(list1.getLast(), list2.getLast());
        list1.removeLast();
        list2.removeLast();
        Assert.assertEquals(list1.getLast(), list2.getLast());
        list1.removeLast();
        list2.removeLast();

    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int last = 0;
                if(L.size() > 0)
                {
                    last = L.getLast();
                    B.getLast();
                }

                System.out.println("getLast: " + last);
            } else if (operationNumber == 2) {
                // size
                if(L.size() > 0) {
                    L.removeLast();
                    B.removeLast();
                }
                System.out.println("removeLast");
            }
        }
    }
}
