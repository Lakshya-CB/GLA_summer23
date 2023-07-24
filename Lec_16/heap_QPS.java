package Lec_16;

import java.util.PriorityQueue;

public class heap_QPS {

	public static void topK(int[] arr, int k) {
		PriorityQueue<Integer> PQ =new PriorityQueue<>();
		for(int ali: arr) {
			PQ.add(ali);
			if(PQ.size()>k) {
				PQ.poll();
			}
		}
	}
}
