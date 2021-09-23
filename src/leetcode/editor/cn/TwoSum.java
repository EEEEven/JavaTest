package leetcode.editor.cn;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8691 👎 0

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 13);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    class Solution {
        public int[] twoSum(int[] ints, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < ints.length; i++) {
                if (map.containsKey(ints[i])) {
                    Integer index = map.get(ints[i]);
                    return new int[]{index, i};
                }
                map.put(sum - ints[i], i);
            }
            return null;
        }
    }


}
//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果当前下标的值为map中的x键，
            //则当前下标的值+map中x键所对应的值就等于target
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            //key为需要的第二个值，value为第一个值的下标
            map.put(target - nums[i], i);
        }
        return null;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
