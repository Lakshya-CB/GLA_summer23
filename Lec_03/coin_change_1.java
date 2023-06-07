package Lec_03;

public class coin_change_1 {
	public static void main(String[] args) {
		int[] coins = {3,2,1,1,1,2,1};
				
		wrtCoin(0, 5 ,coins, "");
	}
	public static void wrtCoin(int idx, int A, int[] arr, String path) {
		if(A==0) {
			System.out.println(path);
			return;
		}
		if(A<0||idx==arr.length) {
			return;
		}
		wrtCoin(idx+1, A-arr[idx], arr, path+arr[idx]);//INclude
		wrtCoin(idx+1, A, arr, path);//Exclude
	}
}
