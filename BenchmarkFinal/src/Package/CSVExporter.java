package Package;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    public static void exportToCSV(String fileName, List<BenchmarkResult> results) {
        try (FileWriter writer = new FileWriter(fileName)) {

            writer.append("Algorithm,InputSize,AverageTimeMs\n");

            for (BenchmarkResult r : results) {
                writer.append(r.getAlgorithmName())
                        .append(",")
                        .append(String.valueOf(r.getInputSize()))
                        .append(",")
                        .append(String.valueOf(r.getAverageTimeMs()))
                        .append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
