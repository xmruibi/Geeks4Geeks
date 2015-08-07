package geeks4Geeks.Array;

import java.util.*;

public class MaxmiumSubarrayOfSizeK {
	private static void getMaxmium(int[] arr, int k) {
		Deque<Integer> deque = new ArrayDeque<>(); // saving index
		for (int i = 0; i < arr.length; i++) {
			while(!deque.isEmpty()&&deque.peekFirst()<=i-k)
				deque.pollFirst();
			while(!deque.isEmpty()&&arr[deque.peekLast()]<arr[i])
				deque.pollLast();
			
			deque.offer(i);
			if(i>=k - 1)
				System.out.print(arr[deque.peekFirst()]+" ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		getMaxmium(arr, 4);
	}
}
