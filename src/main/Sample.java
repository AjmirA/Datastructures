package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Sample {
 public static void main(String[] args) {
	System.out.println("Sample");
}
}

class Anagrm {

    static Boolean checkInclusion(String s1, String s2) {

        int[] s1hash= new int[26];
        int[] s2hash= new int[26];
        int s1len = s1.length();
        int s2len = s2.length();
        if(s1len>s2len)
            return false;
        
        int left=0,right=0;
        while(right<s1len)
        {
            s1hash[s1.charAt(right) -'a'] +=1;
            s2hash[s2.charAt(right) -'a'] +=1;
            right +=1;
        }
        right =right-1;  
        
        if (isEqual(s1hash, s2hash))
			return true;
        
        while(right<s2len)
		{
			if (isEqual(s1hash, s2hash))
				return true;
			right =right+ 1;
			if (right != s2len)
				s2hash[s2.charAt(right) - 'a'] += 1;
			s2hash[s2.charAt(left) - 'a'] -= 1;
			left =left+ 1;
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
    	System.out.println(checkInclusion("anagram","nagajam"));
	}
}


class LongString{
	
	public static void main(String[] args) {
		
		String str="";
		System.out.println("long_String="+longStr(str));
	}
	
	  
	public static int longStr(String s) { 
		int len=0;
	  int left=0,right=0;
	  Map<Character,Integer> map=new HashMap();
	  while(right<s.length()) {
		  char ch=s.charAt(right);
		   if(map.containsKey(ch)) {
			   left=Math.max (map.get(ch)+1,left);
			   map.remove(ch);
		   }else {
			   int currLen=0;
			   while(right<s.length() && !map.containsKey(s.charAt(right))) {
				  
				   map.put(s.charAt(right),right);
				   currLen=right-left+1;
				   right++;
				   if(currLen>len)
					   len=currLen;
				   }
			   
		   }
	  }
	return len;
	  }
}


class Person_Meeting {
	public static void main(String[] args) {
		 int meetings[][] = { {7,10}, {2,4} };
	       
	        System.out.println(
	            "Meeting = "
	            + meetings(meetings));
	}
	  public static boolean meetings(int[][] meetings) {
	    Arrays.sort(meetings, new Comparator<int[]>() {
	      public int compare(int[] i1, int[] i2) {
	        return i1[0] - i2[0];
	      }
	    });

	    for (int i = 0; i < meetings.length - 1; i++) {
	      if (meetings[i][1] > meetings[i + 1][0])
	        return false;
	    }
	    return true;
	  }
	}



 class Main {
	  public static class MaxStack {

	    public MaxStack() {

	    }

	    public void push(int x) {

	    }

	    public int pop() {
	      return 0;
	    }

	    public int top() {
	      return 0;
	    }

	    public int peekMax() {
	      return 0;
	    }

	    public int popMax() {
	      return 0;
	    }

	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	    MaxStack maxst = new MaxStack();

	    while (read.ready()) {
	      String []inp = read.readLine().split(" ");

	      switch (inp[0]) {
	        case "pop":
	          System.out.println(maxst.pop());
	          break;
	        case "top":
	          System.out.println(maxst.top());
	          break;
	        case "popMax":
	          System.out.println(maxst.popMax());
	          break;
	        case "peekMax":
	          System.out.println(maxst.peekMax());
	          break;
	        case "push":
	          maxst.push(Integer.parseInt(inp[1]));
	          break;
	      }

	    }

	  }
	}

  class StudentSorter implements Comparator<int[]> 
 {
     public int compare(int[]  o1, int[]  o2) 
     {
         return  o1[0] - o2[0];
     }


 }
  
  class MarksSorted implements Comparator<int[]> 
 {
	 public int compare(int[]  o1, int[]  o2) 
     {
		  return  o2[1] - o1[1];
     }

 }

	class TopMarks_Avg {

		static List<int[]> getStudentsList(int[][] marks) {
			Arrays.sort(marks, new StudentSorter().thenComparing(new MarksSorted()));
			ArrayList<String> names = new ArrayList<>();
			int sum = 0;

			List<int[]> avg = new ArrayList();
			for (int i = 0; i < marks.length; i++) {
				int studId = marks[i][0];

				int count = 1;
				int j;
				sum = 0;
				for (j = i; j < marks.length && studId == marks[j][0] && count <= 5; j++) {
					sum = sum + marks[j][1];
					count++;
				}
				i = j;
				int[] res = new int[2];
				res[0] = studId;
				res[1] = sum / (count - 1);
				avg.add(res);
			}

			return avg;

		}

//Print function to print the result
		private static void print(List<int[]> resList) {
			for (int i = 0; i < resList.size(); i++) {
				int[] n = resList.get(i);
				System.out.println("\n");
				for (int k : n)
					System.out.print(k + " ");
			}

		}
		
		public static void main(String args[]) {
			int[][] marks = { { 1, 100 }, { 7, 100 }, { 1, 100 }, { 7, 100 }, { 1, 100 }, { 7, 100 }, { 1, 100 },
					{ 7, 100 }, { 1, 100 }, { 7, 100 } };
			List<int[]> resList = getStudentsList(marks);
			print(resList);
		}

	}

	
	
	

	class MaxStack {
	    Stack<Integer> stack;
	    Stack<Integer> maxStack;

	    public MaxStack() {
	        stack = new Stack();
	        maxStack = new Stack();
	    }

	    public void push(int x) {
	        int max = maxStack.isEmpty() ? x : maxStack.peek();
	        maxStack.push(max > x ? max : x);
	        stack.push(x);
	    }

	    public int pop() {
	        maxStack.pop();
	        return stack.pop();
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int peekMax() {
	        return maxStack.peek();
	    }

	    public int popMax() {
	        int max = peekMax();
	        Stack<Integer> buffer = new Stack();
	        while (top() != max) buffer.push(pop());
	        pop();
	        while (!buffer.isEmpty()) push(buffer.pop());
	        return max;
	    }
	}
	

	

