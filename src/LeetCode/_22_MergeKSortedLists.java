package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年09月28日 11:56 AM
 */
public class _22_MergeKSortedLists {
    public static void main(String[] args) {
        ListNode list1  =new ListNode(1);
        list1.next  =new ListNode(4);
        list1.next.next  =new ListNode(5);

        ListNode list2  =new ListNode(1);
        list2.next  =new ListNode(3);
        list2.next.next  =new ListNode(4);

        ListNode list3  =new ListNode(2);
        list3.next  =new ListNode(6);

        ListNode[] lists = {list1,list2,list3};

        mergeKLists(lists);

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        //Minimum Heap, set up the comparator to sort the heap in ascending order
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val-b.val;
            }
        });


        //add each list into heap, and sort by listNode.val
        for (ListNode list : lists) {
            if(list!=null) {
                priorityQueue.add(list);
            }
        }

        ListNode res = new ListNode();
        ListNode curr = res;

        /**
         * while heap is not null,
         * point res=res.next, and poll the listNode into temp, then store it to res
         * then add the temp.next into heap again.(heap will heapify when add)
         */
        while(!priorityQueue.isEmpty()){
            res.next = new ListNode();
            res = res.next;
            ListNode temp=priorityQueue.poll();
            res.val = temp.val;
            if(temp.next!=null){
                priorityQueue.add(temp.next);
            }
        }

        return curr.next;
    }
}
