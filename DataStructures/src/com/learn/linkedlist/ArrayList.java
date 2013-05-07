package com.learn.linkedlist;

/**
 * Sample Class To Learn ArrayList Implementation.
 * 
 * /
public class ArrayList<E> {
	private E elements[];
	private int size;
	private static int DEFAULT_SIZE = 10;
	private static int DEFAULT_INCREMENT_RATIO = 2;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void add(E e) {
		if (size == elements.length) {
			E[] newArray = (E[]) new Object[elements.length
					* DEFAULT_INCREMENT_RATIO];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
		}
		elements[size++] = e;
	}

	public void addAt(int index, E e) {
		if (index >= elements.length) {
			throw new IndexOutOfBoundsException();
		}
		//TODO need to implement.
	}
	
	public void clear(){
		//TODO need to implement.
	}
	
	public void set(int index, E e){
		if (index >= elements.length) {
			throw new IndexOutOfBoundsException();
		}
		elements[index] = e;
	}
	
	public E get(int i) {
		if (i >= elements.length) {
			throw new IndexOutOfBoundsException();
		}
		return elements[i];
	}
	
	public void remove(int i){
		
	}
	
	
}
