package Package;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class ChartGenerator {

    public static void createChart(List<BenchmarkResult> results, String title) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (BenchmarkResult r : results) {
            // Algoritmul va fi pe axa X (jos)
            dataset.addValue(
                    r.getAverageTimeMs(),
                    String.valueOf(r.getInputSize()),   // serie (grupare)
                    r.getAlgorithmName()               // eticheta jos
            );
        }

        // 🔥 AICI schimbăm din LineChart în BarChart
        JFreeChart chart = ChartFactory.createBarChart(
                title,
                "Algoritmi",        // X
                "Timp (ms)",        // Y
                dataset
        );

        ChartFrame frame = new ChartFrame(title, chart);
        frame.pack();
        frame.setVisible(true);
    }
}