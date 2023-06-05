package Lec_Rec01;

public class array_print {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40 };
		printT3(0,arr.length-1, arr);
	}

	public static void printT1(int s, int[] arr) {
		if(s==arr.length) {
			return;
		}
//		BP : printT1(0,arr)
//		SP : printT1(1,arr)
		System.out.println(arr[s]);
		printT1(s+1,arr);// 20,30,40
	}
	public static void printT2(int e, int[] arr) {
		if(e<0) {
			return;
		}
//		Bp : printT2(e,arr) //(3,arr)
//		SP : printT2(e-1,arr) // (2,arr)

		printT2(e-1, arr); // 10,20,30
		System.out.println(arr[e]); //40

	}
	
	public static void printT3(int s, int e, int[]arr) {
		if(s>e) {
			return;
		}
		int mid = (s+e)/2;
		printT3(s, mid-1, arr);
		System.out.println(arr[mid]);
		printT3(mid+1,e, arr);
	}
}
