package LeetCode;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年09月22日 12:15 PM
 */
public class _19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        removeNthFromEnd(node,2);
        System.out.println(node);

    }

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * @param head
     * @param n
     * @return
     */

    //fast pointer move n step faster then slow, when it point to end of the listnode,
    //the slow pointer point right before the node that need to be move
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // set up slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;
        if(head == null ||head.next==null){
            return null;
        }

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //when fast pointer is null, it means the node need to move is the first node
        if(fast == null){
            head= head.next;
            return head;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

}


