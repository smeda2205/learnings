package com.learn.linkedlist;

/**
 * 
 * http://www.algolist.net/Data_structures/Singly-linked_list
 * http://www.mycstutorials.com/articles/data_structures/linkedlists
 * 
 * @author smeda
 * 
 * @param <E>
 */
public class LinkedList<E> {
	private Node<E> head;
	private int listCount;

	public LinkedList() {
		head = new Node<E>(null);
		listCount = 0;
	}

	public void add(E data) {
		if (data != null) {
			Node<E> temp = new Node<E>(data);
			Node<E> current = head;

			while (current.next != null) {
				current = current.getNext();
			}
			current.setNext(temp);
			listCount++;
		}
	}

	public void add(E data, int index) {
		if (data != null) {
			Node<E> temp = new Node<E>(data);
			Node<E> current = head;

			for (int i = 1; i < index && current.next != null; i++) {
				current = current.getNext();
			}

			temp.setNext(current.getNext());
			current.setNext(temp);
			listCount++;
		}
	}

	public boolean remove(int index) {
		if (index <= 0 || index > size()) {
			return false;
		}

		Node<E> current = head;

		for (int i = 1; i < index; i++) {
			if (current.getNext() == null) {
				return false;
			}
			current = current.getNext();
		}

		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}

	public void deleteCompleteList() {
		Node<E> temp1 = head;
		Node<E> temp2;

		while (temp1 != null) {
			temp2 = temp1.next;
			temp1 = null;
			temp1 = temp2;
		}

		head = null;
		listCount = 0;
	}

	public E get(int index) {
		if (index <= 0 || index > size()) {
			return null;
		}
		Node<E> current = head.getNext();
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;

			current = current.getNext();
		}

		return current.getData();
	}

	public int size() {
		return listCount;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void printList() {
		System.out.println(this.toString());
	}

	public String toString() {
		Node<E> current = head.getNext();
		String output = "";
		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
	
	
	public void reverseLinkedListRecursion(Node head){
		Node first;
		Node rest;
		
		if(head != null) {
			first = head;
			rest = first.next;
			
			if(rest != null){
				reverseLinkedListRecursion(rest);
				rest.next = first;
			}
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println("List Contains " + list.size() + " elements.");
		list.printList();

		list.add(6, 3);

		System.out.println("List Contains " + list.size() + " elements.");
		list.printList();

		System.out.println("Element at 3rd position : " + list.get(3));

		System.out.println("Removing element at 3rd position : "
				+ list.remove(3));

		System.out.println("List Contains " + list.size() + " elements.");
		list.printList();

		System.out.println("Reversing the list....... ");
		list.reverseLinkedListRecursion(list.head);
		
		System.out.println("List Contains " + list.size() + " elements.");
		list.printList();

	}

}
