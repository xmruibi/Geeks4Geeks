package scalable;

import java.util.*;

public class TopKthLargest {

	private int kth;
	private int initidx = 0;
	private MinHeap minheap;

	public TopKthLargest(int kth) {
		this.kth = kth;
		this.minheap = new MinHeap(10);
	}

	private void insert(int val) {
		if (initidx < kth)
			init(val);
		else if (val < minheap.peekTop())
			minheap.insert(val);
	}

	private void getMin() {
		for (int i = 0; i < kth; i++)
			System.out.print(minheap.pollTop() + " ");
	}

	private void init(int val) {
		minheap.insert(val);
	}

	public static void main(String[] args) {
		Random r = new Random();
		TopKthLargest t = new TopKthLargest(10);
		for (int i = 0; i < 20; i++) {
			int val = r.nextInt(100);
			t.insert(val);
			System.out.print(val + " ");
		}
		System.out.println("\n");
		t.getMin();
	}

}
