/**
 * 
 */
package cn.wang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: FourSumSolutionII 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月11日 
 */
public class FourSumSolutionII {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        res = kSum_Trim(nums,target,4);
        return res;
    }
    public static List<List<Integer>> kSum_Trim(int[] a, int target, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (a == null || a.length < k || k < 2) return result;
        Arrays.sort(a);
        kSumTrimSolution(a, target, k, 0, result, new LinkedList<Integer>());
        return result;
    }

    public static void kSumTrimSolution(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;

        if (k == 2) {                        // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if      (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new LinkedList<Integer>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++; right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        }
        else {                        // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) continue;
                if (a[i] + max * (k - 1) < target) continue;
                if (a[i] * k > target) break;
                if (a[i] * k == target) {
                    if (a[i + k - 1] == a[i]) {
                        result.add(new LinkedList<Integer>(path));
                        List<Integer> temp = new LinkedList<Integer>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        result.get(result.size() - 1).addAll(temp);    // Add result immediately.
                    }
                    break;
                }
                path.add(a[i]);
                kSumTrimSolution(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);        // Backtracking
            }
        }
    }
    
    public static void main(String args[]){
    	int[] a= {1,0,-1,0,-2,2};
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	res = fourSum(a,0);
    	for(int i=0;i<res.size();i++)
    		System.out.println(res.get(i));
    }
}
