package com.learn.linkedlist.applications;

import com.learn.linkedlist.Node;

public class LinkedListCycleDetection1 {
	public static <E> boolean hasCycle(Node<E> head) {
		Node<E> slow = head;
		Node<E> fast = head;

		while (fast != null && slow != null) {
			fast = fast.getNext();
			if (fast == slow) {
				return true;
			}

			if (fast == null) {
				return false;
			}

			fast = fast.getNext();

			if (fast == slow) {
				return true;
			}

			slow = slow.getNext();
		}

		return false;

	}
}
