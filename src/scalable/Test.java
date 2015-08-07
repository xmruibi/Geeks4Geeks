package scalable;

public class Test {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		System.out.println(cache.get(2));
		cache.set(2, 2);
		System.out.println(cache.get(2));
	}
}
