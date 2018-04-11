package cn.wang.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @ClassName: MergekSortedLists 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangjunting
 * @date 2018年4月11日 
 */
public class MergekSortedLists {
	public static ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val - o2.val;
            }
        });
        
        for(ListNode node:lists){
            if(node != null)
                queue.add(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            
            if(tail.next != null)
                queue.add(tail.next);
        }
        
        return dummy.next;
        
    }
    
   
	public static void main(String args[]){
		//ListNode[] lists = {new ListNode(2),null,new ListNode(-1)};
		ListNode[] lists = null;
		ListNode result=mergeKLists(lists);
		//ListNode result = mergeTwoLists(new ListNode(2),new ListNode(-1));
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
