package cn.even.test;

/**
 * @Author 刘义文
 * @Date 2021/2/4 15:38
 */
public class TestBinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 2;
        int begin = 0;
        int end = array.length - 1;
        int mid = (end - begin) / 2;
        while (true) {
            if (array[mid] == target) {
                break;
            } else {
                if (array[mid] < target) {
                    begin = mid;
                } else {
                    end = mid;
                }
            }
            mid = (end - begin) / 2 + begin;
            System.out.println(mid);
        }
        System.out.println(mid);
    }
}