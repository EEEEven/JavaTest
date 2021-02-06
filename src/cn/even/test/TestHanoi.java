package cn.even.test;

/**
 * @Author 刘义文
 * @Date 2021/2/5 15:37
 */
public class TestHanoi {

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }

    static void hanoi(int index, char from, char temp, char to) {
        if (index == 1) {
            System.out.println("将第1个圆盘从" + from + "移到" + to);
        } else {
            hanoi(index - 1, from, to, temp);
            System.out.println("将第" + index + "个圆盘从" + from + "移到" + to);
            hanoi(index - 1, temp, from, to);
        }
    }

}
