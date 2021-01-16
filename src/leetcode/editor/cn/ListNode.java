package leetcode.editor.cn;

class ListNode {
    int val;
    ListNode next;

    ListNode(int element) {
        this.val = element;
    }

    static void getAll(ListNode listNode){
        while (listNode != null){
            System.out.println("123");
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}