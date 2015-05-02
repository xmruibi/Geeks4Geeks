package geeks4Geeks.Array;

public class MajorityElement {
	private int findMajority(int[] num) {
		if (num == null || num.length == 0)
			return -1;
		int counter = 1;
		int cur = num[0];
		for (int i = 1; i < num.length; i++) {
			if (cur != num[i]) {
				counter--;
				if (counter < 0) {
					cur = num[i];
					counter = 1;
				}
			} else if (cur == num[i])
				counter++;
		}
		return cur;
	}
}
