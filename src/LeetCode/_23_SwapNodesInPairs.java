package LeetCode;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年09月28日 3:21 PM
 */
public class _23_SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode list1  =new ListNode(1);
        list1.next  =new ListNode(2);
        list1.next.next  =new ListNode(3);
        list1.next.next.next  =new ListNode(4);
        swapPairs(list1);

    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     * @param head
     * @return
     */

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swap the two nodes
            first.next = second.next;
            second.next = first;
            //update the current to second, because now other listnode are point to initial list, but second is updated list
            current.next = second;

            // Move the current pointer to the next pair
            current = current.next.next;
        }

        return dummy.next;
    }

}
