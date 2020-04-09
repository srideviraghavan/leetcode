class Solution {
	public int search(int[] nums, int target) {
		int index = -1;
		if (nums != null && nums.length > 0) {
			int pivotIndex = pivot(nums);
			if (pivotIndex == -1) {
				index = binarySearch(nums, 0, nums.length - 1, target);
			} else if (target < nums[0]) {
				index = binarySearch(nums, pivotIndex + 1, nums.length - 1, target);
			} else {
				index = binarySearch(nums, 0, pivotIndex, target);
			}
		}
		return index;
	}

	private int pivot(int[] nums) {
		int pivotIndex = -1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return i;
			}
		}

		return pivotIndex;
	}

	private int binarySearch(int[] nums, int i, int j, int target) {
		int mid = (i + j) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (j < i || mid == nums.length - 1) {
			return -1;
		}
		if (target < nums[mid])
			return binarySearch(nums, i, mid - 1, target);
		return binarySearch(nums, mid + 1, j, target);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
//		int[] nums = { 1, 3 };
//		int[] nums = {  3, 1 };
		int[] nums = {  3, 5, 1 };
//		int target = 0;
		int target = 3;
		sol.search(nums, target);
	}
}
