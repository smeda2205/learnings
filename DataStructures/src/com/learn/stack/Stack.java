package com.learn.stack;

/**
 * Stack Data Structure Implementation
 * 
 * @author Srinivas
 *
 * @param <T>
 */
public class Stack<T> {
	private T[] elements;
	private int size;
	private static int DEFAULT_SIZE = 4;
	private static int DEFAULT_INCREASE_RATIO = 2;

	Stack() {
		elements = (T[]) new Object[DEFAULT_SIZE];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(T t) {
		if (size == elements.length) {
			T[] newArray = (T[]) new Object[elements.length
					* DEFAULT_INCREASE_RATIO];
			System.arraycopy(elements, 0, newArray, 0, elements.length);

			elements = newArray;
		}
		elements[size++] = t;
	}

	public T pop() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}
		T t = elements[--size];
		elements[size] = null;
		return t;
	}

	public int size() {
		return size;
	}

	public T peek() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		return elements[size - 1];
	}

	public static void main(String[] args) throws Exception {
		Stack<Integer> intStack = new Stack<Integer>();

		System.out.println("Is the Stack Empty? :: " + intStack.isEmpty());
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);
		intStack.push(5);
		System.out.println("Is the Stack Empty? :: " + intStack.isEmpty());
		System.out.println("Deleted Element :: " + intStack.pop());
		intStack.push(6);

	}
}
