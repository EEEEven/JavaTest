package cn.even.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 刘义文
 * @Date 2020/12/21 17:32
 */
public class TestMath {

    /**
     * 汉诺塔
     *
     * @param n    盘子个数
     * @param from 起始柱子
     * @param temp 中间柱子
     * @param to   目标柱子
     *             无论有多少个盘子，都认为只有两个。上面的所有盘子 和 最下面一个盘子。
     */
    public static void hanoi(Integer n, char from, char temp, char to) {
        if (n == 1) {
            System.out.println("第1个盘子从" + from + "移到" + to);
        } else {
            //将 “上面的所有盘子（n-1）” 移动到中间柱子
            hanoi(n - 1, from, to, temp);
            System.out.println("第" + n + "个盘子从" + from + "移到" + to);
            //将“上面的所有盘子（n-1）“从中间柱子移动到目标柱子
            hanoi(n - 1, temp, from, to);
        }
    }

    /**
     * 斐波那契数列：1 1 2 3 5 8 13 21
     */
    public static Integer fibonacci(Integer i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }

    private static List<Integer> rankToStudentDataRights(List<Integer> integerList) {
        List<Integer> list = new ArrayList<>();
        if(integerList.contains(2)){
            list.add(4);
        }
        if(integerList.contains(3)){
            list.add(3);
        }
        if(integerList.contains(4)){
            list.add(0);
        }
        if(integerList.contains(5)){
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> list1 = rankToStudentDataRights(list);
        System.out.println(list.toString());
        System.out.println(list1.toString());
    }

















}
