import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> indicesList = new ArrayList<Integer>();
		if (s != null && !"".equals(s) && words.length != 0) {
			Map<String, Long> wordsMap = Stream.of(words)
					.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
			int len = words[0].length();
			int sentenceLen = len * words.length;
			boolean isFound = false;
			String substr = null;
			Map<String, Long> tempMap = null;
			int index = 0;
			tempMap = new HashMap<String, Long>(wordsMap);
			for (int i = 0; i <= s.length() - len; i++) {
				tempMap = new HashMap<String, Long>(wordsMap);
				isFound = false;
				for (int j = i; j + len <= s.length() && j < i + sentenceLen; j = j + len) {
					substr = s.substring(j, j + len);
					if (tempMap.containsKey(substr)) {
						long value = tempMap.get(substr);
						value--;
						if (value == 0) {
							tempMap.remove(substr);
						} else {
							tempMap.put(substr, value);
						}
						if (!isFound) {
							index = i;
						}
						isFound = true;
					} else {
						break;
					}

				}
				if (tempMap.isEmpty() && isFound) {
					indicesList.add(index);
				}

			}
		}

		return indicesList;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		String[] words = new String[] { "foo", "bar" };
//		String[] words = new String[] {"word","good","best","good"};
//		String[] words = new String[] { "cat", "ate", "bat" };
//		String[] words = new String[] { "ab", "ab", "cd" };
//		String[] words = new String[] {"ab", "ab"};
//		String[] words = new String[] { "fooo", "barr", "wing", "ding", "wing" };
//		String[] words = new String[] { "a" };
//		String[] words = new String[] { "aa", "aa" };
		String[] words = new String[] { "mississippis" };
//		sol.findSubstring("barfoothefoobarman", words);
//		sol.findSubstring("wordgoodgoodgoodbestword", words);
//		sol.findSubstring("wordgoodgoodbestword", words);
//		sol.findSubstring("catbatatecatatebat", words);
//		sol.findSubstring("abcdababcd", words);
//		sol.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", words);
//		sol.findSubstring("a", words);
//		sol.findSubstring("aaa", words);
		sol.findSubstring("mississippi", words);
	}
}