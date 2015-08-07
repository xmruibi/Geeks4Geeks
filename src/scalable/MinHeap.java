package scalable;

public class MinHeap {
	int[] arr;
	int size;
	int index = 0;

	public MinHeap(int size) {
		this.size = size + 1;
		this.arr = new int[size + 1];
	}

	public void insert(int val) {
		while (index == size-1) {
			removeLargest();
		}
		arr[++index] = val;
		swim(index);
	}

	public int peekTop() {
		return arr[1];
	}

	public int pollTop() {
		int top = arr[1];
		arr[1] = arr[index];
		arr[index--] = 0;
		sink(1);
		return top;
	}

	private void removeLargest() {
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		for (int i = (int) (Math.log(index) / Math.log(2)); i <= index; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		arr[maxIdx] = arr[index];
		arr[index--] = 0;
	}

	private void swim(int idx) {
		while (idx / 2 > 0) {
			int j = idx >> 1;
			if (arr[j] > arr[idx])
				swap(idx, j);
			idx = j;
		}
	}

	private void sink(int idx) {
		while (idx * 2 <= index) {
			int j = idx << 1;
			if (arr[j] > arr[j + 1])
				j++;
			swap(idx, j);
			idx = j;
		}
	}

	private void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
