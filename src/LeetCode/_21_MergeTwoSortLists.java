package LeetCode;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年09月26日 2:56 PM
 */
public class _21_MergeTwoSortLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(node1,node2));
    }

    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //base case
        if(list1==null && list2==null){
            return null;
        }else if(list1==null){
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        //result and curr to track the start of the result
        ListNode res = new ListNode();
        ListNode curr = res;


        //if both listnode not null, compare which is smaller and asign to result
        while(list1!=null && list2!=null){
            res.next = new ListNode();
            res = res.next;
            if(list1.val<list2.val){
                res.val = list1.val;
                list1 = list1.next;
            }else{
                res.val = list2.val;
                list2 = list2.next;
            }
        }


//        if(list2==null && list1!=null){
//            res.next = new ListNode();
//            res = res.next;
//            res.val = list1.val;
//            list1= list1.next;
//
//        }

        //if only 1 of the list is null, result.next point to the rest of the list
        if(list2==null && list1!=null){
            res.next = list1;
        }

        if(list1==null && list2!=null){
            res.next = list2;
        }

        return curr.next;

    }
}
