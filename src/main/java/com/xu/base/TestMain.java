package com.xu.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.xu.dataStruct.list.stu.MyStack;


public class TestMain extends BaseController{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] c1 = {1,2,3,4,5};
		Integer[] c2 = {3,4,5,6,7,8,9};
		
		List<Integer> list1 = new ArrayList<>(Arrays.asList(c1));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(c2));
		List<Integer> interList = new ArrayList<>();
		List<Integer> unionList = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		for(; i < list1.size(); i++)
			for (; j < list2.size(); j++) {
				if(list1.get(i) < list2.get(j))
					break;
				else if (list1.get(i) == list2.get(j))
					interList.add(list1.get(i));
			}
		
		int ii = 0;
		int jj = 0;
		for(; ii < list1.size(); ii++)
			for (; jj < list2.size(); jj++) {
				if(list1.get(ii) < list2.get(jj)){
					unionList.add(list1.get(ii));
					break;
				}
				else if (list1.get(ii) == list2.get(jj)){
					unionList.add(list1.get(ii));
					jj++;
					break;
				}
				else{
					unionList.add(list2.get(jj));
				}
			}
		
		if(ii == list1.size()){
			while(jj < list2.size()){
				unionList.add(list2.get(jj));
				jj++;
			}
		}
		else{
			while(ii < list1.size()){
				unionList.add(list1.get(ii));
				ii++;
			}
		}
		
		System.out.println("--------------------------------------交集--------------------------------------");
		for(Integer itg : interList)
			System.out.println(itg);
		
		System.out.println("--------------------------------------并集--------------------------------------");
		for(Integer itg : unionList)
			System.out.println(itg);
	}
	
	//中缀转后缀表达式
	public static void cal(String[] calChar){
		MyStack<String> stack = new MyStack<>();
		String temp;
		
		for (int i = 0; i < calChar.length; i++) {
			temp = calChar[i];
			if(temp.equals("*") || temp.equals("+") || temp.equals("(") || temp.equals(")")){
				//空栈时直接进栈
				if(stack.getTopStack() == null){
					stack.push(temp);
				}
				//最高优先级，直接进栈
				else if(temp.equals("(")){
					stack.push(temp);
				}
				//最高优先级，"("前的所有符号顺序出栈
				else if(temp.equals(")")){
					while(!stack.getTopStack().equals("(")){
						System.out.print(stack.pop());
					}
					stack.pop();//"("出栈
				}
				//temp的优先级低于栈顶时
				else if(temp.equals("+") || temp.equals(stack.getTopStack())){
					System.out.print(stack.pop());
					if(temp.equals("+") && !stack.getTopStack().equals("(")){// "低高"型栈全体出栈，栈最多只可能压住2个符号
						System.out.print(stack.pop());
					}
					stack.push(temp);
					
				}
				//高优先级，入栈
				else {
					stack.push(temp);
				}

			}
			else{
				System.out.print(temp);
			}
		}
		
		while(stack.getTopStack() != null)
			System.out.print(stack.pop());
	}

}
