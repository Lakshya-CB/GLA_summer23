package Lec_09;

public class client {
	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
		for (int ali = 10; ali <= 90; ali = ali + 10) {
			LL.addLast(ali);

		}
//		LL.addLast(10);
//		LL.addLast(20);
//		LL.addLast(30);
//		LL.addLast(40);
		LL.disp();
		LL.revK(3);
//		LL.Rev();
		LL.disp();
	}
}
