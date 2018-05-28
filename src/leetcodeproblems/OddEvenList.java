/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import domain.ListNode;

/**
 *
 * @author Mauri-Laptop
 */
public class OddEvenList {

    void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        ListNode res = oddEvenList(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyEven = new ListNode(0);
        dummyEven.next = head;
        ListNode dummyOdd = new ListNode(0);

        ListNode evenRunner = head;
        ListNode oddRunner = dummyOdd;

        while (evenRunner != null && evenRunner.next != null) {
            oddRunner.next = evenRunner.next;
            evenRunner.next = evenRunner.next.next;

            oddRunner = oddRunner.next;
            if (evenRunner.next != null) {
                evenRunner = evenRunner.next;
            }
        }
        oddRunner.next = null;

        evenRunner.next = dummyOdd.next;
        return dummyEven.next;
    }
}
