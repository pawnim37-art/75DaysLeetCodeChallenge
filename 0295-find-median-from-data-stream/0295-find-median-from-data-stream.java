import java.util.*;

class MedianFinder {

    // Max Heap → smaller half
    PriorityQueue<Integer> left;

    // Min Heap → larger half
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to left
        left.offer(num);

        // Step 2: Move largest element of left to right
        right.offer(left.poll());

        // Step 3: Balance sizes
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}