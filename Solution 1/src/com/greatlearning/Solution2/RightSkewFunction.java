package com.greatlearning.Solution2;

public class RightSkewFunction {
	// Declaring and initializing variables
	public static Node node;
	Node prevNode = null;
	Node headNode = null;

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	// Converting BST to RightSkewed Tree

	public void BSTToRightSkew(Node root) {

		// Base Case
		if (root == null) {
			return;
		}

		// In Order Traversal to convert a BST to increasing order skewed tree

		// Recurse to the left subtree
		BSTToRightSkew(root.left);

		Node rightNode = root.right;

		// Checking the root Node
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// Recurse to the right subtree

		BSTToRightSkew(rightNode);

	}

	// Traverse and display the right skewed tree

	public void DisplayRightSkewTree(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		DisplayRightSkewTree(root.right);
	}

}
