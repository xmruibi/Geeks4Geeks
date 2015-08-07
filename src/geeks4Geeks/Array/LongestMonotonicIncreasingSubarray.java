package geeks4Geeks.Array;

import java.util.*;

public class LongestMonotonicIncreasingSubarray {

	private static int getLen(int[] arr) {
		int[] bucket = new int[arr.length]; // in each bucket, save the largest
											// num
		int len = 1;
		bucket[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < bucket[0])
				bucket[0] = arr[i];
			else if (arr[i] > bucket[len - 1])
				bucket[len++] = arr[i];
			else
				bucket[findBucket(arr, -1, len - 1, arr[i])] = arr[i];
		}
		return len;
	}

	private static int findBucket(int[] arr, int l, int r, int key) {
		while (l < r-1) {
			int m = l + ((r - l) >> 1);
			if(arr[m] >= key)
				r = m;
			else
				l = m;
		}
		return r;
	}

	private static int findIndex(List<Integer> list, int tar) {
		int l = 0, r = list.size();
		while (l < r) {
			int mid = l + ((r - l) >> 1);
			if (list.get(mid) > tar)
				r = mid;
			else
				l = mid + 1;
		}
		return r;
	}

	public static void main(String[] args) {
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(getLen(arr));
	}
}
