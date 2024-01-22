package main;

public class Heap_Practice {
 public static void main(String[] args) {
	
}
}


class Create_Heap {
	public static void main(String[] args) {

		int arr[] = { 50,40,45,55 };
		int n=arr.length;
		createHeap(arr); //Creating heap in O(n log n) //Top to Bottom
		print(arr,n);
		
		createHeapify(arr); //Creating heap in O(n) //Bottom to Top
		print(arr,n);

		n=delete(arr,n);
		print(arr,n);
		
		sort(arr);
		print(arr,n);
		
	}

	private static void insert(int[] arr, int n) {

		int i = n;
		int temp = arr[n];

		while (i > 0 && temp > arr[(i - 1) / 2]) {

			arr[i] = arr[(i - 1) / 2];
			i = (i - 1) / 2;
		}
		arr[i] = temp;
	}
	
	private static void heapify_Insert(int[] arr, int n) {

		int i = n; // parent
		int j = 2 * n + 1; // leftchild

		while (j < arr.length - 1) {
			if (arr[j] < arr[j + 1])
				j = j + 1;

			if (arr[i] < arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i = j;
				j = 2 * i + 1;
			}else
				break;

		}

	}
	
	
	private static void createHeap(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			insert(arr, i);
	}
	
	private static void createHeapify(int[] arr) {
		int n=(arr.length / 2) - 1;//This is the first parent from bottom
		for (int i = n; i >= 0; i--) 
			heapify_Insert(arr, i);
	}
	
	private static void sort(int[] arr) {
		int n=arr.length;
		for (int i = 0; i < arr.length; i++)
			n=delete(arr,n);
	}
	
	private static void print(int[] arr,int n) {
		for (int i=0;i<n;i++)
			System.out.print(arr[i] + ",");
		System.out.println();
	}
	
	//In heap,we can always delete the root node only.Other nodes can't be deleted
	private static int delete(int[] arr,int n) {
		
		int tempVal=arr[0];
		arr[0]=arr[n-1]; //move last element to root
		int i=0;//root
		int j=(i*2)+1; //left child
		int temp;
		while(j<n-1) {
			
			if(arr[j+1]>arr[j])//compare left and right child to know which is greater.Because the greater ele will gets compared with parent in the next if loop
				j=j+1;
			if(arr[j]>arr[i]) { //swapping and changing the parent and child node (i and j)
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i=j;
				j=(i*2)+1;
			}else
				break;
			
		}
		arr[n-1]=tempVal;
		return n-1;
	}

}