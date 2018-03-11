/**
 * 
 */
package cn.wang.leetcode;

import java.util.Arrays;

/**
 * @ClassName: ThreeSumClosest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月11日 
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                int low=i+1,high=nums.length-1,sum = target-nums[i];
                while(low < high){
                    int acSum = nums[low] + nums[high];
                    if(acSum == sum)
                        return target;
                    else if(acSum<sum){
                        if(Math.abs(target-acSum-nums[i]) < Math.abs(target-res)){
                            res = acSum+nums[i];    
                        }
                        while(low<high && nums[low] == nums[low+1]) low++;
                        low++;
                    }else{
                        if(Math.abs(target-acSum-nums[i]) < Math.abs(target-res)){
                            res = acSum+nums[i];    
                        }
                        while(low<high && nums[high] == nums[high-1]) high--;
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
