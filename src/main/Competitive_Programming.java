package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;




public class Competitive_Programming {
public static void main(String[] args) {
	
}
}

/**
 * How to check if given four points form a square
 * @author 
 *
 */
class Form_Square {

	public static void main(String[] args) {
		Form_Square x=new Form_Square();
		Point p1=x.new Point(5,1);
		Point p2=x.new Point(8,1);
		Point p3=x.new Point(5,4);
		Point p4=x.new Point(8,4);
		
		System.out.println("IsSquare::"+isSquare(p1,p2,p3,p4));
	}
	
	static Boolean isSquare(Point p1,Point p2,Point p3,Point p4) {
		if(distance(p1,p2) ==distance(p1,p3) && distance(p1,p3)==distance(p3,p4) 
				&& distance(p2,p4)==distance(p1,p2))
			return true;
		return false;
	}
	
	static int distance(Point i,Point j) {
		return (j.x-i.x)*(j.x-i.x) + (j.y-i.y)*(j.y-i.y);
	}		

	
	class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}



/**
 * Given an array of distinct elements and a number x, find if there is a pair with a product equal to x. 
 * @author 
 *
 */
class Find_Pair_For_GnProduct{
	
	public static void main(String[] args) {
		int arr[]=new int[] {10, 20, 9, 40};int key=400;
		findPair(arr,key);
		
	}

	private static void findPair(int[] arr, int key) {		
		Set s=new HashSet();
		for(int i:arr) {			
			if(key%i==0 && s.contains(key/i)) {
				System.out.println(i+" "+key/i);
			}
			s.add(i);                
		}
	}
}

/**
 * Print all possible strings that can be made by placing spaces
 * @author 
 *
 */


 /**
  * Replace all ‘0’ with ‘5’ in an input Integer
  * @author 
  *
  */
	class Replace_0_To_5 {
		public static void main(String[] args) {
			System.out.println(convert0To5Rec(850005));
		}

		static int convert0To5Rec(int num) {
			int rem = 0;
			while (num != 0) {
				rem = num % 10;
				if (rem == 0) rem = 5;	//here, we are changing 0 to 5				
				return convert0To5Rec(num / 10) * 10 + rem;
			}
			return num;

		}
	}
	
	/**
	 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a
	 * matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and
	 * jth column as 1.
	 * 
	 * 
	 * Example 1 The matrix 1 0 0 0 should be changed to following 1 1 1 0
	 * 
	 * Example 2 The matrix 0 0 0 0 0 1 should be changed to following 0 0 1 1 1 1
	 * 
	 * @author 
	 *
	 */
	class ModifyMatrix{
		public static void main(String[] args) {
	        int mat[ ][ ] = { {1, 0, 0, 1},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0},};              			
			int col = mat[0].length;
			int row = mat.length;
			System.out.println("Before Modified");
			printMatrix(mat, row, col);
			modifyMatrix(mat, row, col);
			System.out.println("After Modified");
			printMatrix(mat, row, col);
			
		}

		private static void modifyMatrix(int[][] mat, int row, int col) {
			int[] s1 = new int[row];
			int[] s2 = new int[col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (mat[i][j] == 1) {
                         s1[i]=1;
                         s2[j]=1;
					}
				}
			}
			
			for (int n = 0; n < s1.length; n++) {
				if (s1[n] == 1) {
					for (int m = 0; m < s2.length; m++) {
						mat[n][m] = 1;
					}
				}
			}
			
			for (int n = 0; n < s2.length; n++) {
				if (s2[n] == 1) {
					for (int m = 0; m < s1.length; m++) {
						mat[m][n] = 1;
					}
				}
			}
		}
		
		   /* A utility function to print a 2D matrix */
	    public static void printMatrix(int mat[ ][ ], int R, int C)
	    {
	        int i, j;
	        for (i = 0; i < R; i++)
	        {
	            for (j = 0; j < C; j++)
	            {
	                System.out.print(mat[i][j]+ " ");
	            }
	            System.out.println();
	        }
	    }
	}
	

	
	class Unique_Numbers{
        public static void main(String[] args) {
			System.out.println("uniqueNumbers::"+uniqueNumbers(1,100));
		}
	    static ArrayList<Integer> uniqueNumbers(int L,int R){
	    	ArrayList<Integer> uniqueNumbers=new ArrayList<>();

	    	for(int i=L;i<R;i++) {	    		 
	    		if(i>10 && i%11==0)
	    			uniqueNumbers.add(i);
	    	}
			return uniqueNumbers;
	    }
	}
	


/**
 * A celebrity is a person who is known to all but does not know anyone at a
 * party. If you go to a party of N people, find if there is a celebrity in the
 * party or not. A square NxN matrix M[][] is used to represent people at the
 * party such that if an element of row i and column j is set to 1 it means ith
 * person knows jth person. Here M[i][i] will always be 0. Note: Follow 0 based
 * indexing.
 * 
 * @author 
 *
 */
class CeleibrityProblem{
	
	public static void main(String[] args) {
		
		Stack s=new Stack();
		int matrix[][] = { { 0, 0, 1, 1 },
                { 0, 0, 1, 1 },
                { 0, 0, 0, 1 },
                { 0, 0, 0, 0 } };
		
		for(int i=0;i<matrix.length;i++)
			s.push(i);
		findCelebrity(matrix,s);

	}

	private static void findCelebrity(int[][] matrix, Stack s) {
		
		int a,b;
		while (s.size() > 1) {
			a = (int) s.pop();
			b = (int) s.pop();
			if (matrix[a][b] == 0)
				s.push(a);
			else
				s.push(b);
		}
		int c=(int) s.pop();
		Boolean flag=true;
		for(int i=0;i<matrix.length;i++) {
			
			if(i!=c && matrix[i][c]==0 || matrix[c][i]==1) { 
				flag=false;
				break;
			}
		}
		
		if(flag) 
			System.out.println("Celebrity is ::"+c);
		else
			System.out.println("There is no celebrity");
		
	}
}

/**
 * Maximum sum of i*arr[i] among all rotations of a given array Given an array
 * arr[] of n integers, find the maximum that maximizes the sum of the value of
 * i*arr[i] where i varies from 0 to n-1.
 * 
 * @author 
 *
 */
class Maximum_sum {
	public static void main(String[] args) {
		int arr[] = { 8, 3, 1, 2 };
		int sum = 0;
		Arrays.sort(arr); //Sort in ascending Order
		for (int i = 0; i < arr.length; i++)
			sum = sum + (i*arr[i]);

		System.out.println("SUM::" + sum);
	}
}

class Spiral_Matrix{
	public static void main(String[] args) {
	       int R = 4;
	        int C =4;
	        int a[][] = { { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 10, 11, 12 },
                    { 13, 14, 15, 16 } };
 
        // Function Call
        spiralPrint(R, C, a);
	}

	private static void spiralPrint(int r, int c, int[][] a) {

		int i, k = 0, l = 0;

		while (k < r && l < c) {

			for (i = l; i < c; i++) {
				System.out.print(a[k][i] + ",");
			}
			k++;

			for (i = k; i < r; i++) {
				System.out.print(a[i][c - 1] + ",");
			}
			c--;

			if (k < r) {
				for (i = c - 1; i >= l; i--) {
					System.out.print(a[r - 1][i] + ",");
				}
				r--;
			}

			if (l < c) {
				for (i = r - 1; i >= k; i--) {
					System.out.print(a[i][l] + ",");
				}
				l++;
			}
		}
	}
}



class SmallestString_Contains_AllKeys {
	
	public static void main(String[] args)
	{
	    String s = "azjskfzts";
	    String t = "sz";
	     
	      System.out.print("-->Smallest window that contain all character : ");
	    System.out.print(minWindow(s, t));
	 
	}
	  public static String minWindow(String searchString, String t) {

	    // Creating Map for storing the frequency
	    Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);
	    Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();

	    int left = 0;
	    int right = 0;

	    int totalCharFrequenciesToMatch = requiredCharacters.size();
	    int charFrequenciesInWindowThatMatch = 0;

	    // This will store the minimum length of valid substring
	    int minWindowLengthSeenSoFar = Integer.MAX_VALUE;

	    // It will store the actual substring
	    String minWindow = "";

	    // Here we calculate the ans using 2 pointer's approach
	    while (right < searchString.length()) {
	      char characterAtRightPointer = searchString.charAt(right);
 	      addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

	      boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
	      if (rightCharIsARequirement) {
	        boolean requirementForCharacterMet = requiredCharacters.get(characterAtRightPointer)
	            .intValue() == windowCharacterMapping.get(characterAtRightPointer).intValue();

	        if (requirementForCharacterMet) {
	          charFrequenciesInWindowThatMatch++;
	        }
	      }

	      while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
	        char characterAtLeftPointer = searchString.charAt(left);
	        int windowSize = right - left + 1;

	        if (windowSize < minWindowLengthSeenSoFar) {
	          minWindowLengthSeenSoFar = windowSize;
	          minWindow = searchString.substring(left, right + 1);
	        }

	        windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

	        boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
	        if (leftCharIsARequirement) {
	          boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer)
	              .intValue() < requiredCharacters.get(characterAtLeftPointer).intValue();

	          if (characterFailsRequirement) {
	            charFrequenciesInWindowThatMatch--;
	          }
	        }

	        left++;
	      }

	      right++;
	    }

	    return minWindow;
	  }

	  // Helper function for computing the character's frequency of a string
	  private static Map<Character, Integer> buildMappingOfCharactersToOccurrences(String s) {
	    Map<Character, Integer> map = new HashMap<Character, Integer>();

	    for (int i = 0; i < s.length(); i++) {
	      int occurrencesOfCharacter = map.getOrDefault(s.charAt(i), 0);
	      map.put(s.charAt(i), occurrencesOfCharacter + 1);
	    }

	    return map;
	  }
	  
	  // Helper function to insert a character in the map
	  private static void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c) {
	    int occurrences = map.getOrDefault(c, 0);
	    map.put(c, occurrences + 1);
	  }
	}
/**
 * Sliding Window Maximum (Maximum of all subarrays of size k)
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * 
 * Input: arr[]={1, 2, 3, 1, 4, 5, 2, 3, 6}
 * Output:
1,2,3,::3
2,3,1,::3
3,1,4,::4
1,4,5,::5
4,5,2,::5
5,2,3,::5
2,3,6,::6

 */
class Sliding_Window_Max{
	public static void main(String[] args) {
		
		int  arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k=3;
		printKMax(arr,k);
	}

	private static void printKMax(int[] arr, int k) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			System.out.println();
			max=arr[i];
			int j;
			if (i + k-1 < arr.length) {
				for (j = i; j < i + k; j++) {
					System.out.print(arr[j]+",");
					if (max < arr[j])
						max = arr[j];
				}
				System.out.print("::"+max);
			}
		}
		
	}
}
//another approach
class SlidingWindow
{
	static int[] printMax(int arr[], int k)
	{
		int n=arr.length;
		int[] res=new int[n-k+1];
		Deque<Integer> q=new ArrayDeque<>();
		int ri=0;
		for(int i=0;i<arr.length;i++) {
			if(!q.isEmpty() && q.peek()==i-k)
				q.poll();
			while(!q.isEmpty() && arr[q.peekLast()]<arr[i])
				q.pollLast();
			q.add(i);
			
			if(i>=k-1)
				res[ri++]=arr[q.peek()];
		}
		return res;
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;
		int[] res=printMax(arr, k);
		for(int i:res)
			System.out.print(i+" ");
	}
}


class KthSmallestEle_In_R_C_Sorted_2D{
	
	public static void main(String[] args) {
		 int mat[][] = { { 10, 20, 30, 40 },
                 { 15, 25, 35, 45 },
                 { 25, 29, 37, 48 },
                 { 32, 33, 39, 50 } };
                  
          int res = kthSmallest(mat, 4, 3);
	}

	private static int kthSmallest(int[][] mat, int i, int k) {

		int R = i;
		int C = i;
		int arr[] = new int[i * i];
		int count = -1;
		int smallest = 0;
		for (int n = 0; n < R; n++) {
			for (int m = 0; m < C; m++) {
				count++;
				createHeap(mat[n][m], arr, count);
			}
		}
		print(arr, arr.length);

		smallest = arr[0];//first smallest element after min-heap arranged
		for (int x = 1; x < k; x++) {			
			smallest = delete(arr, arr.length);			
		}
		System.out.println("Smallest Element at"+" k is " + smallest);
		return 0;
	}

	private static void createHeap(int val, int[] arr, int index) {
		
		int temp=val;
		
		while(index>0 && temp<arr[(index-1)/2]) {
			arr[index]=arr[(index-1)/2];
			index=(index-1)/2;
		}
		arr[index] = temp;
	}
	
	private static void print(int[] arr,int n) {
		for (int i=0;i<n;i++)
			System.out.print(arr[i] + ",");
		System.out.println();
	}
	
	private static int delete(int[] arr,int n) {
		arr[0]=arr[n-1];
		
		int i=0;
		int j=(2*i)+1;
		
		while(j<n-1) {
			if(arr[j+1]<arr[j]) 
				j=j+1;
			
			if(arr[j]<arr[i]) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i=j;
				j=(2*i)+1;
			}else
				break;
			
		}
		return arr[0];
		
	}
}

/**
 * Find the smallest and second smallest elements in an array
 * Find the largest and second largest elements in an array
 * @author 
 *
 */
class Second_Largest_Element {

	public static void main(String[] args) {
		int arr[] = { 12, 13, 1, 10, 34, 1 };
		print2Smallest(arr, 5);
	}

	private static void print2Smallest(int[] arr, int n) {
		int largest = 0, secondLargest = 0;
		int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] > secondLargest) {
				if (arr[i] > largest) {
					secondLargest = largest;
					largest = arr[i];
				} else
					secondLargest = arr[i];
			}
			if (arr[i] < secondSmallest) {
				if (arr[i] < smallest) {
					secondSmallest = smallest;
					smallest = arr[i];
				} else
					secondSmallest = arr[i];
			}
		}
		System.out.println("largest=" + largest);
		System.out.println("secondLargest=" + secondLargest);

		System.out.println("smallest=" + smallest);
		System.out.println("secondSmallest=" + secondSmallest);

	}
}

class Power {

	public static void main(String[] args) {
		System.out.println(pow(5, 3));
	}

	private static int pow(int i, int j) {
		if (j > 0)
			return multiply(i, pow(i, j - 1));
		else
			return 1;

	}

	private static int multiply(int x, int y) {

		if (y > 0) {
			return x + multiply(x, y - 1);
		} else
			return 0;
	}
}

/**
 * Count Possible Decodings of a given Digit Sequence
 * Input:  digits[] = "121"
 * Output: 3
// The possible decodings are "ABA", "AU", "LA"
 * @author 
 *
 */
class Decoding{
	
	public static void main(String[] args) {
		int digits[] = {1,2,1,4};
	    int n = digits.length;
	    System.out.println("Count is " +
	               countDecodingDP(digits, n));
	}

	private static int countDecodingDP(int[] digits, int n) {
		int count=0;
		for(int i=0;i<digits.length-1;i++) {
			int val=digits[i]*10+digits[i+1];//Forming two digit number
			if(val<=26)
				count++;
		}
		count++; //This for separation of all the digits
		return count;
	}
}
/**
 * Find s3 is the interleavings of given two strings
Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

Example 3:
Input: s1 = "", s2 = "", s3 = ""
Output: true
 * @author 
 *
 */
class Interleavinng_Stirng {
    private static boolean isInterleaving(String a, String b, String c, Map<String, Boolean> map){
        if(a.length() + b.length() != c.length()) return false;
        if(a.isEmpty() && b.isEmpty() && c.isEmpty()) {
        	System.out.println("Entering Empty");
        	return true;
        }
        String key = a + "->" + b + "->" + c;
        boolean resultOne = false;
        boolean resultTwo = false;
        if(!map.containsKey(key)){
            if(!a.isEmpty() && a.charAt(0) == c.charAt(0)) 
            	resultOne = isInterleaving(a.substring(1), b, c.substring(1), map);
            if(!b.isEmpty() && b.charAt(0) == c.charAt(0))
            	resultTwo = isInterleaving(a, b.substring(1), c.substring(1), map);
            map.put(key, resultOne || resultTwo);
        }
        return map.get(key);
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaving(s1, s2, s3, new HashMap<>());
    }
    
    public static void main(String[] args) {
		String s1="a"; 
		String s2="b"; 
		String s3="ba";
		System.out.println("isInterleave="+isInterleave(s1,s2,s3));
	}
}

class MinCostPath {
	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, 
				         { 1, 3, 2 }, 
				         { 3, 1, 3 } };

		System.out.print(minCost(cost, 2, 2));
	}

	private static int minCost(int[][] cost, int i, int j) {
		
		int R=0,C=0;
			while(R<i || C<j) {
				if(R==i || ( C<j && cost[R][C+1]<cost[R+1][C] && cost[R][C+1]<cost[R+1][C+1] )) {
					cost[R][C+1]=cost[R][C]+cost[R][C+1];
					R=R;
					C=C+1;
				}
				else if(C==j || (R<i && cost[R][C+1]>cost[R+1][C] && cost[R][C+1]>cost[R+1][C+1]))  {
					cost[R+1][C]=cost[R][C]+cost[R+1][C];
					R=R+1;
					C=C;
				}else {
					cost[R+1][C+1]=cost[R][C]+cost[R+1][C+1];
					R=R+1;
					C=C+1;
				}
			}
		
		return cost[i][j];
	}
}

class Node1
{
    int key;
    Node1 left, right;
    int height;
  
    public Node1(int key)
    {
        this.key = key;
        left = right = null;
    }
}




/**
 * Flattening a Linked List
 *  5 -> 10 -> 19 -> 28
       |    |     |    
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
 * Write a function flatten() to flatten the lists into a single linked list. 
 *The flattened linked list should also be sorted. 
 *For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50. 
 * @author 
 *
 */
class Flattening_LinkedList
{
    Node head;  // head of list
 
    /* Linked list Node*/
    class Node
    {
        int data;
        Node right, down;
        Node(int data)
        {
            this.data = data;
            right = null;
            down = null;
        }
    }
    
    Node push(Node ref,int data) {
    	Node newNode=new Node(data);
    	newNode.down=ref;
    	ref=newNode;
		return ref;
    	
    }
    
    public static void main(String[] args) {
    	Flattening_LinkedList l=new Flattening_LinkedList();
    	l.head= l.push(l.head, 30);
    	l.head= l.push(l.head, 8);
    	l.head= l.push(l.head, 7);
    	l.head= l.push(l.head, 5);
    	
    	l.head.right=l.push(l.head.right, 20);
    	l.head.right=l.push(l.head.right, 10);
    	
    	l.head.right.right=l.push(l.head.right.right, 50);
    	l.head.right.right=l.push(l.head.right.right, 22);
    	l.head.right.right=l.push(l.head.right.right, 19);
    	
    	l.head.right.right.right=l.push(l.head.right.right.right, 45);
    	l.head.right.right.right=l.push(l.head.right.right.right, 40);
    	l.head.right.right.right=l.push(l.head.right.right.right, 35);
    	l.head.right.right.right=l.push(l.head.right.right.right, 28);

        Node res= merge(l.head,null);
        //For printing the nodes
        while(res!=null) {
			System.out.print(res.data+",");
			res=res.down;
		}
    	
	}

	private static Node merge(Node head2, Node prev) {
		Node temp = null, res = null;

		if (head2 == null)
			return res;

		if (head2.right != null) {
			merge(head2.right, head2);

			Node l1 = head2;
			Node l2 = head2.right;

			while (l1 != null || l2 != null) {

				if (l2 == null || l1 != null && l1.data < l2.data) {
					if (temp == null) {
						temp = l1;
						res = l1;
					} else
						temp.down = l1;
					temp = l1;
					l1 = l1.down;
				} else if (l1 == null || l2 != null && l1.data > l2.data) {
					if (temp == null) {
						temp = l2;
						res = l2;
					} else
						temp.down = l2;
					temp = l2;
					l2 = l2.down;
				}
			}
			head2.right = res;

		}
		return res;

	}
}

class Node2 {
	int data;
	Node2 next;

	Node2(int data) {
		this.data = data;
	}
}

/**
 * Detect loop in a linked list and return the intersection node
 * @author 
 *
 */


class Largest_Sum_Contiguous_Subarray

{
	public static void main (String[] args)
	{
		int [] a = {-2, -3, 4, -4, -2, 1, 5, -3};
		System.out.println("Maximum contiguous sum is " +
									maxSubArraySum(a));
	}

	static int maxSubArraySum(int a[])
	{
		int max=0,max_B=0;
		for(int i=0;i<a.length;i++) {
			max_B=max_B+a[i];
			if(max_B>max) 
				max=max_B;
			if(max_B<0)
				max_B=0;
		}
		return max;
	}
}

class Palindrome_Partitioning{
	public static void main(String[] args) {
		String str = "aabb";
	    System.out.println("Min cuts needed for "
	                       + "Palindrome Partitioning is " + partition(str));
	}


    public static List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>(); 
        List<String> path = new ArrayList<>();
        func(0, s, path, res);
        return res;
    }
    
    static void func(int index, String s, List<String> path, List<List<String>> res) {
    	System.out.println("INDEx="+index);
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length(); ++i) {
        	System.out.print("\ns====="+s.substring(index, i+1));
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                func(i+1, s, path, res);
                System.out.println("\npath="+path);
            	System.out.print("\npath index and i="+"("+index+","+i+")");
                path.remove(path.size()-1);
            }
        }
    }
    
    static boolean isPalindrome(String s, int start, int end) {
    	System.out.println("\nIS POLINDROME");
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}

class createBinaryTree{

	private static TreeNode createBinaryTree(Integer[] arr, int i) {
		TreeNode tr = null;
		if (i < arr.length) {
			if (arr[i] != null) {
				tr = new TreeNode(arr[i]);
				tr.leftChild = createBinaryTree(arr, (2 * i) + 1);
				tr.rightChild = createBinaryTree(arr, (2 * i) + 2);
			} else
				return null;
		}
		return tr;
	}
	

    
	private static void inOrder(TreeNode tr) {
		if (tr != null) {
			inOrder(tr.leftChild);
			System.out.print(tr.data + ",");
			inOrder(tr.rightChild);
		}

	}
}
/**
 * LRU cache
 * @author 
 *
 */
class Node3 {
	Node3 prev, next;
	int key, value;

	Node3(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
class LRU_Cache {

	Node3 head = new Node3(0, 0);
	Node3 tail = new Node3(0, 0);
	int capacity;
	Map<Integer,Node3> map=new HashMap();
	LRU_Cache(int capacity){
		this.capacity=capacity;
		head.next=tail;
		tail.prev=head;
	}
	int get(int key) {
		if (map.containsKey(key)) {
			Node3 node = map.get(key);
			remove(node);
			insert(node);
			return node.value;
		} else
			return -1;

	}
	
	void put(int key,int value) {
		
		if (map.containsKey(key)) {
			Node3 node = map.get(key);
			remove(node);
		}if(capacity==map.size()) {
			remove(tail.prev);
		}
		insert(new Node3(key,value));
	}
	private void insert(Node3 node) {
		Node3 headNext=head.next;
		node.next=headNext;
		head.next=node;
		node.prev=head;
		headNext.prev=node;
		map.put(node.key, node);
		
	}
	private void remove(Node3 node) {
		map.remove(node.key);
		node.prev.next=node.next;
		node.next.prev=node.prev;
	}
	public static void main(String[] args) {
		LRU_Cache l=new LRU_Cache(3);
		l.put(1, 10);
		l.put(3, 15);
		l.put(2, 12);
		l.get(3);
		l.put(4, 20);
		l.get(2);
	}

}
/**
 * Find the maximum value of `j – i` such that `A[j] > A[i]` in an array
 * Given an array A, find the maximum value of j-i such that A[j] > A[i].
 * @author 
 *
 */
class Max{
	public static void main(String[] args) {
		int A[] ={34, 8, 10, 3, 2, 80, 30, 33, 1};int n=A.length-1;
		int max=0,u=0,v=0;
		for(int j=n;j>=0;j--) {
			for(int i=0;i<j;i++) {
				if(A[j]>A[i] && j-i>max) {
					u=i;
					v=j;
					max=j-i;
				}
			}
		}
		System.out.println(u);
		System.out.println(v);
	}
}


class GFG {

	public static void main(String[] args) {
		int[] v = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		int n = v.length;
		int[] maxFromEnd = new int[n + 1];
		Arrays.fill(maxFromEnd, Integer.MIN_VALUE);

//Create an array maxfromEnd
		for (int i = v.length - 1; i >= 0; i--) {
			maxFromEnd[i] = Math.max(maxFromEnd[i + 1], v[i]);
		}

		int result = 0;

		for (int i = 0; i < v.length; i++) {
			int low = i + 1, high = v.length - 1, ans = i;

			while (low <= high) {
				int mid = (low + high) / 2;

				if (v[i] <= maxFromEnd[mid]) {
					// We store this as current
					// answer and look for further
					// larger number to the right side
					ans = Math.max(ans, mid);
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

			// Keeping a track of the
			// maximum difference in indices
			result = Math.max(result, ans - i);
		}
		System.out.print(result + "\n");
	}
}

/**
 * Arrange given numbers to form the biggest number.
 * Given an array of numbers, arrange them in a way that yields the largest value. For example, 
 * if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
 * And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value. 
 * @author 
 *
 */
class Form_the_biggest_number{
	public static void main(String[] args) {
        Integer[] arr = 
        		{1, 34, 3, 98, 9, 76, 45, 4};
       
        String res= printLargest(arr);
        System.out.println("biggest_number is::"+res);
	}

	private static String printLargest(Integer[] arr) {
		String[] str=new String[arr.length];
		for(int i=0;i<str.length;i++)
			str[i]=String.valueOf(arr[i]);
			
		Arrays.sort(str,new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				String xy=o1+o2;
				String yx=o2+o1;
				return xy.compareTo(yx)>0?-1:1;
			}
			
		});
		

		StringBuilder res=new StringBuilder();
		for(int i=0;i<str.length;i++) 		
			res=res.append (str[i]);
		
		for (int i = 0; i < str.length; i++) {
			if (!str[i].equals("0")) 
				return res.toString();
			
		}
		return "0";
		
	}
}

/**
 * Find if array can be divided into two subarrays of equal sum 
 * Input: arr = [6,2, 3, 2, 1] 
 * Output: true Explanation: On removing element 2 at index 1, the
 * array gets divided into two subarrays [6] and [3, 2, 1] having equal sum
 * 
 * @author 
 *
 */
class Divide{
	
	 public static void main (String[] args)
	    {
	        int arr[] = {1,6,1};
	        int n = arr.length;
	  
	        divideArray(arr, n);
	    }

	private static void divideArray(int[] arr, int n) {
		
		int total=0;
		int left=0,right=total;
		for(int i=0;i<arr.length;i++) 
			total=total+arr[i];
		for(int i=1;i<arr.length-1;i++) {
			left=left+arr[i-1];
			right=total-arr[i]-left;
			if(right==left) 
				System.out.println("On removing element "+arr[i]+ "at index "+i);
		}
	}
}

/**
 * You are given an integer array nums.
 * 
 * You should move each element of nums into one of the two arrays A and B such
 * that A and B are non-empty, and average(A) == average(B).
 * 
 * Return true if it is possible to achieve that and false otherwise.
 * 
 * Note that for an array arr, average(arr) is the sum of all the elements of
 * arr over the length of arr.
 * 
 * Input: nums = [1,2,3,4,5,6,7,8]
Output: true
Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have an average of 4.5.
 * @author 
 *
 */
class Solution2 {    
    public boolean check(int[] A, int leftSum, int leftNum, int startIndex) {       
        if (leftNum == 0) return leftSum == 0;
        if ((A[startIndex]) > leftSum / leftNum) return false;
        for (int i = startIndex; i < A.length - leftNum + 1; i ++) {
	    if (i > startIndex && A[i] == A[i - 1]) continue;
            if (check(A, leftSum - A[i], leftNum - 1, i + 1)) return true;
        }
        return false;       
    }
    
    public boolean splitArraySameAverage(int[] A) {
        if (A.length == 1) return false;
        int sumA = 0;
        for (int a: A) sumA += a;
        Arrays.sort(A);
        for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB ++) {
            if ((sumA * lenOfB) % A.length == 0) {
                if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0)) return true;
            }
        }
        return false;
        
    }
}

class Diameter_of_BinaryTree{
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.leftChild=new TreeNode(2);
		root.rightChild=new TreeNode(3);
		root.leftChild.leftChild=new TreeNode(4);
		root.leftChild.rightChild=new TreeNode(5);

		System.out.println("The diameter of given binary tree is : " +findDiameter(root));
	}

	private static int findDiameter(TreeNode root) {

		int left=height(root.leftChild) ;
		int right=height(root.rightChild) ;
		return left+right + 2;
	}

	private static int height(TreeNode t) {
		return t == null ? -1 : 1 + Math.max(height(t.leftChild), height(t.rightChild));
	}
}


class Node4{
	int data;
	Node4 next;
	Node4(int data){
		this.data=data;
	}
}

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first
 * integer represents the unique id and the second integer represents a value.
 * Your task is to find an element from a and an element from b such that the
 * sum of their values is less or equal to target and as close to target as
 * possible. Return a list of ids of selected elements. If no pair is possible,
 * return an empty list.
 * 
 * Example 1:
 * 
 * Input: a = [[1, 2], [2, 4], [3, 6]] b = [[1, 2]] target = 7
 * 
 * Output: [[2, 1]]
 * 
 * Explanation: There are only three combinations [1, 1], [2, 1], and [3, 1],
 * which have a total sum of 4, 6 and 8, respectively. Since 6 is the largest
 * sum that does not exceed 7, [2, 1] is the optimal pair.
 * 
 * @author 
 *
 */
class Optimal_Utilization{
	
	public static void main(String[] args) {
		
		Map<Integer,Integer> m1=new HashMap<>();
		m1.put(1, 3);
		m1.put(2, 5);
		m1.put(3, 7);
		m1.put(4, 10);
		
		Map<Integer,Integer> m2=new HashMap<>();
		m2.put(1, 2);
		m2.put(2, 3);
		m2.put(3, 4);
		m2.put(4, 5);
		int target=10;
		Map<Integer,Integer> res= findOptiomal(m1,m2,target);
		System.out.println(res);

	}

	private static Map<Integer, Integer> findOptiomal(Map<Integer, Integer> m1, Map<Integer, Integer> m2, int target) {
		Map<Integer,Integer> res=new HashMap<>();
		Boolean exactEqualFound=false;
		int lastAdded=0;
		for(Map.Entry<Integer, Integer> entry1:m1.entrySet()) {
			int v1=entry1.getValue();
			for(Map.Entry<Integer, Integer> entry2:m2.entrySet()) {
				 int currentTotal=v1+entry2.getValue();
				if(exactEqualFound==false && lastAdded<currentTotal && currentTotal<target) {
					res.clear();
					lastAdded=currentTotal;
					res.put(entry1.getKey(),entry2.getKey());
				}else if(currentTotal==target) {
					if(exactEqualFound==false) res.clear();
					exactEqualFound=true;
					res.put(entry1.getKey(),entry2.getKey());
				}
			}
			
		}
		return res;
	}

}
/**
 * Given a List of Orders , where each Order is a string . For example : [aax 12 23 ] [ ff kindle ebook] are two orders.
 *  Each order has an ID which is first part of the order ( ID of order 1 = aax , ID2 = ff ). The remaining part of the order is referred to as MetaData.
 *  There are two types of orders, Prime orders ( which contain non numeric Meta Data) and 
 *  Non-Prime Orders (which contain Only-Numeric Meta Data). Sort the List of Orders as given below :
a. Prime Orders before NonPrime Orders
b. Prime Order with lexicographically smaller MetaData comes first.
c. In Case of tie in (b) , the one with lexicographically smaller ID comes first.
d. The relative order of NonPrime Orders remains the same.
 * @author 
 *
 */
class SortPrimeAndNonPrimeOrders{
	
	public static void main(String[] args) {
		List<String> orders = Arrays.asList("aax 12 23", "ff kindle ebook", "aa ebook", "m ebook", "aax 12 63",
				"mm kind ebook", "aax 0 23", "aa 12 23");

		List<String> finalOrders = sortBothOrders(orders);
		System.out.println("finalOrders::"+finalOrders);
	}
	private static List<String> sortBothOrders(List<String> orders) {
		
		List<String> primeOrder = new ArrayList<String>();
		List<String> nonPrimeOrder = new ArrayList<String>();

		for (String s : orders) {
			if (isPrime(s))
				primeOrder.add(s);
			else
				nonPrimeOrder.add(s);
		}
		sortOrder(primeOrder);
		sortOrder(nonPrimeOrder);
		primeOrder.addAll(nonPrimeOrder);
		return primeOrder;
	}
	private static void sortOrder(List<String> primeOrder) {
		
		Collections.sort(primeOrder, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int keyLen1 = o1.split(" ")[0].length() + 1;
				int keyLen2 = o2.split(" ")[0].length() + 1;
				if (o1.length() - keyLen1 < o2.length() - keyLen2)
					return 1;
				else if (o1.length() - keyLen1 > o2.length() - keyLen2)
					return -1;
				else {
					if(keyLen1>keyLen2)
						return 1;
					else
					    return -1;
				}
			}
		});
		
		
	}
	//Prime should have non-numeric
	private static boolean isPrime(String s) {
		
		String str=s.split(" ")[1];
		try {
			Double.parseDouble(str);
			return false;
		}catch(Exception e) {
			return true;
		}
	}

}

class FindSum_of_Left_Leaves{
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.leftChild=new TreeNode(2);
		root.rightChild=new TreeNode(3);
		root.leftChild.leftChild=new TreeNode(4);
		root.leftChild.rightChild=new TreeNode(5);

		System.out.println("The diameter of given binary tree is : " +findSumOfLeft(root.leftChild));
	}

	private static int findSumOfLeft(TreeNode root) {
		
		int res=0;
		if(root!=null) {
			if(isLeaf(root.leftChild))
				res=res+root.leftChild.data;
			else
				res=res+findSumOfLeft(root.leftChild);
			
			res=res+findSumOfLeft(root.rightChild);
		}
		return res;
	}

	private static boolean isLeaf(TreeNode node) {
		if(node==null) return false;
		if(node.leftChild==null && node.rightChild==null)
			return true;
		return false;
	}
}




class PrevGreater{
	
	public static void main(String[] args) {
	    int arr[] = {10, 4, 2, 50, 40, 12, 30};
	    int n = arr.length;
	    prevGreaterUsingStack(arr, n);
	}

	private static void prevGreater(int[] arr, int n) {
		int[] res=new int[arr.length];		
		for(int i=0;i<n;i++) {
			Boolean flag=false;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>arr[i]) {
					res[i]=arr[j];
					flag=true;
					break;
				}
			}
			if(flag==false)
				res[i]=-1;
		}
		//print
		for(int i:res)
			System.out.print(i+",");
		
	}
	
	private static void prevGreaterUsingStack(int[] arr, int n) {
		int[] res = new int[arr.length];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {

			while (!s.isEmpty() && s.peek() < arr[i])
				s.pop();
			if (s.isEmpty())
				res[i] = -1;
			else 
				res[i] = s.peek();

				s.push(arr[i]);

			

		}
		// print
		for (int i1 : res)
			System.out.print(i1 + ",");

	}
}

class Next_Greated_Elemnt{
	
	public static void main(String[] args) {
		 int arr[]= {11, 13, 21, 3};
	        int n = arr.length;
	        int res[]=print_NGE_Using_Stack(arr, n);
	        for(int i:res)
	        	System.out.print(i+" ");
	}

	private static int[] print_NGE_Using_Stack(int[] arr, int n) {
		Stack<Integer> s=new Stack<Integer>();
		int[] res=new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {  //for rotational array, 1) just copy all the elements to the next indexes and do the same
			                                                //2) since we are copying same elements, we can uses i as i%n as i ->0 to 2n 

			while (!s.isEmpty() && s.peek() <= arr[i])
				s.pop();

			if (s.isEmpty())
				res[i] = -1;
			else
				res[i] = s.peek();

			s.push(arr[i]);
			
		}
		return res;
	}
}

class Sort123{
	
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int n = arr.length;
		sortArr(arr);
	}

	private static void sortArr(int[] arr) {
		
		int count_0=0,count_1=0,count_2=0;
		int[] res=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			
			switch(arr[i]) {
			
			case 0:
				count_0++;
				break;
			case 1:
				count_1++;
				break;
			case 2:
				count_2++;
				break;
			}
		}
			int k=0;
			while (count_0 > 0) {
				res[k++] = 0;
				count_0--;
			}
			while (count_1 > 0) {
				res[k++] = 1;
				count_1--;
			}
			while (count_2 > 0) {
				res[k++] = 2;
				count_2--;
			}
			// print
			for(int j=0;j<res.length;j++)
				arr[j]=res[j];

	}
}

class PermutationOfNum{
	
	public static void main(String[] args) {
		int arr[]= {1,2,3};
		List<List<Integer>> val=permutation(arr);
		System.out.println(val);
	}

	private static List<List<Integer>> permutation(int[] arr) {
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		List<Integer> ds=new ArrayList<Integer>();
		Boolean [] freq=new Boolean[arr.length];
		  Arrays.fill(freq, false);
		recurPermutation(arr,ds,ans,freq);
		return ans;
	}

	private static void recurPermutation(int[] arr, List<Integer> ds, List<List<Integer>> ans, Boolean[] freq) {
		if(ds.size()==arr.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!freq[i]) {
				ds.add(arr[i]);
				freq[i]=true;
				recurPermutation(arr, ds, ans, freq);
				ds.remove(ds.size()-1);
				freq[i]=false;
			}
		}
	}
}
class PermutationOfString{


	
	public static void main(String[] args) {
		String s1="ab";
		String s2="eidbaooo";
		char[] arr= s1.toCharArray();
		List<String> val=permutation(arr);
		System.out.println(val);
		System.out.println(checkInclusion(s1,s2));
	}
	 public static boolean checkInclusion(String s1, String s2) {
			char[] arr= s1.toCharArray();
			List<String> val=permutation(arr);
			for(String str:val) {
			  if(s2.indexOf(str)!=-1)
				  return true;
			}
			return false;
			  
	 }

	private static List<String> permutation(char[] arr) {
		List<String> ans=new ArrayList();
		String ds= "";
		Boolean [] freq=new Boolean[arr.length];
		  Arrays.fill(freq, false);
		recurPermutation(arr,ds,ans,freq);
		return ans;
	}

	private static void recurPermutation(char[] arr, String ds, List<String> ans, Boolean[] freq) {
		if(ds.length()==arr.length) {
			ans.add(ds);
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!freq[i]) {
				ds=ds+arr[i];
				freq[i]=true;
				recurPermutation(arr, ds, ans, freq);
				ds=ds.substring(0, ds.length()-1);
				freq[i]=false;
			}
		}
	}

}

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 
 * Explanation: The above
 * elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
 * are being trapped.
 * 
 * @author 
 *
 */
class Trapping_Rain_Water {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		trap(arr);
	}
	public static int trap(int[] height) {
	    
		   
        int n = height.length; 
        int left=0; int right=n-1;
        int res=0;
        int maxleft=0, maxright=0;
        
        while(left<=right){
            
            if(height[left]<=height[right]){
                
                if(height[left]>=maxleft) maxleft=height[left];
                else res+=maxleft-height[left];
                
                left++;
            }
            else{
                
                if(height[right]>=maxright) maxright= height[right];
                else res+=maxright-height[right];
                
                right--;
            }
        }
        return res;
	}

}

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 * the x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above
 * vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 */
class Container_With_Most_Water{
	
    public static int maxArea(int[] height) {
        
        int left=0, right=height.length-1;
        int maxCantainerTillNow=0;
        while(left<=right){
           
             int cap=Math.min(height[left],height[right]);
             int width=right-left;
             int maxCantainer=cap*width;
             if(maxCantainer>maxCantainerTillNow)
                 maxCantainerTillNow=maxCantainer;
            
            if(height[left]<height[right])
                left++;
            else
                right--;
            
                
        }
        return maxCantainerTillNow;
    }
	public static void main(String[] args) {
		int arr[] = { 1,8,6,2,5,4,8,3,7 };
		int res=maxArea(arr);
		System.out.println(res);
	}
}


class Node5 {
    int val;
    Node5 next;
    Node5 random;

    public Node5(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Random{
	public static void main(String[] args) {
		Node5 root=new Node5(7);
		root.next=new Node5(13);
		root.next.next=new Node5(11);
		root.next.next.next=new Node5(10);
		root.next.next.next.next=new Node5(1);
		
		root.random=null;
		root.next.random=root;
		root.next.next.random=root.next.next.next.next;
		root.next.next.next.random=root.next.next;
		root.next.next.next.next.random=root;
		print(root);
		System.out.println("Arranged::");
		Node5 deepCopy=deepCopy(root);
		Node5 n=copyRandomList(root);
		print(deepCopy);
	}
	

		
	

	private static Node5 deepCopy(Node5 head) {
		  Map<Node5,Node5> map=new HashMap<Node5, Node5>();
		  Node5 root=head;
		  Node5 deepCopy = null;
		  Node5 deepCopy_root = null;
		  while(head!=null) {
			  Node5 n=new Node5(head.val);
			  if(map.isEmpty()) deepCopy=n;
			  map.put(head, n);
			  head=head.next;
		  }
		  deepCopy_root=deepCopy;
		  while(root!=null) {
			  deepCopy.next=map.get(root.next);
			  deepCopy.random=map.get(root.random);
			  deepCopy=deepCopy.next;
			  root=root.next;
		  }
		return deepCopy_root;
	}

	public static Node5 copyRandomList(Node5 head) {
		  Node5 prev=null;
		  Node5 clone=null;
		  while(head!=null) {
			  Node5 n=new Node5(head.val);
			  n.random=head;
			  if(prev!=null)
				  prev.next=n;
			  else
				  clone=n; //to get the head of the cloned node
			  prev=n;
			  Node5 tmp=head;
			  head=head.next;
			  tmp.next=n;
		  }
		  Node5 i=clone;
		  while(i!=null) {
              if(i.random.random==null)
                  i.random=null;
              else
			  i.random=i.random.random.next;
              
			  i=i.next;
		  }
		return clone;
	        
	    }
	  
	  public static void print(Node5 head) {
		  while(head!=null) {
			  if(head.random!=null)
			  System.out.println(head.val+","+head.random.val);
			  else
				  System.out.println(head.val+","+null);  
			  head=head.next;
		  }
	  }
}
/**
 * Given a binary tree, where every node value is a Digit from 1-9 .
 * Find the sum of all the numbers which are formed from root to leaf paths.

For example consider the following Binary Tree.

           6
       /      \
     3          5
   /   \          \
  2     5          4  
      /   \
     7     4
  There are 4 leaves, hence 4 root to leaf paths:
   Path                    Number
  6->3->2                   632
  6->3->5->7               6357
  6->3->5->4               6354
  6->5>4                    654   
Answer = 632 + 6357 + 6354 + 654 = 13997 
 * @author 
 *
 */
class BinaryTree{
	public static void main(String[] args) {
		Node1 root = new Node1(6);
		root = new Node1(6);
		root.left = new Node1(3);
		root.right = new Node1(5);
		root.right.right = new Node1(4);
		root.left.left = new Node1(2);
		root.left.right = new Node1(5);
		root.left.right.right = new Node1(4);
		root.left.right.left = new Node1(7);

		System.out.print("Sum of all paths is " + treePathsSum(root,0));
	}

	private static int treePathsSum(Node1 root, int val) {
		if (root == null)
			return 0;

		val = val * 10 + root.key;
		if (root.left == null && root.right == null)
			return val;
		int left = treePathsSum(root.left, val);
		int right = treePathsSum(root.right, val);
		
		return left + right;

	}
} 


/**
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. 

Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
 * @author 
 *
 */
 class PermutationWithSpace
{
	private static ArrayList<String>
						spaceString(String str)
	{
		ArrayList<String> strs=new ArrayList<String>();
		
		if(str.length()==1) {
			strs.add(str);
			return strs;
		}
			
		ArrayList<String> temp=spaceString(str.substring(1,str.length()));
		
		for(int i=0;i<temp.size();i++) {
			strs.add(str.charAt(0)+temp.get(i));
			strs.add(str.charAt(0)+" "+temp.get(i));
		}
		return strs;
	}

	// Driver Code
	public static void main(String args[])
	{
		ArrayList<String> patterns
			= new ArrayList<String>();

		// Function Call
		patterns = spaceString("ABCD");

		// Print patterns
		for (String s : patterns)
		{
			System.out.println(s);
		}
	}
}
 /**
  * Given the root of a binary tree, return the preorder traversal of its nodes' values Without_Recursion.
  * @author 
  *
  */
class Inorder_Without_Recursion {
	public static void main(String[] args) {
		Node1 root = new Node1(1);
		root.left = new Node1(2);
		root.right = new Node1(3);
		root.left.left = new Node1(4);
		root.left.right = new Node1(5);
		System.out.println(inorder(root));
	}

	private static List<Integer> inorder(Node1 root) {

		Stack<Node1> s = new Stack();
		List<Integer> res=new ArrayList<Integer>();
		while (!s.isEmpty() || root!=null) {
			while (root != null) {
				res.add(root.key);
				s.push(root);
				root = root.left;
			}
			Node1 rt = (Node1) s.pop();
			root = rt.right;
		}
		return res;
	}
}

/**
 * Median of an unsorted array using Quick Select Algorithm
 * 
 * Input: arr[] = {12, 3, 5, 7, 4, 19, 26} Output: 7 Sorted sequence of given
 * array arr[] = {3, 4, 5, 7, 12, 19, 26} Since the number of elements is odd,
 * the median is 4th element in the sorted sequence of given array arr[], which
 * is 7 Input: arr[] = {12, 3, 5, 7, 4, 26} Output: 6 
 * Since number of elements are even, median is average of 3rd and 4th element in sorted sequence of
 * given array arr[], which means (5 + 7)/2 = 6
 * 
 * @author 
 *
 */
class QuickSort{
	static int[] mid = new int[2];
	static int first=-1,second=-1;
	static Boolean midFound=false;
	public static void main(String[] args) {

		int arr[] = { 12, 3, 5, 7, 4, 19, 26, 35};
		int h = arr.length;
		
		if (arr.length % 2 == 1) {
			mid[0] = (arr.length / 2);
			mid[1] = -1;
		} else {
			mid[0] = (arr.length / 2)-1;
			mid[1] = (arr.length / 2);
		}

		quickSort(arr, 0, h - 1);
		
		
	}
	
	private static void quickSort(int[] arr, int l, int h) {
		int j;
		if (l < h) {
			if(midFound)
				return;
			j = partition(arr, l, h);
			findMid(j,arr);
			quickSort(arr, l, j);
			quickSort(arr, j + 1, h);
		}
	}
	

	private static void findMid(int j,int[] arr) {
		if (mid[1] == -1 && j == mid[0]) {
			midFound=true;
			System.out.println("Mid element::" + arr[j]);
		}
		else if(mid[1]!=-1) {
			if(j==mid[0])
				first=j;
			if(j==mid[1])
				second=j;
		}
		if(second!=-1 && first!=-1) {
			midFound=true;
			System.out.println("Mid element::" + (arr[first]+arr[second])/2);
		}
	}

	private static void print(int[] arr) {
		System.out.println();
		for(int i:arr)
			System.out.print(i+",");
		
	}

	private static int partition(int[] arr, int l, int h) {

		int pivot = arr[l];
		int pivotIndex = l;

		while (l < h) {

			while (arr[l] <= pivot)
				l++;
			while (arr[h] > pivot)
				h--;
			if (l < h) { //swap
				int temp = arr[l];
				arr[l] = arr[h];
				arr[h] = temp;
			}
		}//swap
		int tmp = arr[h];
		arr[h] = pivot;
		arr[pivotIndex] = tmp;
		return h;

	}
}

class KClosest {
	public static void main(String[] args) {
		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int n = arr.length;
		int x = 35, k = 4;
		printKclosest(arr, x, 4, n);
	}
	private static void print(int[] arr) {
		System.out.println();
		for(int i:arr)
			System.out.print(i+",");
		
	}


	private static void printKclosest(int[] arr, int mVal, int k, int n) {
          int[] dup=new int[arr.length];
          int index;
			for (index = 0; index < arr.length; index++) {
				if (mVal == arr[index])
					break;
			}
			
			for(int i=index-k;i<index && i>=0 ; i++)
				dup[i]=Math.abs(arr[index]-arr[i]);
			
			for(int i=index+k;i>index && i>=0 ; i--)
				dup[i]=Math.abs(arr[i]-arr[index]);
			
			print(dup);
	}
}

class LinkedListFunctions{
	
	static Node4 prev;
	static Node4 head,rear;
	static Stack<Node4> maxStack=new Stack();
	static Stack<Node4> maxPrev=new Stack();
	static void insert(int data) {
		Node4 n=new Node4(data);
		if(rear==null && head==null) {
			rear=n;
			head=n;	
			maxStack.push(rear);
		}else {
			rear.next=n;
			prev=rear;
			rear=n;
			n.next=null;
		}
		if(maxStack.peek().data<n.data) {
			maxStack.push(n);
			maxPrev.push(prev);
		}
	}
	
	static void delete() {
		if(head==rear)
			head=null;
		if(rear==maxStack.peek()) {
			maxPrev.peek().next=null;
			rear=maxPrev.peek();
			maxPrev.pop();
			maxStack.pop();
		}else {
			prev.next=null;
			rear=prev;
		}
	}
	
	public static int getMax() {
		return maxStack.peek().data;
	}
	
	public static void deleteMax() {
		if (maxStack.peek() == rear) {
			maxPrev.peek().next = null;
			rear = maxPrev.peek();

		} else {
			maxPrev.peek().next = maxStack.peek().next;
		}
		maxPrev.pop();
		maxStack.pop();
	}
	
	static void print(Node4 head) {
		while(head!=null) {
		System.out.print(head.data+",");
		head=head.next;
		}
	}
	public static void main(String[] args) {
		insert(1);
		insert(62);
		insert(97);
		insert(24);
		insert(95);
		
		print(head);
		System.out.println("\nMax Ele::"+getMax());
		System.out.println("\nCalling insert() with 234,23");
		insert(234);
		insert(23);
		print(head);
		System.out.println("\nCalling deleteMax():");
		deleteMax();
		print(head);
		System.out.println("\nCalling deleteMax():");
		deleteMax();
		print(head);
		System.out.println("\nCalling delete():");
		delete();
		print(head);
	}
	
}

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * @author 
 *
 */
class TewoSum{
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		twoSum(nums,target);
	}
	 public static int[] twoSum(int[] nums, int target) {
	        int[] sol=new int[2];
		 for(int i=0;i<nums.length;i++) {
			 for(int j=i+1;j<nums.length;j++) {
				 if(target==nums[i]+nums[j]) {
					 System.out.println("equal");
					 sol[0]=nums[i];
					 sol[1]=nums[j];
				 }
			 }
		 }
		return sol;
	    }
}
/**
 * Input: Given string :"forgeeksskeegfor", 
Output: "geeksskeeg"

Input: Given string :"Geeks", 
Output: "ee"
 * @author 
 *
 */
class Longest_Palindromic_Substring{
	public static void main(String[] args) {
		String  s = "abcd";
		String res=longestPalindrome(s);
		System.out.println(res);
	}
	 public static String longestPalindrome(String s) {
	        String str="",reverse="";
	        String res = "";
	    	if(s.length()==1)
				res=s;
			for (int j = 0; j < s.length(); j++) {
				reverse="";
				for (int i = j + 1; i <= s.length(); i++) {
					str = s.substring(j, i);
					reverse = s.charAt(i - 1) + reverse;
					if (str.equals(reverse) && res.length() < str.length())
						res = str;
				}
			}
		
			return res;
	    }
}
/**
 * Input: Given string :"forgeeksskeegfor", 
Output: "geeksskeeg"

Input: Given string :"Geeks", 
Output: "ee"
 * @author 
 *
 */
class LongestPalinSubstring {

	public static void main(String[] args) {
		String str = "adbbca";
		longestPalSubstr(str);
	}

	private static String longestPalSubstr(String str) {
		int n=str.length();
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			dp[i][i]=1;
		}
		int i=0;
		int count=0;
		while( count < n) {
			int j=i+1+count;
			while( j < n) {
				if (str.charAt(i) == str.charAt(j))
					dp[i][j] = 2 + dp[i + 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				i++;
				j++;
			}
			i=0;
			count++;
		}
		print(dp);
		
		int p_length = dp[0][n-1];
		char[] palindrome=new char[p_length];
		int x = 0;
		int y = n-1;
		int p_start = 0;
		int p_end = p_length-1;
		
		while(p_start<p_end) {
			if(str.charAt(x)==str.charAt(y)) {
				palindrome[p_start]=str.charAt(x);
				palindrome[p_end]=str.charAt(y);
				p_start++;
				p_end--;
				x=x+1;
				y=y-1;
			}else {
				if(dp[x+1][y]>dp[x][y-1])
					x=x+1;
				else
					y=y-1;
			}
		}
		if(p_end == p_start)
			palindrome[p_end] = str.charAt(i);
		print(palindrome);
		return null;
	}
	private static void print(char[] palindrome) {
		System.out.println();
		for(char i:palindrome)
			System.out.print(i+",");
		
	}
	private static void print(int[][] dp) {
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp.length;j++) {
				System.out.print(dp[i][j]+",");
			}
			System.out.println();
		}
		
	}

}

class Graph {
	Map<Integer, int[]> adj = new HashMap<Integer, int[]>();

	private static int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private static LinkedList<Integer> adj_list[];
	static int time = 0;
	static final int NO_PARENT = -1;

	Graph(int v) {
		V = v;
		adj_list = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj_list[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void add_an_edge(int v, int w) {
		adj_list[v].add(w); // Add w to v's list.
		adj_list[w].add(v); // Add v to w's list
	}

	static void DFS(int u, int[] disc, int[] low, int[] parent, boolean[] articulation_Point) {
		disc[u] = low[u] = time;
		time += 1;
		int children = 0;
		Iterator<Integer> i = adj_list[u].iterator();
		while (i.hasNext()) {
			int v = i.next();
			if (disc[v] == -1) // If v is not visited
			{
				children += 1;
				parent[v] = u;
				DFS(v, disc, low, parent, articulation_Point);
				low[u] = Math.min(low[u], low[v]);

				if (parent[u] == -1 && children > 1) // Case-1: U is root
					articulation_Point[u] = true;

				if (parent[u] != -1 && low[v] >= disc[u]) // Case-2: Atleast 1 component will get separated
					articulation_Point[u] = true;
			} else if (v != parent[u]) // Ignore child to parent edge
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	static void findAPs_Tarjan() {
		int[] disc = new int[V];
		int[] low = new int[V];
		int[] parent = new int[V];
		boolean[] articulation_Point = new boolean[V];
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		Arrays.fill(parent, -1);
		Arrays.fill(articulation_Point, false);

		for (int i = 0; i < V; ++i)
			if (disc[i] == -1)
				DFS(i, disc, low, parent, articulation_Point);

		for (int i = 0; i < V; ++i)
			if (articulation_Point[i] == true)
				System.out.println(i);
	}

	public static void main(String[] args) {

		Graph graph_1 = new Graph(6);
		graph_1.add_an_edge(1, 0);
		graph_1.add_an_edge(1, 2);
		graph_1.add_an_edge(2, 0);
		graph_1.add_an_edge(0, 3);
		graph_1.add_an_edge(3, 4);
		graph_1.add_an_edge(3, 5);
		
		findAPs_Tarjan();

		System.out.println("Articulation points in first graph");

	}

}
/**
 * Split the String with 3 char and reverse abc as bca
 * @author 
 *
 */
class String_Manupulation{
	
	public static void main(String[] args) {
		int noSplit=3;
		manupulatation("abcdefghijkmnopqrs", noSplit);
	}

	private static void manupulatation(String str,int noSplit) {
		
		int size=str.length()/noSplit;
		String[] res=new String[size+1];
		int index=0;
		int i=0;
		for(i=0;i<str.length();i=i+3)
			if(i+2<str.length()) res[index++] =(String) str.subSequence(i+1, i+noSplit)+str.charAt(i);
			else res[index++] =(String) str.subSequence(i,str.length());
		//Print
		for(String result:res) System.out.println(result);
		
	}
}
/**
 * determine if a binary tree is height-balanced?
 * An empty tree is height-balanced. A non-empty binary tree T is balanced if: 
1) Left subtree of T is balanced 
2) Right subtree of T is balanced 
3) The difference between heights of left subtree and right subtree is not more than 1. 
 * @author 
 *
 */
class Check_Balanced_Tree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.rightChild = new TreeNode(3);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.leftChild.leftChild.leftChild = new TreeNode(8);
		root.rightChild.rightChild=new TreeNode(6); 
		root.rightChild.rightChild.rightChild=new TreeNode(9);
		
		System.out.println("isBalncedTree::"+isBalncedTree(root));

	}
	
	static int height(TreeNode tr) {
		return tr==null?0:1+Math.max(height(tr.leftChild), height(tr.rightChild));
	}

	private static boolean isBalncedTree(TreeNode root) {
		
		if(root==null)
			return false;
		int lh=height(root.leftChild);
		int rh=height(root.rightChild);
		int diff=Math.abs(lh-rh);
		if(diff>1)
			return false;
		else 
			return isBalncedTree(root.leftChild) && isBalncedTree(root.rightChild);
	}
}

class check_BST_or_Not{
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.leftChild = new TreeNode(4);
		root.rightChild = new TreeNode(6);
		root.rightChild.leftChild=new TreeNode(3);
		root.rightChild.rightChild=new TreeNode(7);

		System.out.println("IsBST::"+isBST(root));
		System.out.println("IsBST::"+isBST1(root));
	}

	private static boolean isBST(TreeNode root) {
		Queue q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode tr = (TreeNode) q.poll();
			if (tr.leftChild != null) {
				if (tr.leftChild.data < tr.data)
					q.add(tr.leftChild);
				else
					return false;
			}
			if (tr.rightChild != null) {
			if (tr.rightChild.data > tr.data)
				q.add(tr.rightChild);
			else
				return false;
			}
		}
		return true;
	}
	
	static boolean isBST1(TreeNode node)
	{
	    if (node == null)
	        return true;
	     
	    /* False if left is > than node */
	    if (node.leftChild != null && node.leftChild.data > node.data)
	        return false;
	     
	    /* False if right is < than node */
	    if (node.rightChild != null && node.rightChild.data < node.data)
	        return false;
	     
	    /* False if, recursively, the left or right is not a BST */
	    if (!isBST1(node.leftChild) || !isBST1(node.rightChild))
	        return false;
	     
	    /* Passing all that, it's a BST */
	    return true;
	}
	 
}
/**
 * Course Schedule | Deadlock detection 
 * @author 
 *
 */
class Course_Schedule {

	static int noOfCources;
	static LinkedList<Integer>[] adj_list;
	static int[] visited;
	static Stack<Object> s;
	static Map<Object,Integer> visitedMap=new HashMap();
	static Map<Object,LinkedList> adj_Map=new HashMap();
	static List<Object> courseList = new ArrayList<Object>();


	Course_Schedule(int v) {
		noOfCources = v;
		adj_list = new LinkedList[noOfCources + 1];
		for (int i = 0; i < noOfCources + 1; i++)
			adj_list[i] = new LinkedList<>();
		visited = new int[noOfCources + 1];
		s=new  Stack<Object>();
	}

	void addEdge(Object i, Object j) {
		if(adj_Map.get(i)!=null) {
			adj_Map.get(i).add(j);
		}else {
			LinkedList l=new LinkedList();
		     l.add(j);
		     adj_Map.put(i, l);
		}
		updateVisitedMap(i,j);
	}

	private void updateVisitedMap(Object i, Object j) {
		if(!visitedMap.containsKey(i))
			visitedMap.put(i, 0);
		if(!visitedMap.containsKey(j))
			visitedMap.put(j, 0);		
	}

	public static void main(String[] args) {
		Course_Schedule g = new Course_Schedule(4);
		g.addEdge('f', 'c');
		g.addEdge('f', 'a');
		g.addEdge('f', 'b');
		g.addEdge('c', 'a');
		
		g.addEdge('b', 'a');
		g.addEdge('b', 'h');
		g.addEdge('a', 'e');
		g.addEdge('b', 'e');
		g.addEdge('d', 'g');
	//	g.addEdge(4, 1);
		System.out.println("Complete can Course::" + canCompleteCourse());
		while(!s.isEmpty())
			System.out.println(s.pop());
	}

	static Boolean canCompleteCourse() {
		courseList.addAll(visitedMap.keySet());
		for (int i = 1; i < courseList.size(); i++) {
			Object courseKey= courseList.get(i);
			if (visitedMap.get(courseKey) != 1 && isCyclic(courseKey) )
				return false;
		}
		return true;
	}

	static Boolean isCyclic(Object i) {
		if (visitedMap.get(i) == 2)
			return true;
		visitedMap.put(i, 2);
		LinkedList<Integer> l = adj_Map.get(i);

		for (int j = 0; l!=null && j < l.size(); j++)
			if (visitedMap.get(l.get(j))!=1 && isCyclic(l.get(j)))
				return true;

		visitedMap.put(i, 1);
		s.push(i);
		return false;
	}
}
/**
 * Check if a binary tree is subtree of another binary tree |
 * @author 
 *
 */
class TreeInTree{
	public static void main(String[] args) {
		
		 /* Construct the following tree
        26
       /   \
      10     3
     /    \     \
    4      6      3
     \
      30  */
		TreeNode root1 = new TreeNode(26);
		root1.rightChild = new TreeNode(3);
		root1.rightChild.rightChild = new TreeNode(3);
		root1.leftChild = new TreeNode(10);
		root1.leftChild.leftChild = new TreeNode(4);
		root1.leftChild.leftChild.rightChild = new TreeNode(30);
		root1.leftChild.rightChild = new TreeNode(6);
		
		  // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
           
		TreeNode root2 = new TreeNode(10);
		root2.rightChild = new TreeNode(6);
		root2.leftChild = new TreeNode(4);
		root2.leftChild.rightChild = new TreeNode(30);
		//root2.leftChild.leftChild = new TreeNode(30);
		
		System.out.println("isSubTree::"+ isSubTree(root1,root2));
	}
	
	static Boolean isSubTree(TreeNode r1,TreeNode r2) {
		
		if (r2 == null) return true;
		if (r1 == null) return false;
	    if(r1==null && r2==null)return true;
	    
		if(checkIdentical(r1,r2))
			return true;

		return isSubTree(r1.leftChild, r2)|| isSubTree(r1.rightChild, r2);
 						
	}
	
	static Boolean checkIdentical(TreeNode p,TreeNode q) {
		if(p==null && q==null)
			return true;
		
		if(p!=null && q!=null)
			return p.data == q.data && checkIdentical(p.leftChild, q.leftChild)
					&& checkIdentical(p.rightChild, q.rightChild);
		return false;
	}
}

/**
 * Design data structure | Insert Delete GetRandom O(1) 
 * @author 
 *
 */
class GetRandomDS{
	static int arr[];
	static int index; //index+1 is the size of the current array
	static Map<Integer,Integer> map;
	
	GetRandomDS(){
		arr=new int[10];
		index=0;
		map=new HashMap<Integer, Integer>();
	}
	
	static void insert(int d) {
		if(arr.length==index)
			System.out.println("DS is Full");
		else if(!map.containsKey(d)) {
			arr[index]=d;
			map.put(d, index);
			index++;
		}
	}
	
	static void delete(int d) {
		if(map.containsKey(d)) {
			int i=map.get(d);
			arr[i]=arr[index-1];
			map.put(arr[index-1], i);
			
		}
	}
	
	static void getRandom() {
		java.util.Random r=new java.util.Random();
		int i= Math.abs(r.nextInt())%index+1;
		System.out.println("Random value="+arr[i]);
	}
	
	public static void main(String[] args) {
		GetRandomDS g=new GetRandomDS();//on;y for initializing the object
		insert(10);
		insert(20);
		insert(30);
		insert(40);
		delete(10);
		getRandom();
	}
}

/**
 * Write a function to print ZigZag order traversal of a binary tree. For the
 * below binary tree the zigzag order traversal will be 1 3 2 7 6 5 4.
 * 
 * @author 
 *
 */
class zigzag{
	
	static Stack<TreeNode> s1=new Stack();
	static Stack<TreeNode> s2=new Stack();

	public static void main(String[] args) {
		
		TreeNode rootNode = new TreeNode(1);
	    rootNode.leftChild = new TreeNode(2);
	    rootNode.rightChild = new TreeNode(3);
	    rootNode.leftChild.leftChild = new TreeNode(7);
	    rootNode.leftChild.rightChild = new TreeNode(6);
	    rootNode.rightChild.leftChild = new TreeNode(5);
	    rootNode.rightChild.rightChild = new TreeNode(4);
	    System.out.println("ZigZag Order traversal of binary tree is");
	    printZigZagTraversal(rootNode);
	}

	private static void printZigZagTraversal(TreeNode root) {
		if(root!=null) {
			s1.push(root);
			while(!s1.isEmpty()) {
				TreeNode n=s1.pop();
				System.out.println(n.data);
				if(n.leftChild!=null) s2.push(n.leftChild);
				if(n.rightChild!=null) s2.push(n.rightChild);
				while(!s2.isEmpty()) {
					TreeNode n2=s2.pop();
					System.out.println(n2.data);
					if(n2.rightChild!=null) s1.push(n2.rightChild);
					if(n2.leftChild!=null) s1.push(n2.leftChild);
				}
			}
		}
		
	}
}

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * @author 
 *
 */
class FindMissing_Num{
	public static int firstMissingPositive(int[] nums) {
		int min = Integer.MAX_VALUE, max = 0;
		int[] dummy;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>0 && nums[i] < min) min = nums[i];
			if (nums[i] > max) max = nums[i];
		}
		if(min>2)
			return 1;
		
		dummy=new int[2147483647];
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=0)
			  dummy[nums[i]]=1;
		}
		for(int i=1;i<max+1;i++) {
			if(dummy[i]==0)
				return i;
		}
		return max+1;
	}
	 public static void main(String[] args) {
		int[] nums= {2147483647};
		System.out.println(firstMissingPositive(nums));
	}
}

/**
 *  Anagram of string s1 in string s2 |
 * @author 
 *
 */
class Anagram {

    static Boolean checkInclusion(String s1, String s2) {

        int[] s1hash= new int[26];
        int[] s2hash= new int[26];
        int s1len = s1.length();
        int s2len = s2.length();
        if(s1len>s2len || s2len>s1len)
            return false;
        
        int left=0,right=0;
        while(right<s1len)
        {
            s1hash[s1.charAt(right) -'a'] +=1;
            s2hash[s2.charAt(right) -'a'] +=1;
            right +=1;
        }
        right -=1;  // to point right to the end of the window
        while(right<s2len)
		{
			if (isEqual(s1hash, s2hash))
				return true;
			right += 1;
			if (right != s2len)//to avoid NPE when right is at full length
				s2hash[s2.charAt(right) - 'a'] += 1;
			s2hash[s2.charAt(left) - 'a'] -= 1;
			left += 1;
		}
        return false;
    }
    private static boolean isEqual(int[] s1hash, int[] s2hash) {
		for(int i=0;i<s1hash.length;i++) {
			if(s1hash[i]!=s2hash[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
    	System.out.println(checkInclusion("cab","mncda"));
	}
}

/**
 * Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 * @author 
 *
 */
class Find_All_Anagram {
    public static List<Integer> findAnagrams(String s, String p) {
        

       List<Integer> list=new ArrayList<>();
        if(p.length()>s.length()) return list;
        
        int[] freq_p=new int[26];
        for(int i=0;i<p.length();i++)
        {
            freq_p[p.charAt(i)-'a']++;
        }
        int[] freq_s=new int[26];
		//i<p.length because we have the check the p window size array in s  
        for(int i=0;i<p.length();i++)
        {
            freq_s[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq_s,freq_p)) list.add(0);
        for(int i=p.length();i<s.length();i++)
        {
		// eleminating the the first character frequency
            freq_s[s.charAt(i-p.length())-'a']--;
			// adding the current character frequency
            freq_s[s.charAt(i)-'a']++;
            
            // i-p.length()+1 is for starting index if the anagram
			// if both arrays are same then we have found the angram
            if(Arrays.equals(freq_s,freq_p)) list.add(i-p.length()+1);
        }
        return list;
    }
    
	public static void main(String[] args) {
    	System.out.println(findAnagrams("cbaebabacd","abc"));
	}
    
    }
     

class Permutation_of_String{
	
	public static void main(String[] args) {
		
		System.out.println("Polindrome::"+Polindrome("abc"));
	}
	static List<String> Polindrome(String s) {
		List list=new ArrayList();
		
		if(s.length()==1) {
			list.add(s);
			return list;
		}
		
		List<String> temp=Polindrome(s.substring(1,s.length()));
		for(int i=0;i<temp.size();i++) {
			String str=temp.get(i);
			for(int j=0;j<str.length()-1;j++) {
                
				list.add(str.substring(j, j+1) + s.charAt(0)+str.subSequence(j+1, str.length()));
			}
				list.add(str+s.charAt(0));
				list.add(s.charAt(0)+str);
					
		}
		return list;
		
	}
}

class Infix_Postfix{
	
	public static void main(String[] args) {
		String s="1 + 1";
		System.out.println("Infix_Postfix::"+expression_Evaluation(s));
	}

	private static Object expression_Evaluation(String s) {
		String str=infix_Postfix(s);
		System.out.println(str);
		Boolean operator=false;
		Stack<Object> stack=new Stack<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch!=' ') {
			if(!isOperator(ch)) {
				stack.push(ch);
			}
			else {
				operator=true;
				Integer x2 =Integer.parseInt( stack.pop().toString());
				Integer x1 = Integer.parseInt( stack.pop().toString());
				int r = 0;
				switch (ch) {
				case '+': r = x1 + x2; break;
				case '-': r = x1 - x2; break;
				case '*': r = x1 * x2; break;
				case '/': r = x1 / x2; break;
				}
				stack.push(r);
			}
			}
			
		}
		if(operator==false) return str;	
		return stack.peek();
	}

	private static String infix_Postfix(String s) {
		String postfix="";
		Stack<Object> st=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!isOperator(ch))
				postfix=postfix+ch;
			else {
				if(st.isEmpty() ||ch=='(' || (getPrecedance(ch)>getPrecedance((char)st.peek())))
					st.push(ch);
				else if(ch==')') {
					while ( (char)st.peek() != '(')  
					{  
					postfix = postfix + st.pop();  
					}  
					st.pop(); 
				}
				else {
					do {
					postfix=postfix+st.pop();
					}while(!st.isEmpty() && (char)st.peek()!='(' && getPrecedance((char)st.peek())<=getPrecedance(ch));
					st.push(ch);
				}
			}
		}
		 while(!st.isEmpty()) 
			 postfix=postfix+st.pop();
		 
		return postfix;
	}
	
	static int getPrecedance(char c) {
		if(c=='+' || c=='-')
			return 1;
		if(c=='*' || c=='/')
			return 2;
		return -1;
	}
	
	static Boolean isOperator(char c) {
		if(c=='+' || c=='-' || c=='*' || c=='/' || c=='(' || c==')')
			return true;
		return false;
	}
}

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
 * 
 * @author 
 *
 */
class CoinChanging1 {
	public static void main(String[] args) {
		int total = 3;
		int coins[] = { 2};
		
		System.out.println("minimumCoinBottomUp="+coinChanging(total,coins));
	}
	public static int coinChanging(int total, int coins[]) {
		int a[][] = new int[coins.length + 1][total + 1];

		for (int i = 0; i <= total; i++)
			a[0][i] = Integer.MAX_VALUE - 1;

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j < coins[i - 1]) {

					a[i][j] = a[i - 1][j];
				} else {

					a[i][j] = Math.min(a[i - 1][j], 1 + a[i][j - coins[i - 1]]);
				}
			}
		}
		if (a[coins.length][total] == Integer.MAX_VALUE - 1) //If no coins can create the total, return -1
			return -1;
		return a[coins.length][total];
	}
}
class CoinChanging {
	public static void main(String[] args) {
		int total = 11;
		int coins[] = { 1,2,5};

		System.out.println(numberOfSolutions(0, total, coins));
		printCoinChangingSolution(total, coins);
		
		System.out.println("minimumCoinBottomUp="+minimumCoinBottomUp(total,coins));
	}

	public static int numberOfSolutions(int index, int sum, int coins[]) {
		if (sum == 0)
			return 1;
		if (sum < 0 || index >= coins.length)
			return 0;
		int left = numberOfSolutions(index, sum - coins[index], coins);
		int right = numberOfSolutions(index + 1, sum, coins);
		return left + right;

	}

	public static int minimumCoinBottomUp(int total, int coins[]) {
		int a[][] = new int[coins.length + 1][total + 1];

		for (int i = 0; i <= total; i++)
			a[0][i] = Integer.MAX_VALUE - 1;

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j < coins[i - 1]) {

					a[i][j] = a[i - 1][j];
				} else {

					a[i][j] = Math.min(a[i - 1][j], 1 + a[i][j - coins[i - 1]]);
				}
			}
		}
		if (a[coins.length][total] == Integer.MAX_VALUE - 1) //If no coins can create the total, return -1
			return -1;
		return a[coins.length][total];
	}

	public static void printCoinChangingSolution(int total, int coins[]) {
		List<Integer> result = new ArrayList<>();
		// printActualSolution(result, total, coins, 0);
		printActualSolution_Recursive(0, total, coins, new ArrayList<Integer>());
	}

	// Method 1 - Iter+Recursive
	private static void printActualSolution(List<Integer> result, int total, int coins[], int pos) {

		if (total == 0) {
			for (int r : result) {
				System.out.print(r + " ");
			}
			System.out.print("\n");
		}
		for (int i = pos; i < coins.length; i++) {
			if (total >= coins[i]) {
				result.add(coins[i]);
				printActualSolution(result, total - coins[i], coins, i);
				result.remove(result.size() - 1);
			}
		}
	}

	// Method 2 - Recursive
	private static void printActualSolution_Recursive(int index, int sum, int coins[], List<Integer> result) {
		if (sum < 0 || index >= coins.length)
			return;

		if (sum == 0) {
			for (int r : result) 
				System.out.print(r + " ");
			System.out.print("\n");
			return;
		}

		result.add(coins[index]);
		printActualSolution_Recursive(index, sum - coins[index], coins, result);
		result.remove(result.size() - 1);
		printActualSolution_Recursive(index + 1, sum, coins, result);
		return;
	}
}

class Find_First_last_Index{
	 public static void main(String[] args) {
		int arr[]= {5,7,7,8,8,10};
		int k=11;
		int first=findFirstIndex(arr,k);
		int last=findSecondIndex(arr,k);
		System.out.println("first="+first);
		System.out.println("last="+last);
	}

	private static int findFirstIndex(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		int mid, first = 0;
		while (low <= high) {
			mid = low + (high - low)/ 2;
			if (arr[mid] == k) {
				first = mid;
				high = mid - 1;
			} else if (arr[mid] > k)
				high = mid - 1;
			else if (arr[mid] < k)
				low = mid + 1;
		}
		return first;
	}
	
	private static int findSecondIndex(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		int mid, second = 0;
		while (low <= high) {
			mid = low + (high - low)/ 2;
			if (arr[mid] == k) {
				second = mid;
				low = mid + 1;
			} else if (arr[mid] > k)
				high = mid - 1;
			else if (arr[mid] < k)
				low = mid + 1;
		}
		return second;
	}
}

/**
 * Search in Rotated Sorted Array
 * @author 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 *
 */
class Search_in_Rotated_Sorted_Array{
	
	public static void main(String[] args) {
		int arr[] = { 3,4,5,6,1,2};
		int target = 2;
		int n = arr.length - 1;
		int res, pivot;
		if (arr.length == 1 && target == arr[0])
			res = 0;
		else if (arr.length == 1 && target != arr[0])
			res = -1;

		pivot = findIndex(0, arr.length - 1, arr);
		if (pivot != -1) {
			if (target >= arr[pivot] && target <= arr[n])
				res = binarySearch(pivot, n, arr, target);
			else
				res = binarySearch(0, pivot - 1, arr, target);
		} else {
			res = binarySearch(0, n, arr, target);
		}
		System.out.println(res);
	}
	private static int binarySearch(int i, int j, int[] arr,int target) {
	      int low=i;
	      int high=j;
	      int mid,first=-1;
	      while(low<=high) {
	    	  mid=low+(high-low)/2;
	    	  if(arr[mid]==target) {
	    		   first= mid;
	    		   high=mid-1;
	    	  }else if(arr[mid]>target)
	    		    high=mid-1;
	    	  else if(arr[mid]<target)
	    		   low=mid+1;
	      }
		return first;
	}

	private static int findIndex(int s, int e, int[] arr) {
		int m;
		m = (s + e) / 2;
		if (m < arr.length - 1) {
			if (arr[m] >= arr[m + 1])
				return m + 1;// pivot
			else {
				if (arr[s] > arr[m])
					return findIndex(s, m - 1, arr);
				else
					return findIndex(m + 1, e, arr);
			}
		}
		return -1;
	}
}

class Dictionary{
	
	public static void main(String[] args) {
	      Set<String> s = new HashSet<String>();
	      Map map=new HashMap<String, Boolean>();
	        s.add("apple");
	        s.add("pear");
	        s.add("pie");
	       System.out.println(DFS("applepie",s,map));
	}
	
	static Boolean DFS(String s,Set set,Map map) {
		if(s.isEmpty()) return true;
		if(map.containsKey(s)) return (Boolean) map.get(s);
		for(int i=0;i<=s.length();i++) {
			System.out.println(s.substring(0, i));
			if(set.contains(s.substring(0, i)) && DFS(s.substring(i,s.length()),set,map)) {
				map.put(s.substring(i, s.length()), true);
					return true;
			}
			}
		return false;			
		}
	}


class subset{
	
	public static void main(String[] args) {
		int arr[] = { 2,3,4};
		List res=subset(arr,0);
		System.out.println(res);
	}

	private static List subset(int[] arr, int index) {
		List res=new ArrayList();
		if(index==arr.length-1) {
			res.add(Arrays.asList(arr[arr.length-1]));
			return res;
		}
		List<List> l=subset(arr, index+1);
		
		for (int i = 0; i < l.size(); i++) {
			ArrayList n = new ArrayList();
			n.add(arr[index]);
			if (l.get(i) instanceof List) {
				for (int j = 0; j < l.get(i).size(); j++) {
					n.add(l.get(i).get(j));
				}
			} else {
				n.add(l.get(i));
			}
			res.add(n);
		}
		 res.add(Arrays.asList(arr[index]));
		 res.addAll(l);
		 return res;		
	}
}


/**
 * Input : n=2
Output: 
{}{}
{{}}
 * @author 
 *
 */

class Balanced_Brace
{
	// Function that print all combinations of
	// balanced parentheses
	// open store the count of opening parenthesis
	// close store the count of closing parenthesis
	static void _printParenthesis(char str[], int pos, int n, int open, int close)
	{
		if(close == n)
		{
			// print the possible combinations
			for(int i=0;i<str.length;i++)
				System.out.print(str[i]);
			System.out.println();
			return;
		}
		else
		{
			if(open > close) {
				str[pos] = '}';
				_printParenthesis(str, pos+1, n, open, close+1);
			}
			if(open < n) {
				str[pos] = '{';
				_printParenthesis(str, pos+1, n, open+1, close);
			}
		}
	}
	
	// Wrapper over _printParenthesis()
	static void printParenthesis(char str[], int n)
	{
		if(n > 0)
		_printParenthesis(str, 0, n, 0, 0);
		return;
	}
	
	// driver program
	public static void main (String[] args)
	{
		int n = 3;
		char[] str = new char[2 * n];
		printParenthesis(str, n);
	}
}

class Node6 {
	Node6 prev;
	Node6 next;
	int val;

	Node6(int val) {
		this.val = val;
	}
}
/**
 * 25 12 30 10 36 15
 * @author 
 *
 */
class BinaryTree_to_DLL_Conversion {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.leftChild = new TreeNode(12);
		root.rightChild = new TreeNode(15);
		root.leftChild.leftChild = new TreeNode(25);
		root.leftChild.rightChild = new TreeNode(30);
		root.rightChild.leftChild = new TreeNode(36);

		// convert to DLL
		binaryTree2DoubleLinkedList(root);

		// Print the converted List
		printList(head);
	}

	private static void printList(Node6 head) {
		// TODO Auto-generated method stub
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	static Node6 head = null;
	static Node6 prev_Node = null;

	private static void binaryTree2DoubleLinkedList(TreeNode root) {

		if (root == null)
			return;

		binaryTree2DoubleLinkedList(root.leftChild);
		Node6 n = new Node6(root.data);
		if (head == null)
			head = n;
		else {
			prev_Node.next = n;
			n.prev = prev_Node;
		}
		prev_Node = n;
		binaryTree2DoubleLinkedList(root.rightChild);

	}
}
/**
 * Input: Root of below tree
       1
      / \
     2   3
Output: 6

See below diagram for another example.
1+2+3
 * @author 
 *
 */
class Maximum_Path_Sum_in_BinaryTree{
	
	public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(10);
        root.leftChild.leftChild = new TreeNode(20);
        root.leftChild.rightChild = new TreeNode(1);
        root.rightChild.rightChild = new TreeNode(-25);
        root.rightChild.rightChild.leftChild = new TreeNode(3);
        root.rightChild.rightChild.rightChild = new TreeNode(4);
        findMaxSum(root);
        System.out.println("maximum path sum is :"+res);
	}
static int res=Integer.MIN_VALUE;
	private static int findMaxSum(TreeNode root) {
		if(root ==null)
			return 0;
		int left=findMaxSum(root.leftChild);
		int right=findMaxSum(root.rightChild);
		int max_s=Math.max(Math.max(left, right)+root.data,root.data);
		int max_top=Math.max(max_s, left+right+root.data);
		if(max_top>res) res=max_top;
		return max_s;
	}
}

class RotateArray {
	public static void main(String[] args) {
		  int arr[] = { 1, 2 };
		  rightRotate(arr, 3);
	        for(int i:arr)
	        	System.out.print(i+" ");
	}

	private static void leftRotate(int[] arr, int r) {
		if(r>arr.length)
			r=r%arr.length;
		int[] temp=new int[r];
		for(int i=0;i<r;i++)
			temp[i]=arr[i];
		
		for(int i=0;i<arr.length-r;i++) 
			arr[i]=arr[i+r];
		
		int index=0;
		for(int i=arr.length-r;i<arr.length;i++) 
			arr[i]=temp[index++];
		
		
	}
	
	
	private static void rightRotate(int[] arr, int r) {
		if(r>arr.length)
			r=r%arr.length;
		int[] temp=new int[r];
		int index=0;
		for(int i=arr.length-r;i<arr.length;i++)
			temp[index++]=arr[i];
		
		for(int i=arr.length-1;i>=r;i--)
			arr[i]=arr[i-r];
		
	
		for(int i=0;i<temp.length;i++)
			arr[i]=temp[i];
		
		
	}
}
/**
 * Longest Increasing Subsequence
 * @author 
 *
 */
class LIS {
	
	public static void main(String[] args) {
		 int arr[] = {1,3,6,7,9,4,10,5,6};
	        int n = arr.length;
	        System.out.println("Length of lis is " + lis(arr, n)
	                           + "\n");
	}

	private static int lis(int[] arr, int n) {
	  int[] length=new int[arr.length];
	  int[] subSeq=new int[arr.length];
	  Arrays.fill(length, 1);
	  
	  for(int i=1;i<n;i++) {
		  for(int j=0;j<i;j++) {
			  if(arr[i]>arr[j] && length[j]+1>=length[i]) {
				  length[i]=length[j]+1;
				  subSeq[i]=j;
			  }
		  }
	  }
	  int max=Integer.MIN_VALUE;
	  for(int i:length) {
		  if(max<i)
			  max=i;
	  }
		return max;
	}
}
/**
 * Given an array, reverse every sub-array formed by consecutive k elements.
 * 
 * Input: 
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9] 
k = 3 
Output: 
[3, 2, 1, 6, 5, 4, 9, 8, 7]

Input: 
arr = [1, 2, 3, 4, 5, 6, 7, 8] 
k = 5 
Output: 
[5, 4, 3, 2, 1, 8, 7, 6]
 * @author 
 *
 */
class Reverse_ArrayIn_Group{
	
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int k = 3;
		int n = arr.length;
		reverse(arr, k);

		
	}

	private static void reverse(int[] arr, int k) {
		int[] temp=new int[arr.length];
		int index=0;
		for(int i=0;i<arr.length;i=i+k) {
			for(int j=i+k-1;j>=i && j<arr.length;j--) {
				temp[index++]=arr[j];
			}
		}
		//Remaining values in the array which are less than k
		for(int j=arr.length-1;index<arr.length;j--)
			temp[index++]=arr[j];
		//print
		for (int i = 0; i < temp.length; i++)
			System.out.print(temp[i] + " ");
		
	}
}

class Rotate_LinkedList{
	public static void main(String[] args) {

		Node2 head = new Node2(10);
		head.next = new Node2(20);
		head.next.next = new Node2(30);
		head.next.next.next = new Node2(40);
		head.next.next.next.next = new Node2(50);
		System.out.println("Given list");
		printList(head);

		head=rotate(head, 10);

		System.out.println("Rotated Linked List");
		printList(head);
	}

	private static Node2 rotate(Node2 head,int r) {
       
		Node2 n=head;
		int j=0;
		if(n!=null && n.next!=null){
		while(j<r) {
			if(n!=null) {
			n=n.next;
			j++;
			}else {
				int size=j;
				r=r%size;
				j=0;
				n=head;
			}
		}
		Node2 m=head;
		if(n==null || r==0)
			return head;
		while(n.next!=null) {
			n=n.next;
			m=m.next;					
		}
		Node2 n_head=m.next;
		m.next=null;
		n.next=head;
		head=n_head;
		}
		return head;
	}

	private static void printList(Node2 head) {
		Node2 temp = head;
	        while (temp != null) {
	            System.out.print(temp.data + " ");
	            temp = temp.next;
	        }
	        System.out.println();
		
	}
}
/**
 * For example, this binary tree is symmetric: 

     1
   /   \
  2     2
 / \   / \
3   4 4   3
 * @author 
 *
 */
class Symmetric_Tree{
	
	public static void main(String[] args) {
	        TreeNode root = new TreeNode(1);
	        root.leftChild = new TreeNode(2);
	        root.rightChild = new TreeNode(2);
	        root.leftChild.leftChild = new TreeNode(3);
	        root.leftChild.rightChild = new TreeNode(4);
	        root.rightChild.leftChild = new TreeNode(4);
	        root.rightChild.rightChild = new TreeNode(3);
	        boolean output = isSymmetric(root,root);
	        if (output == true)
	            System.out.println("Symmetric");
	        else
	            System.out.println("Not symmetric");
	}

	private static boolean isSymmetric(TreeNode node1,TreeNode node2) {
		  if(node1==null && node2==null)
			  return true;
		  
		  if (node1!=null && node2!=null && node1.data==node2.data)
			  return isSymmetric(node1.leftChild,node2.rightChild)
				  && isSymmetric(node1.rightChild,node2.leftChild);
		   return false;
	}
}

class Subarray_sum_equals_K{
	
	public static void main(String[] args) {
		   int[] arr = {6, 3, -1, -3, 4, -2, 2,
		             4, 6, -12, -7};            
           System.out.println(findSubArrays(arr,0));
	}

	private static int findSubArrays(int[] arr,int k) {
		int sum=0,count=0,index=0;
		Map prevSum=new HashMap();
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			if(sum==k)
				count++;
			else if(prevSum.containsValue(sum-k)) {
				count++;
				System.out.println(sum-k+"-->"+prevSum.get(sum-k)+"  "+i);
			}
			
			prevSum.put(i,sum);
			
		}
return count;		
	}
} 

/**
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz” 
Output : 5 
Explanation:
The longest common substring is “Geeks” and is of length 5.
 * @author 
 *
 */
class Longest_Common_Substring {

	public static void main(String[] args) {
		String X = "abcde";
		String Y = "ace";
		findLCSubStr(X, Y);

		System.out.println("LCSubStr::"+LCSubStr);
	}

	private static String findLCSubStr(String x, String y) {

		String n1 = x.length() > y.length() ? x : y;
		String n2 = x.length() > y.length() ? y : x; //lesser length string
			

		return 	LCSubStr(n1,n2);
	}
	static String LCSubStr="";
	private static String LCSubStr(String n1, String n2) {
		
		if(n2.isEmpty())
			return "";
		
		LCSubStr(n1,n2.substring(1,n2.length()));
		for(int i=0;i<n2.length();i++) {
			if(n1.contains(n2.substring(i, n2.length()))) {
				if(LCSubStr.length()<n2.substring(i, n2.length()).length())
					LCSubStr=n2.substring(i, n2.length());
			}
		}
		return "";
	}
}

class Longest_Common_Subsequence{
	
	public static void main(String[] args) {
		String x = "bqdrcvefgh";
		String y = "abcvdefgh";
		
		longestCommonSubsequence(x, y);
	}

	private static void longestCommonSubsequence(String n1, String n2) {
		n1=" "+n1;
		n2=" "+n2;
		int T[][]=new int[n1.length()][n2.length()];
		
		for(int i=1;i<n1.length();i++) {
			char c=n1.charAt(i);
			for(int j=1;j<n2.length();j++) {
				if(c!=' ' && c==n2.charAt(j)) 
					 T[i][j]=T[i-1][j-1]+1;
				else
					 T[i][j]=Math.max(T[i-1][j], T[i][j-1]);
					
				}
			}
		System.out.println(T[n1.length()-1][n2.length()-1]);//length of the longest common sequence 
		String res="";
		int i=n1.length()-1;
		int j=n2.length()-1;
				
			while(j>=1 && i>=1) {
				int k=T[i][j];
				if(k==T[i-1][j-1]+1) {
					res=res+n1.charAt(i);
					i=i-1;
					j=j-1;
				}else {
					if(k==T[i-1][j]) {
						i=i-1;
						j=j;
					}
					else {
						j=j-1;
						i=i;
					}											
				}
			}
		System.out.println(res); //longest common subsequence
		}
	
	    
	}

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            inputs.add(Integer.valueOf(br.readLine()));
        }
        ArrayList<BigInteger> outputs = new ArrayList<BigInteger>();
        for(Integer input : inputs){
            outputs.add(factorial(input));
        }
        for(BigInteger result: outputs){
            System.out.println(result);
        }
    }

    private static BigInteger factorial(Integer input) {
        if(input == 1) return BigInteger.ONE;
        return factorial(input - 1).multiply(new BigInteger(String.valueOf(input)));
    }
}

class Solution {

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
    	 Set<Integer> seen=new HashSet<>();
         while(n!=1 && !seen.contains(n)){
             seen.add(n);
             n=getNext(n);
         }
         return n==1;
    }
    
    public static void main(String[] args) {
    	 int n = 2;
    	 for(int i=7;i<=7;i++) {
    	    if (isHappy(i))
    	        System.out.println(i +
    	        " is a Happy number");
    	    else
    	        System.out.println(i +
    	        " is not a Happy number");
    	}
    }
	}


 class TestClass1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);

            long out_ = solve(l, r);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static long solve(int l, int r){
       long res=0;
       for(int i=l;i<=r;i++){
           if(isHappy(i)){
             res=res+i;
           }
       }
       return res;
    
    }

    private static int getNext(int n){
        int total=0;
        while(n>0){
            int d=n%10;
            n=n/10;
            total+=d*d;
        }
        return total;
    }

    public static boolean isHappy(int n){
        Set<Integer> seen=new HashSet<>();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n=getNext(n);
        }
        return n==1;
    }
}
/**
 * Given an array arr[] of N elements, the task is to update all the elements of the given array to some value X such that the sum of all the updated array elements is strictly greater than the sum of all the elements of the initial array and X is the minimum possible.
Examples: 
 

Input: arr[] = {4, 2, 1, 10, 6} 
Output: 5 
Sum of original array = 4 + 2 + 1 + 10 + 6 = 23 
Sum of the modified array = 5 + 5 + 5 + 5 + 5 = 25
Input: arr[] = {9876, 8654, 5470, 3567, 7954} 
Output: 7105 
 * @author 
 *
 */
class FindMinValue{
	
	public static void main(String[] args) {
		 int arr[] = { 9876, 8654, 5470, 3567, 7954 };
	        int n = arr.length;
	 
	        System.out.print(findMinValue(arr, n));
	}

	private static int findMinValue(int[] arr, int n) {
		
		int sum=0;
		for(int i:arr)
			sum=sum+i;
		
		return (sum/n)+1;
	}
}

/**
 * Given an int array wood representing the length of n pieces of wood and an
 * int k. It is required to cut these pieces of wood such that more or equal to
 * k pieces of the same length len are cut. What is the longest len you can get?
 * 
 * Input: wood = [5, 9, 7], k = 3
Output: 5
Explanation: 
5 -> 5
9 -> 5 + 4
7 -> 5 + 2
 * @author 
 *
 */
class WoodCutter {
 // check whether woods can be cut into at least k pieces with length Length 
 public static boolean isValid(int[] wood, int cutLength, int k){
     int count = 0;
     for(int w: wood){
    	 int cutted=w / cutLength;
         if(cutted>0) count=count+cutted;
     }
     return count >= k;
 }
 public static int cutWood(int[] wood, int k){
     // corner cases:
     if(wood.length == 0 || k == 0) return 0;
     int left = 1, right = Integer.MAX_VALUE;
     int res = 0;
     if(!isValid(wood, left, k)) return 0;
     while(left < right){
         int mid = left + (right - left)/2;
         boolean valid = isValid(wood, mid, k);
         if(valid){
             left = mid + 1;
             res = mid;
         }
         else
             right = mid;
     }
     return res;
 }
 public static void main(String[] args) {
     int[][]testcases_wood = { {5, 9, 7} ,{5, 9, 7} };
     int[] testcases_k = {3, 4};
     for(int i = 0; i < testcases_wood.length; ++i)
         System.out.println(cutWood(testcases_wood[i], testcases_k[i]));
 }
}



/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * 
 * @author 
 *
 */
class KoKo_Banana_Eating{
	
	static Boolean isValid(int[] piles, int K, int H) {
		int time = 0;
		for (int p : piles) {
			time += p / K; // Get the number of hours not accounting for leftover hours
			time += (p % K == 0) ? 0 : 1; // Now account for leftover hours here.
		}
		return time <= H;
	}
	
	 public static int minEatingSpeed(int[] piles, int h) {
		 
		 if(piles.length==0 || h==0)
			 return 0;
		 int left=1;
		 int right=Integer.MAX_VALUE;

		 int mid,res = 0;
		 while(left<right) {
			 mid=left+(right-left)/2;
			 if(isValid(piles,mid,h)) {
				 res=mid;
				 right=mid;
			 }else
				 left=mid+1;
		 }
		return res;
	        
	    }
	
	public static void main(String[] args) {
		int[] piles= {30,11,23,4,20};
		int h=5;
		int res=minEatingSpeed(piles,h);
		System.out.println(res);
	}
}

/**
 * There are n piles of stones arranged in a row. The ith pile has stones[i] stones.

A move consists of merging exactly k consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these k piles.

Return the minimum cost to merge all piles of stones into one pile. If it is impossible, return -1.

 

Example 1:

Input: stones = [3,2,4,1], k = 2
Output: 20
Explanation: We start with [3, 2, 4, 1].
We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
We merge [4, 1] for a cost of 5, and we are left with [5, 5].
We merge [5, 5] for a cost of 10, and we are left with [10].
The total cost was 20, and this is the minimum possible.
 * @author 
 *
 */
class Merge_Stone {
	public static void main(String[] args) {
	     int[] stones1 = {3,2,4,1};
	     int k1 = 2;
	    System.out.println(mergeStones(stones1, k1));
	}
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if (n == 1)
            return 0;
        if ((n - 1) % (k - 1) != 0)
            return -1;
        
        int[][] dp = new int[n][n]; // dp[i][j] is the min cost of merging stones[i] ~ stones[j] to (j - 1) % (k - 1) + 1 piles.
        int[] sums = new int[n + 1]; // sums[0] = 0; sums[j + 1] - sums[i] is the sum of stones from i to j (included).
        for (int i = 0; i < n; i++)
            sums[i + 1] = stones[i] + sums[i];
        for (int[] cur : dp)
            Arrays.fill(cur, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            dp[i][i] = 0;
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int m = i; m < j; m += k - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                if ((len - 1) % (k - 1) == 0)
                    dp[i][j] += sums[j + 1] - sums[i];
            }
        }
        return dp[0][n - 1];
    }
}

class Request {
    String name;
    int from;
    int to;

    public Request(String n, int from, int to) {
        this.name = n;
        this.to = to;
        this.from = from;
    }
}

class EmployeeMovingPlan {

    boolean findMovingPlanWrapper(Set<Set<String>> plan, Map<Integer, Map<Integer, List<String>>> g, Set<String> p, int src, int dst, String name) {

        if (src == dst) {
            p.add(name);
            plan.add(new HashSet<>(p));
            return true;
        } else {
            Map<Integer, List<String>> neighbors = g.getOrDefault(src, new HashMap<>());
            for (int i : neighbors.keySet()) {
                List<String> l = neighbors.get(i);
                if (l.size() == 0) continue;
                String n = l.get(l.size() - 1);
                l.remove(l.size() - 1);
                p.add(n);
                if(!findMovingPlanWrapper(plan, g, /*v,*/ p, i, dst, name)) {
                    p.remove(n);
                    l.add(n);
                }else{
                    break;
                }
            }
            return false;
        }
    }


    List<List<String>> findMovingPlans(List<Request> requests) {
        Set<Set<String>> finalPlan = new HashSet<>();
        Map<Integer, Map<Integer, List<String>>> graph = new HashMap<>();
        for (Request r : requests) {
            if (!graph.containsKey(r.to)) {
                Map<Integer, List<String>> neighbors = graph.getOrDefault(r.from, new HashMap<>());
                List<String> l = neighbors.getOrDefault(r.to, new ArrayList<>());
                l.add(r.name);
                neighbors.put(r.to, l);
                graph.put(r.from, neighbors);
            } else {
                Set<String> names = new HashSet<>();
                findMovingPlanWrapper(finalPlan, graph, names, r.to, r.from, r.name);
            }
        }
        List<List<String>> l = new ArrayList<>();
        for (Set<String> s : finalPlan) {
            l.add(new ArrayList<>(s));
        }
        return l;
    }

    public static void main(String[] args) {
        List<Request> l = new ArrayList() {{
            add(new Request("Alex", 1, 2));
            add(new Request("Ben", 2, 1));
            add(new Request("Chris", 1, 2));
            add(new Request("David", 2, 3));
            add(new Request("Ellen", 3, 1));
            add(new Request("Frank", 4, 5));
        }};
        System.out.println(new EmployeeMovingPlan().findMovingPlans(l));
    }

}


class Cake_Cut{
	
	public static void main(String[] args) {
		int h = 2, w = 2, horizontalCuts[] = {1000000000}, verticalCuts[] = {1000000000};
		int maxArea=maxArea(h, w, horizontalCuts, verticalCuts);
		System.out.println("maxArea::"+maxArea);
	}
	
	   public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		   System.out.println((int)1L%1000000008);
		   Arrays.sort(horizontalCuts);
		   Arrays.sort(verticalCuts);		   
		   int h_lar=0;
		   int v_lar=0;
			for (int i = 0; i < horizontalCuts.length-1; i++) {
				 int k=horizontalCuts[i+1]-horizontalCuts[i];
					if (k> h_lar)
						h_lar =k;
				}
			int init=horizontalCuts[0];
			int last=h-horizontalCuts[horizontalCuts.length-1];
			h_lar=init>last && init>h_lar?init:last>h_lar?last:h_lar;
			
			for (int i = 0; i < verticalCuts.length-1; i++) {
				 int k=verticalCuts[i+1]-verticalCuts[i];
					if (k> v_lar)
						v_lar =k;
				}
			int left_end=verticalCuts[0];
			int right_end=w-verticalCuts[verticalCuts.length-1];
			v_lar=left_end>right_end && left_end>v_lar?left_end:right_end>v_lar?right_end:v_lar;
					  		   
		
		return (int) ((1L*h_lar*v_lar)% 1000000007);
	        
	    }
}


class Longest_path_from_root{
	public static void main(String[] args) {
		   TreeNode root = new TreeNode(4);         /*        4        */
	        root.leftChild = new TreeNode(2);         /*       / \       */
	        root.rightChild = new TreeNode(5);        /*      2   5      */
	        root.leftChild.leftChild = new TreeNode(7);    /*     / \ / \     */
	        root.leftChild.rightChild = new TreeNode(1);   /*    7  1 2  3    */
	        root.rightChild.leftChild = new TreeNode(2);   /*      /          */
	        root.rightChild.rightChild = new TreeNode(3);  /*     6           */
	        root.leftChild.rightChild.leftChild = new TreeNode(6);
	        sumOfLongRootToLeafPathUtil(root);
	        System.out.println( "Sum = " +maxSum);
	}

	static int maxSum;
	static int maxLen;
	private static void sumOfLongRootToLeafPathUtil(TreeNode root) {
		 sumOfLongRootToLeaf(root,0,0);
	}
	private static void sumOfLongRootToLeaf(TreeNode root, int sum, int len) {
		if (root == null) {
			if (maxLen < len) {
				maxLen = len;
				maxSum = sum;
			} else if (maxLen == len && maxSum < sum)
				maxSum = sum;
			return;
		}
		sumOfLongRootToLeaf(root.leftChild,sum+root.data,len+1);
		sumOfLongRootToLeaf(root.rightChild,sum+root.data,len+1);
	}
	
}
/**
 * Input
3 16
2 8
4 5
5 1
Output
2
Expected Correct Output
2
 * @author 
 *
 */
class Task_Completion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String[] line = br.readLine().split(" ");
         int n = Integer.parseInt(line[0]);
         int t = Integer.parseInt(line[1]);  
         int[][] task = new int[n][2];
         for(int i_task = 0; i_task < n; i_task++)
         {
            String[] arr_task = br.readLine().split(" ");
            for(int j_task = 0; j_task < arr_task.length; j_task++)
            {
                task[i_task][j_task] = Integer.parseInt(arr_task[j_task]);
            }
         }

         int out_ = solve(n, t, task);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int solve(int n, int t, int[][] task){
       
       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
       Arrays.sort(task,Comparator.comparingInt(k->k[0]));

      int pqsum=0;
      int max=0;
      for(int i=0;i<n;i++){
          int tt=t;
          int dist=2*task[i][0];
          int rem=tt-dist;
          int c_eff=task[i][1];
          if(rem<0)
          break;
          while(pqsum>rem){
              pqsum-=pq.poll();
          }
          if(pq.isEmpty() && rem>c_eff){
              pq.add(c_eff);
              pqsum+=c_eff;
          }
          else if(pqsum+c_eff<=rem){
              pq.add(c_eff);
              pqsum+=c_eff;
          }
          else{
              Integer c_max=pq.peek();
              if(c_max!=null && c_max>c_eff){
                  pq.poll();
                  pq.add(c_eff);
                  pqsum=pqsum-c_max+c_eff;
              }
          }
          max=Math.max(max,pq.size());
      } 
    return max;
    }
}

/**
 * Coloring of graph 1
Vertex 0 --->  Color 0
Vertex 1 --->  Color 1
Vertex 2 --->  Color 2
Vertex 3 --->  Color 0
Vertex 4 --->  Color 1
 * @author 
 *
 */
class Graph3{
	
	LinkedList<Integer> [] adj;
	int v;
	Graph3(int V){
		v=V;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<Integer>();
	}
	
	void addEdge(int u,int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	private void greedyColoring() {
		String result[] = new String[v];
		List<String> color=new ArrayList<>(Arrays.asList("Green", "Blue", "Black"));
        Arrays.fill(result, "");
         result[0]  = color.get(0);
         for(int i=1;i<v;i++) {
        	 LinkedList<Integer> l=adj[i];
        	 LinkedList<String> adjColor=new LinkedList();
        	 for(int j:l)
        		 adjColor.add(result[j]);
        	  for(String k:color) {
        			if(!adjColor.contains(k)) {
        				result[i]=k;
        				break;
        			}
        	  }
        		  
         }
         for (int u = 0; u < v; u++)
             System.out.println("Vertex " + u + " --->  Color "
                                 + result[u]);
		
	}
	public static void main(String[] args) {
	    Graph3 g1 = new Graph3(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();
	}
}

class BinarySearch {
    static int findMinimum(Integer[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (arr[low] > arr[high]) {
            int mid = (low + high) /2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // must be in sorted order, allowing rotation, and contain no duplicates

        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr));
            int minIndex = findMinimum(arr);
            System.out.println(" Min is " + arr[minIndex] + " at " + minIndex);
            Collections.rotate(Arrays.asList(arr), 1);
        }
    }
}

/**
 * Merge two sorted linked lists
 * @author 
 *
 */
class MergeLists{
	public static void main(String[] args) {
		Node2 list1=new Node2(5);
		list1.next=new Node2(10);
		list1.next.next=new Node2(15);
		
		Node2 list2=new Node2(2);
		list2.next=new Node2(13);
		list2.next.next=new Node2(20);
		Node2 list3=sortedMerge(list1,list2);
		printList(list3);
	}
	static void printList(Node2 head)
	{
		Node2 temp = head;
	    while (temp != null)
	    {
	        System.out.print(temp.data + " ");
	        temp = temp.next;
	    }
	    System.out.println();
	}
	private static Node2 sortedMerge(Node2 list1, Node2 list2) {
	
		Node2 list3=new Node2(0);
		Node2 dummy=list3;
		while(true) {
			
			if(list1==null) {
				list3.next=list2;
				break;
			}
			if(list2==null) {
				list3.next=list1;
				break;
			}
			
			if(list1.data<list2.data) {
				list3.next=list1;
				list1=list1.next;
			}
			else {
				list3.next=list2;
				list2=list2.next;
			}
			
			list3=list3.next;
		}
		return dummy.next;
	}
}



class Non_Repeated_Longest_String {

	static final int NO_OF_CHARS = 256;

	static int longestUniqueSubsttr(String str)
	{
		int n = str.length();

		int res = 0; // result

		// last index of all characters is initialized
		// as -1
		int [] lastIndex = new int[NO_OF_CHARS];
		Arrays.fill(lastIndex, -1);

		// Initialize start of current window
		int i = 0;

		// Move end of current window
		for (int j = 0; j < n; j++) {

			// Find the last index of str[j]
			// Update i (starting index of current window)
			// as maximum of current value of i and last
			// index plus 1
			i = Math.max(i, lastIndex[str.charAt(j)] + 1);

			// Update result if we get a larger window
			res = Math.max(res, j - i + 1);

			// Update last index of j.
			lastIndex[str.charAt(j)] = j;
		}
		return res;
	}

	/* Driver program to test above function */
	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubsttr(str);
		System.out.println("The length of "
						+ "the longest non repeating character is " + len);
	}
}


class Second_Larger_Ele_BST{
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(30);
		insert(root,15);
		insert(root,50);
		insert(root,10);
		insert(root,20);;
		insert(root,40);
		insert(root,60);
		
		insert(root,16);
		insert(root,19);
		insert(root,13);
		insert(root,8);
		insert(root,22);
		
		findSecondLargest(root);
	}
	static int count=0;
	private static void findSecondLargest(TreeNode root) {
		if(root==null ||count>=2)
			return;
		findSecondLargest(root.rightChild);
		count++;
		if(count==2)
			System.out.println(root.data);
		findSecondLargest(root.leftChild);
		
	}

	static void insert(TreeNode root,int key) {
		
		TreeNode t=root;
		TreeNode r=root;
		
		while(t!=null) {
			if(key>t.data) {
				r=t;
				t=t.rightChild;
			}else if(key<t.data) {
				r=t;
				t=t.leftChild;				
			}
		}
		TreeNode node=new TreeNode(key);
		
		if(key<r.data)
			r.leftChild=node;
		else
			r.rightChild=node;
	}
}
/**
 * Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20
 * @author 
 *
 */
class Maximum_Sum_Subsequence_Non_Adjacent{
	
	public static void main(String[] args) {
		
		int[] arr= {4,1,1,4,2,1};
		maxSum(arr);
	}

	private static void maxSum(int[] arr) {
		int excl=0;
		int incl=arr[0];
		for(int i=1;i<arr.length;i++) {
			int temp=incl;
			incl=Math.max(incl, excl+arr[i]);
			excl=temp;
					
		}
		System.out.println(incl);
	}
	
}

/**
 * Input : str1[] = "geeks", 
        str2 = "dgeek"
Output : Shift = 1, 
         Prefix = geek

Input : str1[] = "practicegeeks",
        str2 = "coderpractice"
Output : Shift = 5
         Prefix = practice
 * @author 
 *
 */
class longest_common_prefix{
	
	public static void main(String[] args) {
		 String str1 = "practicegeeks";
	        String str2 = "coderpractice";
	        int n = str1.length();
	        str2 = str2 + str2;
	        findCommonPrefix(str1,str2);
	}

	private static void findCommonPrefix(String str1, String str2) {
		
		for(int i=str1.length();i>=0;i--) {
			String s=str1.substring(0,i);
			if(str2.indexOf(s)!=-1) {
				System.out.println("String is" +s+" and the rotation is "+str2.indexOf(s));
				break;
			}
		}
		
	}
}

class  TestClass3 {

	static long[] result = new long[1000005];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter wr = new PrintWriter(System.out);

		pre();

		int T = Integer.parseInt(br.readLine().trim());

		for (int t_i = 0; t_i < T; t_i++)

		{

			String[] str = br.readLine().split(" ");

			int l = Integer.parseInt(str[0]);

			int r = Integer.parseInt(str[1]);

			long out_ = solve(l, r);

			wr.write(out_ + "\n");

		}

		wr.close();

		br.close();

	}

	static void pre() {

		for (int i = 1; i <= 1000000; i++) {

			Set<Long> set = new HashSet<>();

			if (isBeautiful(i, set)) {

				result[i] = i;

			}

		}

		for (int i = 1; i <= 1000000; i++) {

			result[i] += result[i - 1];

		}

	}

	static boolean isBeautiful(long n, Set<Long> set) {

		while (true) {

			if (n == 1) {

				return true;

			} else if (set.contains(n)) {

				return false;

			}

			set.add(n);

			long num = 0;

			while (n > 0) {

				num += (n % 10) * (n % 10);

				n = n / 10;

			}

			n = num;

		}

	}

	static long solve(int l, int r) {

// Your code goes here

		return result[r] - result[l - 1];

	}
}


 class TestClass5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);

            long out_ = solve(l, r);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static long solve(int l, int r){
        long res=0;
        Set<Integer> seen=new HashSet();
      for(int i=l;l<=r;i++){
        if(isHappy(i,seen)){
         res=res+i;
        }
         System.out.println("Solve");
      }
       return res;
    
    }

    public static boolean isHappy(int n,Set<Integer> seen){
        
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
           n =getNext(n);
        }
        return n==1;
    }

    private static int getNext(int n){
        int totalSum=0;
        while(n>0){
            int d=n%10;
            n=n/10;
            totalSum=totalSum+d*d;
        }
        return totalSum;
    }
}


