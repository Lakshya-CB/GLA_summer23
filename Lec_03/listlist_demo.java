package Lec_03;

import java.util.ArrayList;
import java.util.List;

public class listlist_demo {
	public static void main(String[] args) {
//		List<String> AL = new ArrayList<>();
		List<List<Integer>> big_AL = new ArrayList<>();
		List<Integer> AL = new ArrayList<>();
		
		AL.add(10);
		big_AL.add(AL);
//		System.out.println(big_AL);
		AL.add(20);
		big_AL.add(AL);
//		System.out.println(big_AL);
		AL.add(30);
		big_AL.add(AL);
//		System.out.println(big_AL);
		AL.add(40);
		big_AL.add(AL);
		System.out.println(big_AL);
	}
}
