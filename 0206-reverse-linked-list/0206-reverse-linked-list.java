class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // store next node
            current.next = prev;          // reverse link
            prev = current;               // move prev forward
            current = next;               // move current forward
        }

        return prev; // new head
    }
}