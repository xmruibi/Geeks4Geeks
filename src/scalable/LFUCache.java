package scalable;

import java.util.*;

public class LFUCache {

	int size = 0;
	int cursor = 0;
	PriorityQueue<Info> queue;
	Map<Integer, Info> map;

	public LFUCache(int capacity) {
		this.size = capacity;
		this.queue = new PriorityQueue<>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o2.freq - o1.freq;
			};
		});
		this.map = new HashMap<>();
	}

	private void insert(Info info) {
		
		if (map.containsKey(info.key)) {
			map.put(info.key, map.get(info.key).update());
		} else {
			if (cursor == size) {
				Info remove = queue.poll();
				System.out.println("Remove" + remove.key);
				map.remove(remove.key);
				cursor--;
			}
			map.put(info.key, info);
			queue.offer(map.get(info.key));
			cursor++;
		}
	}

	private void getInfo() {
		while(!queue.isEmpty()) {
			System.out.println(queue.poll().key);
		}
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(5);
		Info i1 = new Info(1, 10);
		Info i2 = new Info(2, 10);
		Info i3 = new Info(3, 10);
		Info i4 = new Info(4, 10);
		Info i5 = new Info(5, 10);
		Info i6 = new Info(6, 10);
		Info i7 = new Info(7, 10);

		cache.insert(i1);
		cache.insert(i2);
		cache.insert(i3);
		cache.insert(i2);
		cache.insert(i3);
		cache.insert(i2);
		cache.insert(i2);cache.insert(i2);cache.insert(i2);
		cache.insert(i3);
		cache.insert(i4);
		cache.insert(i5);
		cache.insert(i6);
		cache.insert(i4);
		cache.insert(i7);
		cache.insert(i6);
		cache.insert(i6);
		cache.insert(i6);
		cache.insert(i6);
		cache.insert(i6);

		cache.getInfo();
	}

}

class Info {
	int key, val, freq;

	public Info(int key, int val) {
		this.key = key;
		this.val = val;
		this.freq = 1;
	}

	public Info update() {
		this.freq++;
		return this;
	}
}
