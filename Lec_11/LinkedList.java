package Lec_11;

import java.util.*;
public class LinkedList {
	static class Node {
    	int data;
    	Node next;
		Node(int data){
        	this.data = data;
        	this.next = null;
		}
	}
	
	static Node head, tail;
	int size = 0;

    public static void main(String args[])throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList obj = new LinkedList();
		while(n-->0){
			obj.addLast(sc.nextInt());
		}
		int k = sc.nextInt();
		head = obj.kthRemoval(k);
		obj.disp();

    }

	public Node kthRemoval(int k){
		Node slow = head, fast = head;
		for(int i = 0; i < k ; i++){
			fast = fast.next;
		}
		while(fast!=null && fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}
	public void disp(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        
    }

	public void addLast(int x){
        Node n = new Node(x);
        if(size==0){
            head = tail = n;
            size++;
        }
        else{
            tail.next = n;
            tail = n;
            size++;
        }
    }
}
