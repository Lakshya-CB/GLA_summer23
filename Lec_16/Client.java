package Lec_16;

public class Client {
	public static void main(String[] args) {
		Heap PQ =new Heap();
		PQ.add(10);
		PQ.add(20);
		PQ.add(15);
		PQ.add(26);
		PQ.add(40);
		PQ.add(5);
		System.out.println(PQ.AL);
		System.out.println(PQ.poll());

		System.out.println(PQ.AL);
		System.out.println(PQ.poll());

		System.out.println(PQ.AL);
		System.out.println(PQ.poll());

		System.out.println(PQ.AL);
		System.out.println(PQ.poll());

		System.out.println(PQ.AL);
		System.out.println(PQ.poll());

	}
}
