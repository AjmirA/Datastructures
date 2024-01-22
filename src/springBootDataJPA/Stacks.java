package springBootDataJPA;

import java.util.Stack;

public class Stacks {
	public static void main(String[] args) {

	}
}



/**
 * Find the nearest smaller numbers on left side in an array
 * @author 
 *
 */
class Find_Nearest_Smallest{
	public static void main(String[] args) {
		int[] arr=new int[]{1,6,4,10,2,5};
		int [] smallestArray=find_Nearest_Smallest_optimal(arr);
		for(int j:smallestArray)
			System.out.print(j+",");
	}
//naive approach
	private static int[] find_Nearest_Smallest(int[] arr) {
		int[] smallest=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int smallestValue=Integer.MIN_VALUE;
			for(int j=i-1;j>=0;j--) {
				if(j>=0 && arr[j]<arr[i]) {
					smallestValue=arr[j];
					break;
				}
			}
			smallest[i]=smallestValue;
		}
		return smallest;
	}
	
//optimal approach	
	private static int[] find_Nearest_Smallest_optimal(int[] arr) {
		int[] smallest=new int[arr.length];
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!s.isEmpty() && s.peek()>arr[i])
				s.pop();
				
			if(s.isEmpty()) smallest[i]=-1;
			else smallest[i]=s.peek();
			s.push(arr[i]);
		}
		return smallest;
	}
}

/**
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 */
class DecodeString {
	public static String decodeString(String s) {
		Stack<Integer> intStack = new Stack<>();
		Stack<StringBuilder> strStack = new Stack<>();
		StringBuilder cur = new StringBuilder();
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if ( ch == '[') {
				intStack.push(k);
				strStack.push(cur);
				cur = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder tmp = cur;
				cur = strStack.pop();
				for (k = intStack.pop(); k > 0; --k)
					cur.append(tmp);
			} else cur.append(ch);
		}
		return cur.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("3[a2[c]]"));
	}
}

/**
 * Given a circular integer array nums (i.e., the next element of
 * nums[nums.length - 1] is nums[0]), return the next greater number for every
 * element in nums.
 * 
 * The next greater number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, return -1 for this
 * number.
 * 
 * Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
 * @author 
 *
 */
class NextGreaterElements_II {
    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int num2[]=new int[nums.length*2];
        int nge[]=new int[nums.length];
        
        for(int i=0;i<=2*n-1;i++){
            num2[i]=nums[i%n];
        }
        
        Stack<Integer> st=new Stack();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <=num2[i]) st.pop();
            if(i<n){
                
                if(!st.isEmpty())
                    nge[i]=st.peek();
                else
                    nge[i]=-1;
                
            }
            st.push(num2[i]);
        }
        return nge;
        
    }
    
    public static void main(String[] args) {
    	int[] arr=new int[]{1,2,1};
		int [] smallestArray=nextGreaterElements(arr);
		for(int j:smallestArray)
			System.out.print(j+",");
	}
}

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in
 * the histogram.
 * 
 * 
 * Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

 * @author 
 *
 */
class Histogram {
	public static void main(String[] args) {
		int[] arr=new int[]{2,1,5,6,2,3,1};
		System.out.println("largestRectangleArea="+largestRectangleArea(arr));
	}
    public static int largestRectangleArea(int[] heights) {
    	int[] leftSmallest=findLeftSmallestBoundary(heights);
    	int[] rightSmallest=findRightSmallestBoundary(heights);
    	int res=0;
    	for(int i=0;i<heights.length;i++) {
    	  int area=(Math.abs(leftSmallest[i]-rightSmallest[i])+1)*heights[i];
    	  res=Math.max(area, res);
    	}
		return res;
        
    }


	private static int[] findLeftSmallestBoundary(int[] heights) {
		int[] lse=new int[heights.length];
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<heights.length;i++) {
			while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
			if(st.isEmpty()) lse[i]=0;
			else lse[i]=st.peek()+1;//since its boundary, we are adding 1
			st.push(i);
		}
		return lse;
	}
	
	private static int[] findRightSmallestBoundary(int[] heights) {
		int[] rse=new int[heights.length];
		Stack<Integer> st=new Stack<Integer>();
		for(int i=heights.length-1;i>=0;i--) {
			while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
			if(st.isEmpty()) rse[i]=heights.length-1;
			else rse[i]=st.peek()-1;//since its boundary, we are subtracting 1
			st.push(i);
		}
		return rse;
	}

}

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 * 
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
 * 
 * @author 
 *
 */
//SAME LIKE HISTOGRAM PROBLEM WITH EXTRA ONE STEP. Creating histogram for each row. so there are 4 call as there are 4 rows
class MaximalRectangle {

	 public int maximalRectangle(char[][] matrix) {
	        if(matrix.length == 0)  return 0;
	        int maxArea = 0;
	        int row = matrix.length;
	        int col = matrix[0].length;
	        int[] dp = new int[col];
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
	            }
	            //treating dp[j] as histogram, solving max area problem there and updating the max area
	            maxArea = Math.max(maxArea, largestRectangleArea(dp));
	        }
	        return maxArea;
	    }

    public static int largestRectangleArea(int[] heights) {
    	int[] leftSmallest=findLeftSmallest(heights);
    	int[] rightSmallest=findRightSmallest(heights);
    	int res=0;
    	for(int i=0;i<heights.length;i++) {
    	  int area=(Math.abs(leftSmallest[i]-rightSmallest[i])+1)*heights[i];
    	  res=Math.max(area, res);
    	}
		return res;
        
    }


	private static int[] findLeftSmallest(int[] heights) {
		int[] lse=new int[heights.length];
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<heights.length;i++) {
			while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
			if(st.isEmpty()) lse[i]=0;
			else lse[i]=st.peek()+1;
			st.push(i);
		}
		return lse;
	}
	
	private static int[] findRightSmallest(int[] heights) {
		int[] rse=new int[heights.length];
		Stack<Integer> st=new Stack<Integer>();
		for(int i=heights.length-1;i>=0;i--) {
			while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
			if(st.isEmpty()) rse[i]=heights.length-1;
			else rse[i]=st.peek()-1;
			st.push(i);
		}
		return rse;
	}

}


/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 * 
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * @author 
 *
 */
class Daily_Temperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> st=new Stack();
        
        int[] res=new int[temperatures.length];
        
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int id=st.pop();
                res[id]=i-id;
            }
            st.push(i);
        }
       
        return res;
    }
    public static void main(String[] args) {
		int[]  temperatures = {73,74,75,71,69,72,76,73};
		System.out.println(dailyTemperatures(temperatures));
	}
}

