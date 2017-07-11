package com.xu.dataStruct.tree.stu;

import java.util.Comparator;

/**
 * 二叉查找树
 * @author 39767
 *
 * @param <T>
 */
public class BinarySearchTree<T> {
	
	public BinaryNode<T> root;
	private Comparator<? super T> cmp;
	
	public BinarySearchTree(){
		this(null);
	}
	
	public BinarySearchTree(Comparator<? super T> c){
		clear();
		this.cmp = c;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	private void clear(){
		root = null;
	}
	
	public boolean contains(T t){
		return contains(t, root);
	}
	
	public T findMin(){
		return findMin(root).t;
	}
	
	public T findMax(){
		return findMax(root).t;
	}
	
	public BinaryNode<T> insert(T t){
		return root = insert(t, root);
	}
	
	public void remove(T t){
		root = remove(t, root);
	}
	
	private boolean contains(T t, BinaryNode<T> rootNode) {
		if(null == rootNode)
			return false;
		
		int compareResult = myCompare(t, rootNode.t);
		if(compareResult == 0)
			return true;
		else if (compareResult < 0)
			return contains(t, rootNode.left);
		else
			return contains(t, rootNode.right);
	}
	
	private BinaryNode<T> findMin(BinaryNode<T> rootNode) {
		if(null == rootNode)
			return null;
		else if(null != findMin(rootNode).left)
			return findMin(rootNode);
		return rootNode;
	}
	
	private BinaryNode<T> findMax(BinaryNode<T> rootNode) {
		if(null == rootNode)
			return null;
		else if(null != findMax(rootNode).right)
			return findMax(rootNode);
		return rootNode;
	}

	private BinaryNode<T> insert(T t, BinaryNode<T> rootNode) {
		if(null == rootNode)
			return new BinaryNode<T>(t, null, null);
		
		int compareResult = myCompare(t, rootNode.t);
		if(compareResult < 0)
			rootNode.left = insert(t, rootNode.left);
		else if(compareResult > 0)
			rootNode.right = insert(t, rootNode.right);
		
		return rootNode;
	}
	
	private BinaryNode<T> remove(T t, BinaryNode<T> rootNode) {
		return null;
	}
	
	private int myCompare(T left, T right){
		if(null != cmp)
			return cmp.compare(left, right);
		else
			return ((Comparable)left).compareTo(right);
	}

	private static class BinaryNode<T>{
		T t;
		BinaryNode<T> left;
		BinaryNode<T> right;
		
		BinaryNode(T t) {
			this(t, null, null);
		}
		
		BinaryNode(T t, BinaryNode<T> lt, BinaryNode<T> rt){
			this.t = t;
			this.left = lt;
			this.right = rt;
		}
	}
	
	public static void main(String[] arg){
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		
		System.out.println(tree.insert(4).t);
		System.out.println(tree.root.t);
	}
}
