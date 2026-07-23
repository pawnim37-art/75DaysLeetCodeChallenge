class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev points to last unique node
        ListNode prev = dummy;

        while (head != null) {

            // Check if duplicate exists
            if (head.next != null && head.val == head.next.val) {

                // Skip all duplicate nodes
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                // Remove all duplicates
                prev.next = head.next;

            } else {
                // Current node is unique
                prev = prev.next;
            }

            // Move head
            head = head.next;
        }

        return dummy.next;
    }
}