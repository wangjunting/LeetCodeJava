/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: GuessNumberHigherOrLowerII 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月7日 
 */
public class GuessNumberHigherOrLowerII {
	public static int getMoneyAmount(int n){
		int[][] table = new int[n+1][n+1];
		return DP(table,1,n);
	}
	
	public static int DP(int[][] t,int s,int e){
		if(s>=e) return 0;
		if(t[s][e]>0) return t[s][e];
		int res=Integer.MAX_VALUE;
		for(int i=s;i<=e;i++){
			int temp = i+Math.max(DP(t,s,i-1), DP(t,i+1,e));
			res = Math.min(res, temp);
		}
		
		return res;
	}
	
	public static void main(String args[]){
		System.out.println(getMoneyAmount(5));
	}
}
