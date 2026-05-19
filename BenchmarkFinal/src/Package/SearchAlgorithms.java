package Package;

public class SearchAlgorithms {

    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == value) return mid;
            else if (arr[mid] < value) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}