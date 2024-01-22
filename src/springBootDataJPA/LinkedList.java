package springBootDataJPA;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LRUCache {

    Node3 head = new Node3(0, 0);
    Node3 tail = new Node3(0, 0);
    int capacity;
    Map<Integer,Node3> map=new HashMap();
    LRUCache(int capacity){
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    int get(int key) {
        if (map.containsKey(key)) {
            Node3 node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else
            return -1;

    }

    void put(int key,int value) {

        if (map.containsKey(key)) {
            Node3 node = map.get(key);
            remove(node);
        }if(capacity==map.size()) {
            remove(tail.prev);
        }
        insert(new Node3(key,value));
    }
    private void insert(Node3 node) {
        Node3 headNext=head.next;
        node.next=headNext;
        head.next=node;
        node.prev=head;
        headNext.prev=node;
        map.put(node.key, node);

    }
    private void remove(Node3 node) {
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

class Node3 {
    Node3 prev, next;
    int key, value;

    Node3(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
/**
 * @author
 */
class Delete_continuous_nodes {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next = new ListNode(5);

        ListNode r = find_continous_node(root);
        while (r != null) {
            System.out.print(r.val + ",");
            r = r.next;
        }
    }

    private static ListNode find_continous_node(ListNode root) {
        ListNode current = root;

        while (root.next.next != null) {
            int latestSum = root.val + root.next.val;
            if (latestSum == root.next.next.val) {
                root.next = root.next.next.next;
            } else
                root = root.next;
        }
        return current;
    }

    /**
     * Input: head = [1,2,-3,3,1]
     * Output: [3,1]
     * Note: The answer [1,2,1] would also be accepted.
     *
     * @param root
     * @return
     */
    public ListNode removeZeroSumSubLists(ListNode root) {

        ListNode dummy = new ListNode(0);
        dummy.next = root;
        int val = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);

        ListNode i = dummy;
        while (i != null) {
            val = val + i.val;
            map.put(val, i);
            i = i.next;
        }

        ListNode j = dummy;
        int val2 = 0;
        while (j != null) {
            val2 = val2 + j.val;
            j.next = map.get(val2).next;
            j = j.next;
        }
        return dummy.next;

    }
}

class Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode r = reverseKGroup(root, 2);
        while (r != null) {
            System.out.print(r.val + ",");
            r = r.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        // If there are at least k nodes, reverse them
        if (count == k) {
            // Reverse the current k nodes
            ListNode prev = null;
            ListNode currentHead = head;
            for (int i = 0; i < k; i++) {
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }

            // Connect the reversed k nodes to the remaining list
            currentHead.next = reverseKGroup(head, k); // Fix here: use currentHead, not head

            // Return the new head of the reversed group
            return prev;
        }

        // If there are less than k nodes, return the current head as is
        return head;
    }
}

/**
 * Delete_Duplicates_nodes from sorted list
 */
class Delete_Duplicates_nodes {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(5);

        ListNode r = deleteDuplicates(root);
        while (r != null) {
            System.out.print(r.val + ",");
            r = r.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}

class Middle_of_the_Linked_List {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode middle = middleNode(head);
        System.out.println(middle.val);
    }

    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


class Merge_Two_Sorted_Lists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(10);
        ListNode res = mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) //Boundary
            return null;
        if (l1 == null && l2 != null) //Boundary
            return l2;
        if (l1 != null && l2 == null) //Boundary
            return l1;

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (prev != null) prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            prev.next = l1;
        if (l2 != null)
            prev.next = l2;
        return res;

    }
}

/**
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */

class Merge_k_Sorted_Lists {
    public static ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public static ListNode partion(ListNode[] lists, int low, int high) {
        if (low == high) return lists[low];
        if (low < high) {
            int mid = low + (high - low) / 2;
            ListNode l1 = partion(lists, low, mid);
            ListNode l2 = partion(lists, mid + 1, high);
            return mergeTwoLists(l1, l2);
        } else
            return null;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) //Boundary
            return null;
        if (l1 == null && l2 != null) //Boundary
            return l2;
        if (l1 != null && l2 == null) //Boundary
            return l1;


        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (prev != null) prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            prev.next = l1;
        if (l2 != null)
            prev.next = l2;
        return res;

    }
}

class LoopedLinkedList {


    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = root.next.next.next;
        findLoopAndRemovingLoop(root);
        //After loop got removed.
        while (root != null) {
            System.out.print(root.val + ",");
            root = root.next;
        }


    }

    private static void findLoopAndRemovingLoop(ListNode l) {

        ListNode head = l;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        slow = head;
        ListNode prev = null;

        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null; //Removing loop and making that node to null
        System.out.println("Loop=" + slow.val);

    }
}

/**
 * Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5]
 * Input: head = [1], n = 1 Output: []
 *
 * @author
 */
class Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(9);
        int target = 1;
        ListNode res = removeNthFromEnd(l1, target);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i <= n; i++)
            fast = fast.next;
        if (fast == null) return head.next;//exceptional case
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

/**
 * Input: head = [4,5,1,9], node = 5 Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after
 * calling your function.
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 *
 * @author
 */
class Delete_a_node {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        deleteNode(head.next.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/**
 * Reverse LL with the value from left to right
 *
 * @author
 */
class ReverseLinkedList_II {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //first part
        ListNode cur1 = dummy;
        ListNode pre1 = null;
        for (int i = 0; i < left; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        //reverse
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        ListNode q2;
        for (int i = left; i <= right; i++) {
            q2 = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = q2;
        }

        //connect
        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }

    static ListNode reverse(ListNode head, int right) {
        ListNode prev = null;
        ListNode i = null;
        while (head != null) {
            ListNode temp = head.next;
            if (prev == null) i = head;
            head.next = prev;
            prev = head;
            head = temp;
            if (prev.val == right) {
                i.next = head;
                return prev;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode res = reverseBetween(l1, 2, 4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

}

/**
 * Group Odd Even Linked List
 */
class Group_Odd_Even_Linked_List {
    public static ListNode oddEvenList(ListNode head) {
        /*Boundary cases */
        if (head == null) return null;
        if (head != null && head.next == null) return head;
        if (head != null && head.next != null && head.next.next == null) return head;

        ListNode odd_head = head;
        ListNode even_head = head.next;

        ListNode odd = head;
        ListNode even = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = even_head;
        return odd_head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode res = oddEvenList(l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

}

/**
 * https://leetcode.com/problems/reorder-list/submissions/
 */


class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;
        while (head2 != null && head != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = temp1;
            head2 = temp2;

        }

    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}

/**
 * RemoveElements
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * @author
 */
class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;

        while (node != null && node.next != null) {

            if (node.next.val == val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return dummy.next;
    }
}

/**
 * Split Linked List in Parts
 * <p>
 * Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a ListNode is [].
 *
 * @author
 */
class Split_Linked_List_in_Parts {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        int rem = 0;

        for (ListNode root = head; root != null; root = root.next)
            len++;

        if (len > k)
            rem = len % k;

        for (int i = 0; i < k; i++) {
            res[i] = head;
            for (int j = 1; j < len / k; j++) {
                head = head.next;
            }
            if (rem != 0) {
                head = head.next;
                rem--;
            }
            if (head != null) {
                ListNode temp = head.next;
                head.next = null;
                head = temp;
            } else {
                head = null;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode[] res = splitListToParts(l1, 2);

    }
}

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 *
 * @author
 */
class Add_Two_Numbers_Given_as_LinkedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(9);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode prev = start;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = 0, rem = 0;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;
            carry = sum / 10;
            rem = sum % 10;
            ListNode n = new ListNode(rem);
            prev.next = n;
            prev = n;
        }
        return start.next;

    }
}

class Intersection_of_Two_Linked_Lists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(1);
        l2.next.next.next = l1.next.next;
        l2.next.next.next.next = l1.next.next.next;
        l2.next.next.next.next.next = l1.next.next.next.next;
        ListNode res = getIntersectionNode1(l1, l2);
        System.out.println("IntersectionNode::" + res.val);
    }

    //method1
    private static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    //method2 - Both will take same time complexity. But code will be smaller in method1
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int len1 = 0, len2 = 0;
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }
        int len = Math.abs(len2 - len1);

        ListNode fast = len1 > len2 ? headA : headB;
        ListNode slow = len1 > len2 ? headB : headA;


        for (int i = 1; i <= len; i++)
            fast = fast.next;
        while (fast != null && slow != null && fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}

class Palindrome_Linked_List {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(0);
        l1.next.next.next.next = new ListNode(1);
        System.out.println("isPalindrome::" + isPalindrome(l1));

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);

        ListNode ptr1 = head;
        ListNode ptr2 = slow.next;


        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val != ptr2.val)
                return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;

    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;

    }
}

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * @author
 */
class Rotate_LinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(5);
        ListNode res = rotateRight(l1, 6);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode l1 = head;
        int len = 1;
        while (l1.next != null) {
            len++;
            l1 = l1.next;
        }

        if (k == len)
            return head;
        if (k > len)
            k = k % len;
        l1.next = head;
        int r = len - k;

        for (int i = 1; i < r; i++)
            head = head.next;

        ListNode temp = head.next;
        head.next = null;
        return temp;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Random_Ptr_LinkedList {
    public static void main(String[] args) {
        Node root = new Node(7);
        root.next = new Node(13);
        root.next.next = new Node(11);
        root.next.next.next = new Node(10);
        root.next.next.next.next = new Node(1);

        root.random = null;
        root.next.random = root;
        root.next.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next.next;
        root.next.next.next.next.random = root;
        print(root);
        System.out.println("Arranged::");
        Node res = copyRandomList(root);
        print(res);
    }

    public static Node copyRandomList(Node head) {

        /*1. Creating copy in middle of an existing nodes */
        Node l1 = head;
        while (l1 != null) {
            Node temp = l1.next;
            l1.next = new Node(l1.val);
            l1.next.next = temp;
            l1 = l1.next.next;
        }

        /*2. connecting random ptrs*/
        Node l2 = head;
        while (l2 != null) {
            if (l2.random != null)
                l2.next.random = l2.random.next;
            l2 = l2.next.next;
        }

        /*3. connecting next ptrs*/
        Node front = head;
        Node iter = head;

        Node head2 = new Node(0); //copied index
        Node copy = head2;

        while (iter != null) {

            copy.next = iter.next;
            copy = copy.next;

            front = iter.next.next;

            iter.next = front;
            iter = front;

        }
        return head2.next;

    }

    public static void print(Node head) {
        while (head != null) {
            if (head.random != null)
                System.out.println(head.val + "," + head.random.val);
            else
                System.out.println(head.val + "," + null);
            head = head.next;
        }
    }
}

