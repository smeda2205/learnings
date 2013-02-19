package com.learn.linkedlist;

public class CircularSinglyLinkedList<E> {
	private Node<E> start;
	private int length;

	/**
	 * Adds at the end of the list pointing the new element back to start node.
	 * 
	 * @param data
	 */
	public void add(E data) {
		Node<E> temp = new Node<E>(data);
		if (start == null) {
			start = temp;
			start.next = start;
		} else {
			Node<E> current = start;
			while (current.next != start) {
				current = current.next;
			}
			current.next = temp;
			temp.next = start;
		}
		length++;
	}

	public Node<E> get(int index) {
		if (index <= 0 || index > length) {
			return null;
		}
		Node<E> current = start;

		for (int i = 1; i <= index && current.next != start; i++) {
			current = current.next;
		}

		return current;
	}

	public E remove(int index) {
		return null;
	}

}
