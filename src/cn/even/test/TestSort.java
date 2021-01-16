package cn.even.test;

import java.util.*;

import static cn.even.test.Utils.*;


public class TestSort {
    public static void main(String[] args) {
        Integer[] ints = {5, 12, 2, 98, 19, 25, 1, 67, 32};
//        testBubbleSortReverse(ints);
        testRandomInput(ints);
        arrayErgodic(ints);

    }


    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static Integer[] CountingSort(Integer[] array) {
        if (array.length == 0) {
            return array;
        }
        Integer bias, min = array[0], max = array[0];
        for (Integer i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        bias = 0 - min;
        Integer[] bucket = new Integer[max - min + 1];
        Arrays.fill(bucket, 0);
        for (Integer i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        Integer index = 0, i = 0;
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
     * 插入排序
     * <p>
     * 从左向右扫描 每个num都会与num-n(n = 1;n++)进行比较，
     * 当num-n大于num时，就将num-n向后挪一位；
     * 当num-n小于num时，就将num插入到num-n后方；
     *
     * @param array
     */
    public static void testInsertionSort(Integer[] array) {
        //外层控制次数 第一个数不参与比较
        for (Integer i = 1; i < array.length; i++) {
            Integer temp = array[i];
            Integer j;
            //与前面的数依次比较，如果前面的数大于当前数 就将前面的数往后推一格
            for (j = i - 1; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
            }
            //当前面的这个数小于当前数时，将当前数插入到此数后方
            array[j + 1] = temp;
            //已完成一个数的排序
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
    public static Integer[] testQuickSort(Integer[] array, Integer start, Integer end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        //选取一个数作为基数pivot，从start到end，都依次与pivot进行比较;
        //本次以随机数作为基数
        Integer pivot = (int) (start + Math.random() * (end - start + 1));
        //创建一个初始值为start-1的smallIndex作为标记;
        Integer smallIndex = start - 1;
        //将end与pivot交换位置,方便比较;
        swap(array, pivot, end);
        for (Integer i = start; i <= end; i++) {
            //如果当前下标i对应的元素大于pivot对应的元素,直接进入下一次迭代;
            //如果当前下标i对应的元素小于等于pivot对应的元素,smallIndex+1;
            //如果当前下标i对应的元素等于pivot对应的元素，则为最后一次迭代,
            //也就是将end元素与smallIndex元素交换位置,即将所有大于基数pivot的元素全部置右;
            if (array[i] <= array[end]) {
                smallIndex++;
                //再判断i值是否大于smallIndex值,大于则将i和smallIndex两个所对应的元素交换位置;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        //再将smallIndex作为分界点,进行递归排序
        if (smallIndex > start) {
            testQuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            testQuickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    /**
     * @param ints
     */
    public static void testBubbleSortReverse(Integer[] ints) {
        for (Integer i = 0; i < ints.length - 1; i++) {
            for (Integer j = ints.length - 1; j > 0 + i; j--) {
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
    public static void testBubbleSort(Integer[] ints) {
        //外层控制排序次数
        for (Integer i = 0; i < ints.length - 1; i++) {
            //内层控制本次排序比较的次数
            for (Integer j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    swap(ints, j, j + 1);
                }
            }
        }
    }

    public static void testEZBucketSort(Integer[] ints) {
        Integer[] scores = new Integer[11];
        for (Integer i = 0; i < ints.length; i++) {
            scores[ints[i]]++;
        }
//        for (Integer i = 0; i <= scores.length; i++) {
        for (Integer i = 10; i >= 0; i--) {
            for (Integer j = 0; j < scores[i]; j++) {
                System.out.print(i + ".");
            }
        }
    }

    public static void testRandomInput(Integer[] ints) {
        Random random = new Random();
        Integer num = 0;
        Integer count = 0;
        Integer bound = ints.length;
        while (true) {
            num = random.nextInt(bound);
            System.out.println(ints[num]);
            if (bound == 1) {
                return;
            }
            Integer[] newInts = new Integer[--bound];
            for (Integer i = 0; i < newInts.length; i++) {
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
