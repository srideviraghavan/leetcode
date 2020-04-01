class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			throw new RuntimeException("Cant have empty lists");
		}

		ListNode ln = null, headln = null, temp = null;
		int carry = 0, sum = 0;
		int val1 = 0, val2 = 0;

		while (l1 != null || l2 != null) {
			val1 = 0;
			val2 = 0;
			if (l1 != null) {
				val1 = l1.val;
			}
			if (l2 != null) {
				val2 = l2.val;
			}
			sum = val1 + val2 + carry;
			if (sum > 9) {
				carry = sum / 10;
				sum %= 10;
			} else {
				carry = 0;
			}
			temp = new ListNode(sum);
			if (ln == null) {
				ln = temp;
				headln = ln;
			} else {
				ln.next = temp;
				ln = ln.next;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		while (carry != 0) {
			int rem = carry % 10;
			ln.next = new ListNode(rem);
			ln = ln.next;
			carry /= 10;
		}

		return headln;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		ListNode l1 = new ListNode(2);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);

//		ListNode l1 = new ListNode(9);
//
//		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(9);
//		l2.next.next.next = new ListNode(9);
//		l2.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

		ListNode l1 = new ListNode(4);
		l1.next = new ListNode(3);

		ListNode l2 = new ListNode(6);
		l2.next = new ListNode(4);

		sol.addTwoNumbers(l1, l2);
	}
}