package homework.Arithmetic;

public class AddTwoNums {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(8);

        ListNode node = addTwoNumbers(l1,l2);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;

        ListNode result = null;

        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }

            int v_l1 = 0, v_l2 = 0;

            if (l1 != null) {
                v_l1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                v_l2 = l2.val;
                l2 = l2.next;

            }

            ListNode newNode = new ListNode(v_l1 + v_l2);

            if (result == null) {
                result = newNode;
                head = result;
            } else {
                result = result.next = newNode;
            }
        }

        result = head;

        while (result != null) {
            if (result.val >= 10) {
                result.val -= 10;
                if(result.next == null) {
                    result.next = new ListNode(1);
                } else {
                    result.next.val += 1;
                }
            }
            result = result.next;
        }

        return head;
    }

}
