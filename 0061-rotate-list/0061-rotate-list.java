/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // If list is empty, has one node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length of list
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Step 3: Connect tail to head (make circular)
        tail.next = head;

        // Step 4: Find new tail
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: New head
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}