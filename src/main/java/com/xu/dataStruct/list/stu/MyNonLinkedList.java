package com.xu.dataStruct.list.stu;

/**
 * 无头尾节点
 * @author 39767
 *
 */
public class MyNonLinkedList<E> {
	
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	public MyNonLinkedList(){
		clear();
	}
	
	public int size(){
		return size;
	}
	
	//添加末端
	public void add(E e){
		add(size(), e);
	}
	
	//在指定位添加
	public void add(int index, E e){
		if(index > size())
			throw new IndexOutOfBoundsException();
		if(index == 0){
			tail = head = new Node<E>(e, head.prev, head.next);
		}
		else if(index == size()){
			tail = tail.next = new Node<E>(e, tail, null);
		}
		else{
			Node<E> node = getNode(index);
			node.prev = node.prev.next = new Node<E>(e, node.prev, node);
		}
		size++;
	}
	
	//删除末端
	public E remove(){
		return remove(size() - 1);
	}
	
	//删除指定位
	public E remove(int index){
		if(index >= size())
			throw new IndexOutOfBoundsException();
		E removedVal = null;
		
		if(index == 0){
			removedVal = head.data;
			head = head.next;
			if(size() == 1)
				tail = head;
		}
		else if(index == size() - 1){
			removedVal = tail.data;
			tail = tail.prev;
			tail.next = null;
		}
		else{
			Node<E> node = getNode(index);
			removedVal = node.data;
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
		return removedVal;
	}
	
	//变更指定位值
	public E set(int index, E e){
		E oldVal;
		Node<E> tagNode = getNode(index);
		oldVal = tagNode.data;
		tagNode.data = e;
		return oldVal;
	}
	
	//获取指定位值
	public E get(int index){
		Node<E> node = getNode(index);
		return node.data;
	}
	
	private Node<E> getNode(int index){
		Node<E> tagNode;
		
		if(index >= size)
			throw new IndexOutOfBoundsException();
		
		tagNode = head;
		if(index == 0)
			return tagNode;
		for(int i = 0; i < index; i++){
			tagNode = tagNode.next;
		}
		return tagNode;
	}
	
	//清空链表
	private void clear(){
		size = 0;
		tail = head = new Node<E>(null, null, null);
	}
	
	//链结构
	private static class Node<E>{
		public E data;
		public Node<E> prev;
		public Node<E> next;
		
		public Node(E data, Node<E> prev, Node<E> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
}
