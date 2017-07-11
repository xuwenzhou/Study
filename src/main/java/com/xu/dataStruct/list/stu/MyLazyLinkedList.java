package com.xu.dataStruct.list.stu;

/**
 * 包含惰性删除方法的链表
 * @author 39767
 *
 */
public class MyLazyLinkedList<E> {
	private int realSize;
	private int deletedSize;
	private Node<E> head;
	private Node<E> tail;
	
	public MyLazyLinkedList(){
		clear();
	}
	
	public int size(){
		return realSize + deletedSize;
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
		realSize++;
	}
	
	//删除末端
	public E remove(){
		return remove(size() - 1);
	}
	
	//删除指定位
	public E remove(int index){
		if(index >= size())
			throw new IndexOutOfBoundsException();
		
		Node<E> node = getNode(index);
		if(node.flag){
			node.flag = false;
			realSize--;
			deletedSize++;
		}
		
		if(realSize == deletedSize){
			//确定新链的头节点
			while(head.flag == false)
				head = head.next;
			delete(head);
			
		}
		return node.data;
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
		
		if(index >= realSize)
			throw new IndexOutOfBoundsException();
		
		tagNode = head;
		if(index == 0){
			return tagNode;
		}
		for(int i = 0; i < index; i++){
			tagNode = tagNode.next;
		}
		return tagNode;
	}
	
	private void clear(){
		realSize = deletedSize = 0;
		tail = head = new Node<E>(null, null, null);
	}
	
	//删除false节点，调整链表
	private void delete(Node<E> node){
		if(node.next == null)
			return;
		while(node.flag == false && node.next != null){
			node = node.next;
		}
		if(node.next == null)
			return;
		tail = node.next;
		while(tail.flag == false && tail.next != null){
			tail = tail.next;
		}
		if(node.next == null)
			return;
		splice(node, tail);
		delete(tail);
		
	}
	
	//连接两节点
	private void splice(Node<E> front, Node<E> back){
		front.next = back;
		back.prev = front;
	}
	
	//链结构
	private static class Node<E>{
		public E data;
		public Node<E> prev;
		public Node<E> next;
		public boolean flag;

		public Node(E data, Node<E> prev, Node<E> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
			this.flag = true;
		}
	}
	
}
