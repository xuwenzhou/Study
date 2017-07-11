package com.xu.dataStruct.list.stu;

/**
 * 
 * @author 39767
 * 单数组实现首尾双栈
 * @param <E>
 */
public class MyDoubleStack<E> {
	private static final int MaxSize = 1024;
	private E[] stackArray;
	private E topStack;
	private E bottomStack;
	private int topIndex;
	private int bottomIndex;
	
	public MyDoubleStack(){
		clear();
	}
	
	@SuppressWarnings("unchecked")
	private void clear(){
		stackArray = (E[]) new Object[MaxSize];
		topIndex = -1;
		bottomIndex = MaxSize;
		topStack = null;
		bottomStack = null;
	}
	
	private boolean isFull(){
		return bottomIndex == topIndex + 1;
	}
	
	public void pushTop(E e){
		if(isFull())
			throw new IndexOutOfBoundsException();
		else{
			topStack = stackArray[++topIndex] = e;
		}
	}
	
	public void pushBottom(E e){
		if(isFull())
			throw new IndexOutOfBoundsException();
		else{
			bottomStack = stackArray[--bottomIndex] = e;
		}
	}
	
	public E popTop(){
		if(topIndex == -1)
			throw new IndexOutOfBoundsException();
		E pushVal = topStack;
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
	
	public E popBottom(){
		if(bottomIndex == MaxSize)
			throw new IndexOutOfBoundsException();
		E pushVal = bottomStack;
		stackArray[bottomIndex] = null;
		if(bottomIndex == MaxSize - 1){
			bottomIndex = MaxSize;
			bottomStack = null;
		}
		else{
			bottomStack = stackArray[--bottomIndex];
		}
		return pushVal;
	}

}
