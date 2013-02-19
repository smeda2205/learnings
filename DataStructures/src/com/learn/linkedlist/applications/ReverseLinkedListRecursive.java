package com.learn.linkedlist.applications;

import com.learn.linkedlist.Node;

public class ReverseLinkedListRecursive {
	public <E> void reverseLinkedListRecursion(Node<E> head) {
		Node<E> first;
		Node<E> rest;

		if (head != null) {
			first = head;
			rest = first.getNext();

			if (rest != null) {
				reverseLinkedListRecursion(rest);
				rest.setNext(first);
			}
		}
	}
}
