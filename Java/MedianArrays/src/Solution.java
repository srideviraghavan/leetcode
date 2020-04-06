import java.lang.Math;

import javax.management.RuntimeErrorException;

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) {
			throw new RuntimeException("Arrays cannot be empty");
		}
		double median = 0;
		int len = nums1.length + nums2.length;
		int mid = len / 2;
		boolean isEven = false;
		if (len % 2 == 0) {
			isEven = true;
		}

		if (nums1.length == 0) {
			median = returnMedian(nums2, isEven, mid);
		} else if (nums2.length == 0) {
			median = returnMedian(nums1, isEven, mid);
		} else {
			int[] arr = new int[mid+1];
			int a1 = 0, a2 = 0;
			for (int i = 0; i < arr.length; i++) {
				if ((a2 >= nums2.length) || (a1 < nums1.length && nums1[a1] <= nums2[a2])) {
					arr[i] = nums1[a1];
					a1++;
				} else {
					arr[i] = nums2[a2];
					a2++;
				}
			}
			median = returnMedian(arr, isEven, mid);
		}
		return  median;
	}

	private double returnMedian(int[] arr, boolean isEven, int mid) {
		if (isEven) {
			return (arr[mid-1] + arr[mid]) / 2.0;
		}
		return arr[mid];
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.findMedianSortedArrays(new int[] {1,2  }, new int[] {3, 4}));
	}
}