package Lec_11;

import java.util.Queue;
import java.util.LinkedList;;

public class BTree {
	class Node {
		public Node(int i) {
			data = i;
		}

		int data;
		Node left;
		Node right;
	}

	Node root;

	public void print() {
		print(root);
	}

	private void print(Node nn) {
		if (nn == null) {
			return;
		}
//		BP : nn 
//		SP : nn.left and nn.right
		String str = "";
		if (nn.left != null) {
			str = nn.left.data + "";
		}
		str = str + " => " + nn.data + " <= ";
		if (nn.right != null) {
			str = str + nn.right.data;
		}
		System.out.println(str);
		print(nn.left);
		print(nn.right);
	}

	public BTree(int[] lvl) {
		root = new Node(lvl[0]);
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		int idx = 1;
		while (!Q.isEmpty()) {
			Node curr = Q.poll();

			if (idx < lvl.length && lvl[idx] != -1) {
				curr.left = new Node(lvl[idx]);
				Q.add(curr.left);

			}
			idx++;
			if (idx < lvl.length && lvl[idx] != -1) {
				curr.right = new Node(lvl[idx]);
				Q.add(curr.right);
			}
			idx++;

		}
	}

}
