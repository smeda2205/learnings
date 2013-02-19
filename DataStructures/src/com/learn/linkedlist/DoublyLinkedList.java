package com.learn.linkedlist;

/**
 * 
 * Each node in Doubly Linked List contains three fields: Data, and Two
 * Pointers. One pointer points to the previous node in the list, and the other
 * pointer points to the next node in the list.
 * 
 * The previous pointer of the first node, and the next pointer of the last node
 * are both null.
 * 
 * 
 * http://en.literateprograms.org/Doubly_linked_list_%28Java%29
 * http://pages.cs.wisc.edu/~vernon/cs367/notes/4.LINKED-LIST.html
 * 
 * http://www.java-tips.org/java-se-tips/java.lang/linked-list-implementation-in
 * -java.html
 * 
 * @author smeda
 * 
 * @param <E>
 */
public class DoublyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;

	private int length;

	public DoublyLinkedList() {
		head = new Node<E>(null);
		tail = new Node<E>(null);

		head.next = tail;
		head.prev = null;

		tail.prev = head;
		tail.next = null;

		length = 0;
	}

	public DoublyLinkedList(Node<E> head, Node<E> tail) {
		head.setPrev(null);
		head.setNext(tail);

		tail.setNext(null);
		tail.setPrev(head);
	}

	public Node<E> get(int index) throws IndexOutOfBoundsException {
		if (index <= 0 || index > length) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> current = head;

		for (int i = 1; i <= index && current.next != null; i++) {
			current = current.next;
		}

		return current;
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		if (index <= 0 || index > length) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> current = get(index);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		length--;

		return current.data;
	}

	public void add(int index, E data) throws IndexOutOfBoundsException {
		if (index <= 0 || index > length) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> temp = new Node<E>(data);
		Node<E> current = get(index);
		temp.prev = current;
		temp.next = current.next;
		current.next = temp;
		current.next.prev = temp;
		length++;
	}

	public void addHead(E data) {
		if (data != null) {
			Node<E> temp = new Node<E>(data);
			Node<E> current = head;

			// if (current.next != null) {
			temp.next = current.next;
			temp.prev = current;
			current.next.prev = temp;
			current.next = temp;
			/*
			 * } else { temp.next = tail; current.next = temp; }
			 */
			// Note : commented this because 'current.next' never be null as it
			// will be pointed to 'tail' node
			length++;
		}
	}

	public void addTail(E data) {
		if (data != null) {
			Node<E> temp = new Node<E>(data);

			Node<E> current = tail;
			temp.prev = current.prev;
			temp.next = current;
			current.prev.next = temp;
			current.prev = temp;
		}
		length++;
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();

		result.append("(head) - ");
		Node<E> temp = head;
		while (temp.getNext() != tail) {
			temp = temp.getNext();
			result.append(temp.getData() + " - ");
		}
		result.append("(tail)");
		return result.toString();
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addHead(new Integer(1));
		System.out.println("Adding Head 1 :: " + list);
		list.addHead(new Integer(2));
		System.out.println("Adding Head 2 :: " + list);
		list.addTail(new Integer(9));
		System.out.println("Adding Tail 9 :: " + list);
		list.addHead(new Integer(3));
		System.out.println("Adding Head 3 :: " + list);
		list.addTail(new Integer(11));
		System.out.println("Adding Tail 11 :: " + list);
		list.add(2, new Integer(0));
		System.out.println("Adding at index 2 :: " + list);
		list.remove(list.size());
		System.out.println("Removing last element :: " + list);
	}

	public static class Node<E> {
		E data;
		Node<E> prev;
		Node<E> next;

		public Node(E data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}

		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
	}
}
