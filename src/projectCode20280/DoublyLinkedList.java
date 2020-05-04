package com.company;

import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<E> implements List<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size;

    private class Node<E> {
        private E data;

        private Node<E> nextRef;
        private Node<E> prevRef;

        public Node(E element, Node<E> prev, Node<E> next) {
            data = element;
            prevRef = prev;
            nextRef = next;
        }

        public Node<E> getNextRef() {
            return nextRef;
        }

        public void setNextRef(Node<E> location) {
            nextRef = location;
        }

        public Node<E> getPrevRef() {
            return prevRef;
        }

        public void setPrevRef(Node<E> location) {
            prevRef = location;
        }

        public E getData() {
            return data;
        }

    }


    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<E>(e, predecessor, successor);
        predecessor.setNextRef(newest);
        successor.setPrevRef(newest);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public E first(){
        if (isEmpty()) return null;
        return get(0);
    }

    public E last(){
        return get(size-1);
    }
    @Override
    public E get(int i) {
        Node<E> tmp = header;
        for (int index = 0; index < i; index++) {
            tmp = tmp.getNextRef();
        }
        return tmp.getData();
    }

    @Override
    public void add(int i, E e) {
        if (i== 0){
            addFirst(e);
        } else if(i == size-1){
            addLast(e);
        } else{
            Node<E> prevRef;
            Node<E> nextRef = null;
            Node<E> tmp = header;
            Node<E> newest = new Node<E>(e, null, null);
            for (int index = 0; index < i-1; index++){
                tmp = tmp.getNextRef();
            }
            prevRef = tmp.getNextRef().getPrevRef();
            nextRef = tmp.getNextRef();
            tmp.setNextRef(newest);
            newest.setPrevRef(tmp);
            newest.setNextRef(nextRef);
        }
    }

    @Override
    public E remove(int i) {
        if (size == 0) return null;
        else if(i == 0) {
            size--;
            return removeFirst();
        }
        else if(i == size-1) {
            size--;
            return removeLast();}
        else{
            Node<E> prevRef, nextRef = null;
            Node<E> tmp = header;
            E returnValue = null;
            for (int index = 0; index < i-1; index++){
                tmp = tmp.getNextRef();
            }
            prevRef = tmp.getNextRef().getPrevRef();
            nextRef = tmp.getNextRef().getNextRef();
            returnValue = tmp.getNextRef().getData();
            tmp.setNextRef(nextRef);
            tmp.getNextRef().setPrevRef(prevRef);
            size--;
            return returnValue;
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            Node<E> curr = header;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E result = curr.getData();
                curr = curr.getNextRef();
                return result;
            }
        };
        return iterator;
    }
    
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            E retValue = header.getData();
            header = header.getNextRef();
            size--;
            return retValue;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }else {
            E retValue = trailer.getData();
            trailer = trailer.getPrevRef();
            trailer.setNextRef(null);
            size--;
            return retValue;
        }
    }

    public void addFirst(E e) {
        Node<E> newest = new Node<E>(e, null, null);
        if (size == 0) {
            trailer = newest;
        } else {
            header.setPrevRef(newest);
        }
        newest.setNextRef(header);
        header = newest;
        size++;
    }

    public void addLast(E e) {
        Node<E> lastNewest = new Node<E>(e, null, null);
        if (size == 0) {
            header = lastNewest;
        } else {
            trailer.setNextRef(lastNewest);
            lastNewest.setPrevRef(trailer);
        }
        trailer = lastNewest;
        size++;

    }

    public String toString() {
        StringBuilder str = new StringBuilder("List : [ ");
        Node<E> tmp = header;
        while (tmp != trailer){
            str.append(tmp.getData()).append("-> ");
            tmp = tmp.getNextRef();
        }
        str.append(tmp.getData()).append(" ]");
        return str.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
        ll.addFirst(0);
        ll.removeFirst();
    }

}
