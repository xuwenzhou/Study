package com.xu.dataStruct.list.stu;

/**
 * 栈的数组实现
 * @author 39767
 *
 * @param <E>
 */
public class MyStack<E> {
	private static final int SIZE = 1024;
	private E[] stackArray;
	private int topIndex;
	private E topStack;
	
	@SuppressWarnings("unchecked")
	public MyStack(){
		this.stackArray = (E[])new Object[SIZE];
		topIndex = -1;
		topStack = null;
	}
	
	public void push(E e){
		if(topIndex >= SIZE -1)
			throw new IndexOutOfBoundsException();
		topStack = stackArray[++topIndex] = e;
	}
	
	public E pop(){
		if(topIndex < 0)
			throw new IndexOutOfBoundsException();
		E pushVal = stackArray[topIndex];
		stackArray[topIndex] = null;
		if(topIndex == 0){
			topIndex = -1;
			topStack = null;
		}
		else{
			topStack = stackArray[--topIndex];
		}
		return pushVal;
	}
	
	public E getTopStack(){
		return topStack;
	}
}
