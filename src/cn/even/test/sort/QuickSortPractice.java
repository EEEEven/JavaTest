package cn.even.test.sort;

import static cn.even.test.Utils.*;

/**
 * @Author 刘义文
 * @Date 2021/3/5 14:55
 */
public class QuickSortPractice {
    public static void main(String[] args) {
        int[] array = new int[]{12, 9, 31, 1, 3, 71, 28, 18};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static int[] quickSort(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            quickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = end;
        int smallIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[pivot]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, smallIndex, i);
                }
            }
        }
        return smallIndex;
    }

}
