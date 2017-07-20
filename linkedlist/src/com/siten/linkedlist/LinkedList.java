package com.siten.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author thomc
 *
 */
public class LinkedList implements Iterable<Integer> {
	private LinkedNode head;

	/**
	 * Append an element into the linked list
	 * 
	 * @param item
	 */
	public void append(Integer item) {
		head = new LinkedNode(item, head);
	}

	/**
	 * Remove the tail element from a linked list
	 *
	 */
	public void removeTail() {
		if (head == null)
			return;
		LinkedNode tmp = head;
		LinkedNode prev = null;
		while (tmp != null && tmp.getNext() != null) {
			prev = tmp;
			tmp = tmp.getNext();
		}
		prev.setNext(null);
	}

	/**
	 * Remove all element in the linked list that is great than a target value
	 * 
	 * @param targetValue
	 */
	public void removeGreaterThan(Integer targetValue) {
		if (head == null)
			return;
		LinkedNode cur = head;

		while (cur != null && (cur.getNext() != null)) {
			if (cur.getNext().getData().compareTo(targetValue) > 0) {
				cur.setNext(cur.getNext().getNext());
			} else {
				cur = cur.getNext();
			}
		}

		if (head.getData().compareTo(targetValue) > 0)
			head = head.getNext();
	}

	/**
	 * For iterator
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new LinkedListIterator(head);
	}

	/**
	 * For printing list to console
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Integer x : this)
			result.append(x + " ");

		return result.toString();
	}

	/**
	 * For initial List test
	 * 
	 * @return
	 */
	private static LinkedList initList() {
		LinkedList list = new LinkedList();
		list.append(7);
		list.append(6);
		list.append(5);
		list.append(4);
		list.append(3);
		list.append(2);
		list.append(1);
		return list;
	}

	/**
	 * Linked Node class
	 * 
	 * @author thomc
	 *
	 */
	private class LinkedNode {
		private Integer data;
		private LinkedNode next;

		public LinkedNode(Integer data, LinkedNode next) {
			this.data = data;
			this.next = next;
		}

		public Integer getData() {
			return data;
		}

		public LinkedNode getNext() {
			return next;
		}

		public void setNext(LinkedNode next) {
			this.next = next;
		}

	}

	/**
	 * Iterator class
	 * 
	 * @author thomc
	 *
	 */
	private class LinkedListIterator implements Iterator<Integer> {
		private LinkedNode nextNode;

		public LinkedListIterator(LinkedNode head) {
			nextNode = head;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Integer res = nextNode.getData();
			nextNode = nextNode.getNext();
			return res;
		}
	}

	/**
	 * Testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = initList();
		System.out.print("Before append: ");
		System.out.println(list);
		list.append(0);
		System.out.print("After  append: ");
		System.out.println(list);

		list = initList();
		System.out.print("Before remove tail: ");
		System.out.println(list);
		list.removeTail();
		System.out.print("After  remove tail: ");
		System.out.println(list);

		list = initList();
		int r = 7;
		System.out.print("Before removeGreaterThan " + r + ": ");
		System.out.println(list);
		list.removeGreaterThan(r);
		System.out.print("After  removeGreaterThan " + r + ": ");
		System.out.println(list);

		list = initList();
		r = 5;
		System.out.print("Before removeGreaterThan " + r + ": ");
		System.out.println(list);
		list.removeGreaterThan(r);
		System.out.print("After  removeGreaterThan " + r + ": ");
		System.out.println(list);

		list = initList();
		r = 6;
		System.out.print("Before removeGreaterThan " + r + ": ");
		System.out.println(list);
		list.removeGreaterThan(r);
		System.out.print("After  removeGreaterThan " + r + ": ");
		System.out.println(list);

		list = initList();
		r = 1;
		System.out.print("Before removeGreaterThan " + r + ": ");
		System.out.println(list);
		list.removeGreaterThan(r);
		System.out.print("After  removeGreaterThan " + r + ": ");
		System.out.println(list);

		list = initList();
		r = 0;
		System.out.print("Before removeGreaterThan " + r + ": ");
		System.out.println(list);
		list.removeGreaterThan(r);
		System.out.print("After  removeGreaterThan " + r + ": ");
		System.out.println(list);

	}

}