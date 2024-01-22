package main;

 class Array_Practice {
/**
 *  Binary search to find the element in array
 *  Arrays are in sorted order.	
 * @param arr
 * @param l
 * @param h
 * @param key
 * @return
 */
	 public static	class BinarySearch{
		public static void main(String[] args) {
			  int arr[] = {10,20,30,40,50};  //sorted Array
		        int key = 30;  
		        int last=arr.length-1;  
		       int res= binarySearch(arr,0,last,key);
		       System.out.println("Found element at "+res);
		}

		private static int binarySearch(int[] arr, int l, int h, int key) {
			int mid=0;
			while(l<h) {
				 mid=(l+h)/2;
				if(arr[mid]==key)
					return mid;
				else if(key<arr[mid])
					h=mid-1;
				else
					l=mid+1;
			}
			return -1;
		}
	}
	 /**
	  * Merge two sorted arrays
	  * Arrays are in sorted order.	
	  * @author 
	  *
	  */
	public static class MergeArray{
		public static void main(String[] args) {
			  int arr1[] = {1,3,4,7,9}; //sortedArray
			  int arr2[] = {2,4,6,8,9}; //sortedArray
			  int[] arr3=new int[arr1.length+arr2.length];
			  int[] intersection=new int[arr1.length];
			  int i=0,n=0,m=0,k=0;
			  while(n<arr1.length) {
				  if(n<arr1.length && m<arr2.length && arr1[n]==arr2[m]) { //This condition is when both the array have same elements
					  arr3[i]=arr1[n];
					  intersection[k++]=arr1[n];
					  n++;
					  m++;
					  i++;
				  }
			      else if(n<arr1.length && m<arr2.length && arr1[n]<arr2[m]) {
					  arr3[i]=arr1[n];
					  n++;
					  i++;
				  }else if( n<arr1.length && m<arr2.length && arr2[m]<arr1[n]) {
					  arr3[i]=arr2[m];
					  m++;
					  i++;
				  }
			  }
			  for(;n<arr1.length;n++,i++) 
				  arr3[i]=arr1[n];
			  for(;m<arr2.length;m++,i++) 
				  arr3[i]=arr2[m];
			 
			  /* Print merged array*/
			  System.out.println("Merged Array::");
			  for(int j:arr3) {
				  if(j!=0)
				  System.out.print(j+" ");
			  }
			  /* Print intersection array*/
			  System.out.println("\nIntersetion Element::");
			  for(int j:intersection) {
				  if(j!=0)
				  System.out.print(j+" ");
			  }

		}
	}
	
/**
 * Find the differences in the 1st array by comparing with the 2nd array.
 * Arrays are in sorted order.
 * @author 
 *
 */
		public static class diiferenceArray{
			public static void main(String[] args) {
				  int arr1[] = {1,3,4,7,9}; //sortedArray
				  int arr2[] = {2,4,6,8,9}; //sortedArray
				  int[] arr3=new int[arr1.length];
				  int i=0,n=0,m=0,k=0;
				  while(n<arr1.length) {
					  if(arr1[n]==arr2[m]) {
						  n++;
						  m++;
					  }
				      else if(arr1[n]<arr2[m]) {
						  arr3[i]=arr1[n];
						  n++;
						  i++;
					  }else {
						  m++;
					  }
				  }
				 
				  /* Print merged array*/
				  System.out.println("Differnce Array(A - B)::");
				  for(int j:arr3) {
					  if(j!=0)
					  System.out.print(j+" ");
				  }

			}
		}
	
/**find missing element in sorted natural order array
  * @author 
   */
		public static class findMissingElement{
			public static void main(String[] args) {
				  int arr[] = {6,7,8,9,11,12,15,16,17,18}; //sortedArray
                  int diff=arr[0];
                  int i=0;
				  while(i<arr.length) {
					  if(diff!=arr[i]-i) {
						  while(diff<arr[i]-i) {
						  System.out.print(diff+i+",");
						  diff++;		
						  }
					  }
					  i++;
				  }

			}
		}
/**
 * Find the duplicated element and duplicated count in the sorted array		
 * @author 
 *
 */
		public static class findDuplicateElementAndCount {
			public static void main(String[] args) {
				int arr[] = { 1, 2, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 9, 9, 10, 10, 10, 10 }; // sortedArray
				for (int i = 0; i < arr.length - 1; i++) {
					if (arr[i] == arr[i + 1]) {
						int j = i + 1;
						while (arr[j] == arr[i]) {
							j++;
							if (j == arr.length)
								break;

						}
						System.out.println("Duplicated Element=" + arr[i] + " Count=" + (j - i));
						i = j - 1;
					}

				}
			}
		}

/**
 * Find duplicated element in the unsorted array -O(n2) and O(n2)
 * @author 
 *
 */
		public static class findDuplicateElementInUnSorted{
			public static void main(String[] args) {
				int arr[] = { 8, 3, 6, 4, 6, 5, 6, 8, 2, 7 }; // UnsortedArray
				System.out.println("Hashing Technique::");
				findDuplicateUsingHash(arr); // HashMethod O(n)
				System.out.println("Actual Technique::");
				findDuplicate(arr); // Normal method - O(n2)

			}
			
			static void findDuplicate(int arr[]) {
				int count;
				for (int i = 0; i < arr.length - 1; i++) {
					count = 1;
					if (arr[i] != -1) {
						for (int j = i+1; j < arr.length; j++) {
							if (arr[i] == arr[j]) {
								count++;
								arr[j] = -1;
							}
						}
						if(count>1)System.out.println("Duplicated Element=" + arr[i] + " Count=" + count);
					}

				}
			}
			
			static void findDuplicateUsingHash(int arr[]) {
				int[] temp=new int[20];
				for(int i=0;i<arr.length;i++) 
					temp[arr[i]]++;
				for(int j=0;j<temp.length;j++) {
					if(temp[j]>1)
						System.out.println("Duplicated Element="+j+" count="+temp[j]);
				}
			}
		}
/**
 * Find pair of element with sum k
 */ 
		
		public static class findPairWithSumK{
			public static void main(String[] args) {
				int arr[] = { 8, 3, 6, 4, 5, 2, 7 }; 
				findSumPair(arr,10);
			}
			static void findSumPair(int arr[],int sum) {
				int[] temp=new int[20];
				int rem=0;
				for(int i=0;i<arr.length;i++) {
					rem=sum-arr[i];
					if(temp[rem]>0)
						System.out.println("Pair found="+arr[i]+" and"+rem);
					temp[arr[i]]++;

				}
				
			}
		}
		
/**
 * Find pair of element with sum k in a sorted array
 */ 
				
				public static class findPairWithSumKInSortedAray{
					public static void main(String[] args) {
						int arr[] = {1,2,3,4,5,6,7,8,9,10}; 
						findSumPair(arr,10);
					}

					static void findSumPair(int arr[], int sum) {
						int l = 0;
						int h = arr.length - 1;
						for (int i = 0; i < arr.length; i++) {
                      			if (l == h || l > h) break;
							
								if (arr[l] + arr[h] > sum)
									h = h - 1;
								else if (arr[l] + arr[h] == sum) {
									System.out.println("Pair found=" + arr[l] + "and " + arr[h]);
									l++;
									h--;
								}
							
						}

					}
				}
				
/**
 * find Min and Max in a single scan
 */
				public static class findMinMax{
					public static void main(String[] args) {
						int arr[] = {5,8,3,9,6,2,10,7,-1,4}; 
						findMinAndMax(arr);
					}

					private static void findMinAndMax(int[] arr) {
						int min=arr[0],max=arr[0];
						 for(int val:arr) {
							 if(val>max)
								 max=val;
							 else if(val<min)
								min=val;
						 }
						 System.out.println("Max="+max);
						 System.out.println("Min="+min);
					}
				}

}

//Java code to find
//duplicates in O(n) time

class FindDuplicate {
	// Function to print duplicates
	void printRepeating(int arr[], int size)
	{
		int i;
		System.out.println("The repeating elements are : ");
		
		for (i = 0; i < size; i++) {
			int j = Math.abs(arr[i]);
			if (arr[j] >= 0)
				arr[j] = -arr[j];
			else
				System.out.print(j + " ");
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		FindDuplicate duplicate = new FindDuplicate();
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		int arr_size = arr.length;

		duplicate.printRepeating(arr, arr_size);
	}
}

//This code has been contributed by Mayank Jaiswal
