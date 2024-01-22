package springBootDataJPA;

import java.util.*;

public class Array {
	public static void main(String[] args) {

	}
}
/**
 * Input : n =10 Output : 2 3 5 7 Input : n = 20 Output: 2 3 5 7 11 13 17 19
 * 
 * @author 
 *
 */
class PrimeNumbers {
	static int sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n+1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		int count=0;
		for(int i=2;i<=n;i++){
			if(prime[i]==true){
				count++;
				for(int j=2;i*j<=n;j++){
					prime[i*j]=false;
				}
			}
		}
		// Print all prime numbers
		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				System.out.print(i + " ");
		}
		return count;
	}
	public static void main(String args[]) {
		int n = 30;
		System.out.println("Following are the prime numbers which are smaller than or equal to " + n+"="+sieveOfEratosthenes(n));
	}
}

/**
 * rearrange an array in the pattern of low, next high, next low, next high without sorting the array,
 * Original array: [9, 2, 1, 5, 7, 3]
 * Rearranged array: [2, 9, 1, 7, 3, 5]
 */
class RearrangeArray {

	public static void rearrangeArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			if (i % 2 == 0 && arr[i] > arr[i + 1]) {
				// Swap elements at even indices if they are greater than the next element
				swap(arr, i, i + 1);
			} else if (i % 2 != 0 && arr[i] < arr[i + 1]) {
				// Swap elements at odd indices if they are less than the next element
				swap(arr, i, i + 1);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {9, 2, 1, 5, 7, 3};
		System.out.println("Original array: " + Arrays.toString(arr));
		rearrangeArray(arr);
		System.out.println("Rearranged array: " + Arrays.toString(arr));
	}
}

//Java program for checking
//balanced brackets

class BalancedBrackets {

	// function to check if brackets are balanced
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	// Driver code
	public static void main(String[] args) {
		String expr = "([{}])";

		// Function call
		if (isValid(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}
}

/**
 * Remove minimum number of characters so that two strings become anagram Input
 * : str1 = "bcadeh" str2 = "hea" Output: 3 We need to remove b, c and d from
 * str1.
 * 
 * @author 
 *
 */
class GFG {
	final static int CHARS = 26;
	static int countDeletions(String str1, String str2) {
		int arr[] = new int[CHARS];
		for (int i = 0; i < str1.length(); i++) {
			arr[str1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < str2.length(); i++) {
			arr[str2.charAt(i) - 'a']--;
		}

		int ans = 0;
		for (int i = 0; i < CHARS; i++) {
			ans += Math.abs(arr[i]);
		}
		return ans;
	}

	static public void main(String[] args) {
		String str1 = "bcadeh", str2 = "hea";
		System.out.println(countDeletions(str1, str2));
	}
}

/**
 * First Missing Positive number in the array Given an unsorted integer array
 * nums, return the smallest missing positive integer.
 * 
 * You must implement an algorithm that runs in O(n) time and uses constant
 * extra space.
 * 
 * Input: nums = [3,4,-1,1] Output: 2
 * 
 * @author 
 *
 */
class MissingNumber {
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);
			else
				i++;
		}

		for (int j=0; j < nums.length; j++) {
			if (nums[j] != j + 1)
				return j + 1;
		}
		return nums.length + 1;
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

/**
 * https://leetcode.com/problems/couples-holding-hands/description/
 */

class SortArray_Couples {
	Map<Integer, Integer> map = new HashMap();

	public int minSwapsCouples(int[] row) {
		for (int i : row)
			map.put(row[0], i);

		int swap = 0;

		for (int i = 0; i < row.length; i = i + 2) {
			int first = row[i];
			int second = first + (first % 2 == 0 ? 1 : -1);
			if (row[i + 1] != second) {
				swap(row, i + 1, map.get(second));
				swap++;
			}
		}
		return swap;
	}

	void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		map.put(A[i], i);
		map.put(A[j], j);

	}

}

class Spiral_Matrix {
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> res = new ArrayList<Integer>();

		if (matrix.length == 0) {
			return res;
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
	}
}

/**
 * https://leetcode.com/problems/task-scheduler/
 */
class Task_Least_Interval {
	public int leastInterval(char[] tasks, int n) {

		int[] freq=new int[26];

		int idle=0;

		for(char ch:tasks){
			freq[ch-'A']++;
		}
		// idle=idle-1;
		Arrays.sort(freq);
		idle=freq[25]-1;

		int totalIdle=idle*n;
		for(int i=24;i>=0;i--){
			totalIdle-=Math.min(freq[i],idle);
		}

		return totalIdle<0?tasks.length:tasks.length+totalIdle;

	}
}
/**
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 * @author Moore's Voting Algorithm
 *
 */
class MajorityElement {
	public static void main(String[] args) {
		int[] nums = { 5, 1, 5, 2, 5, 5, 4 };
		System.out.println("majorityElement::" + majorityElement(nums));
	}

	public static int majorityElement(int[] num) {
		int major = 0, count = 0;
		for (int i = 0; i < num.length; i++) {
			if (count == 0) {
				count++;
				major = num[i];
			} else if (major == num[i])
				count++;
			else
				count--;
		}
		return major;
	}
}

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * @author 
 *
 */
class MajorityElementII {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 3, 3, 2, 2, 2 };
		System.out.println("majorityElement::" + majorityElement(nums));
	}

	public static List majorityElement(int[] num) {
		// At max there will be 2 elements. so we are using two variables(maj1,maj2) ,
		// c1 and c2 respectively
		int c1 = 0, c2 = 0;
		int maj1 = 0, maj2 = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == maj1)
				c1++;
			else if (num[i] == maj2)
				c2++;
			else if (c1 == 0) {
				maj1 = num[i];
				c1++;
			} else if (c2 == 0) {
				maj2 = num[i];
				c2++;
			} else {
				c1--;
				c2--;
			}
		}
		List ans = new ArrayList<>();
		int count1 = 0, count2 = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == maj1)
				count1++;
			if (num[i] == maj2)
				count2++;
		}
		if (count1 > num.length / 3)
			ans.add(maj1);
		if (count2 > num.length / 3)
			ans.add(maj2);

		return ans;
	}
}

class Pascals_Triangle {
	public static void main(String[] args) {
		System.out.println("generate::" + generate(5));
		System.out.println("getRow::" + getRow(3));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row = null, prev = null;
		for (int i = 0; i < numRows; i++) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(prev.get(j - 1) + prev.get(j));
			}
			prev = row;
			res.add(row);
		}

		return res;
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++)
			res.add(1);// initializing res with four times 1 as row is 3 [1,1,1,1]
		for (int i = 1; i < rowIndex; i++)
			for (int j = i; j > 0; j--)
				res.set(j, res.get(j) + res.get(j - 1));
		return res;
	}
}

/**
 * Reverse an Array in groups of given size
 * Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9], K = 3
 * Output: 3, 2, 1, 6, 5, 4, 9, 8, 7
 */
class Reverse_Array {

	// Function to reverse every sub-array formed by
	// consecutive k elements
	static void reverse(int arr[], int n, int k)
	{
		for (int i = 0; i < n; i =i+ k)
		{
			int left = i;
			// to handle case when k is not multiple
			// of n
			int right = Math.min(i + k - 1, n - 1);
			int temp;
			// reverse the sub-array [left, right]
			while (left < right)
			{
				temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
	}
	// Driver method
	public static void main(String[] args)
	{

		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int k = 3;
		int n = arr.length;
		reverse(arr, n, k);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}


/**
 * Rotate the array by K
 * 
 * @author 
 *
 */

class ArrayRotation {
		public static void rotateArrayByTwo(int[] nums,int k) {
			reverse(nums, 0, nums.length - 1);
			reverse(nums, 0, k - 1);
			reverse(nums, k, nums.length - 1);
		}

		public static void reverse(int[] arr, int start, int end) {
			while (start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}

		public static void main(String[] args) {
			int[] nums = {1, 2, 3, 4, 5};
			int k=9;
			k %= nums.length;
			rotateArrayByTwo(nums,k);
			System.out.println("Array after rotating by 2 positions to the left:"+Arrays.toString(nums));
		}
	}

/**
 * An efficient Java program to remove all spaces from a string
 */
class RemoveSpaces {

	static int removeSpaces(char[] str) {
		int count = 0;

		for (int i = 0; i < str.length; i++)
			if (str[i] != ' ')
				str[count++] = str[i]; // here count is
										// incremented

		return count;
	}

//Driver code
	public static void main(String[] args) {
		char str[] = "g eeks for ge eeks ".toCharArray();
		int i = removeSpaces(str);
		System.out.println(String.valueOf(str).subSequence(0, i));
	}
}

class Math_Expression {
	public static int postfixEval(String str) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if (x >= '0' && x <= '9') {
				st.push(Character.getNumericValue(str.charAt(i)));
			} else {
				int op1 = st.pop();
				int op2 = st.pop();
				switch (x) {
				case '+':
					st.push(op2 + op1);
					break;
				case '-':
					st.push(op2 - op1);
					break;
				case '*':
					st.push(op2 * op1);
					break;
				case '/':
					st.push(op2 / op1);
					break;
				}
			}
		}
		return st.pop();
	}

	public static void main(String[] args) {
		String exp = "3*2+5";
		Stack operator = new Stack();
		Stack numbers = new Stack();
		for (int i = 1; i < exp.length() - 1; i++) {
			char ch = exp.charAt(i);
			if (isOperator(ch)) {
				if (precedence(ch) > precedence((char) operator.peek())) {
					numbers.push(exp.charAt(i - 1));
					numbers.push(exp.charAt(i + 1));
					operator.push(ch);
				} else {

				}
			}
		}

	}

	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
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

/**
 * Find the element that appears once in an array where every other element
 * appears twice
 * 
 * @author 
 *
 */
class Non_Duplicate {
	// Return the maximum Sum of difference
	// between consecutive elements.
	static int findSingle(int ar[], int ar_size) {
		/*
		 * res = 7 ^ 3 ^ 5 ^ 4 ^ 5 ^ 3 ^ 4
		 * 
		 * Since XOR is associative and commutative, above expression can be written as:
		 * res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5) = 7 ^ 0 ^ 0 ^ 0 = 7 ^ 0 = 7 n
		 */
		int res = ar[0];
		for (int i = 1; i < ar_size; i++)
			res = res ^ ar[i];

		return res;
	}

	// Driver code
	public static void main(String[] args) {
		int ar[] = { 2, 3, 5, 4, 5, 3, 4 };
		int n = ar.length;
		System.out.println("Element occurring once is " + findSingle(ar, n) + " ");
	}
}
/**/
class SetZeroesMatrix {
	public static void main(String[] args) {

	}
	static void setZeroes(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;
		int[] dummy1=new int[rows];
		int[] dummy2=new int[cols];
		Arrays.fill(dummy1,-1);
		Arrays.fill(dummy2,-1);
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(matrix[i][j]==0){
					dummy1[i]=0;
					dummy2[j]=0;
				}
			}
		}

		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(dummy1[i]==0 || dummy2[j]==0)
					matrix[i][j]=0;
				}
			}
		}
	}


/**
 * Sort an array of 0’s 1’s 2’s without using extra space or sorting algo (Dutch
 * National Algo)
 * 
 * @author 
 *
 */
class Sort_0_1_2 {

	public static void main(String[] args) {
		int arr[] = { 2, 0, 1 };
		sortNumbers(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}

	private static void sortNumbers(int[] arr) {
		int low = 0, high = arr.length - 1;
		int mid = 0;
		int temp;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0: {
				temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;
				mid++;
				break;
			}

			case 1:
				mid++;
				break;

			case 2: {
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
				mid++;
				break;
			 }
			}
		}
	}
}

class Sort_1_9 {
	// function for sort array
	static void sortit(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;

	}

	public static void main(String args[]) {
		int[] arr = { 10, 7, 9, 2, 8, 3, 5, 4, 6, 1 };
		int n = arr.length;
		sortit(arr, n);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}


class Merge_Sorted_Array {

	public static void main(String[] args) {
		int arr1[] = new int[] { 1, 2, 3, 0, 0, 0 };
		int arr2[] = new int[] { 2, 5, 6 };
		merge(arr1, arr2);
		System.out.print("After Merging \nFirst Array: ");
		for (int i : arr1)
			System.out.print(i + " ");
		for (int i : arr2)
			System.out.print(i + " ");
	}

	public static void merge(int[] nums1, int[] nums2) {
		int m = 3;
		int n =3;
		int p1 = m - 1, p2 = n - 1, i = m + n - 1;
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[i--] = nums1[p1--];
			} else {
				nums1[i--] = nums2[p2--];
			}
			System.out.println(Arrays.toString(nums1));
		}
	}
}

/**
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}.
 * The intervals {1,3} and {2,4} overlap with each other, so they should be
 * merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and
 * become {5, 8}
 * 
 * @author 
 *
 */
class Merge_Intervals {
	public static void main(String[] args) {

		int arr[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 9, 11 }, { 15, 18 }, { 2, 4 }, { 16, 17 } };
		List<int[]> list = merge(arr);
		for (int[] i : list)
			System.out.println(i[0] + " " + i[1]);
	}

	public static List<int[]> merge(int[][] intervals) {
		List<int[]> res = new ArrayList<int[]>();

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int[] i : intervals) {
			if (i[0] < end)
				end = Math.max(end, i[1]);
			else {
				res.add(new int[] { start, end });
				start = i[0];
				end = i[1];
			}
		}
		res.add(new int[] { start, end });
		return res;
	}
}

/**
 * https://leetcode.com/problems/insert-interval/
 */
class Insert_Intervals {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> result=new ArrayList();

		int i=0;
		int n=intervals.length;
		while(i<n && intervals[i][1]<newInterval[0]){
			result.add(intervals[i]);
			i++;
		}

		while(i<n && intervals[i][0]<=newInterval[1]){
			newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
			newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
			i++;
		}
		result.add(newInterval);


		while(i<n){
			result.add(intervals[i]);
			i++;
		}
		return result.toArray(new int[result.size()][]);

	}
}
/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes,
 * where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes
 * that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 *
 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * Output: 8
 * Explanation: There are:
 * - 1 box of the first type that contains 3 units.
 * - 2 boxes of the second type that contain 2 units each.
 * - 3 boxes of the third type that contain 1 unit each.
 * You can take all the boxes of the first and second types, and one box of the third type.
 * The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
 */
class Solution {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes,(a,b)->a[1]-b[1]);
		int totalBoxes=0;
		int units=0;

		for(int[] i:boxTypes){
			 int currentBoxes=0;
			if(truckSize>=i[0]){
				currentBoxes=i[0];
			}else{
				currentBoxes=truckSize;
			}
			units=units+ (currentBoxes*i[1]);
			totalBoxes=totalBoxes + currentBoxes;
			truckSize=truckSize-currentBoxes;
			if(truckSize<=0) break;
		}
		return units;
	}
}

/**
 * Given the arrival and departure times of all trains that reach a railway
 * station, the task is to find the minimum number of platforms required for the
 * railway station so that no train waits. We are given two arrays that
 * represent the arrival and departure times of trains that stop.
 * 
 * Examples:
 * 
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00} dep[] = {9:10, 12:00,
 * 11:20, 11:30, 19:00, 20:00} Output: 3 Explanation: There are at-most three
 * trains at a time (time between 11:00 to 11:20)
 * 
 * @author 
 *
 */
class Train {
	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = 6;
		System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
	}

	private static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int platReqd = 0;
		int i = 0, j = 0;
		int count = 0;

		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			if (count > platReqd)
				platReqd = count;
		}
		return platReqd;
	}
}

/**
 * Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1} Output: 1, 3, 6
 * 
 * @author 
 *
 */
class Find_Duplicates {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 6, 3, 6, 1 };
		findDuplicates1(arr);
	}

	private static void findDuplicates1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int j = Math.abs(arr[i]);
			if (arr[j] >= 0)
				arr[j] = -arr[j];
			else
				System.out.println(j);
		}
	}

	public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
		// Write your code here
		int[] res=new int[2];

		for(int i=0;i<arr.size();i++){
			int j=Math.abs(arr.get(i));
			if(arr.get(j-1)>0)
				arr.set(j-1, -arr.get(j-1));
			else {
				res[1]=j;
			}
		}

		for(int i=0;i<arr.size();i++){
			if(arr.get(i)>0){
				res[0]=i+1;
				break;
			}
		}
		return res;
	}

	// 2nd method
	private static void findDuplicates(int[] arr) {

		int slow = arr[0];
		int fast = arr[0];
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		} while (slow != fast);
		slow = arr[0];
		while (fast != slow) {
			slow = arr[slow];
			fast = arr[fast];
		}
		System.out.println(slow);
	}
}
/**
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
 * @author 
 *
 */

class GasStation {
	public static void main(String[] args) {
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		System.out.println("canCompleteCircuit::"+canCompleteCircuit(gas,cost));
	}
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas=0;
        int sumCost=0;
        int start=0;
        int tank=0;
        
        for(int i=0;i<gas.length;i++){
            sumGas+=gas[i];
            sumCost+=cost[i];
            tank=tank+(gas[i]-cost[i]);
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        
        if(sumGas<sumCost) return -1;
        else return start;
    }
}

/**
 *  Jump Game
 *  You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
 *  array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
class Jump_Game {
	public boolean canJump(int[] nums) {
		int reachable=0;
		int jump=0;
		for(int i=0;i<nums.length;i++){
			if(reachable<i) return false;
			jump=i+nums[i];
			reachable=Math.max(reachable,jump);
		}
		return true;
	}
}

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
 * if you are at nums[i], you can jump to any nums[i + j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
class Jump_Game_II {
	public int jump(int[] nums) {

		if(nums.length==1) return 0;

		int coverageStart=0;
		int coverageEnd=nums[0];
		int jumpCount=0;

		while(coverageEnd<nums.length-1){//last index need not to considered as it takes one jump only from the current position
			                              // ,so it will go out of loop and add 1.
			int nextCoverageEnd=coverageEnd;
			for(int i=coverageStart;i<=coverageEnd;i++){
				nextCoverageEnd=Math.max(nextCoverageEnd,i+nums[i]);
			}
			jumpCount++;
			coverageStart=coverageEnd+1;
			coverageEnd=nextCoverageEnd;
		}
		return jumpCount+1;
	}
}
/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 *
 *Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Quickselect
 */
class KthLargest {

	public static int findKthLargest(int[] nums, int k) {
		// Create a max heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		// Add elements to the max heap
		for (int num : nums) {
			maxHeap.offer(num);
		}

		// Extract K-1 elements from the heap
		for (int i = 0; i < k - 1; i++) {
			maxHeap.poll();
		}

		// The top of the heap now contains the Kth largest element
		return maxHeap.peek();
	}


	public static void main(String[] args) {
		int[] arr = new int[]{7,10,4,3,20,15};
		KthLargest q = new KthLargest();
		System.out.println("2nd largest element is ->" + q.findKthLargest(arr,2));
	}
}
 class KthSmallest {
	 public static int findKthSmallest(int[] nums, int k) {
		 // Create a max heap
		 PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

		 // Add elements to the max heap
		 for (int num : nums) {
			 maxHeap.offer(num);
		 }

		 // Extract K-1 elements from the heap
		 for (int i = 0; i < k - 1; i++) {
			 maxHeap.poll();
		 }

		 // The top of the heap now contains the Kth largest element
		 return maxHeap.peek();
	 }

	public static void main(String[] args) {
		int[] arr = new int[]{7,10,4,3,20,15};
		KthSmallest q = new KthSmallest();
		System.out.println("3rd smallest element is ->" + q.findKthSmallest(arr,3));
	}


}

/**
 * Count pairs with given sum
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
 * Input:
 * N = 4, K = 6
 * arr[] = {1, 5, 7, 1}
 * Output: 2
 * Explanation:
 * arr[0] + arr[1] = 1 + 5 = 6
 * and arr[1] + arr[3] = 5 + 1 = 6.
 */
class FindPairs {
	static int getPairsCount(int[] arr, int n, int target) {
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		int pairCount=0;
		for(int num:arr){
			int requiredValues=target-num;
			if(map.containsKey(requiredValues)){
				pairCount=pairCount+map.get(requiredValues);
			}
			map.put(num,map.getOrDefault(num,0)+1);
		}
		return pairCount;
	}

	public static void main(String[] args) {
		int arr[]=new int[]{1, 5, 5, 5, 5, 7};
		int k=10;
		System.out.println("FindPairs="+getPairsCount(arr,arr.length,k));
	}
}

/**
 * Given an array of integers nums, find the maximum length of a subarray where
 * the product of all its elements is positive.
 * 
 * A subarray of an array is a consecutive sequence of zero or more values taken
 * out of that array.
 * 
 * Return the maximum length of a subarray with positive product.
 * 
 * Input: nums = [1,-2,-3,4] Output: 4 Explanation: The array nums already has a
 * positive product of 24.
 * 
 * @author 
 *
 */
class Maximum_Length_of_Subarray_With_Positive_Product {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 6, 3, 6, 1 };
		getMaxLen(arr);
	}

	public static int getMaxLen(int[] nums) {
		int firstNegative = -1, zeroPosition = -1, cntNegative = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				cntNegative++;
				if (firstNegative == -1) firstNegative = i;
			}
			if (nums[i] == 0) {
				cntNegative = 0;
				firstNegative = -1;
				zeroPosition = i;
			} else {
				if (cntNegative % 2 == 0) max = Math.max(i - zeroPosition, max);
				else max = Math.max(i - firstNegative, max);
			}
		}
		return max;
	}
}

/**
 * https://www.youtube.com/watch?v=hnswaLJvr6g
 * Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.
 * N = 5
 * Arr[] = {6, -3, -10, 0, 2}
 * Output: 180
 * Explanation: Subarray with maximum product
 * is [6, -3, -10] which gives product as 180.
 */
class MaxProduct {
	// Function to find maximum product subarray
	long maxProduct(int[] arr, int n) {
		int prefix=1;
		int suffix=1;
		long ans=Long.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(prefix<=0) prefix=1;
			if(suffix<=0) suffix=1;
			prefix=prefix*arr[i];
			suffix=suffix*arr[n-1-i];
			ans=Math.max(ans,Math.max(prefix,suffix));
		}
		return ans;
	}
}
/**
 * Input: N = 6 arr = {1, 2, 3, 6, 5, 4} Output: {1, 2, 4, 3, 5, 6}
 * Explaination: The next permutation of the given array is {1, 2, 4, 3, 5, 6}.
 * 
 * @author 
 *
 */
class Next_Permutation {
	private static void nextPermutation(int[] nums) {
		int index1 = 0;
		Boolean swapDone = false;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				index1 = i;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[index1] < nums[i]) {
				swap(nums, index1, i);
				swapDone = true;
				break;
			}
		}
		if (nums.length > 2) {
			if (swapDone) reverse(nums, index1 + 1, nums.length - 1);
			else reverse(nums, 0, nums.length - 1);
		}
	}
	private static void reverse(int[] nums, int i, int j) {
		while (i < j)  swap(nums, i++, j--);
	}
	static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	public static void main(String[] args) {
		int nums[] = {1, 3, 2};
		nextPermutation(nums);
		for (int i : nums)
			System.out.print(i + " ");
	}
}

/**
 * Given a positive integer n, find the smallest integer which has exactly the
 * same digits existing in the integer n and is greater in value than n. If no
 * such positive integer exists, return -1.
 * 
 * Note that the returned integer should fit in 32-bit integer, if there is a
 * valid answer but it does not fit in 32-bit integer, return -1.
 * 
 * Input: n = 12
Output: 21

Input: n = 21
Output: -1
 * 
 * @author 
 *
 */
class NextGreaterElement_III {
	public int nextGreaterElement(int n) {
		String temp = Integer.toString(n);
		int[] nArray = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			nArray[i] = temp.charAt(i) - '0';
		}

		int num[] = findNextPermutation(nArray);

		int res = 0;
		for (int i = 0; i < num.length; i++) {
			res = res * 10 + num[i];
		}
		System.out.println("res=" + res);

		if (res > n)
			return res;
		return -1;
	}

	public int[] findNextPermutation(int[] num) {
		int index = 0;
		Boolean swapdone = false;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				index = i;
				break;
			}

		}

		for (int i = num.length - 1; i >= 0; i--) {
			if (num[i] > num[index]) {
				swap(num, i, index);
				swapdone = true;
				break;
			}
		}

		if (num.length > 2) {
			if (swapdone)
				reverse(num, index + 1, num.length - 1);
			else
				reverse(num, 0, num.length - 1);
		}
		return num;
	}

	void reverse(int[] nums, int i, int j) {
		while (i < j)
			swap(nums, i++, j--);

	}

	void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}




class Two_Sum_Problem {
	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 16, -8, 24 };
		int n = 16;
		int[] val = twoSum(A, n);
		for (int i : val)
			System.out.print(i + " ");
	}

	public static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if (map.containsKey(val)) {
				res = new int[] { map.get(val), i };
				break;
			} else
				map.put(nums[i], i);
		}
		return res;

	}
}

/**
 * Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
 * Output: 12, 3, 9
 */
 class Three_Sum { //Recursion

	// The check function recursively checks all possible subsets of the array
	// to see if any of them sum to the target value
	public static boolean check(int n, int[] arr, int target, ArrayList<Integer> triplet, List<ArrayList> resList) {

		// If the target value has been reached and the length of the triplet is 3,
		// then a triplet with a sum of target has been found and is printed
		if (target == 0 && triplet.size() == 3) {
			resList.add(new ArrayList(triplet));
			return true;
		}
		if (n == 0 || target < 0 || triplet.size() == 3)
			return false;

		triplet.add(arr[n-1]);
		boolean a = check(n - 1, arr, target - arr[n - 1], triplet,resList);
		triplet.remove(triplet.size() - 1);
		boolean b = check(n - 1, arr, target, triplet,resList);

		return a | b;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] arr = {1,2,4,3,6};
		int target = 10;
		ArrayList<Integer> triplet = new ArrayList<>();
		List<ArrayList> res= new ArrayList<>();
		if (!check(n, arr, target, triplet,res)) {
			System.out.println("does not exist");
		}else System.out.println("Ans="+res);
	}
}

/**
 * Input: array = {10, 2, 3, 4, 5, 9, 7, 8} X = 23 Output: 3 5 7 8 Sum of output
 * is equal to 23, i.e. 3 + 5 + 7 + 8 = 23.
 * 
 * @author 
 *
 */
class Four_Sum_Problem {
	public static void main(String[] args) {
		int A[] = { 10, 2, 3, 4, 5, 9, 7, 8 };
		int n = 23;
		List val = fourSum(A, n);

		System.out.print(val + " ");
	}

	private static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int target_2 = target - nums[i] - nums[j];
				int front = j + 1;
				int back = nums.length - 1;
				while (front < back) {
					int sum = nums[front] + nums[back];
					if (sum < target_2)
						front++;
					else if (sum > target_2)
						back--;
					else {
						List<Integer> l = new ArrayList();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[front]);
						l.add(nums[back]);
						res.add(l);

						while (front < back && l.get(2) == nums[front])
							front++;
						while (front < back && l.get(3) == nums[back])
							back--;
					}
				}
				while (j + 1 < nums.length && nums[j] == nums[j + 1])
					j++;
			}
			while (i + 1 < nums.length && nums[i] == nums[i + 1])
				i++;
		}
		return res;
	}
}

/**
 * Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest
 * consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author 
 *
 */
class Longest_Consecutive_Subsequence {

	public static void main(String[] args) {
		int[] nums = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
		System.out.println("Res::" + longestConsecutive(nums));
	}
	public static int longestConsecutive(int[] arr) {

		Set s=new HashSet();
		List res=new ArrayList();
		int count=1;
		if(arr.length<=0) return 0;
		for(int i:arr)
			s.add(i);
		for(int i=0;i<arr.length;i++) {
			if(i>0 && s.contains(arr[i]-1))
				continue;
			else {
				if(s.contains(arr[i]+1)) {
					List l=new ArrayList();
					l.add(arr[i]);
					int index=1;
					// count=1;
					while(s.contains(arr[i]+index)) {
						l.add(arr[i]+index);
						index++;
					}
					if(l.size()> count) {
						res.clear();
						res.add(l);
						count=l.size();
					}
				}
			}

		}
		return count;
		}
	}

/**
 * Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23}; Output: 5 Explanation: The
 * longest sub-array with elements summing up-to 0 is {-2, 2, -8, 1, 7}
 * 
 * @author 
 *
 */
class Largest_subarray_with_zero_sum {

	public static void main(String[] args) {
		int arr[] = { 2,10,10,10,10,10,10,10,10,10,10,-100 };
		System.out.println("Largest_Subarray_with_Zero_Sum::" + maxLen(arr));
	}

	private static int maxLen(int[] arr) {

		Map<Integer, Integer> map = new HashMap();
		int sum = 0, len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum == 0)
				len = i + 1;
			else if (map.containsKey(sum)) {
				int currLen = i - map.get(sum);
				len = Math.max(len, currLen);
			} else
				map.put(sum, i);
		}
		return len;

	}
}

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * 
 * @author 
 *
 */
class Three_Value_Sum_is_Zero {

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		List res = threeSum(nums);
		System.out.println(res);
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		int low, high, sum, reqd;
		for (int i = 0; i < nums.length; i++) {
			reqd = -nums[i];
			low = i + 1;
			high = nums.length - 1;
			while (low < high) {
				sum = nums[low] + nums[high];
				if (sum == reqd) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(nums[i]);
					l.add(nums[low]);
					l.add(nums[high]);
					res.add(l);

					while (low < nums.length && l.get(1) == nums[low])
						low++;
					while (high >= 0 && l.get(2) == nums[high])
						high--;
					while (i + 1 < nums.length && nums[i] == nums[i + 1])
						i++;
				} else if (sum < reqd)
					low++;
				else
					high--;
			}
		}
		return res;

	}
}

/**
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1 Output: 2 Explanation: The sum that is
 * closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author 
 *
 */
class Three_Sum_Closest {
	public static void main(String[] args) {
		int nums[] = { 1, 1, -1, -1, 3 };
		int target = -1;
		System.out.println(threeSumClosest(nums, target));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int low, high, sum;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			low = i + 1;
			high = nums.length - 1;
			while (low < high) {
				sum = nums[i] + nums[low] + nums[high];
				if (sum < target)
					low++;
				else
					high--;

				if (Math.abs(sum - target) < Math.abs(res - target))
					res = sum;
			}
		}
		return res;
	}

}

/**
 * Input: nums = [1,1,2] Output: 2, nums = [1,2,_] Explanation: Your function
 * should return k = 2, with the first two elements of nums being 1 and 2
 * respectively. It does not matter what you leave beyond the returned k (hence
 * they are underscores).
 * 
 * @author 
 *
 */
class Remove_Duplicate_from_Sorted_array {

	public static void main(String[] args) {
		int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int n = removeDuplicates(nums);
		for (int i = 0; i < n; i++)
			System.out.print(nums[i] + " ");
	}

	public static int removeDuplicates(int[] nums) {

		int index = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[index] != nums[j])
				nums[++index] = nums[j];
		}
		return index + 1; // No.of non-duplicate elements

	}
}

/**
 * Input: nums = [1,1,0,1,1,1] Output: 3 Explanation: The first two digits or
 * the last three digits are consecutive 1s. The maximum number of consecutive
 * 1s is 3.
 * 
 * @author 
 *
 */
class Max_Consecutive_Ones {
	public static void main(String[] args) {
		int nums[] = { 1, 1, 0, 1, 1, 1 };
		int n = findMaxConsecutiveOnes(nums);
		System.out.println("findMaxConsecutiveOnes::" + n);
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				maxCount = Math.max(maxCount, count);
				count = 0;
			}
		}
		maxCount = Math.max(maxCount, count);
		return maxCount;
	}
}

/**
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's. Input: nums =
 * [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6 Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * 
 * @author 
 *
 */
class Max_Consecutive_Ones_with_KFlip {
	public static void main(String[] args) {
		int[] arr = { 1,0,1,0 };
		int N = 0;
		System.out.println("longest=" + longest1(arr, N));
	}

	private static int longest1(int[] nums, int k) {
		int start = 0;
		int max = 0;
		int zeroCount = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				zeroCount++;
			while (zeroCount > k) {
				if (nums[start] == 0)
					zeroCount--;
				start++;
			}
			if(start<=i)
				max = Math.max(max, i - start + 1);
		}
		return max;
	}
}

/**
 * Given an array of integers nums and an integer k, return the number of
 * contiguous subarrays where the product of all the elements in the subarray is
 * strictly less than k.
 * 
 * Input: nums = [10,5,2,6], k = 100 Output: 8 Explanation: The 8 subarrays that
 * have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6],
 * [5, 2, 6] Note that [10, 5, 2] is not included as the product of 100 is not
 * strictly less than k.
 * 
 * @author 
 *
 */
class Subarray_Product_Less_Than_K {
	public static void main(String[] args) {
		int[] nums = { 10, 5, 2, 6 };
		int k = 100;
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int right = 0, left = 0, prod = 1, ans = 0;
		while (right < nums.length) {
			prod = prod * nums[right];
			while (prod >= k) {
				prod = prod / nums[left];
				left++;
			}
			ans += right - left + 1;
			right++;
		}
		return ans;
	}
}

/**
 * Given an integer array nums, return true if there exists a triple of indices
 * (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
 * indices exists, return false.
 * 
 * Input: nums = [1,2,3,4,5] Output: true Explanation: Any triplet where i < j <
 * k is valid.
 * 
 * @author 
 *
 */
class Increasing_Triplet {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println("increasingTriplet::" + increasingTriplet(nums));
	}

	public static boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE;
		int large = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i <= small)
				small = i;
			else if (i <= large)
				large = i;
			else
				return true;
		}
		return false;
	}
}

/**
 * Count triplets with sum smaller than X.
 * Input: N = 5, sum = 12
 * arr[] = {5, 1, 3, 4, 7}
 * Output: 4
 * Explanation: Below are triplets with
 * sum less than 12 (1, 3, 4), (1, 3, 5),
 * (1, 3, 7) and (1, 4, 5).
 */
class Find_Triplet_Sum_Lessthan_X{
	public static void main(String[] args) {
		System.out.println(countTriplets(new long[]{5, 1, 3, 4, 7},5,12));
	}

	static long countTriplets(long arr[], int n, int sum) {
		Arrays.sort(arr);
		int ans = 0;

		for (int i = 0; i < n - 2; i++) {
			int low = i + 1, high = n - 1;
			while (low < high){ //binary search
				long val=arr[i] + arr[low] + arr[high];
				if ( val>= sum)
					high--;
				else {
					ans += (high - low);
					low++;
				}
			}
		}
		return ans;
	}
}


class maxEvents {
	public static int num_maxEvents(int[] arr, int[] dur) {
		int drop = 0;
		int numOfEvents = arr.length;
		int[][] intervals = new int[numOfEvents][2];

		for (int i = 0; i < numOfEvents; i++) {
			intervals[i] = new int[] { arr[i], arr[i] + dur[i] };
		}

		Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
		// the finish time of first event;
		int curTime =	 intervals[0][1];

		for (int i = 1; i < numOfEvents; i++) {
			int[] toSchedual = intervals[i];
			if (toSchedual[0] < curTime)
				drop++;
			else
				curTime = toSchedual[1];

		}
		return numOfEvents - drop;

	}

	public static void main(String[] args) {
		int[] arrival1 = { 1, 3, 3, 5, 7 };
		int[] duration1 = { 2, 2, 1, 2, 1 };
		System.out.println(num_maxEvents(arrival1, duration1));
		int[] arrival2 = { 1, 3, 3, 5, 7, 6, 9 };
		int[] duration2 = { 2, 2, 1, 2, 1, 10, 2 };
		System.out.println(num_maxEvents(arrival2, duration2));
		int[] arrival = { 1, 3, 35, 7 };
		int[] duration = { 2, 2, 1, 2, 1 };
		System.out.println(num_maxEvents(arrival, duration));
	}
}

/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
 */
class MaxEvents {
	public int maxEvents(int[][] events) {
		Arrays.sort(events,(a,b)->a[0]-b[0]);

		int day=0,index=0,n=events.length,result=0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		while(!pq.isEmpty() || index<n){

			if(pq.isEmpty())  day = events[index][0];

			while(index<n && events[index][0]==day){
				pq.offer(events[index][1]);
				index++;
			}
			pq.poll();
			day++;
			result++;
			while(!pq.isEmpty() && pq.peek()<day){
				pq.poll();
			}
		}
		return result;
	}
}

/**
 * There is a car with capacity empty seats. The vehicle only drives east (i.e.,
 * it cannot turn around and drive west).
 * 
 * You are given the integer capacity and an array trips where trips[i] =
 * [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi
 * passengers and the locations to pick them up and drop them off are fromi and
 * toi respectively. The locations are given as the number of kilometers due
 * east from the car's initial location.
 * 
 * Return true if it is possible to pick up and drop off all passengers for all
 * the given trips, or false otherwise.
 * 
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4 Output: false
 * 
 * @author 
 *
 */
class Trip {
	public static boolean carPooling(int[][] trips, int capacity) {
		Map<Integer, Integer> m = new TreeMap<>();
		for (int[] t : trips) {
			m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
			m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
		}
		for (int v : m.values()) {
			capacity = capacity - v;
			if (capacity < 0) {
				return false;
			}
		}
		return true;
	}

	// Approach 2: using Array
	public static boolean carPooling1(int[][] trips, int capacity) {
		int stops[] = new int[1001];
		for (int t[] : trips) {
			stops[t[1]] = stops[t[1]] + t[0];
			stops[t[2]] = stops[t[2]] - t[0];
		}
		for (int i = 0; i < 1001; ++i) {
			capacity = capacity - stops[i];
			if (capacity < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity = 4;
		System.out.println(carPooling(trips, capacity));
	}
}

/**
 * Input: boxes = "110" Output: [1,1,3] Explanation: The answer for each box is
 * as follows: 1) First box: you will have to move one ball from the second box
 * to the first box in one operation. 2) Second box: you will have to move one
 * ball from the first box to the second box in one operation. 3) Third box: you
 * will have to move one ball from the first box to the third box in two
 * operations, and move one ball from the second box to the third box in one
 * operation.
 * 
 * @author 
 *
 */
class Move_All_Balls_To_EachBoxes {
	public static void main(String[] args) {
		String boxes = "100";
		minOperations2(boxes);
	}

	// using set
	public static int[] minOperations(String boxes) {
		Set<Integer> ones = new HashSet<Integer>();
		String box_Arr[] = boxes.split("");
		int[] res = new int[box_Arr.length];
		int index = 0;
		for (int i = 0; i < box_Arr.length; i++)
			if (box_Arr[i].equals("1"))
				ones.add(i);
		for (int i = 0; i < box_Arr.length; i++) {
			int sum = 0;
			for (int s : ones)
				sum = sum + Math.abs(i - s);
			res[index++] = sum;
		}

		return res;

	}

	// not using set - method2
	public static int[] minOperations2(String boxes) {
		int n = boxes.length();
		char[] ch = boxes.toCharArray();

		int[] left = new int[n];
		int count = ch[0] - '0';
		for (int i = 1; i < n; i++) {
			left[i] = left[i - 1] + count;
			count += ch[i] - '0';
		}

		int[] right = new int[n];
		count = ch[n - 1] - '0';
		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] + count;
			count += ch[i] - '0';
		}

		// its for answer
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			answer[i] = left[i] + right[i];
		}

		return answer;
	}
}

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i]. Input: nums
 * = [1,2,3,4] Output: [24,12,8,6]
 */
class ProductExceptSelf {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] res = productExceptSelf(nums);
		for (int i : res)
			System.out.print(i + " ");
	}

	public static int[] productExceptSelf(int[] nums) {

		int[] res = new int[nums.length];
		int n = nums.length;
		int left = 1, right = 1;
		for (int i = 0; i < n; i++) {
			if (i > 0)
				left = left * nums[i - 1];
			res [i] = left;
		}
		for (int i = n - 1; i >= 0; i--) {
			if (i < n - 1)
				right = right * nums[i + 1];
			res[i] = res[i] * right;
		}
		return res;

	}
}

/**
 * Given a string s and a character c that occurs in s, return an array of integers answer
 * where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 */
class Shortest_Distance_to_a_Character {
	public int[] shortestToChar(String s, char c) {
		int n=s.length();
		int[] ans=new int[n];
		int currPos=-n;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==c) currPos=i;
			ans[i]=i-currPos;
		}
		for(int i=currPos-1;i>=0;i--){
			if(s.charAt(i)==c) currPos=i;
			ans[i]=Math.min(currPos-i,ans[i]);

		}
		return ans;
	}
}

/**
 *
 * /** There are n people that are split into some unknown number of groups.
 * Each person is labeled with a unique ID from 0 to n - 1.
 * 
 * You are given an integer array groupSizes, where groupSizes[i] is the size of
 * the group that person i is in. For example, if groupSizes[1] = 3, then person
 * 1 must be in a group of size 3.
 * 
 * Return a list of groups such that each person i is in a group of size
 * groupSizes[i].
 * 
 * Each person should appear in exactly one group, and every person must be in a
 * group. If there are multiple answers, return any of them. It is guaranteed
 * that there will be at least one valid solution for the given input. Input:
 * groupSizes = [3,3,3,3,3,1,3] Output: [[5],[0,1,2],[3,4,6]] Explanation: The
 * first group is [5]. The size is 1, and groupSizes[5] = 1. The second group is
 * [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] =
 * 3. The third group is [3,4,6]. The size is 3, and groupSizes[3] =
 * groupSizes[4] = groupSizes[6] = 3. Other possible solutions are
 * [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
 * 
 * @author 
 *
 */

class Group {
	public static void main(String[] args) {
		int[] groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
		System.out.println("Answer::" + groupThePeople(groupSizes));
	}

	public static List<List<Integer>> groupThePeople(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			List temp;
			if (map.containsKey(curr))
				temp = map.get(curr);
			else
				temp = new ArrayList();
			temp.add(i);
			map.put(curr, temp);
			if (temp.size() == curr) {
				res.add(temp);
				map.remove(curr);
			}
		}
		return res;

	}
}

/**
 * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the
 * largest pair sum in a list of pairs.
 * 
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum
 * would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * 
 * @author 
 *
 */
class MaxPairSum {
	public static void main(String[] args) {
		int[] nums = { 3, 5, 2, 3 };
		System.out.println("Answer::" + maxPairSum(nums));
	}

	public static int maxPairSum(int[] nums) {

		Arrays.sort(nums);
		int left = 0, right = nums.length - 1, maxi = 0;
		while (left < right) {
			maxi = Math.max(maxi, nums[left++] + nums[right--]);
		}
		return maxi;
	}
}

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j
 * in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 */
class Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set=new HashSet<>();//SLIDING WINDOW
		for(int i=0;i<nums.length;i++){
			if(i>k) set.remove(nums[i-k-1]);
			if(set.contains(nums[i])) return true;
			set.add(nums[i]);
		}
		return false;
	}
}

/**
 * A leader in an array is an element which is greater than all the elements on
 * its right side in the array. For example, take an array {2,5,8,7,3,6}. Here
 * 6,7,8 are leaders
 * 
 * @author 
 *
 */
class LeadersInArray {
	void printLeaders(int arr[], int size) {
		int max_from_right = arr[size - 1];

		/* Rightmost element is always leader */
		System.out.print(max_from_right + " ");

		for (int i = size - 2; i >= 0; i--) {
				if (max_from_right < arr[i]) {
				max_from_right = arr[i];
				System.out.print(max_from_right + " ");
			}
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		LeadersInArray lead = new LeadersInArray();
		int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
		int n = arr.length;
		lead.printLeaders(arr, n);
	}
}

class validateParanthesis {
	public static void main(String[] args) {
		String str = "()[]{}";
		System.out.println("isValid::" + isValid(str));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}

/**
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 */
class Longest_Valid_Parentheses {
	public static int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);
		int maxLen=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='(') st.push(i);
			else{
				st.pop();
				if(st.isEmpty()) st.push(i);
				else maxLen=Math.max(maxLen,i-st.peek());
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "((()))";
		System.out.println("longestValidParentheses="+longestValidParentheses(s));
	}
}

/**
 * Given an array of integers nums, return the number of good pairs. A pair (i,
 * j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Input: nums = [1,2,3,1,1,3] Output: 4 Explanation: There are 4 good pairs
 * (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * 
 * @author 
 *
 */
class Number_of_Good_Pairs {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 1, 3 };
		System.out.println(numIdenticalPairs(nums));
	}

	public static int numIdenticalPairs(int[] nums) {

		int[] count = new int[101];
		int res = 0;
		for (int i : nums)
			count[i]++;
		for (int j : count)
			res += j * (j - 1) / 2;
		return res;
	}
}

/**
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order. Input: nums =
 * [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * 
 * @author 
 *
 */
class Sorted_Square {
	public static void main(String[] args) {
		int[] nums = { -4, -1, 0, 3, 10 };
		int res[] = sortedSquares(nums);
		for (int i : res)
			System.out.print(i + " ");
	}

	public static int[] sortedSquares(int[] nums) {

		int low = 0;
		int high = nums.length - 1;
		int[] res = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			if (Math.abs(nums[low]) > Math.abs(nums[high])) {
				res[i] = nums[low] * nums[low];
				low++;
			} else {
				res[i] = nums[high] * nums[high];
				high--;
			}
		}
		return res;
	}
}

/**
 * Smallest window that contains all characters of string itself
 */
class Smallest_window {

	public static void main(String[] args) {
		String s1 = "ADOBECODEBANC";
		String s2 = "ABC";

		System.out.println("smallestString::" + minWindow(s1, s2));

	}

	public static String minWindow(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s2.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int i = 0, j = 0, count = map.size();
		int min = Integer.MAX_VALUE;
		String res="";
		while (j < s1.length()) {
			char ch = s1.charAt(j++);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) count = count - 1;
			}
			if (count > 0) continue;
			while (count == 0) {
				char st = s1.charAt(i++);
				if (map.containsKey(st)) {
					map.put(st, map.getOrDefault(st, 0) + 1);
					if (map.get(st) > 0) count = count + 1;
				}
			}
			if(j-i<min){
				min=j-i;
				res = s1.substring(i-1,j);
			}
		}
		return res;
	}
}

/**
 * Can You RANDOMLY Reorder Array in O(N)? - Paypal interview questions
 * 
 * @author 
 *
 */
class ShuffleRand {
	// A Function to generate a random permutation of arr[]
	static void randomize(int arr[], int n) {
		// Creating a object for Random class
		Random r = new Random();

		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n - 1; i > 0; i--) {

			// Pick a random index from 0 to i
			int j = Math.abs(r.nextInt() % i);

			// Swap arr[i] with the element at random index
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		// Prints the random array
		System.out.println(Arrays.toString(arr));
	}

	// Driver Program to test above function
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = arr.length;
		randomize(arr, n);
	}
}

/**
 * For example, if the input string is “wwwwaaadexxxxxx�?, then the function
 * should return “w4a3d1e1x6�?
 * 
 * @author 
 *
 */

class RunLength_Encoding {
	public static void printRLE(String str) {
		int n = str.length();
		int count = 1;
		System.out.print(str.charAt(0));
		for (int i = 1; i < n; i++) {

			// Count occurrences of current character

			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {

				System.out.print(count);
				System.out.print(str.charAt(i));
				count = 1;
			}

		}
		System.out.print(count);
	}

	public static void main(String[] args) {
		String str = "wwwwaaadexxxxxxywww";
		printRLE(str);
	}
}

//Java program for the above approach

class Thread_Progream {

	// Starting counter
	int counter = 1;

	static int N;

	// Function to print odd numbers
	public void printOddNumber() {
		synchronized (this) {
			// Print number till the N
			while (counter < N) {

				// If count is even then print
				while (counter % 2 == 0) {

					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.print(counter + " ");

				// Increment counter
				counter++;

				// Notify to second thread
				notify();
			}
		}
	}

	// Function to print even numbers
	public void printEvenNumber() {
		synchronized (this) {
			// Print number till the N
			while (counter < N) {

				// If count is odd then print
				while (counter % 2 == 1) {

					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.print(counter + " ");

				// Increment counter
				counter++;

				// Notify to 2nd thread
				notify();
			}
		}
	}

	// Driver Code
	public static void main(String[] args) {
		// Given Number N
		N = 10;

		// Create an object of class
		Thread_Progream mt = new Thread_Progream();

		// Create thread t1
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				mt.printEvenNumber();

			}
		});
		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mt.printOddNumber();
			}
		});

		// Start both threads
		t1.start();
		t2.start();
	}
}

class Diamond_Pattern {

	public static void main(String[] args) {

		int r = 5;
		int gap = r - 1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < gap; j++)
				System.out.print(" ");

			for (int j = 0; j < i; j++)
				System.out.print(" *");

			System.out.println("");
			gap--;
		}

		gap = 0;
		for (int i = r; i > 0; i--) {
			for (int j = 0; j < gap; j++)
				System.out.print(" ");

			for (int j = 0; j < i; j++)
				System.out.print("* ");

			System.out.println("");
			// System.out.print(" ");
			gap--;
		}

	}

}

class Goldman_Sachs {
	public static void main(String[] args) {
		int[][] parentChildPairs = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 },
				{ 8, 9 } };

		List<List<Integer>> returnList = findParents(parentChildPairs);
		int i = 0;
		while (i < returnList.get(0).size()) {
			System.out.println(returnList.get(0).get(i));
			i++;
		}

		System.out.println(" ");
		i = 0;
		while (i < returnList.get(1).size()) {
			System.out.println(returnList.get(1).get(i));
			i++;
		}
		// parent, child

	}

	// Time Complexity: O(n) n - num of ind.
	// Space Complexity: O(n)
	// {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
	// {4, 5}, {4, 8}, {8, 9}
	public static List<List<Integer>> findParents(int[][] pairs) {
		HashMap<Integer, Integer> numberOfParents = new HashMap<>();

		for (int i = 0; i < pairs.length; i++) {
			int child = pairs[i][1];
			int parent = pairs[i][0];

			if (numberOfParents.containsKey(child))
				numberOfParents.put(child, numberOfParents.get(child) + 1);
			else
				numberOfParents.put(child, 1);

			if (!numberOfParents.containsKey(parent))
				numberOfParents.put(parent, 0);

		}

		ArrayList<Integer> zeroParents = new ArrayList<>();
		ArrayList<Integer> oneParent = new ArrayList<>();

		numberOfParents.forEach((key, value) -> {
			if (value == 0)
				zeroParents.add(key);
			if (value == 1)
				oneParent.add(key);
		});

		List<List<Integer>> returnList = new ArrayList<>();

		returnList.add(zeroParents);
		returnList.add(oneParent);

		return returnList;

	}
}