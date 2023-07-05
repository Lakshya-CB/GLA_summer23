package Lec_10;

import java.util.Queue;

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

	public void disp() {
		disp(root);
	}

	private void disp(Node nn) {
		if (nn == null) {
			return;
		}
		System.out.println(nn.data);
		disp(nn.left);

		disp(nn.right);
	}

	public BTree(int[] pre, int[] in) {
		root = createTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

	}

	private Node createTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if (ps > pe) {
			return null;
		}
		Node nn = new Node(pre[ps]);
		int f = -1;
		int Lsize = 0;
		for (int i = is; i <= ie; i++) {
			if (in[i] == pre[ps]) {
				f = i;
				break;
			}
			Lsize++;
		}
		nn.left = createTree(pre, ps + 1, ps + Lsize, in, is, f - 1);
		nn.right = createTree(pre, ps + Lsize + 1, pe, in, f + 1, ie);
		return nn;
	}
	public void lvl() {
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		while(!Q.isEmpty()) {
			Node curr = Q.poll();
			System.out.println(curr.data);
			if(curr.left!= null) {
				Q.add(curr.left);
			}
			if(curr.right!= null) {
				Q.add(curr.right);
			}
		}
	}

}
