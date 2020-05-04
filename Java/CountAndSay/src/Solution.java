class Solution {
	public String countAndSay(int n) {

		String str = "1";

		str = countAndSay(n, str);
		System.out.println(str);
		return str;
	}

	private String countAndSay(int n, String str) {
		if (n == 1) {
			return str;
		}

		str = count(str);
		return countAndSay(n - 1, str);
	}

	private String count(String str) {
		StringBuilder strCount = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			int count = 1;
			for (int j = i; j < str.length() - 1; j++) {
				if (str.charAt(j) == str.charAt(j + 1)) {
					i = j + 1;
					count++;
				} else {
					break;
				}
			}
			strCount.append(count).append(str.charAt(i));
			i++;
		}
		return strCount.toString();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.countAndSay(10);
	}
}