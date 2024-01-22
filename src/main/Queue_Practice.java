package main;

class Queue_Practice {

	static Queue_Practice q=new Queue_Practice();
 static class QueueUsingTwoStack{
		public static void main(String[] args) {
			StackImpl s=q.new StackImpl();
			StackImpl s2=q.new StackImpl();
			driver(s,s2);
			
		}
		
		private static void driver(StackImpl s, StackImpl s2) {
			s.push(6);
			s.push(3);
			s.push(9);
			s.push(5);
			s.push(4);
			s.push(2);
			s.push(8);
			s.push(12);
			s.push(10);

			s.print(s.peek());
			dequeue(s, s2);
			s.push(31);
			s.push(91);
			s.push(5);
			s.print(s.peek());
			dequeue(s, s2);
			s.print(s.peek());
			dequeue(s, s2);
			s.print(s.peek());
			dequeue(s, s2);
			s.print(s.peek());
			dequeue(s, s2);
			s.print(s.peek());
			dequeue(s, s2);
			dequeue(s, s2);
			dequeue(s, s2);
			dequeue(s, s2);
			s.print(s.peek());
			dequeue(s, s2);
			s.print(s.peek());

		}

		static void dequeue(StackImpl s,StackImpl s2) {
			if(!s2.isEmpty()) {
				System.out.println("\nDeque Element="+s2.peek().data);
				s2.pop();
			}else if(s2.isEmpty()) {
				while(!s.isEmpty()) {
					s2.push(s.peek().data);
					s.pop();
				}
				System.out.println("\nDeque Element="+s2.peek().data);
				s2.pop();
			}
		}
	}
	
	static class Stack{		
		public Stack(int data) {
			this.data = data;
		}

		int data;
		Stack next;
	}
	
	class StackImpl{
		Stack top;
		void push(int val) {
			Stack s=new Stack(val);
			s.next=top;
			top=s;
		}
		void pop() {
			top=top.next;
		}
	   Stack peek() {
		   return top;
	   }
	   void print(Stack s) {
		   while(s!=null) {
		   System.out.print(s.data+",");
		   s=s.next;
		   }
	   }
	   Boolean isEmpty() {
	     return top==null;
	   }
	}
}
