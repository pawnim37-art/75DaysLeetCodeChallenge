class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater element for nums2
        for (int num : nums2) {

            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Remaining elements have no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer array
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}