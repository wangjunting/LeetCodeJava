/**
 * 
 */
package cn.wang.leetcode;

import java.util.HashMap;

/**
 * @ClassName: LongestSubstringWithoutRepeatingCharacters 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月23日 
 */
public class LongestSubstringWithoutRepeatingCharacters {
	 public static int lengthOfLongestSubstring(String s) {
	        if(s.length() <= 1) return s.length();
	        int max =0;
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        for(int i=0,j=0;i<s.length();i++){
	            if(map.containsKey(s.charAt(i))){
	                j = Math.max(j, map.get(s.charAt(i))+1);
	            }
	            map.put(s.charAt(i),i);
	            max= Math.max(max,i-j+1);
	        }
	        return max;
	    }
	 
	 public static void main(String args[]){
		 String s = "abba";
		 System.out.println(lengthOfLongestSubstring(s));
	 }
}
