/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: RotateList 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年4月13日 
 */
public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
        if(k <= 0) return head;
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preNode=null,node1 = null,fast = head,slow=dummy;
        int len=0;
        while(fast != null){
            preNode=slow;
            node1=fast;
            fast = fast.next;
            slow = slow.next;
            len++;
        }
        k=k%(len);
        if( k==0 )
            return head;
        else{
            node1.next = dummy.next;
            dummy.next = node1;
            preNode.next = null;
            return rotateRight(dummy.next,k-1);
        }   
    }
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode newHead = rotateRight(head,10);
		
		while (newHead != null) {
			System.out.println(newHead.val + " ");
			newHead = newHead.next;
		}
		//System.out.println(2000000000%3);
		
	}
}
