package geeks4Geeks.Array;

import java.util.*;

public class SortByFrequency {
	private static void sortByFrequency(int[] arr) {
		Arrays.sort(arr);
		List<int[]> tab = new ArrayList<>();
		int cnt = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1 &&	 arr[i] == arr[i + 1])
				cnt++;
			else {
				tab.add(new int[] { arr[i], cnt });
				cnt = 1;
			}
		}
		Collections.sort(tab, (o1, o2) -> Integer.compare(o2[1], o1[1]));
		for (int[] cur : tab) {
			for (int i = 0; i < cur[1]; i++)
				System.out.print(cur[0] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 2, 8, 5, 6, 8, 8 };
		sortByFrequency(arr);
	}
}
