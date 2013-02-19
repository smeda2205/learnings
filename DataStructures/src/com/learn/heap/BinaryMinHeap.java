package com.learn.heap;

public class BinaryMinHeap {
	private int[] data;
	private int heapSize;

	public BinaryMinHeap(int size) {
		this.data = new int[size];
		this.heapSize = 0;
	}

	public int getMinimum() throws Exception {
		if (isEmpty()) {
			throw new Exception("Heap is Empty!!");
		}
		return data[0];
	}

	public boolean isEmpty() {
		return heapSize == 0;
	}

	public int getRightChildIndex(int index) {
		return 2 * index + 2;
	}

	public int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	/**
	 * Insert into heap
	 * 
	 * complexity: O(logn)
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void insert(int element) throws Exception {
		if (heapSize == data.length) {
			throw new Exception("Heap's underlying storage is overflow");
		} else {
			heapSize++;
			data[heapSize - 1] = element;
			shiftUp(heapSize - 1);
		}
	}

	public void shiftUp(int nodeIndex) {
		int parentIndex, tmp;

		if (nodeIndex != 0) {
			parentIndex = getParentIndex(nodeIndex);

			if (data[parentIndex] > data[nodeIndex]) {
				tmp = data[parentIndex];
				data[parentIndex] = data[nodeIndex];
				data[nodeIndex] = tmp;

				shiftUp(parentIndex);
			}
		}
	}

	public void removeMin() throws Exception {
		if (isEmpty())
			throw new Exception("Heap is empty");
		else {
			data[0] = data[heapSize - 1];
			heapSize--;
			if (heapSize > 0) {
				shiftDown(0);
			}
		}
	}

	public void shiftDown(int nodeIndex) {
		int leftChildIndex, rightChildIndex, minIndex, tmp;
		leftChildIndex = getLeftChildIndex(nodeIndex);
		rightChildIndex = getRightChildIndex(nodeIndex);

		if (rightChildIndex >= heapSize) {
			if (leftChildIndex >= heapSize)
				return;
			else
				minIndex = leftChildIndex;
		} else {
			if (data[leftChildIndex] <= data[rightChildIndex])
				minIndex = leftChildIndex;
			else
				minIndex = rightChildIndex;
		}
		if (data[nodeIndex] > data[minIndex]) {
			tmp = data[minIndex];
			data[minIndex] = data[nodeIndex];
			data[nodeIndex] = tmp;
			shiftDown(minIndex);
		}
	}
}
