package Package;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 50000};

        var sort = BenchmarkRunner.runSortingBenchmarks(sizes);
        CSVExporter.exportToCSV("sorting.csv", sort);
        ChartGenerator.createChart(sort, "Sorting");

        var cpuGpu = BenchmarkRunner.runCpuVsGpuBenchmark(sizes);
        CSVExporter.exportToCSV("cpu_gpu.csv", cpuGpu);
        ChartGenerator.createChart(cpuGpu, "CPU vs GPU");

        
        Analyzer.analyze(sort);
    }
}