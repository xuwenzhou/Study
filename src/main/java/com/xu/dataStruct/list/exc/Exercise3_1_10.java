package com.xu.dataStruct.list.exc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.xu.dataStruct.list.stu.MyCircularQueue;
import com.xu.dataStruct.list.stu.MyDoubleQueue;
import com.xu.dataStruct.list.stu.MyStack;
import com.xu.dataStruct.list.stu.MyStandardSingleLinkedList;
import com.xu.math.util.Util;

public class Exercise3_1_10 {

	public static void main(String[] arg){
		System.out.print("习题3.06 Josephus问题");
		System.out.println(_3_06(5, 1));
		System.out.print("习题3.22 1+2*3+(4*5+6)*7 = ");
		_3_22("1,+,2,*,3,+,(,4,*,5,+,6,),*,7".split(","));
		System.out.print("习题3.23 中缀表达式转后缀表达式 a+b*c+(d*e+f)*g = ");
		_3_23("a,+,b,*,c,+,(,d,*,e,+,f,),*,g".split(","));
		System.out.println("习题3.27 栈实现斐波拉契数列演示：" + _3_27(6));
		System.out.print("习题3.28 双端队列演示：");
		_3_28();
		System.out.print("习题3.35 链表循环队列演示：");
		_3_35();
		System.out.print("习题3.37 高效单链表演示：");
		_3_37();
		
		_3_38("15.1");
	}
	
	/**
	 * 习题3.6
	 * 时间复杂度O(n^2)
	 * @param n
	 * @param m
	 * @return
	 */
	public static int _3_06(int n, int m){
		List<Integer> list = new ArrayList<>();
		int i = 1;
		int size = n;
		int index = 0;
		while(i <= n){
			list.add(i);
			i++;
		}
		
		while(size-- > 1){
			index = (index + m) % size;
			System.out.print(list.remove(index) + ",");
		}
		
		return list.get(0);
	}
	
	public static Integer _3_27(int n){
		MyStack<Integer> stack = new MyStack<>();
		
		int i = 0;
		
		if(n <= 2){
			while(i++ < n){
				stack.push(Util.ONE);
			}
		}
		else{
			stack.push(Util.ONE);
			i++;
			stack.push(Util.ONE);
			i++;
			
			Integer first;
			Integer second;
			while(i++ < n){
				first = stack.pop();
				second = stack.pop();
				stack.push(second);
				stack.push(first);
				stack.push(first + second);
			}
			
		}
		
		return stack.getTopStack();
	}
	
	/**
	 * 计算器，中缀转后缀表达式
	 * @param calChar
	 */
	public static void _3_23(String[] calChar){
		MyStack<String> stack = new MyStack<>();
		String input;
		
		for (int i = 0; i < calChar.length; i++) {
			input = calChar[i];
			if(input.equals("*") || input.equals("+") || input.equals("(") || input.equals(")")){
				//空栈时直接进栈
				if(stack.getTopStack() == null){
					stack.push(input);
				}
				//最高优先级，直接进栈
				else if(input.equals("(")){
					stack.push(input);
				}
				//最高优先级，"("前的所有符号顺序出栈
				else if(input.equals(")")){
					while(!stack.getTopStack().equals("(")){
						System.out.print(stack.pop());
					}
					stack.pop();//"("出栈
				}
				//input的优先级低于栈顶时
				else if(input.equals("+") || input.equals(stack.getTopStack())){
					System.out.print(stack.pop());
					if(input.equals("+") && !stack.getTopStack().equals("(")){// "低高"型栈全体出栈，栈最多只可能压住2个符号
						System.out.print(stack.pop());
					}
					stack.push(input);
					
				}
				//高优先级，入栈
				else {
					stack.push(input);
				}

			}
			else{
				System.out.print(input);
			}
		}
		
		while(stack.getTopStack() != null)
			System.out.print(stack.pop());
		System.out.println();
	}
	
	public static void simulate(int n, int m) {
        int[] answer = new int[n];;
        for(int i = 1; i <= n; i++) {
        	answer[i - 1] = 0;
        	for(int j = i; j <= n; j++){
        		answer[i - 1] = (answer[i - 1] + m + 1) % j;
        	}
            System.out.println("answer[" + (i - 1) + "] = " + answer[i - 1]);
        }
    }
	
	/**
	 * 计算器
	 * @param calChar
	 */
	public static void _3_22(String[] calChar){
		//符号栈
		MyStack<String> stack = new MyStack<>();
		//数字栈
		MyStack<String> stackResult = new MyStack<>();
		//输入
		String input;
		
		for (int i = 0; i < calChar.length; i++) {
			input = calChar[i];
			if(input.equals("*") || input.equals("+") || input.equals("(") || input.equals(")")){
				//空栈时直接进栈
				if(stack.getTopStack() == null){
					stack.push(input);
				}
				//最高优先级，直接进栈
				else if(input.equals("(")){
					stack.push(input);
				}
				//最高优先级，"("前的所有符号顺序出栈
				else if(input.equals(")")){
					while(!stack.getTopStack().equals("(")){
						reslut(stackResult, stack.pop());
					}
					stack.pop();//"("出栈
				}
				//input的优先级低于栈顶时
				else if(input.equals("+") || input.equals(stack.getTopStack())){
					reslut(stackResult, stack.pop());
					if(input.equals("+") && !stack.getTopStack().equals("(")){// "低高"型栈全体出栈，栈最多只可能压住2个符号
						reslut(stackResult, stack.pop());
					}
					stack.push(input);
					
				}
				//高优先级，入栈
				else {
					stack.push(input);
				}

			}
			else{
				stackResult.push(input);
			}
		}
		
		while(stack.getTopStack() != null)
			reslut(stackResult, stack.pop());
		
		System.out.println(stackResult.pop());
	}
	
	private static void reslut(MyStack<String> stackResult, String operator){
		if(operator.equals("*"))
			stackResult.push(Integer.valueOf(stackResult.pop()) * Integer.valueOf(stackResult.pop()) + "");
		else if(operator.equals("+"))
			stackResult.push(Integer.valueOf(stackResult.pop()) + Integer.valueOf(stackResult.pop()) + "");
	}
	
	/**
	 * 习题3.28
	 * 双端队列
	 */
	public static void _3_28(){
		MyDoubleQueue<Integer> queue = new MyDoubleQueue<>();
		
		Integer i = 0;
		while(i++ < 10){
			if(i % 2 == 0)
				queue.inject(i);
			else
				queue.push(i);
		}
		
		while(--i > 0){
			if(i % 2 == 0)
				System.out.print(queue.eject() + ",");
			else
				System.out.print(queue.pop() + ",");
		}
		System.out.println();
	}
	
	public static void _3_35(){
		MyCircularQueue<Integer> queue = new MyCircularQueue<>();
		
		Integer i = 0;
		
		while (i++ < 10) {
			queue.enqueue(i);
		}
		
		while (--i > 0) {
			System.out.print(queue.dequeue() + ",");
		}
		System.out.println();
	}
	
	public static void _3_37(){
		MyStandardSingleLinkedList<Integer> list = new MyStandardSingleLinkedList<>();
		
		ListIterator<Integer> iterator1 = list.iterator();
		
		Integer i = 0;
		while(i++ < 10){
			iterator1.next();
			iterator1.add(i);
		}
		
		ListIterator<Integer> iterator2 = list.iterator();
		do {
			System.out.print(iterator2.next() + ",");
		}while (iterator2.hasNext());
		
	}
	
	public static BigDecimal _3_38(String rate){
		BigDecimal bd = new BigDecimal(rate);
		BigDecimal div = new BigDecimal(100);
		
		return bd.divide(div, 3, BigDecimal.ROUND_DOWN);
		
	}
	
	public static String _3_39(String rate){
		return Float.valueOf(rate)/100 + "";
		
	}
}
