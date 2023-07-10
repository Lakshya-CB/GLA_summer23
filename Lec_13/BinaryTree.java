package Lec_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;

	BinaryTree(String[] arr) {
		Queue<Node> queue = new LinkedList<Node>();
		construct(arr, 0, queue);
	}

	public void topview() {
//		verticalTraversalTop(this.root);
		ArrayList<ArrayList<Integer>> Right = new ArrayList<>();
		ArrayList<ArrayList<Integer>> Left = new ArrayList<>();
		solve(root, 0, Right, Left);
		for (int axis = Left.size() - 1; axis > 0; axis--) {
			for (int ali : Left.get(axis)) {
				System.out.print(ali + " ");
			}
		}
		for (ArrayList<Integer> AL : Right) {
			for (int ali : AL) {
				System.out.print(ali + " ");
			}
		}
	}

	public void solve(Node nn, int axis, ArrayList<ArrayList<Integer>> Right, ArrayList<ArrayList<Integer>> Left) {
		if(nn==null||nn.data==-1) {
			return;
		}
		if (axis >= 0) {
			while (Right.size() <= axis) {
				Right.add(new ArrayList<>());
			}
			Right.get(axis).add(nn.data);
		} else {
			while (Left.size() <= -1 * axis) {
				Left.add(new ArrayList<>());
			}
			Left.get(-1*axis).add(nn.data);
		}
		
		solve(nn.left, axis-1, Right, Left);
		solve(nn.right, axis+1, Right, Left);
	}

	class pair {
		public pair(Node root, int i) {
			nn = root;
			axis = i;
		}

		Node nn;
		int axis;

		@Override
		public String toString() {
			return nn.data + " - " + axis;
		}
	}

//BFS_App
	private void verticalTraversalTop(Node root) {
		ArrayList<ArrayList<Integer>> Right = new ArrayList<>();
		ArrayList<ArrayList<Integer>> Left = new ArrayList<>();
		Queue<pair> Q = new LinkedList<>();
		Q.add(new pair(root, 0));
		while (!Q.isEmpty()) {
			pair curr = Q.poll();
			if (curr.nn.data == -1) {
				continue;
			}
//		   System.out.println(curr);
			if (curr.axis >= 0) {
				while (Right.size() <= curr.axis) {
					Right.add(new ArrayList<>());
				}
				Right.get(curr.axis).add(curr.nn.data);
			} else {
				while (Left.size() <= -1 * curr.axis) {
					Left.add(new ArrayList<>());
				}
				Left.get(curr.axis).add(curr.nn.data);
			}
			if (curr.nn.left != null) {
				Q.add(new pair(curr.nn.left, curr.axis - 1));
			}
			if (curr.nn.right != null) {
				Q.add(new pair(curr.nn.right, curr.axis + 1));
			}
		}
//		System.out.println(Left);
		for (int axis = Left.size() - 1; axis > 0; axis--) {
			for (int ali : Left.get(axis)) {
				System.out.print(ali + " ");
			}
		}
		for (ArrayList<Integer> AL : Right) {
			for (int ali : AL) {
				System.out.print(ali + " ");
			}
		}
//		System.out.println(Right);

	}

	private void construct(String[] arr, int ind, Queue<Node> Q) {
		Q.add(new Node(Integer.parseInt(arr[ind])));
		ind++;
		while (!Q.isEmpty() && ind < arr.length) {
			Node nn = Q.poll();
			if (ind < arr.length) {
				nn.left = new Node(Integer.parseInt(arr[ind]));
				ind++;
				Q.add(nn.left);
			}
			if (ind < arr.length) {
				nn.right = new Node(Integer.parseInt(arr[ind]));
				ind++;
				Q.add(nn.right);
			}
		}
	}

	public void display() {
		display_tree(this.root);
	}

	private void display_tree(Node root) {
		if (root == null)
			return;
		String str = root.data + "";
		if (root.left != null) {
			str = root.left.data + " <= " + str;
		} else {
			str = "END <= " + str;
		}

		if (root.right != null) {
			str = str + " => " + root.right.data;
		} else {
			str = str + " => END";
		}
		System.out.println(str);
		display_tree(root.left);
		display_tree(root.right);

	}

}