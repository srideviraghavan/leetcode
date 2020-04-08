import java.util.Arrays;

class Solution {
	public void nextPermutation(int[] nums) {
		if (nums != null && nums.length > 1) {
			boolean isSwapped = false;
			for (int i = nums.length - 2; i >= 0 && !isSwapped; i--) {
				for (int j = nums.length - 1; j > i; j--) {
					if (nums[i] < nums[j]) {
						swap(nums, i, j);
						reverse(nums, i + 1);
						isSwapped = true;
						break;
					}
				}
			}

			if (!isSwapped) {
				reverse(nums, 0);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void reverse(int[] nums, int i) {
		for (int x = i, j = nums.length - 1; x < j; x++, j--) {
			swap(nums, x, j);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		int[] nums = { 1, 2, 3 };
//		int[] nums = {1,1,2,1};
//		int[] nums = {1,1,1,1};
		int[] nums = { 3, 2, 1 };
//		int[] nums = {1,1,5};
//		int[] nums = { 3, 3, 2, 2, 5, 5 };
//		int[] nums = { 1, 3,  2};
		sol.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
