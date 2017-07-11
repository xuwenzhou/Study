package com.xu.dataStruct.list.stu;

public class MyArrayQueue<E> {
	private static final int MAX_SIZE = 10;
	private int front;
	private int back;
	private E[] theArray;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayQueue(){
		theArray = (E[])new Object[10];
		size = 0;
		front = 0;
		back = -1;
	}
	
	public void enqueue(E e){
		if(size == MAX_SIZE)
			throw new IndexOutOfBoundsException();
		if(back == MAX_SIZE - 1)
			back = 0;
		else
			back++;
		theArray[back] = e;
		size++;
	}
	
	public E dequeue(){
		if(size == 0)
			throw new IndexOutOfBoundsException();
		
		E outVal = theArray[front];
		theArray[front] = null;
		if(front == MAX_SIZE - 1)
			front = 0;
		else
			front++;
		size--;
		return outVal;
	}

}
