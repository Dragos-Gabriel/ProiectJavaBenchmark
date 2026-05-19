package Package;

import java.util.Random;

public class DataGenerator {

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000);
        }

        return array;
    }

    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }
}
