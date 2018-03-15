/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: ReverseLinkedList 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年3月15日 
 */


class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		this.val = x;
	}
}
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