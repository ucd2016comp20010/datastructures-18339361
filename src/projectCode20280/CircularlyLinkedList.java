package com.company;

import java.util.Iterator;
import java.util.List;

public class CircularlyLinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;


    private class Node<E> {
        private E data;
        private Node<E> ref;

        public Node(E e, Node<E> dest) {
            data = e;
            ref = dest;

        }

        public E getData() {
            return data;
        }

        public void setNext(Node<E> next) {
            ref = next;
        }

        public Node<E> getNext() {
            return ref;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if (i == 0){
            return null;
        }
        Node<E> tmp = head;
        for(int index = 0; index < i-1; index++) {
            tmp = tmp.getNext();		//tmp is the element before the required one
        }
        return tmp.getNext().getData();
    }

    @Override
    public void add(int i, E e) {
        if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> tmp = head;
            Node<E> newest = new Node<E>(e, null);
            Node<E> setLocation = null;
            for (int index = 0; index < i - 1; index++) {
                tmp = tmp.getNext();
                if (index == i - 2) {
                    setLocation = tmp.getNext();
                }
            }
            tmp.setNext(newest);
            newest.setNext(setLocation);
            size++;
        }
    }

    @Override
    public E remove(int i) {
        if(i == 0 && size == 0) {
            return null;
        } else if(i == 0) {
            return removeFirst();
        } else if(i == size) {
            return removeLast();
        } else {
            E returnValue = null;
            Node<E> tmp = head;
            Node<E> setLocation = null;
            for(int index = 0; index < i-1; index++) {
                tmp = tmp.getNext();
            }
            setLocation = tmp.getNext().getNext();
            size--;
            returnValue = tmp.getNext().getData();
            tmp.setNext(setLocation);
            return returnValue;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return head.getData();
        } else {
            E returnValue = head.getData();
            Node<E> tmp = head;
            while (tmp.getNext() != head) {
                tmp = tmp.getNext(); // tmp is the last item in the list
            }
            head = head.getNext();
            size--;
            tmp.setNext(head);
            return returnValue;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return head.getData();
        } else {
            Node<E> tmp = head;
            Node<E> setLocation = null;
            E returnValue = null;
            while (tmp.getNext().getNext() != head) {
                tmp = tmp.getNext(); // tmp is the second last item in the list
            }
            size--;
            setLocation = tmp.getNext().getNext();
            returnValue = tmp.getNext().getData();
            tmp.setNext(setLocation);
            return returnValue;
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
                curr = curr.getNext();
                return result;
            }
        };
        return iterator;
    }

    public void addFirst(E e) {
        Node<E> newest = new Node<E>(e, null);
        if (head == null) {
            head = newest;
            head.setNext(head);
        } else {
            Node<E> tmp = head;
            while (tmp.getNext() != head) {
                tmp = tmp.getNext(); // Tmp is the last element in the list
            }
            tmp.setNext(newest);
            newest.setNext(head);
            head = newest;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<E>(e, null);
        Node<E> tmp = head;
        while (tmp.getNext() != head) {
            tmp = tmp.getNext(); // Tmp is the last element in the list
        } 
        tmp.setNext(newest); 
        newest.setNext(head); // Closing the circle loop
        size++;
    }

    public void rotate() {
        head = head.getNext();
    }

    public String toString() {
        String result = "";
        Node<E> tmp = head;
        while (tmp.getNext() != head) {
            result += tmp.getData() + "-> ";
            tmp = tmp.getNext();
        }
        result += tmp.getData();
        return result;
    }

    public static void main(String[] args) {
        CircularlyLinkedList<String> lst = new CircularlyLinkedList<String>();
        lst.addFirst("First");lst.addLast("Last");lst.addFirst("First-again");
        System.out.println(lst.size());
        System.out.println(lst.get(1));
        lst.add(2, "2nd position");
        System.out.println(lst.remove(1));
        System.out.println(lst);
        System.out.println(lst.get(2));
    }
}
