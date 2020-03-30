import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target){
    	HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
    	int diff = 0, index=0;
    	for(int num: nums)
    	{
    		diff = target - num;
    		if(hMap.containsKey(num))
    		{
    			return(new int[] {hMap.get(num), index});
    		}
    		hMap.put(diff, index);
    		index++;
    	}
        throw new RuntimeException("No two sums match the target");
    }
    
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		Arrays.stream(sol.twoSum(nums, target)).forEach(n -> {System.out.print(n); System.out.print(" ");});
	}
}