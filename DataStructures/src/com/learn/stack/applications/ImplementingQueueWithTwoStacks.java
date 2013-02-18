package com.learn.stack.applications;

import java.util.Stack;

/**
 * The Example demonstrate how we can implement a queue with the help of two
 * stacks.
 * 
 * @author Srinivas
 * 
 */
public class ImplementingQueueWithTwoStacks {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();

		for (int i = 0; i < 5; i++) {
			System.out.println("Inserted the element : " + i);
			queue.enqueue(i);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Element deleted was : " + queue.dequeue());
		}

	}
}

class Queue<E> {
	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();

	public void enqueue(E item) {
		inbox.push(item);
	}

	public E dequeue() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
}