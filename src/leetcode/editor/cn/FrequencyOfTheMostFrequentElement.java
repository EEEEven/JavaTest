package leetcode.editor.cn;

//元素的 频数 是该元素在一个数组中出现的次数。 
//
// 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。 
//
// 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,4], k = 5
//输出：3
//解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
//4 是数组中最高频元素，频数是 3 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,8,13], k = 5
//输出：2
//解释：存在多种最优解决方案：
//- 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
//- 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
//- 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,9,6], k = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 1 <= k <= 105 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 121 👎 0


import java.util.Arrays;

/*
 * 最高频元素的频数
 */
class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
//        int[] array = new int[]{1, 4, 8, 13};
        int[] array = new int[]{1, 2, 4};
        int i = maxFrequency(array, 5);
        System.out.println(i);
    }

    /*
    # 滑动窗口模板
    left,right = 0, (0 or 1)
    res = total = 0
    while right < len(nums):
       更新total值
       while 窗口内数据不满足要求
          1. 更新total值
          2. 收缩左边界
       更新res最大值
    返回 res
     */

    public static int maxFrequency(int[] nums, int k) {
        int left = 0;
        int total = 0;
        int res = 1;
        Arrays.sort(nums);
        for (int right = 1; right < nums.length; right++) {
            //right - left 为窗口内除最大数的个数总和
            //(right - left) *
            total += (right - left) * (nums[right] - nums[right - 1]);
            //窗口内数据需要的操作次数大于k，即窗口内的数据不满足要求
            while (total > k) {
                //因为nums是已排过序的数组，所以right在窗口内总是最大的，即right-left=需要减掉的操作数.
                total -= nums[right] - nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}

//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int total = 0;
        int res = 1;
        Arrays.sort(nums);
        for (int right = 1; right < nums.length; right++) {
            //right - left 为窗口内除最大数的个数总和
            //(right - left) *
            total += (right - left) * (nums[right] - nums[right - 1]);
            //窗口内数据需要的操作次数大于k，即窗口内的数据不满足要求
            while (total > k) {
                //因为nums是已排过序的数组，所以right在窗口内总是最大的，即right-left=需要减掉的操作数.
                total -= nums[right] - nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)

