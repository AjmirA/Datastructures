package main;

public class Sorting_Practice {
	public static void main(String[] args) {

	}
}


class Insertion_Sort{
	public static void main(String[] args) {
		int arr[]= {8,5,7,3,10};
		int[] res=insertion_Sort(arr);
		print(res);
		
		
	}

	private static void print(int[] res) {
		for(int i:res)
			System.out.print(i+",");
		
	}

	private static int[] insertion_Sort(int[] arr) {
		int j=0;
		int x;
		for(int i=1;i<arr.length;i++) {
			x=arr[i];
			j=i-1;
			while(j>-1 && arr[j]>x) {
				arr[j+1]=arr[j];
				j--;
				}
			arr[j+1]=x;
			}
		return arr;
		}
	}


class Quick_Sort{
	
	public static void main(String[] args) {
		  int A[] = {3, 7, 9, 10, 6, 5, 12, 4, 11, 2,Integer.MAX_VALUE};
		  quickSort(A,0,10);
		  print(A);
	}
	
	static void quickSort(int[] a,int l,int h) {
		int j;
		if(l<h) {
			j=partition(a, l, h);
			quickSort(a,l,j);
			quickSort(a,j+1,h);
		}
	}

	static int partition(int a[], int l, int h) {

		int pivot = a[l];
		int i = l, j = h;
		while (i < j) {
			do {
				i++;
			} while (a[i] <= pivot);

			do {
				j--;
			} while (a[j] > pivot);

			if (i < j)
				swap(i, j, a);
		} 
		swap(l, j, a);

		return j;

	}
	private static void swap(int i, int j, int[] a) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}
	
	private static void print(int[] res) {
		for(int i:res)
			System.out.print(i+",");
		
	}
}


class Selection_Sort{
	
	public static void main(String[] args) {
		 int A[] = {3, 7, 9, 10, 6, 5, 12, 4, 11, 2,Integer.MAX_VALUE};
		  selectionSort(A);
		  print(A);
	}
	
	private static void selectionSort(int[] a) {
		
		for(int i=0;i<a.length;i++) {
			int val=a[i];
			int k=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[k])
					k=j;
			}
			a[i]=a[k];
			a[k]=val;
		}
 		
	}

	private static void print(int[] res) {
		for(int i:res)
			System.out.print(i+",");
		
	}
}


class MergeSort{
	public static void main(String[] args) {
		int arr[]= {2,7,9,20,3,5,8,12};
		for(int p=2;p<=arr.length;p=p*2) {
			for(int i=0;i+p-1<arr.length;i=i+p) {
				merge(arr,i,i+p);
			}
		}

		for(int i:arr)
			System.out.print(i+",");
	}

	private static void merge(int[] arr, int l, int h) {
		int mid = (l + h) / 2;
		int i = l;
		int m=mid;
		int low=l;
		
		int[] newArray = new int[h];

		while (l < mid && m < h) {
			if (arr[l] < arr[m]) {
				newArray[i++] = arr[l];
				l++;
			} else {
				newArray[i++] = arr[m];
				m++;
			}
		}
		for (; l < mid; l++)
			newArray[i++] = arr[l];
		for (; m < h; m++)
			newArray[i++] = arr[m];
		 for (int k=low; k<h; k++){
		        arr[k] = newArray[k];
		    }
	}
	
}