package scalable;

import java.util.*;

public class LRUCache {

	Map<Integer, Node> map;
	DoublyLinkedList list;

	public LRUCache(int capacity) {
		this.map = new HashMap<>();
		this.list = new DoublyLinkedList(capacity);
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			list.detach(node);
			list.attach(node);
			return node.val;
		} else
			return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);		
			list.detach(node);
			node = new Node(key, value);
			map.put(key, node);
			list.attach(node);
		} else {
			Node node = new Node(key, value);
			if(list.isFull()){
				Node de = list.detach(list.tail.prev);
				map.remove(de.key);
			}
			list.attach(node);
			map.put(key, node);
		}
	}
}

class DoublyLinkedList {
	int size;
	int curSize;
	Node head;
	Node tail;

	public DoublyLinkedList(int size) {
		this.size = size;
		this.curSize = 0;
		this.head = new Node(0,0);
		this.tail = new Node(0,0);
		head.next = tail;
		tail.prev = head;
	}

	public boolean isFull() {
		return this.curSize >= this.size;
	}

	private boolean isEmpty() {
		return this.curSize == 0;
	}

	public void attach(Node node) {
		if (node == null)
			return;
		this.head.next.prev = node;
		node.next = this.head.next;
		node.prev = this.head;
		this.head.next = node;
		this.curSize++;
	}

	public Node detach(Node node) {
		if (isEmpty())
			return null;
		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;
		this.curSize--;
		return node;
	}
}

class Node {
	int key;
	int val;
	Node next;
	Node prev;

	public Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
