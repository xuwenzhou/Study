package com.xu.dataStruct.list.stu;

/**
 * 单节点单向链表
 * @author 39767
 *
 */
public class MySingleLinkedList<E> {
	private int size;
	private Node<E> head;
	
	private static class Node<E>{
		public E date;
		public Node<E> prev;
		public Node<E> next;
		
		public Node(E date, Node<E> prev, Node<E> next){
			this.date = date;
			this.prev = prev;
			this.next = next;
		}
	}
	
	public MySingleLinkedList(){
		clear();
	}
	
	public void clear(){
		head = new Node<E>(null, head, head);
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public void show(){
		Node<E> node = head.next;
		while(node != head){
			System.out.println(node.date + ",");
		}
	}
	
	public boolean contains(E e){
		Node<E> node = head.next;
		boolean flg = false;
		while(node != head){
			if(e.equals(node.date)){
				flg = true;
				break;
			}
			else
				node = node.next;
		}
		return flg;
	}
	
	public void addOrRemove(E e) {
		Node<E> node = head.next;
		int oldSize = size;
		while(node != head){
			if(e.equals(node.date)){
				node.prev.next = node.next;
				node.next.prev = node.prev;
				size--;
			}
			node = node.next;
		}
		
		if(oldSize == size){
			head.prev = head.prev.next = new Node<E>(e, head.prev, head);
			size++;
		}
	}
	
	public void addOrRemoveBySort(E e){
		Node<E> node = head.next;
		int oldSize = size;
		
		if(size == 0){
			head.prev = head.prev.next = new Node<E>(e, head.prev, head);
		}
		if(size == 1){
			if(e.equals(node.date)){
				head.next = head;
				head.prev = head;
			}
		}
		while(node != head){
			if(e.equals(node.date)){
				node.prev.next = node.next;
				node.next.prev = node.prev;
				size--;
			}
			node = node.next;
		}
		
		if(oldSize == size){
			head.prev = head.prev.next = new Node<E>(e, head.prev, head);
			size++;
		}
	}
	
}
