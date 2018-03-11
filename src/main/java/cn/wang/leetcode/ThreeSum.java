/**
 * 
 */
package cn.wang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: ThreeSum 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月11日 
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		for(int i=0;i<nums.length-2;i++){
			if(i==0 || (i>0 && nums[i] != nums[i-1])){
				int low = i+1,high=nums.length-1,sum=0-nums[i];
				while(low < high){
					if(nums[low] + nums[high] == sum){
						res.add(Arrays.asList(nums[i],nums[low],nums[high]));
						while(low < high && nums[low] == nums[low+1]) low++;
						while(low < high && nums[high] == nums[high-1]) high--;
						low++;
						high--;
					}else if(nums[low] + nums[high] < sum){
						while(low < high && nums[low] == nums[low+1])low++; 
						low++;
					}else{
						while(low < high && nums[high] == nums[high-1])high--;
						high--;
					}
				}
			}
		}
		return res;
	}
}
