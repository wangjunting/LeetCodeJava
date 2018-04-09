/**
 * 
 */
package cn.wang.leetcode;
/**
 * @ClassName: RemoveNthNodeFromEndofList 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年4月4日 
 */
public class RemoveNthNodeFromEndofList {
	/*public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        
        while(first != null){
            length++;
            first = first.next;
        }
        System.out.println(length);
        length -= n;
        first = head;
        while(length >1){
            length--;
            first=first.next;
        }
        System.out.println(first.val);
        first.next = first.next.next;
        return head;
    }*/
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
	    
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	    }
	public static void main(String args[]){
		ListNode dummy = new ListNode(0);
		ListNode head = new ListNode(1);
		dummy.next = head;
		for (int i=2;i<=5;i++){
			ListNode next = new ListNode(i);
			head.next = next;
			head = next;
		}
		head.next=null;
		head = dummy.next;
		ListNode next = removeNthFromEnd(head,5);
		while (next != null){
			System.out.print(next.val + ",");
			next = next.next;
		}
	}
}
