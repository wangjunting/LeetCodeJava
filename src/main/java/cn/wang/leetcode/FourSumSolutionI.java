/**
 * 
 */
package cn.wang.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: FourSumSolutionI 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月11日 
 */
public class FourSumSolutionI {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
        
        if(nums == null || nums.length <4)
            return res;
        
        Arrays.sort(nums);
        
        if(4*nums[0] > target || 4*nums[nums.length-1] < target)
            return res;
        
        for(int i=0;i<nums.length-3;i++){
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                for(int j=i+1;j<nums.length-2;j++){
                    if(j == i+1 || (j>i+1 && nums[j]!=nums[j-1])){
                        int low = j+1,high = nums.length-1,sum = target-nums[i]-nums[j];
                        while(low < high){
                            if(nums[low] + nums[high] == sum){
                                res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                                while(low < high && nums[low] == nums[low+1]) low++;
                                while(low < high && nums[high] == nums[high-1]) high--;
                                low++;
                                high--;
                            }else if(nums[low] + nums[high] < sum){
                                while(low < high && nums[low] == nums[low+1]) low++;
                                low++;
                            }else{
                                while(low < high && nums[high] == nums[high-1]) high--;
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
