/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: ReverseLinkedListSolutionII 
 * @Description: TODO(������һ�仰��������������) 
 * @author wangjunting
 * @date 2018��3��15�� 
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
