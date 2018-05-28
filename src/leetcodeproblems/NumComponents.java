/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import domain.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
public class NumComponents {

    public void test() {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
//        l1.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next = new ListNode(5);

        int[] n = {0, 1, 3};
        System.out.println(numComponents(l1, n));
    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }

        int cont = 0;
        boolean prog = false;
        while (head != null) {
            if (set.contains(head.val)) {
                prog = true;
            } else {
                if (prog) {
                    prog = false;
                    cont++;
                }
            }
            head = head.next;
        }
        if (prog) {
            cont++;
        }
        return cont;
    }
}
