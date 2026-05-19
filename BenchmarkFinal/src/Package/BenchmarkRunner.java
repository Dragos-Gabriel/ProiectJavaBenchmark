package Package;

import java.util.ArrayList;
import java.util.List;

public class BenchmarkRunner {

    private static final int RUNS = 5;

    public static List<BenchmarkResult> runSortingBenchmarks(int[] sizes) {
        List<BenchmarkResult> results = new ArrayList<>();

        for (int size : sizes) {
            int[] baseArray = DataGenerator.generateRandomArray(size);

            results.add(testSort("Bubble", baseArray, size, "bubble"));
            results.add(testSort("Insertion", baseArray, size, "insertion"));
            results.add(testSort("Merge", baseArray, size, "merge"));
            results.add(testSort("Quick", baseArray, size, "quick"));
            results.add(testSort("Java", baseArray, size, "java"));
        }

        return results;
    }

    private static BenchmarkResult testSort(String name, int[] baseArray, int size, String type) {
        long totalTime = 0;

        for (int i = 0; i < RUNS; i++) {
            int[] arr = DataGenerator.copyArray(baseArray);

            long start = System.nanoTime();

            switch (type) {
                case "bubble": SortAlgorithms.bubbleSort(arr); break;
                case "insertion": SortAlgorithms.insertionSort(arr); break;
                case "merge": SortAlgorithms.mergeSort(arr); break;
                case "quick": SortAlgorithms.quickSort(arr, 0, arr.length - 1); break;
                case "java": SortAlgorithms.javaSort(arr); break;
            }

            long end = System.nanoTime();
            totalTime += (end - start);
        }

        return new BenchmarkResult(name, size, (totalTime / RUNS) / 1_000_000.0);
    }

    public static List<BenchmarkResult> runCpuVsGpuBenchmark(int[] sizes) {
        List<BenchmarkResult> results = new ArrayList<>();

        for (int size : sizes) {
            int[] arr = DataGenerator.generateRandomArray(size);

            results.add(testCpuGpu("CPU", arr, size, true));
            results.add(testCpuGpu("GPU(simulated)", arr, size, false));
        }

        return results;
    }

    private static BenchmarkResult testCpuGpu(String name, int[] baseArray, int size, boolean cpu) {
        long total = 0;

        for (int i = 0; i < RUNS; i++) {
            int[] arr = DataGenerator.copyArray(baseArray);

            long start = System.nanoTime();

            if (cpu) GpuSimulator.cpuSort(arr);
            else GpuSimulator.gpuSort(arr);

            long end = System.nanoTime();
            total += (end - start);
        }

        return new BenchmarkResult(name, size, (total / RUNS) / 1_000_000.0);
    }
}