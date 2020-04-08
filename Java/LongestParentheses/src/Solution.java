import java.util.Stack;
import java.lang.Math;

class Solution {
	public int longestValidParentheses(String s) {
		int ct = 0;
		if (s != null && !"".equals(s)) {
			char[] ch = s.toCharArray();
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(-1);
			for (int i = 0; i < ch.length; i++) {
				if (ch[i] == '(') {
					stack.push(i);
				}
				if (ch[i] == ')') {
					stack.pop();
					if (stack.isEmpty()) {
						stack.push(i);
					}
					ct = Math.max(ct, i - (int) stack.peek());
				}
			}
		}
		return ct;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		String s = ")()())";
		String s = "(())";
		System.out.println(sol.longestValidParentheses(s));
	}
}
