/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Arrays;
import domain.ListNode;

/**
 *
 * @author Mauri-Laptop
 */
public class HeapNode {
    int capacity = 10000;
        int size = 0;

        ListNode[] items = new ListNode[capacity];

        private int getLeftChildIndex(int parentIndex) {
            return parentIndex * 2 + 1;
        }

        private int getRightChildIndex(int parentIndex) {
            return parentIndex * 2 + 2;
        }

        private int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        private boolean hasParent(int index) {
            if(index == 0) return false;
            return getParentIndex(index) >= 0;
        }

        private ListNode leftChild(int index) {
            return items[getLeftChildIndex(index)];
        }

        private ListNode rightChild(int index) {
            return items[getRightChildIndex(index)];
        }

        private ListNode parent(int index) {
            return items[getParentIndex(index)];
        }

        private void ensureExtraCapacity() {
            if (size == capacity) {
                items = Arrays.copyOf(items, capacity * 2);
                capacity *= 2;
            }
        }
        
        private void swap(int indexOne, int indexTwo){
            ListNode aux = items[indexTwo];
            items[indexTwo] = items[indexOne];
            items[indexOne] = aux;
         }

        public ListNode peek() {
            if (size == 0) {
                return null;
            }
            return items[0];
        }

        public ListNode poll() {
            if (size == 0) {
                return null;
            }
            ListNode item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        public void add(ListNode item) {
            if(item == null) return;
            ensureExtraCapacity();
            items[size] = item;
            size++;
            heapifyUp();
        }

        private void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index).val > items[index].val) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        public void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index).val < leftChild(index).val) {
                   smallerChildIndex = getRightChildIndex(index);
                }
                
                if(items[index].val < items[smallerChildIndex].val){
                    break;
                } else{
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }
        
        public boolean hasElements(){
            return size != 0;
        }
}
