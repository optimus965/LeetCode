class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null) {
            ListNode temp = head;
            ListNode second = temp.next;
            ListNode third = null;
            if(second.next != null) {
                third = second.next;
            }
            second.next = temp;
            temp.next = swapPairs(third);
            return second;
        }
        else {
            return head;
        }
    }
}
