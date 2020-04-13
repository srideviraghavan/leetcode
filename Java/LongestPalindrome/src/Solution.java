class Solution {
	public String longestPalindromeTimeOut(String s) {
		String palindromeStr = "";
		int startIndex = -1, endIndex = -1, diff = -1;
		boolean isPalindrome = false;
		if (s != null && s.length() > 0) {
			for (int i = 0; i < s.length(); i++) {
				for (int j = s.length() - 1; j >= i; j--) {
					isPalindrome = true;
					for (int x = i, y = j; x <= y; x++, y--) {
						if (s.charAt(x) != s.charAt(y)) {
							isPalindrome = false;
							break;
						}
					}
					if (isPalindrome) {
						if (diff < j - i) {
							startIndex = i;
							endIndex = j;
							diff = endIndex - startIndex;
							palindromeStr = s.substring(startIndex, endIndex + 1);
						}
					}
				}
			}
		}
		return palindromeStr;
	}

	public String longestPalindrome(String s) {
		String palindrome = "";
		if (s != null && !"".equals(s)) {
			int startIndex = 0, endIndex = 0;
			int len1, len2, len;
			for (int i = 0; i < s.length(); i++) {
				len1 = expandFromMiddle(s, i, i);
				len2 = expandFromMiddle(s, i, i + 1);
				len = Math.max(len1, len2);
				if (len > endIndex - startIndex) {
					startIndex = i - (len - 1) / 2;
					endIndex = i + len / 2;
				}
			}
			palindrome = s.substring(startIndex, endIndex + 1);
		}

		return palindrome;
	}

	private int expandFromMiddle(String s, int i, int j) {
		int left, right;
		for (left = i, right = j; left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right); left--, right++)
			;

		return right - left - 1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "ac";
		System.out.println(sol.longestPalindrome(s));
	}
}