/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: ZigZagConversion 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年4月9日 
 */
public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		char[] c=s.toCharArray();
		int len=c.length;
		StringBuffer[] sb=new StringBuffer[numRows];
		for(int i=0;i<numRows;i++)
			sb[i]=new StringBuffer();
		int i=0;
		while(i<len){
			for(int idx=0;idx<numRows && i<len;idx++)
				sb[idx].append(c[i++]);
			for(int idx=numRows-2;idx>0 && i<len;idx--)
				sb[idx].append(c[i++]);
		}
		for(int idx=1;idx<numRows;idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}
	
	public static void main(String args[]){
		String s="PAYPALISHIRING";
		String d=convert(s,3);
		System.out.println(d);
	}
}
