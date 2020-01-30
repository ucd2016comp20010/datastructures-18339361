package projectCode20280;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

	private Node<E> head;
	private int size;

	private class Node<E> {
		/// TODO
		private E element; //the element stored at this node
		private Node<E> next; //the next node in the list

		public Node(E e, Node<E> n){ //method to create a node
			element= e; //element of new node
			next= n; //next node after new node
		}

		public E getElement(){ //getter method to return element
			return element;
		}

		public Node<E> getNext(){ //getter method to return next node
			return next;
		}

		public void setNext(Node<E> n){ //setter method to set next node
			next= n;
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}	
	

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(E e) { //adding new node to start of list
		// TODO Auto-generated method stub
		head= new Node<E>(e, head); //head points to new start of list
		size++; //size of list incremented
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		Node<E> newest= new Node<E>(e, null);
		Node<E> last= head;
		if(last== null){
			head= newest;
		}
		else{
			while(last.getNext() != null){
				last= last.getNext();
			}
			last.setNext(newest);
		}
		size++;
	}
	
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}
