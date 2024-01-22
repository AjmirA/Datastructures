package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Fix multiple stacks in a single array
 * @author 
 *
 */
public class Stacks_Into_Array{
	int stackCapacity;
	int noOfStack=3;
	int[] values;
	int[] sizes;
	
	public Stacks_Into_Array(int stackSize) {
		stackCapacity=stackSize;
		values=new int[noOfStack*stackSize];
		sizes=new int[noOfStack];
	}
	boolean isFull(int stackNo) {
		return sizes[stackNo]==stackCapacity;
	}
	int indexOfTop(int stackNo) {
		int offset=stackNo*stackCapacity;
		int size=sizes[stackNo];
		return offset+size-1;
	}
	void push(int stackNo,int val) {
		if(isFull(stackNo)) {
			System.out.println("Stack "+stackNo+" is full");
		}
		sizes[stackNo]++;
		values[indexOfTop(stackNo)]=val;
	}
	void pop(int stackNo) {
		if (sizes[stackNo] >0) {
			int popElement=indexOfTop(stackNo);
			sizes[stackNo]--;
			System.out.println("Pop Element=" + values[popElement]);
		}
	}
	
	void peek(int stackNo) {
		if (sizes[stackNo] >0) {
			int popElement=indexOfTop(stackNo);
			System.out.println("Peak Element=" + values[popElement]);
		}else {
			System.out.println("Stack in empty in peek");
		}
	}
	public static void main(String[] args) {
		Stacks_Into_Array fixMultiStackInArray =new Stacks_Into_Array(3);
		fixMultiStackInArray.push(0, 1);
		fixMultiStackInArray.push(0, 2);
		fixMultiStackInArray.push(0, 3);
		fixMultiStackInArray.peek(0);
		fixMultiStackInArray.pop(0);
		fixMultiStackInArray.pop(0);
		
		fixMultiStackInArray.push(0, 4);
		fixMultiStackInArray.peek(0);
	}
}
/**Find mind vaue in the stack when ever its called
 * 
 * @author 
 *
 */
class StackNode{
	Object data;
	StackNode next;
	
	public StackNode(Object val) {
		this.data=val;
	}
}

class StackImpl{
	static StackNode top;
	static StackNode mTop;
	static StackNode s2;
	Stack s=new Stack();
	int min;
	public static void main(String[] args) {
		StackImpl obj =new StackImpl();
		obj.push(0);
		obj.pop();
		
		obj.getMin();
		obj.print(top);
		
	}
	void push(int val) {
		if(s.peek()==null || val<=(int)s.peek().data) {
			s.push(val);
		}
		StackNode stack=new StackNode(val);
		stack.next=top;
		top=stack;		
	}
	
	void pop() {
		System.out.println("popped Element="+top.data);
		if(top.data==s.peek().data)
			s.pop();
		top=top.next;
	}
	
	
	StackNode peek() {
		System.out.println("popped Element="+top.data);
		return top;
	}
	
	void getMin() {
		if (s != null && s.top != null)
			System.out.println("Min value=" + s.top.data);
		else
			System.out.println("Stack is Empty");
	}
	
	void print(StackNode top) {
		while(top!=null) {
			System.out.println(top.data);
			top=top.next;
		}
	}	
}

class Stack {
	 StackNode top;
	public StackNode getTop() {
		return top;
	}

	void push(Object val) {
		StackNode a = new StackNode(val);
		a.next = top;
		top = a;
	}

	StackNode pop() {
		StackNode temp=top;
		top = top.next;
		return temp;
	}

	StackNode peek() {
		return top;
	}
	
	Boolean isEmpty(){
		return top==null;
	}
}

class SortStack{
		public static void main(String[] args) {
			Stack st=new Stack();
			st.push(80);
			st.push(6);
			st.push(72);
			st.push(14);
			print(st);
		Stack tempStack=sortStackValues(st);
		System.out.println("Sorted=");
		print(tempStack);
		
	}
	 static Stack sortStackValues(Stack s) {
		Stack tempStack=new Stack();
		while(!s.isEmpty()) {
			int poppedElement=(int)s.peek().data;
			s.pop();
			if(tempStack.isEmpty()) {
				tempStack.push(poppedElement);
				continue;
			}
			if((int)tempStack.peek().data<poppedElement)
				tempStack.push(poppedElement);
			else {
				while(!tempStack.isEmpty() && (int)tempStack.peek().data>poppedElement) {
					s.push(tempStack.peek().data);
					tempStack.pop();
				}
				tempStack.push(poppedElement);
			}
		}
		return tempStack;
	}
		static void print(Stack s) {
			StackNode top=s.getTop();
			while(top!=null) {		
				System.out.println(top.data);
				top=top.next;
			}
		}
}

class ParanthesisMatching{
	
	public static void main(String[] args) {
		String str="[((a+b))*((c+d))]";
		Boolean flag=findBalancedMethod2(str);
		 
		 if(flag)
			 System.out.println("Balanced");
		 else
			 System.out.println("Not Balanced");
	}

	private static Boolean findBalancedMethod1(String str) {
		Stack s=new Stack();
		for(int i=0;i<str.length();i++) {
			 if(str.charAt(i)=='(') 
				 s.push(str.charAt(i));
			 if(str.charAt(i)==')') 
				 if(s.isEmpty())
				   return false;
				 else
					 s.pop();
				 
		 }
		if(s.isEmpty())
			return true;
		else
			return false;
	}
	
	private static Boolean findBalancedMethod2(String str) {
		int[] val=new int[128];
		int n;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(' || str.charAt(i)=='[') {
				n=str.charAt(i);
				val[n]++;
			}
			if(str.charAt(i)==')') {
				int m='(';
				if(val[m]>0) 
					val[m]--;
				else
					return false;
			}
			if(str.charAt(i)==']') {
				int k='[';
				if(val[k]>0) 
					val[k]--;
				else
					return false;
			}
		}
		
		for(int j=0;j<val.length;j++) {
			if(val[j]!=0)
				return false;
			
		}
		return true;
	}	
	
}

/**
 * Convert Infix To Postfix
 * @author 
 *
 */
class ConvertInfixToPostfix {
	public static void main(String[] args) {
		String infix = "a+b*c-d/e";
		String res = convertToPostfix(infix);
		System.out.println("Converted::" + res);
	}

	private static String convertToPostfix(String infix) {
		String postfix = "";
		try {
			int i = 0;
			Stack s = new Stack();
			while (i < infix.length()) {
				char val = infix.charAt(i);
				if (isOperend(val)) {

					if (s.peek() != null && (precedence(val) < precedence((char) s.peek().data)
							|| precedence(val) == precedence((char) s.peek().data))) {
						postfix = postfix + s.peek().data;
						s.pop();
					} else {
						s.push(val);
						i++;
					}
				} else {
					postfix = postfix + val;
					i++;
				}
			}
			while (!s.isEmpty()) {
				postfix = postfix + s.peek().data;
				s.pop();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postfix;
	}

	static Boolean isOperend(char n) {
		if (n == '+' || n == '-' || n == '*' || n == '/')
			return true;
		else
			return false;
	}

	static int precedence(char n) {
		if (n == '+' || n == '-')
			return 1;
		if (n == '*' || n == '/')
			return 2;
		return 0;

	}
}


