/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: ReverseLinkedList 
 * @Description: TODO(������һ�仰��������������) 
 * @author wangjunting
 * @date 2018��3��15�� 
 */

public class ReverseLinkedListSolutionI {
	public ListNode reverseList(ListNode head){
		ListNode newHead = null,next = null;
		while(head != null){
			next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}