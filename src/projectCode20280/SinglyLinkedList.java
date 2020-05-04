package com.company;

import java.util.Iterator;
import java.util.List;

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head;
    private int size;

    private class Node<E> {
        private E data;
        private Node<E> reference;

        public Node(E data, Node<E> next) {
            this.data = data;
            reference = next;
        }

        public E getData() {
            return data;
        }

        //returns the reference to the next element
        public Node<E> getRef() {
            return reference;
        }

        public void setRef(Node<E> next) {
            reference = next;
        }
    }

    public static void main(String[] args) {
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        for (String s : alphabet) {
            sll.addFirst(s);
        }

        Iterator<String> it = sll.iterator();
        System.out.println("Elements: ");
        while (it.hasNext()){
            System.out.print(it.next() + " -> ");
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E get(int i) {
        if (head == null) {
            return null;
        }
        Node<E> tmp = head;
        if (i == 0) {
            return head.getData();
        }
        for (int j = 0; j < i - 1; j++) { //i-1 is used as the call to getReference() on the i-1 element will get to i
            tmp = tmp.getRef();
        }
        return tmp.getRef().getData();
    }

    @Override
    public void add(int i, E e) {
        if (size == 0 || i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> tmp = head;
            Node<E> newest = new Node<E>(e, null);
            for (int index = 0; index < i - 1; index++) { //i-1 is used as the call to getReference() on the i-1 element will get to i
                tmp = tmp.getRef();
            }
            newest.setRef(tmp.getRef());
            tmp.setRef(newest);
        }
        size++;
    }

    public E first(){
        return get(0);
    }

    public E last(){
        return get(size-1); //size-1 as indexing starts at 0
    }

    @Override
    public E remove(int i) {
        if (i == 0 && size == 0){
            System.out.println("Invalid command");
            return null;
        } else if (i == 0){
            return removeFirst();
        } else if(i == size-1){ //size-1 as indexing starts at 0
            return removeLast();
        } else{
            Node<E> tmp = head;Node<E> nextRef = null;
            E returnValue = null;
            for (int index = 0; index < i-1; index++){ //i-1 is used as the call to getReference() on the i-1 element will get to i
                tmp = tmp.getRef();
            }
            returnValue = tmp.getRef().getData();
            nextRef = tmp.getRef().getRef();
            tmp.setRef(nextRef);
            size--;
            return returnValue;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public void reversePrinter(){
        printNode(this.head);
    }

    public void printNode(Node<E> e){
        if (e != null){
            printNode(e.getRef());
            System.out.print(e.data + "-> ");
        }
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }

        E element = head.getData();
        head = head.getRef();
        size--;
        return element;
    }

    public E removeLast() {
        if (size == 0){
            Node<E> returnValue = head;
            head = null;
            return returnValue.getData();
        } else{
            Node<E> tmp = head;
            E element = null;
            while (tmp.getRef().getRef() != null){
                tmp = tmp.getRef();
            }
            element = tmp.getRef().getData();
            tmp.setRef(null);
            size--;
            return element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            Node<E> curr = head;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E result = curr.getData();
                curr = curr.getRef();
                return result;
            }
        };
        return iterator;
    }

    public void addFirst(E e) {
        head = new Node<E>(e, head);
        size++;
    }

    public void addLast(E e) {
        if (size == 0) addFirst(e);
        else{
            Node<E> tmp = head;
            while (tmp.getRef() != null){
                tmp = tmp.getRef();
            }
            tmp.setRef(new Node<E>(e, null));
        }
        size++;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("List: "); Node<E> tmp = head;
        while (tmp.getRef() != null){
            str.append(tmp.getData()).append(" -> ");
            tmp = tmp.getRef();
        }
        str.append(tmp.getData());
        str.append(" ");
        return str.toString() ;
    }
}
