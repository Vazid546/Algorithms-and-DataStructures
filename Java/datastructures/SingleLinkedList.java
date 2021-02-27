package datastructures;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        tail = node;
        size++;
    }

    public void insertAt(int index, int data) {
        if (index >= 0 && index <= size) {
            Node node = new Node(data);
            for (int tempIndex = 0; tempIndex <= size; head = head.next) {
                if (tempIndex == index) {
                    if (head == null) {
                        head = node;
                        tail = node;
                    } else {
                        Node temp = head;
                        head = node;
                        head.next = temp;
                        if (index == size - 1) {
                            tail = node;
                        }
                    }
                    break;
                }
            }
        }
    }

    @Override
    public String toString(){
        String s = "SingleLinkedList: ";
        Node temp = head;
        for(int index=0;index<=size-1;index++){
            if(temp != null) {
                s = s + temp.data + " ";
            }
            temp = temp.next;
        }
        return s;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insert(0);
        singleLinkedList.insert(1);
        System.out.println(singleLinkedList);
    }

}