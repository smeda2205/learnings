package com.learn.linkedlist.applications;

import com.learn.linkedlist.Node;

public class AppendTwoLists {
	public <E> Node<E> appendTwoLists(Node<E> headA, Node<E> headB) {
		if (headA == null) {
			headA = headB;
		} else {
			Node<E> temp = headA;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(headB);
		}
		headB = null;

		return headA;
	}
}
