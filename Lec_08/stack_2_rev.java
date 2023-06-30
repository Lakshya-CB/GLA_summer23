package Lec_08;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class stack_2_rev {
	public static void main(String[] args) {
//		PriorityQueue<Integer> PQ = new PriorityQueue<>();
//		PQ.add(10);
//		PQ.add(2);
//		PQ.add(5);
//		PQ.add(90);
//		PQ.add(90);
//		PQ.add(0); // log(n)
//		PQ.add(1000);
//		System.out.println(PQ.poll());
//		System.out.println(PQ.poll());
//		System.out.println(PQ.poll()); // log(n)
//		System.out.println(PQ.poll());
//		System.out.println(PQ.poll());
//		System.out.println(PQ.poll());
		int[] nums = { 2, 4, 3, 0, 6, 3, 5};
//				      [3, 5, 5, 5, 10, 8, 10, 8, 10, 9, -1, -1, -1, -1, -1, -1]
//					3,5,5,3,10,8,10,8,10,9,-1,-1,-1,-1,-1,-1]

		System.out.println(Arrays.toString(secondGreaterElement(nums)));
	}

	public static int[] secondGreaterElement(int[] arr) {
		
		int[] ans = new int[arr.length];
		Arrays.fill(ans, -1);
		Stack<Integer> A = new Stack<>();
		Stack<Integer> Second = new Stack<>();
		Stack<Integer> tempS = new<Integer> Stack();
		
		for (int idx = 0; idx < arr.length; idx++) {
			int B = arr[idx];
//			tu kis kis ka second next greater hein!!
			while (!Second.isEmpty() && B > arr[Second.peek()]) {
				int temp = Second.pop();
				ans[temp] = B;
				System.out.println(arr[temp] + " => " + B);
			}
			
			while (!A.isEmpty() && B > arr[A.peek()]) {	
//				Second.add(A.pop());
				tempS.add(A.pop());
			}
			while(!tempS.isEmpty()) {
				Second.add(tempS.pop());
			}
			A.add(idx);
			System.out.println(B+"=>"+A + " - "+Second );
			
		}
		return ans;
	}
}
