package greatlearninglab3;

import java.util.*;

public class BST {
	static class Node {
		int data;
		Node left, right;
	};

	static Node NewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	static boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (findpairUtil(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		} else
			set.add(root.data);

		return findpairUtil(root.right, sum, set);
	}

	static void findPair(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.print("Pairs do not exit" + "\n");
	}

	// Driver code
	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 4);
		root = insert(root, 2);
		root = insert(root, 6);
		root = insert(root, 1);
		root = insert(root, 3);
		root = insert(root, 5);
		root = insert(root, 7);
		

		int sum = 130;
		findPair(root, sum);
	}

}
