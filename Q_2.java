package GLA_test;

import java.util.ArrayList;

public class Q_2 {
	static ArrayList<Integer> AL;
	static int ans =0;
	public static void main(String[] args) {
		// Q1) n-1*f(n-1) + n-1*f(n-2);
		int n = 3;
		AL  = new ArrayList<>();
		ans =0;
		for(int num = 1;num<=n*n;num++) {
			int nof =0;
			for(int div = 1;div<= num;div++) {
				if(num%div==0) {
					nof++;
				}
			}
			if(nof==2) {
				AL.add(num);
			}
		}
		System.out.println(n);
		solve(0, 0, n, "{0-0}");
		System.out.println();
		System.out.println(ans);
	}

	public static void solve(int r, int c, int n,String path) {
		int curr_num = r*n+c+1;
		if(r>n-1||c>n-1|| AL.indexOf(curr_num)%2==0) {
			return;
		}
		if(r==n-1&&c==n-1) {
			System.out.print(path+" ");
			ans++;
			return;
		}
//		if port
		if(AL.indexOf(curr_num)%2==1) {
			solve(n-1, n-1, n, path+"P{"+(n-1)+"-"+(n-1)+"}");
		}
		
//		knight

		solve(r+2, c+1, n,path+"K{"+(r+2)+"-"+(c+1)+"}");
		solve(r+1, c+2, n,path+"K{"+(r+1)+"-"+(c+2)+"}");
		if(r==0 ||c==0||r==n-1||c==n-1) {
//			haathi
			for(int C = c+1;C<n;C++) {
				solve(r, C, n, path+"R{"+r+"-"+C+"}");
			}
			for(int R = r+1;R<n;R++) {
				solve(R, c, n, path+"R{"+R+"-"+c+"}");
				
			}
			
			
		}
//		detect diagonal
		if(r==c||r+c==n-1) {
			int R =r+1;
			int C = c+1;
			while(R<n && C<n) {
				solve(R, C, n, path+"B{"+R+"-"+C+"}");
				R++;
				C++;
			}
		}
	}
}
