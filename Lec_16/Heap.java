package Lec_16;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> AL = new ArrayList<>();

	public void add(int ali) {
		AL.add(ali);
		upheapify(AL.size() - 1);
	}

	private void upheapify(int ch) {
		int p = (ch - 1) / 2;
		if (AL.get(p) > AL.get(ch)) {
			swap(ch, p);
			upheapify(p);
		}
	}

	private void swap(int i, int j) {
		int tmep = AL.get(i);
		AL.set(i, AL.get(j));
		AL.set(j, tmep);

	}

	public int poll() {
		int ans = AL.get(0);
		AL.set(0, AL.get(AL.size() - 1));
		AL.remove(AL.size() - 1);
		downheapify(0);
		return ans;
	}

	private void downheapify(int p) {
		int L = 2 * p + 1;
		int R = 2 * p + 2;
		int min = p;
		if (L < AL.size() && AL.get(min) > AL.get(L)) {
			min = L;
		}
		if (R < AL.size() && AL.get(min) > AL.get(R)) {
			min = R;
		}
		if (min != p) {
			swap(min, p);
			downheapify(min);
		}
	}

}
