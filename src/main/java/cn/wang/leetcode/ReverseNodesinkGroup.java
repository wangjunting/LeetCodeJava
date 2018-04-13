/**
 * 
 */
package cn.wang.leetcode;

/**
 * @ClassName: ReverseNodesinkGroup 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年4月13日 
 */
public class ReverseNodesinkGroup {
public static ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;
        if( k==1 ) return head;
        
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast=dummy,preNode = dummy;
        slow.next = head;
        
        ListNode node1 = null,node2 = null;
        
        int i=1;
        for(;i<=k+1 && fast != null;i++){
            fast = fast.next;
        } 
        //System.out.println("fast"+fast.val);
        if(i == k+2){        	
        	ListNode res = reverseKGroup(fast,k);
            node1 = preNode.next;
            node2 = node1.next;
            for(int j=1;j<k;j++){
                node1.next = node2.next;
                node2.next = preNode.next;
                preNode.next = node2;
                node2 = node1.next; 
            }
            //System.out.println("*"+node2.val);
            node1.next = res;          
            return dummy.next;
        }else{
             return dummy.next;
        }
    }

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		
		ListNode newHead = reverseKGroup(head,2);
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}
