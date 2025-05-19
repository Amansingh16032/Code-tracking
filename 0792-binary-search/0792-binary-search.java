class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid; // Found the target

            }else if(nums[mid] < target) {
                low = mid + 1; // Search in right half
            } else {
                high = mid - 1; // Search in left half
            }
        }
        return -1;  // Target not found
    }
}