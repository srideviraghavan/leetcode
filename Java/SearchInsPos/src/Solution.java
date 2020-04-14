class Solution {
	public int searchInsert(int[] nums, int target) {
		int index = binarySearch(nums, 0, nums.length - 1, target);
		return index;
	}

	private int binarySearch(int[] nums, int low, int high, int target) {
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (low == high) {
			if (target <= nums[low])
				return low;
			else
				return high + 1;
		}

		if (target <= nums[mid]) {
			return binarySearch(nums, low, mid, target);
		} else
			return binarySearch(nums, mid + 1, high, target);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = { 1, 3, 5, 6 };
		int target = 0;
		System.out.println(sol.searchInsert(nums, target));
	}
}