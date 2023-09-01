package IntList;

public class IntListExercises {

    /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
        while (head!= null) {
            head.first += c;
            head = head.rest;
        }
    }

    /**
     * Part B: Buggy method that sets node.first to zero if
     * the max value in the list starting at node has the same
     * first and last digit, for every node in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))){
                p.first = 0;
            }
            p = p.rest;
        }
    }

    /** Returns the max value in the IntList starting at L. */
    public static int max(IntList L) {
        int max = L.first;
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }

    /** Returns true if the last digit of x is equal to
     *  the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        int lastDigit = x % 10;
        while (x >= 10) {
            x = x / 10;
        }
        int firstDigit = x % 10;
        return firstDigit == lastDigit;
    }

    /**
     * Part C: (Buggy) mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
    public static boolean squarePrimes(IntList lst) {
        // Base Case: we have reached the end of the list
        if (lst == null) {
            return false;
        }

        boolean currElemIsPrime = Primes.isPrime(lst.first);

        if (currElemIsPrime) {
            lst.first *= lst.first;
        }

        return squarePrimes(lst.rest) || currElemIsPrime;
    }

    public static void main(String[] args) {

        /** Below this line is the starter Code*/
        //IntList lst = new IntList(1, new IntList(2, new IntList(3, null)));
        // Creates an empty list!
        IntList empty = IntList.of();
        // Creates an IntList one element, 7
        IntList oneElem = IntList.of(7);
        // Creates an IntList with many elements
        IntList manyElems = IntList.of(5, 4, 3, 2, 1);

        /* Expected Behavior */

        IntList lst = IntList.of(1, 2, 3);

        addConstant(lst, 1);
        System.out.println(lst.toString());
        // Output: 2 -> 3 -> 4

        addConstant(lst, 4);
        System.out.println(lst.toString());
        // Output: 6 -> 7 -> 8

    }
}
