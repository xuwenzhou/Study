package com.xu.dataStruct.list.stu;

/**
 * 双端队列
 * @author 39767
 *
 */
public class MyDoubleQueue<E> {
	private static final int DEFAULT_SIZE = 100;
	private int maxSize;
	private int midIndex;
	private int currentSize;
	private E[] queueArray;
	private int beginIndex;
	private int endIndex;
	
	@SuppressWarnings("unchecked")
	public MyDoubleQueue(){
		this.maxSize = DEFAULT_SIZE;
		this.midIndex = this.maxSize / 2;
		this.queueArray = (E[])new Object[this.maxSize];
		clear();
	}
	
	@SuppressWarnings("unchecked")
	public MyDoubleQueue(int maxSize){
		this.maxSize = maxSize;
		this.midIndex = this.maxSize / 2;
		this.queueArray = (E[])new Object[this.maxSize];
		clear();
	}
	
	public void push(E e){
		if(currentSize == maxSize || beginIndex == 0)
			throw new IndexOutOfBoundsException();
		if(currentSize == 0){
			addFirst(e);
		}
		else{
			queueArray[--beginIndex] = e;
			currentSize++;
		}
	}
	
	public E pop(){
		if(currentSize == 0)
			throw new IndexOutOfBoundsException();
		
		E removeVal;
		if(currentSize == 1){
			removeVal = removeLast();
		}
		else{
			removeVal = queueArray[beginIndex];
			queueArray[beginIndex++] = null;
			currentSize--;
		}
		
		return removeVal;
	}
	
	public void inject(E e){
		if(currentSize == maxSize || endIndex == 0)
			throw new IndexOutOfBoundsException();
		if(currentSize == 0){
			addFirst(e);
		}
		else{
			queueArray[++endIndex] = e;
			currentSize++;
		}
	}
	
	public E eject(){
		if(currentSize == 0)
			throw new IndexOutOfBoundsException();
		
		E removeVal;
		if(currentSize == 1){
			removeVal = removeLast();
		}
		else{
			removeVal = queueArray[endIndex];
			queueArray[endIndex--] = null;
			currentSize--;
		}
		
		return removeVal;
	}
	
	private void addFirst(E e){
		queueArray[midIndex] = e;
		beginIndex--;
		endIndex++;
		currentSize++;
	}
	
	private E removeLast(){
		E last = queueArray[beginIndex];
		queueArray[beginIndex] = null;
		clear();
		return last;
	}
	
	private void clear(){
		this.currentSize = 0;
		this.beginIndex = midIndex + 1;
		this.endIndex = midIndex - 1;
	}
	
}
