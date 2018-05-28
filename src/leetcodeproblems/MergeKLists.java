/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import datastructures.HeapNode;
import domain.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Mauri-Laptop
 */
public class MergeKLists {

    private void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);

//        ListNode l3 = new ListNode(5);
//        l3.next = new ListNode(45);
//        l3.next.next = new ListNode(344);
//
//        ListNode l4 = new ListNode(-1);
//        l4.next = new ListNode(5);
//        l4.next.next = new ListNode(9);
        ListNode[] elems = {l1, l2};

//        ListNode res = mergeKLists_BruteForce(elems);
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
        ListNode res2 = mergeKLists_WithMyHeapImplementation(elems);
        while (res2 != null) {
            System.out.println(res2.val);
            res2 = res2.next;
        }
    }

    private static ListNode mergeKLists(ListNode[] elems) {
        if (elems == null || elems.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (int i = 0; i < elems.length; i++) {
            if (elems[i] != null) {
                priorityQueue.add(elems[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode min = priorityQueue.poll();
            runner.next = min;
            runner = runner.next;
            if (min.next != null) {
                priorityQueue.add(min.next);
            }
        }
        return dummy;
    }

    private static ListNode mergeKLists_WithMyHeapImplementation(ListNode[] elems) {
        if (elems == null || elems.length == 0) {
            return null;
        }
        HeapNode heap = new HeapNode();
        for (int i = 0; i < elems.length; i++) {
            heap.add(elems[i]);
        }
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while (heap.hasElements()) {
            ListNode next = heap.peek().next;
            ListNode min = heap.poll();
            runner.next = min;
            runner = runner.next;
            heap.add(next);
        }
        return dummy.next;
    }

    public static ListNode mergeKLists_BruteForce(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = insertListInOrder(res, lists[i]);
        }
        return res;
    }

    private static ListNode insertListInOrder(ListNode actualRes, ListNode listToInsert) {
        if (actualRes == null) {
            return listToInsert;
        }
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (actualRes != null && listToInsert != null) {
            if (actualRes.val < listToInsert.val) {
                dummy.next = actualRes;
                actualRes = actualRes.next;
            } else {
                dummy.next = listToInsert;
                listToInsert = listToInsert.next;
            }
            dummy = dummy.next;
        }
        if (actualRes == null) {
            dummy.next = listToInsert;
        }
        if (listToInsert == null) {
            dummy.next = actualRes;
        }
        return res.next;
    }
}
