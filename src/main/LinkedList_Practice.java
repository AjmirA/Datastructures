package main;


class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class Result{

	int length;
	Node node;
	public Result(int length, Node node) {
		this.length = length;
		this.node = node;
	}
}

public class LinkedList_Practice {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5,6,7,8 };
		int[] arr1 = new int[] {9,6,3,0,9};
		Node a = createNode(arr);
		Node b = createNode(arr1);
		print(a);
		System.out.println();
		print(b);
		System.out.println();
		 Node c;
		  c =swapKthNode(a,1);
		 System.out.println("\n After Swapping");
		 print(c);
		 System.out.println("END");
		 
		  c =swapKthNode(c,2);
		 System.out.println("\n After Swapping");
		 print(c);
		 System.out.println("END");
		 
		  c =swapKthNode(c,3);
		 System.out.println("\n After Swapping");
		 print(c);
		 System.out.println("END");
		 
		  c =swapKthNode(c,4);
		 System.out.println("\n After Swapping");
		 print(c);
		 System.out.println("END");
		 
		  c =swapKthNode(c,5);
		 System.out.println("\n After Swapping");
		 print(c);
		 System.out.println("END");
		 
	    Node val=addLinkedList(a, b,arr.length,arr1.length);
	    System.out.println("\nAdd to Linked List");
	    print(val);
		System.out.println("\n Output:");
		 print(reverseList(val));

	}

	static Node createNode(int[] arr) {
		Node prev = null;
		Node head = null;
		for (int i = 0; i < arr.length; i++) {
			Node j = new Node(arr[i]);
			if (i == 0) head = j;
			if(prev!=null) prev.next = j;
			prev = j;
		}

		return head;
	}
	
	static int size(Node a) {
		int count=0;
		while(a!=null) {
			count++;
			a=a.next;
		}
		return count;
	}
	
	static Node swapKthNode(Node head,int k) {
        // Count nodes in linked list
        int n = size(head);
 
        // Check if k is valid
        if (n < k)
            return null;
 
        // If x (kth node from start) and
        // y(kth node from end) are same
        if (2 * k - 1 == n)
            return null;
 
        // Find the kth node from beginning of linked list.
        // We also find previous of kth node because we need
        // to update next pointer of the previous.
        Node x = head;
        Node x_prev = null;
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }
 
        // Similarly, find the kth node from end and its
        // previous. kth node from end is (n-k+1)th node
        // from beginning
        Node y = head;
        Node y_prev = null;
        for (int i = 1; i < n - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }
 
        // If x_prev exists, then new next of it will be y.
        // Consider the case when y->next is x, in this case,
        // x_prev and y are same. So the statement
        // "x_prev->next = y" creates a self loop. This self
        // loop will be broken when we change y->next.
        if (x_prev != null)
            x_prev.next = y;
 
        // Same thing applies to y_prev
        if (y_prev != null)
            y_prev.next = x;
 
        // Swap next pointers of x and y. These statements
        // also break self loop if x->next is y or y->next
        // is x
        Node temp = x.next;
        x.next = y.next;
        y.next = temp;
 
        // Change head pointers when k is 1 or n
        if (k == 1)
            head = y;
 
        if (k == n)
            head = x;
        
        return head;
}

	static Node addLinkedList(Node a, Node b,int len1,int len2) {
		Node ar=reverseList(a);
		Node br=reverseList(b);
		Node head=null,tail=null;
		if(len1>len2)
			addNode(br,len1-len2);
		else
			addNode(ar,len2-len1);
		
		print(ar);
		System.out.println();
		print(br);
		int rem,carry=0,add,divByTen = 0;
		while(ar!=null && br!=null) {
			add=ar.data+br.data+carry;
			rem=add%10;			
			divByTen=add/10;
			carry=divByTen;
			ar=ar.next;
			br=br.next;
			if(divByTen!=0) {
				Node newNode=new Node(rem);
				if(head==null) {
					head=newNode;
					tail=newNode;
				}else {
					tail.next=newNode;
					tail=newNode;
				}
			} else {
				Node newNode = new Node(rem);
				if (head == null) {
					head = newNode;
					tail = newNode;
				} else {
					tail.next = newNode;
					tail = newNode;
				}
			}
		}
		if(carry!=0) {
			Node newNode=new Node(carry);
			tail.next=newNode;
			tail=newNode;
		}
		return head;

	}
	

	static Node reverseList(Node head) {
		Node current,prev,next;
		current=head;
		prev=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
      head=prev;
      return head;
	}
	
	static void addNode(Node n,int diff) {
		Node head=n;
		while(head.next!=null) 
			head=head.next;
		for(int i=0;i<diff;i++) {
			Node newNode=new Node(0);
			head.next=newNode;
			head=newNode;
		}
	}
	
	static void print(Node m) {
		while(m!=null) {
			System.out.print(m.data+" ");
			m=m.next;
		}
	}
}

class checkPolindromeInLinkedList{

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3,4, 3,2,1 };
		Node head=createNode(arr);
		print(head);
		System.out.println();
		int length=findLenghtofLinkedList(head);
		Node midNode=findMindNode(head,length);
		System.out.println("midNode="+midNode.data);
      
		Node midReversed=reverseLinkedList(midNode);
		System.out.println("Reversed"+head.data);
		Boolean polindromeFlag=comparePolindrome(head,midNode.next);
		print(head);
		System.out.println("\npolindromeFlag="+polindromeFlag);
	}
	
	static Boolean comparePolindrome(Node a,Node b) {
		while(b!=null) {
			if(a.data!=b.data)
				return false;
			a=a.next;
			b=b.next;
		}
		return true;
	}
	static Node reverseLinkedList(Node midNode) {
		Node prev=null,current=midNode.next,next;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		midNode.next=prev;
		return prev;
	}
	static Node createNode(int[] arr) {
		Node prev = null;
		Node head = null;
		for (int i = 0; i < arr.length; i++) {
			Node j = new Node(arr[i]);
			if (i == 0) head = j;
			if(prev!=null) prev.next = j;
			prev = j;
		}

		return head;
	}
	static int findLenghtofLinkedList(Node temp) {
		int count=0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	} 
	static Node findMindNode(Node temp,int len) {
		for(int k=0;k<len/2;k++) {
			temp=temp.next;
		}
		return temp;
	}
	static void print(Node m) {
		while(m!=null) {
			System.out.print(m.data+" ");
			m=m.next;
		}
	}
}

class findIntersectionNode{
	
	public static void main(String[] args) {
	      Node n1 = new Node(1);
	        n1.next = new Node(2);
	        n1.next.next = new Node(3);
	        n1.next.next.next = new Node(4);
	        n1.next.next.next.next = new Node(5);
	        n1.next.next.next.next.next = new Node(6);
	        n1.next.next.next.next.next.next = new Node(7);
	        // list 2
	        Node n2 = new Node(10);
	        n2.next = new Node(9);
	        n2.next.next = new Node(8);
	        n2.next.next.next = new Node(7);
	        n2.next.next.next.next = new Node(6);
	        n2.next.next.next.next.next=n1.next.next.next;
	        System.out.print("Node1::");
	        print(n1);
	        System.out.print("\nNode2::");
	        print(n2);
		System.out.println();
		Result res1=findLengthAndTailNode(n1);
		Result res2=findLengthAndTailNode(n2);
		if(res1.node.data!=res2.node.data)
			System.out.println("There is no intersection");
		Node longer=res1.length>res2.length?n1:n2;
		Node shorter=res1.length>res2.length?n2:n1;
		System.out.print("Longer::");
		print(longer);
		System.out.print("\nShorter::");
		print(shorter);
	
		Node adjustedLonger=getKthNode(longer,Math.abs(res1.length-res2.length));
		System.out.print("\nadjustedLonger::");
		print(adjustedLonger);
		
		while(adjustedLonger!=shorter) {
			adjustedLonger=adjustedLonger.next;
			shorter=shorter.next;
		}
		System.out.println("\nIntersection::"+adjustedLonger.data);
	}
	
	private static Node getKthNode(Node temp, int k) {
		
		while(k>0 && temp!=null) {
			temp=temp.next;
			k--;
		}
		return temp;
		
	}

	static Result findLengthAndTailNode(Node n) {
		int len=1;
		while(n.next!=null) {
			len++;
			n=n.next;
		}
		return new Result(len, n);
	}
	
	static Node createNode(int[] arr) {
		Node prev = null;
		Node head = null;
		for (int i = 0; i < arr.length; i++) {
			Node j = new Node(arr[i]);
			if (i == 0) head = j;
			if(prev!=null) prev.next = j;
			prev = j;
		}

		return head;
	}
	static void  print(Node m) {
		while(m!=null) {
			System.out.print(m.data+" ");
			m=m.next;
		}
	}
}

class findLoopInALinkedList{
	
	public static void main(String[] args) {
	     Node head = new Node(1);
	        head.next = new Node(2);
	        head.next.next = new Node(3);
	        head.next.next.next = new Node(4);
	        head.next.next.next.next = new Node(5);
	 
	        head.next.next.next.next.next = head.next;
	        print(head);
	        Node val=findLoop(head);
	        System.out.println("Start of the loop="+val.data);
	}
	private static Node findLoop(Node head) {
       Node n1=head;
       Node n2=head;
		while(n1!=null && n1.next!=null) {
			n1=n1.next;
			n2=n2.next.next;
			if(n1==n2) {
				System.out.println("LOOP Deducted");
				break;
			}
		}
		n1=head;
		while(n1!=n2) {
	    n1=n1.next;
	    n2=n2.next;
   		}
		return n1;
	}
	static void  print(Node m) {
		int len=0;
		while(len<6) {
			System.out.print(m.data+" ");
			m=m.next;
			len++;
		}
	}
}