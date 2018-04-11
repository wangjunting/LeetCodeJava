/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: SwapNodesinPairs 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年4月11日 
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode dummy = new ListNode(0);
		ListNode temp = null;
		ListNode res = swapPairs(head.next.next);
		
		temp = head.next;
		head.next.next = head;
		head.next = res;
		dummy.next = temp;
		return dummy.next;
	}
}
