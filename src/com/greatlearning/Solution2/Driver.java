package com.greatlearning.Solution2;

import com.greatlearning.Solution2.RightSkewFunction.Node;

/*
 * Input tree in NOT a BST as 40 is present in the right side of the root 50.
 * Correcting the input given in the question in order to create BST.
 */

public class Driver {

	public static void main(String[] args) {
		RightSkewFunction tree = new RightSkewFunction();
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(60);
		root.left.right = new Node(40); // correcting the position in order to create the BST
		root.left.left = new Node(10);

		tree.BSTToRightSkew(root);
		tree.DisplayRightSkewTree(tree.headNode);
	}

}
