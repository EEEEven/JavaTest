package cn.even.test;

/**
 * @Author 刘义文
 * @Date 2021/2/4 17:12
 */
public class TestFibonacci {

    //1,1,2,3,5,8,13,21

    public static void main(String[] args) {
        System.out.println(fibonacci(50));;
    }

    static Integer fibonacci(int index) {
        if (index <= 0) {
            return null;
        }
        if (index == 1 || index == 2) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }

    }


}
