package largestsubstring;
import java.util.HashMap;
import java.util.Map;

public class Solution 
{
	public int lengthOfLongestSubstring(String s) 
	{
		int max = 0;
		Map<Character, Integer> visited = new HashMap<>();
		for (int right = 0,left=0; right < s.length(); right++) 
		{
			/*
			 * StringBuilder current = new StringBuilder(); for(int j=i;j<s.length();j++) {
			 * if(current.indexOf(String.valueOf(s.charAt(j)))!=-1) { break; }
			 * current.append(s.charAt(j));
			 * 
			 * if(current.length()>max) { max = current.length(); }
			 * 
			 * //same as above max=Math.max(max, current.length()); }
			 */
			
			char current =s.charAt(right);
			if(visited.containsKey(current)&& visited.get(current)>=left)
			{
				left = visited.get(current)+1;
			}
			max = Math.max(max, right - left +1);
			visited.put(current,right);
		}
		return max;
	}
}