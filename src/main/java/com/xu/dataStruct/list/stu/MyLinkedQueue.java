package com.xu.dataStruct.list.stu;

/**
 * 队列的链表实现
 * @author 39767
 *
 * @param <E>
 */
public class MyLinkedQueue<E> {
	private static final int MAX_SIZE = 100;
	private Node<E> beginMaker;
	private Node<E> endMaker;
	private int size;
	
	public MyLinkedQueue(){
		clear();
	}
	
	public boolean isEmpty(){
		return size ==0;
	}
	
	public void clear(){
		beginMaker = new Node<E>(null, null, endMaker);
		endMaker = new Node<E>(null, beginMaker, null);
		size = 0;
	}
	
	//返回队列首元素
	public E font(){
		if(size == 0)
			throw new IndexOutOfBoundsException();
		return beginMaker.next.e;
	}
	
	//返回队列末元素
	public E rear(){
		if(size == 0)
			throw new IndexOutOfBoundsException();
		return endMaker.prev.e;
	}
	
	public E dequeue(){
		if(size == 0)
			throw new IndexOutOfBoundsException();
		E old = beginMaker.next.e;
		beginMaker.next = beginMaker.next.next;
		beginMaker.next.prev = beginMaker;
		size--;
		return old;
	}
	
	public boolean enqueue(E e){
		if(size == MAX_SIZE)
			throw new IndexOutOfBoundsException();
		Node<E> node = new Node<E>(e, endMaker.prev, endMaker);
		endMaker.prev.next = node;
		endMaker.prev = node;
		size++;
		return true;
	}
	
	private static class Node<E>{
		private E e;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n){
			this.e = e;
			this.prev = p;
			this.next = n;
		}
	}
}
