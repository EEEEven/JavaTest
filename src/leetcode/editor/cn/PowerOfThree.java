package leetcode.editor.cn;

//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你能不使用循环或者递归来完成本题吗？ 
// 
// Related Topics 递归 数学 
// 👍 190 👎 0


/*
 * 3的幂
 */
class PowerOfThree {
    public static void main(String[] args) {
//        String s = "2819";
//        System.out.println(Arrays.asList(s.split("")));
//        System.out.println(s.toCharArray());
//        boolean powerOfThree = isPowerOfThree(2147483647);
        boolean powerOfThree = isPowerOfThree2(-3);
        System.out.println(powerOfThree);
    }

    public static boolean isPowerOfThree2(int n) {
        while (n > 2) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            char[] chars = Integer.valueOf(n).toString().toCharArray();
            int tempNum = 0;
            for (char c : chars) {
                tempNum += c;
            }
            if (tempNum % 3 > 0) {
                return false;
            }
            tempNum = 1;
            while (tempNum < n) {
                tempNum *= 3;
            }
            if (tempNum == n) {
                return true;
            } else {
                return false;
            }
        }
    }
}

/*//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 2) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)*/

