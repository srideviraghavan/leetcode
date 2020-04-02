import java.util.HashMap;
import java.lang.Math;

class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int len = 0;
    	HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
    	char ch;
    	for(int i=0, j=0; i < s.length(); i++)
    	{
    		ch = s.charAt(i);
    		if(hMap.containsKey(ch))
    		{
    			j = Math.max(hMap.get(ch), j);
    		}
    		len = Math.max(len, i-j+1);
    		hMap.put(ch, i+1);
    	}
    	return len;
    }
    
    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.lengthOfLongestSubstring("abcabcdabcde"));
	}
}