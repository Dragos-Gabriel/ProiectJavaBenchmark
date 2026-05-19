package Package;

import java.util.List;

public class Analyzer {

    public static void analyze(List<BenchmarkResult> results) {

        System.out.println("\n===== ANALIZA =====");

        for (BenchmarkResult r : results) {
            if (r.getAverageTimeMs() < 1) {
                System.out.println(r.getAlgorithmName() + " este FOARTE rapid.");
            } else if (r.getAverageTimeMs() < 10) {
                System.out.println(r.getAlgorithmName() + " este rapid.");
            } else {
                System.out.println(r.getAlgorithmName() + " este lent.");
            }
        }

        System.out.println("\nObservatii:");
        System.out.println("- O(n log n) > O(n^2)");
        System.out.println("- Binary Search > Linear Search");
        System.out.println("- Binary Search + GPU > Binary Search + CPU > Linear Search + GPU > Linear Search + CPU");
    }
}
