package leetcode.editor.cn;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4750 👎 0

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(6);

        listNode1.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode2 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(7);

        listNode2.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);

        ListNode.getAll(listNode);

    }

    /**
     * 从个位数开始计算
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int n = l1.val + l2.val;
        return null;
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 从个位数开始计算
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode resultNode = new ListNode(0);
            //存储相加结果
            int sum;
            //进位
            int more = 0;
            ListNode tempNode = resultNode;
            while (l1 != null || l2 != null || more > 0) {
                sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + more;
                more = sum / 10;
                sum %= 10;
                tempNode.next = new ListNode(sum);
                tempNode = tempNode.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            return resultNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
