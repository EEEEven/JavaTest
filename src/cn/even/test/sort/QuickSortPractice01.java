package cn.even.test.sort;

import static cn.even.test.Utils.swap;

/**
 * @Author 刘义文
 * @Date 2021/3/5 14:55
 */
public class QuickSortPractice01 {
    public static void main(String[] args) {
        int[] array = new int[]{12, 9, 31, 19, 23, 8, 72, 47, 30, 56, 91, 14};
        //9,12,31
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static int[] quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int pivot = array[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && array[r] >= pivot) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] < pivot) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = pivot;

        quickSort(array, start, l - 1);
        quickSort(array, l + 1, end);
        return array;
    }
}
