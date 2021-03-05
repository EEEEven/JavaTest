package cn.even.test.sort;

import java.util.*;

import static cn.even.test.Utils.*;


public class TestSort {
    public static void main(String[] args) {
        int[] ints = {12, 9, 5, 2};
//        int[] ints = {2, 5, 9, 12};
//        testBubbleSortReverse(ints);
//        testRandomInput(ints);
//        arrayErgodic(ints);
        testQuickSort(ints, 0, ints.length - 1);
//        mergeSort(ints, ints.length);
//        testSelectionSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }


    /**
     * 插入排序
     * <p>
     * 插入排序将数组数据分成已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，即数组第一个元素。
     * 在未排序区间取出一个元素插入到已排序区间的合适位置，直到未排序区间为空。
     *
     * @param array
     */
    public static void testInsertionSort(int[] array) {
        //外层控制次数 第一个数不参与比较
        for (int i = 1; i < array.length; i++) {
            int tempValue = array[i];
            int j = i - 1;
            //与前面的数依次比较，如果前面的数大于当前数 就将前面的数往后推一格
            for (; j >= 0; j--) {
                if (array[j] > tempValue) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            //当前面的这个数小于当前数时，将当前数插入到此数后方
            array[j + 1] = tempValue;
            //已完成一个数的排序
        }
    }

    /**
     * 选择排序
     * <p>
     * 选择排序将数组分成已排序区间和未排序区间。
     * 初始已排序区间为空。
     * 每次从未排序区间中选出最小的元素插入已排序区间的末尾，直到未排序区间为空。
     *
     * @param array
     */
    public static void testSelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //找到最小的
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // 归并排序算法, a是数组，n表示数组大小
    public static void mergeSort(int[] array, int n) {
        mergeSortInternally(array, 0, n - 1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] array, int startIndex, int endIndex) {
        // 递归终止条件
        if (startIndex >= endIndex) {
            return;
        }

        // 取startIndex到endIndex之间的中间位置q
        int midIndex = (startIndex + endIndex) / 2;
        // 分治递归
        mergeSortInternally(array, startIndex, midIndex);
        mergeSortInternally(array, midIndex + 1, endIndex);

        // 将array[startIndex...endIndex]和array[midIndex+1...endIndex]合并为array[startIndex...endIndex]
        merge(array, startIndex, midIndex, endIndex);
    }

    private static void merge(int[] array, int startIndex, int midIndex, int endIndex) {
        int i = startIndex;
        int j = midIndex + 1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[endIndex - startIndex + 1]; // 申请一个大小跟array[startIndex...endIndex]一样的临时数组

        // 1 排序
        while (i <= midIndex && j <= endIndex) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = array[j++];
            }
        }

        // 2 判断哪个子数组中有剩余的数据
        int start = i;
        int end = midIndex;
        if (j <= endIndex) {
            start = j;
            end = endIndex;
        }

        // 3 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = array[start++];
        }

        // 4 将tmp中的数组拷贝回array[startIndex...endIndex]
        for (i = 0; i <= endIndex - startIndex; ++i) {
            array[startIndex + i] = tmp[i];
        }
    }




    /**
     * 快速排序方法
     * <p>
     * 运用到了分治思想
     * 通过一个基数pivot，将小于pivot的元素左置，大于pivot的元素右置
     * 再通过递归将 小于基数pivot的子数组和大于基数pivot的子数组 进行排序
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] testQuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        //再将smallIndex作为分界点,进行递归排序
        if (smallIndex > start) {
            testQuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            testQuickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    public static int partition(int[] array, int start, int end){
        //选取一个数作为基数pivot，从start到end，都依次与pivot进行比较;
        int pivot = end;
        //创建一个初始值为start-1的smallIndex作为标记;
        int smallIndex = start - 1;
        for (int i = start; i <= end; i++) {
            //如果当前下标i对应的元素大于pivot对应的元素,直接进入下一次迭代;
            //如果当前下标i对应的元素小于等于pivot对应的元素,smallIndex+1;
            //如果当前下标i对应的元素等于pivot对应的元素，则为最后一次迭代,
            //也就是将end元素与smallIndex元素交换位置,即将所有大于基数pivot的元素全部置右;
            if (array[i] <= array[pivot]) {
                smallIndex++;
                //再判断i值是否大于smallIndex值,大于则将i和smallIndex两个所对应的元素交换位置;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
            return smallIndex;
    }


    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return array;
    }

    /**
     * @param ints
     */
    public static void testBubbleSortReverse(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = ints.length - 1; j > 0 + i; j--) {
                if (ints[j] < ints[j - 1]) {
                    swap(ints, j, j - 1);
                }
            }
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 顾名思义,就像水中的气泡,大的往上冒;
     * 将数组逆时针旋转90°就
     * 两数比较,大的右置;
     *
     * @param ints
     */
    public static void testBubbleSort(int[] ints) {
        //外层控制排序次数
        for (int i = 0; i < ints.length - 1; i++) {
            //内层控制本次排序比较的次数
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    swap(ints, j, j + 1);
                }
            }
        }
    }

    public static void testEZBucketSort(int[] ints) {
        int[] scores = new int[11];
        for (int i = 0; i < ints.length; i++) {
            scores[ints[i]]++;
        }
//        for (int i = 0; i <= scores.length; i++) {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < scores[i]; j++) {
                System.out.print(i + ".");
            }
        }
    }

    public static void testRandomInput(int[] ints) {
        Random random = new Random();
        int num = 0;
        int count = 0;
        int bound = ints.length;
        while (true) {
            num = random.nextInt(bound);
            System.out.println(ints[num]);
            if (bound == 1) {
                return;
            }
            int[] newInts = new int[--bound];
            for (int i = 0; i < newInts.length; i++) {
                if (i >= num) {
                    newInts[i] = ints[i + 1];
                    continue;
                }
                newInts[i] = ints[i];
            }
            ints = newInts;
        }
    }

}
