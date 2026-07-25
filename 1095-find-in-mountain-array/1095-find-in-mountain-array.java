
 
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeak(mountainArr);

        // Search in ascending part
        int ans = binarySearch(mountainArr, target, 0, peak, true);

        // If not found, search in descending part
        if (ans == -1) {
            ans = binarySearch(mountainArr, target, peak + 1,
                    mountainArr.length() - 1, false);
        }

        return ans;
    }

    // Find Peak Index
    private int findPeak(MountainArray mountainArr) {

        int low = 0;
        int high = mountainArr.length() - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Binary Search
    private int binarySearch(MountainArray mountainArr,
                             int target,
                             int low,
                             int high,
                             boolean isAscending) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (isAscending) {

                if (target < value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {

                if (target < value) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}