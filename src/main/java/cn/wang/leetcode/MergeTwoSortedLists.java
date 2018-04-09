/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: MergeTwoSortedLists 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年4月9日 
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode  l3 = dummy;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				l3.next=l1;
				l1=l1.next;
			}
			else{
				l3.next=l2;
				l2=l2.next;
			}
			l3=l3.next;
		}
		while(l1 != null){
			l3.next = l1;
			l1=l1.next;
			l3=l3.next;
		}
		while(l2 !=null){
			l3.next=l2;
			l2=l2.next;
			l3=l3.next;
		}
		l3.next=null;
		return dummy.next;
	}
}
