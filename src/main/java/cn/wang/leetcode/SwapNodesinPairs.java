/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: SwapNodesinPairs 
 * @Description: TODO(������һ�仰��������������) 
 * @author wangjunting
 * @date 2018��4��11�� 
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
