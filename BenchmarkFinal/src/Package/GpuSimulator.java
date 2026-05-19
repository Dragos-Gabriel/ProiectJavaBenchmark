package Package;

public class GpuSimulator {

    public static void gpuSort(int[] arr) {
        try {
            Thread.sleep(arr.length / 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void cpuSort(int[] arr) {
        SortAlgorithms.javaSort(arr);
    }
}
