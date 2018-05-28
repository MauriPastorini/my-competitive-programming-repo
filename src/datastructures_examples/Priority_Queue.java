package datastructures_examples;

import domain.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_Queue {

    private void Custom_Comparator() {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
                /*
                    Compare to: 
                        -1: Si el elemento 1 tiene mayor prioridad, va primero
                         1: Si el elemento 2 tiene mayor prididad, va primero
                         2: Misma prioridad, ojo que algunas estructuras no los agrega, por ejemplo los TreeSet 
                 */
            }
        });

        priorityQueue.add(new ListNode(0));
        ListNode l = priorityQueue.poll();
    }
}
