package cn.even.test;

/**
 * @Author 刘义文
 * @Date 2020/12/21 17:31
 */
public class Utils {

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 遍历数组
     */
    public static void arrayErgodic(int[] array) {
        for (Integer i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
