package Package;


public class BenchmarkResult {
    private String algorithmName;
    private int inputSize;
    private double averageTimeMs;

    public BenchmarkResult(String algorithmName, int inputSize, double averageTimeMs) {
        this.algorithmName = algorithmName;
        this.inputSize = inputSize;
        this.averageTimeMs = averageTimeMs;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public int getInputSize() {
        return inputSize;
    }

    public double getAverageTimeMs() {
        return averageTimeMs;
    }

    @Override
    public String toString() {
        return algorithmName + " | Input: " + inputSize + " | Time: " + averageTimeMs + " ms";
    }
}
