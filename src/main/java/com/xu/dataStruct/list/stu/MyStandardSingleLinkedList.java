package com.xu.dataStruct.list.stu;

import java.util.ListIterator;

public class MyStandardSingleLinkedList<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public MyStandardSingleLinkedList(){
		clear();
	}
	
	public void show(){
		
	}
	
	public int size(){
		return size;
	}
	
	private void clear(){
		this.size = 0;
		this.tail = new Node<E>(null, null);
		this.head = new Node<E>(null, tail);
	}
	
	private static class Node<E>{
		public E data;
		public Node<E> next;
		
		public Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public ListIterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}
	
	private class MyIterator implements ListIterator<E>{
		
		private Node<E> currentNode = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNode.next != tail;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			currentNode = currentNode.next;
			E current = currentNode.data;
			return current;
		}
		
		public void add(E e){
			tail = currentNode.next = new Node<E>(currentNode.data, currentNode.next);
			currentNode.data = e;
			size++;
			if(size == 1){
				head.next = currentNode;
			}
		}
		
		public void remove(){
			currentNode.data = currentNode.next.data;
			currentNode.next = currentNode.next.next;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
