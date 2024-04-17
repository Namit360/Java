package leetcode;
import java.util.HashMap;
import java.util.Map;

class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
		/*
		 * for(int i =0;i<nums.length;i++) { for(int j=i+1;j<nums.length;j++) {
		 * if(nums[i]+nums[j]==target) { return new int[] {i,j}; } } } return nums;
		 */
    	Map<Integer, Integer> complements = new HashMap<>(); 
    	for(int i =0;i<nums.length;i++)
        {
        	Integer index =complements.get(nums[i]);
        	if(index!= null)
        	{
        		return new int[] {i, index};
        	}
        	complements.put(target-nums[i], i);
        }
    	return nums;
    }
    public static void main(String args[])
    {
    	Solution sol = new Solution();
    	int[] a = {2,7,11,15};
    	sol.twoSum(a, 9);
    }
}