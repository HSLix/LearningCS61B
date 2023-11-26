package timingtest;

import edu.princeton.cs.algs4.Stopwatch;
import net.sf.saxon.functions.ConstantFunction;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Double> time = new AList<Double>();
        AList<Integer> Ns = new AList<Integer>();
        AList<Integer> opCounts = new AList<Integer>();
        AList<Integer> L = new AList<>();

        int temp = 1000;
        while(temp <= 128000){
            Ns.addLast(temp);
            opCounts.addLast(temp);
            temp *= 2;
        }

        for(int i = 0; i < Ns.size(); i++)
        {
            int N = Ns.get(i);
            int j = 0;
            Stopwatch sw = new Stopwatch();
            while(j < N)
            {
                L.addLast(j);
                j = j+ 1;
            }
            time.addLast(sw.elapsedTime());
        }
        printTimingTable(Ns, time, opCounts);
    }



}
