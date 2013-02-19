package com.learn.linkedlist.applications;

public class LinkedListCycleDetection {
	public static boolean hasCycle(Node head) {
		if (null == head) {
			return false;
		}

		Node fast = head;
		Node slow = head;

		while (true) {
			if (fast == null || fast.next == null)
				return false;
			else if (fast == slow || fast.next == slow)
				return true;
			else {
				fast = fast.next.next;
				slow = slow.next;
			}
		}

	}
	
	private class Node {
		Object data;
		Node next;
	}
}
