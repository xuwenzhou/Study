package com.xu.dataStruct.list.stu;

import java.util.Iterator;

/**
 * 循环链表实现队列
 * @author 39767
 *
 */
public class MyCircularQueue<E> implements Iterable<E>{
	
	private int size;
	Node<E> head;
	Node<E> tail;
	
	public MyCircularQueue(){
		clear();
	}
	
	public int size(){
		return size;
	}
	
	/**
	 * 队尾入队
	 * @param e
	 */
	public void enqueue(E e){
		if (size() == 0) {
			this.head = this.tail = new Node<E>(e, null);
			this.tail.next = head;
			this.head.next = tail;
		}
		else{
			Node<E> newNode = new Node<E>(e, head);
			tail = tail.next = newNode;
		}
		size++;
	}
	
	/**
	 * 队首出队
	 * @return
	 */
	public E dequeue(){
		E removed;
		if(size() == 0)
			throw new NullPointerException();
		else if (size() == 1) {
			removed = head.e;
			clear();
		}
		else {
			removed = head.e;
			head = head.next;
			size--;
		}
		
		return removed;
	}
	
	private void clear(){
		this.head = this.tail = null;
		this.size = 0;
	}
	
	private static class Node<E>{
		public E e;
		public Node<E> next;
		
		public Node(E e, Node<E> next){
			this.e = e;
			this.next = next;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyQueueIterator();
	}
	
	private class MyQueueIterator implements Iterator<E>{
		
		private Node<E> currentNode = tail;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E current = currentNode.e;
			currentNode = currentNode.next;
			return current;
		}
		
	}

}
