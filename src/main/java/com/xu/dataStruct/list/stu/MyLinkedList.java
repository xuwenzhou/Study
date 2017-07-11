package com.xu.dataStruct.list.stu;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 双向链表
 * @author 39767
 *
 * @param <T>
 */
public class MyLinkedList<T> implements Iterable<T> {
	private int myListSize;
	private int modCount = 0;
	private Node<T> beginMarker;
	private Node<T> endMarker;
	
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		clear();
	}
	
	public MyLinkedList(Collection<? extends T> c){
		this();
		addAll(c);
	}
	
	public void clear(){
		beginMarker = new Node<T>(null,null,endMarker);
		endMarker = new Node<T>(null, beginMarker, null);
		
		myListSize = 0;
		modCount++;
	}
	
	public int size(){
		return myListSize;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public T set(int index, T newValue){
		Node<T> node = getNode(index);
		T oldValue = node.date;
		node.date = newValue;
		return oldValue;
	}
	
	public T get(int index){
		return getNode(index).date;
	}
	
	public boolean add(T x){
		add(size(), x);
		return true;
	}
	
	public void add(int index, T x){
		addBefore(getNode(index),x);
	}
	
	public void addAll(Collection<? extends T> c){
		addAll(size(), c);
	}
	
	public void addAll(Iterable<? extends T> c){
		Iterator<? extends T> iterator = c.iterator();
		while(iterator.hasNext()){
			add(iterator.next());
		}
	}
	
	/**
	 * 添加集合
	 * @param index
	 * @param c
	 */
	@SuppressWarnings("unchecked")
	public void addAll(int index, Collection<? extends T> c){
		Node<T> indexNode = getNode(index);
		Node<T> prevNode = indexNode.prev;
		Node<T> newNode;
		
		Object[] o = c.toArray();
		int oLength = o.length;
		
		if(oLength == 0)
			return;
		
		for(int i = 0; i < oLength; i++){
			newNode = new Node<T>((T)o[i], prevNode, indexNode);
			prevNode.next = newNode;
			prevNode = newNode;
		}
		
		indexNode.prev = prevNode;
		myListSize += oLength;
	}
	
	public T remove(int index){
		return remove(getNode(index));
	}
	
	/**
	 * 移除所有集合的C集合
	 * @param c
	 */
	public void removeAll(Iterable<? extends T> c){
		Iterator<? extends T> iterator = c.iterator();
		while(iterator.hasNext()){
			Node<T> node = beginMarker.next;
			T t = iterator.next();
			while(node != endMarker){
				if(t == node.date){
					remove(node);
					node = node.next;
				}
				else
					node = node.next;
			}
		}
	}
	
	/**
	 * 是否包含指定元素
	 * @param t
	 * @return
	 */
	public boolean contains(T t){
		Node<T> node = beginMarker.next;
		boolean flg = false;
		while(node != endMarker){
			if(t == node.date){
				flg = true;
				break;
			}
			else
				node = node.next;
		}
			
		return flg;
	}
	
	public void exchange(int index){
		exchange(getNode(index));
	}
 	
	private void exchange(Node<T> node){
		exchange(node.prev, node);
	}
	
	/**
	 * 交换两相邻的链
	 * @param prevNode
	 * @param node
	 */
	private void exchange(Node<T> prevNode,Node<T> node){
		if(prevNode == beginMarker)
			throw new IndexOutOfBoundsException();
		prevNode.prev.next = node;
		node.next.prev = prevNode;
		prevNode.next = node.next;
		node.prev = prevNode.prev;
		prevNode.prev = node;
		node.next = prevNode;
	}
	
	/**
	 * 在index前插入元素
	 * @param node
	 * @param x
	 */
	private void addBefore(Node<T> node, T x){
		node.prev = node.prev.next = new Node<T>(x, node.prev, node);
		myListSize++;
		modCount++;
	}
	
	/**
	 * 移除元素
	 * @param node
	 * @return
	 */
	private T remove(Node<T> node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
		myListSize--;
		modCount++;
		
		return node.date;
	}
	
	private Node<T> getNode(int index){
		Node<T> node;
		if(index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		
		if(index < size()/2){
			node = beginMarker.next;
			for(int i = 0; i < index; i++)
				node = node.next;
		}
		else{
			node = endMarker;
			for(int i = size(); i > index; i--){
				node = node.prev;
			}
		}
		
		return node;
	}
	

	private static class Node<T>{
		public T date;
		public Node<T> prev;
		public Node<T> next;
		
		public Node(T date, Node<T> prev, Node<T> next){
			this.date = date;
			this.prev = prev;
			this.next = next;
		}
	}
	
	
	@Override
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements ListIterator<T>{
		private Node<T> currentNext = beginMarker.next;
		private Node<T> currentPrev = endMarker.prev;
		private int nextIndex = 0;
		private int prevIndex = myListSize - 1;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		private boolean okToAdd = false;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNext != endMarker;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!hasNext())
				throw new NoSuchElementException();
			
			T nextItem = currentNext.date;
			currentNext = currentNext.next;
			nextIndex++;
			okToRemove = true;
			okToAdd = true;
			
			return nextItem;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return currentPrev != beginMarker;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!hasNext())
				throw new NoSuchElementException();
			
			T prevItem = currentPrev.date;
			currentPrev = currentPrev.prev;
			prevIndex--;
			okToRemove = true;
			okToAdd = true;
			
			return prevItem;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return nextIndex;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return prevIndex;
		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub
			if(nextIndex != 0){
				currentNext.prev.date = e;
			}
			else if(prevIndex != myListSize - 1){
				currentPrev.next.date = e;
			}
		}

		@Override
		public void add(T e) {
			// TODO Auto-generated method stub
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!okToAdd)
				throw new IllegalStateException();
			if(nextIndex != 0){
				MyLinkedList.this.addBefore(currentNext.prev, e);
				nextIndex++;
			}
			else if(prevIndex != myListSize - 1){
				MyLinkedList.this.addBefore(currentPrev.next, e);
			}
			okToAdd = false;
			expectedModCount++;
		}
		
		@Override
		public void remove(){
			// TODO Auto-generated method stub
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			if(nextIndex != 0){
				MyLinkedList.this.remove(currentNext.prev);
				nextIndex--;
			}
			else if(prevIndex != myListSize - 1){
				MyLinkedList.this.remove(currentPrev.next);
			}
				
			okToRemove = false;
			expectedModCount++;
		}
		
	}

}
