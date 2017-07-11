package com.xu.dataStruct.list.stu;

public class MySelfAdjustingList<E> {
	private static final int DEFAULT_SIZE = 1024;
	private E[] array;
	private int size;
	private int maxSize;
	
	@SuppressWarnings("unchecked")
	public MySelfAdjustingList(){
		this.maxSize = DEFAULT_SIZE;
		this.array = (E[])new Object[this.maxSize];
		clear();
	}
	
	@SuppressWarnings("unchecked")
	public MySelfAdjustingList(int size){
		this.maxSize = size;
		this.array = (E[])new Object[this.maxSize];
		clear();
	}
	
	public void add(E e){
		if(size == maxSize)
			throw new IndexOutOfBoundsException();
		move(this.array, e ,size);
		size++;
	}
	
	public void find(E e){
		int index = 0;
		for(;index < size;)
			if(array[index] == e)
				break;
		if(index == size)
			add(e);
		else
			move(this.array, e, index);
	}
	
	private void move(E[] array, E e, int end){
		for (int i = end; i > 0; i--) {
			array[i] = array[i-1];
		}
		array[0] = e;
	}
	
	private void clear() {
		this.size = 0;
	}
}
