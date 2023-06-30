package Lec_09;

import java.util.Stack;

public class LinkedList {
	class Node {
		public Node(int ali) {
			// TODO Auto-generated constructor stub
			data = ali;
		}

		int data;
		Node next;
	}

	Node head;

	public void disp() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}
		System.out.println("end");
	}

	public int size() {
		Node temp = head;
		int cnt = 0;
		while (temp != null) {
			cnt++;
			temp = temp.next;
		}
		return cnt;
	}

	public int getFirst() {
		if (isEmpty()) {
			throw new RuntimeException("kya dheek rha hein?");
		}
		return head.data;
	}

	public int getLast() {
		if (isEmpty()) {
			throw new RuntimeException("kya dheek rha hein?");
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	public int getAt(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("kya dheek rha hein?");
		}
		Node temp = head;
		for (int cnt = 0; cnt < idx; cnt++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getNodeAt(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("Internally : kya dheek rha hein?");
		}
		Node temp = head;
		for (int cnt = 0; cnt < idx; cnt++) {
			temp = temp.next;
		}
		return temp;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int ali) {
		Node nn = new Node(ali);
		nn.next = head;
		head = nn;
	}

	public void addLast(int ali) {
		if (isEmpty()) {
			addFirst(ali);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node nn = new Node(ali);
		temp.next = nn;
	}

	public void addAt(int idx, int ali) {
		if (idx < 0 || idx > size()) {
			throw new RuntimeException("kya daal rha hein?");
		}
		if (idx == 0) {
			addFirst(ali);
		} else if (idx == size()) {
			addLast(ali);
		} else {

			Node nn = new Node(ali);
			Node prev = getNodeAt(idx - 1);
			Node after = prev.next;
			nn.next = after;
			prev.next = nn;
		}
	}

	public void Rev() {
		Rev(head);
	}

	private Node Rev(Node curr) {
		if (curr.next == null) {
			head = curr;
			return curr;
		}
		Node Tail = Rev(curr.next);
		Tail.next = curr;
		curr.next = null;
		return curr;
	}

	public void revK(int K) {
		Stack<Node> S = new Stack<>();
		Node curr = head;
		Node nHead = null;
		Node nTail = null;
		while (curr != null) {
			Node after = curr.next;
			S.add(curr);
			if (S.size() == K) {
				while (!S.isEmpty()) {
					Node nn = S.pop();
//					add this to the end!!
					if (nTail == null) {
						nHead = nn;
						nTail = nn;
						nTail.next = null;// guud practice
					} else {
						nTail.next = nn;
						nTail = nn;
						nTail.next = null;
					}

				}
			}
			curr = after;
		}
		head = nHead;

	}

}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        for(int cnt = 0;cnt<k;cnt++){
            temp = temp.next;
            if(temp==null && cnt<k-1){
                return head;
            }
        }
        ListNode sp = reverseKGroup(temp,k);
        ListNode curr = head;
        ListNode prev = null;
        for(int i=0;i<k;i++){
            ListNode after = curr.next;
            curr.next = prev;

            prev = curr;
            curr = after;
        }
        head.next = sp;

        return prev;
    }
}
