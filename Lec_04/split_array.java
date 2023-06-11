package Lec_04;

public class split_array {
	static int solve =0;
	public static void main(String[] args) {
		solve =0;
		int[] arr = { 1, 2, 3, 3, 4, 5 };
		solve(0, "", 0, "", 0, arr);
		System.out.println(solve);
	}

	public static void solve(int idx, String G1, int sum1, String G2, int sum2, int[] arr) {
		if (idx == arr.length) {
			if (sum1 == sum2) {
				System.out.println(G1 + "and " + G2);
				solve++;
			}
			return;
		}
		solve(idx + 1, G1 + arr[idx] + " ", sum1 + arr[idx], G2, sum2, arr);
		solve(idx + 1, G1, sum1, G2 + arr[idx] + " ", sum2 + arr[idx], arr);

	}
}
