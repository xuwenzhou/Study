package com.xu.dataStruct.list.stu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.保持基础数组，数组的容量，及存储在MyArrayList中的当前项
 * 2.自动改变数组容量，拷贝老数组至新数组，并回收老数组
 * 3.提供get(),set()方法
 * 4.
 * 5.实现Iterator接口,并提供 next(),hasNext(),remove()等方法的实现
 * 
 * @author 39767
 *
 */
public class MyArrayList<T> implements Iterable<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private int myListSize;
	private int modCount = 0;
	private T[] myArray;
	
	public MyArrayList(){
		clear();
	}
	
	public void clear(){
		myListSize = 0;
		modCount++;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size(){
		return myListSize;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public void trimToSize(){
		ensureCapacity(size());
	}
	
	public T get(int index){
		if(index < 0 || index >= size())
			throw new ArrayIndexOutOfBoundsException();
		return myArray[index];
	}
	
	public T set(int index, T math){
		if(index < 0 || index >= size())
			throw new ArrayIndexOutOfBoundsException();
		
		T old = myArray[index];
		myArray[index] = math;
		return old;
		
	}
	
	public boolean add(T math){
		set(size(), math);
		return true;
	}
	
	public void add(int index, T math){
		if(myArray.length == size())
			ensureCapacity(2 * size() + 1);
		for(int i = size(); i > index; i++)
			myArray[i] = myArray[i - 1];
		myArray[index] = math;
		myListSize++;
		modCount++;
			
	}
	
	public T remove(int index){
		T removedItem = myArray[index];

		for(int i = index; i < size() - 1; i++)
			myArray[i] = myArray[i + 1];
		myListSize--;
		modCount++;
		return removedItem;
	}
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity){
		if(newCapacity < size())
			return;
		T[] old = myArray;
		myArray = (T[])new Object[newCapacity];
		for(int i = 0; i < size(); i++){
			myArray[i] = old[i];
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<T>{
		private int current = 0;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext(){
			return current < size();
		}
		
		public T next(){
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!hasNext())
				throw new NoSuchElementException();
			okToRemove = true;
			return myArray[current++];
		}
		
		public void remove(){
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			MyArrayList.this.remove(--current);
			okToRemove = false;
			expectedModCount++;
		}
		
	}

}
