package com.learn.binarysearchtree;

public class BinarySearchTree {
	private BSTNode root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean add(int value) {
		if (root == null) {
			root = new BSTNode(value);
			return true;
		} else {
			return root.add(value);
		}
	}

	public boolean search(int value) {
		if (root != null) {
			return root.search(value);
		}
		return false;
	}

	public boolean remove(int value) {
		if (root == null) {
			return false;
		} else {
			if (root.getValue() == value) {
				BSTNode tempNode = new BSTNode(0);
				tempNode.setLeft(root);
				boolean result = root.remove(value, tempNode);
				root = tempNode.getLeft();
				return result;
			} else {
				return root.remove(value, null);
			}
		}

	}
}
