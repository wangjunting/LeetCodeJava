/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: ReverseLinkedListSolutionII 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月15日 
 */
public class ReverseLinkedListSolutionII {
	public ListNode reverseList(ListNode head){
		return reverseListInt(head,null);
	}
	
	public ListNode reverseListInt(ListNode head,ListNode newHead){
		if(head == null)
			return head;
		ListNode next = head.next;
		head.next = newHead;
		return reverseListInt(next,head);
	}
}
