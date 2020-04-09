
class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] rangeArr = { -1, -1 };
		if (nums != null && nums.length > 0) {
			binarySearch(nums, 0, nums.length, target, rangeArr);
		}
		return rangeArr;
	}

	private void binarySearch(int[] nums, int low, int high, int target, int[] rangeArr) {
		int mid = (low + high) / 2;
		if (low <= high) {
			if (target == nums[mid]) {
				int first = rangeArr[0];
				int last = rangeArr[1];
				if (first == -1)
					first = mid;
				else
					first = Math.min(mid, first);
				last = Math.max(mid, last);
				rangeArr[0] = first;
				rangeArr[1] = last;
			}
			if (mid != 0 && target <= nums[mid - 1]) {
				binarySearch(nums, low, mid - 1, target, rangeArr);
			}
			if (mid < nums.length - 1 && target >= nums[mid + 1]) {
				binarySearch(nums, mid + 1, high, target, rangeArr);
			}
		}
		return;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 10;
		sol.searchRange(nums, target);
	}
}
