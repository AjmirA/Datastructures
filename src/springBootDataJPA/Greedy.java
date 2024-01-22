package springBootDataJPA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Greedy {
	public static void main(String[] args) {

	}
}
/**
 * N meeting in one room 
 * @author 
 *
 */

class Meeting {
	
	int start;
	int end;
	int pos;
	public Meeting(int start, int end, int pos) {
		super();
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}
class MeetingImpl{
	
	public static void main(String[] args) {
		int start[] = {1,2,3,1};
		int end[] =  {2,3,4,2};
		int n=4;
		int max_No_of_Meeting=max_No_of_Meeting(start,end,n);
		System.out.println("max_No_of_Meeting::"+max_No_of_Meeting);
		meetingsToBeHappened(start,end,n);
	}
	
	private static void meetingsToBeHappened(int[] start, int[] end, int NumOfMeetings) {
		Meeting m=null;
		ArrayList<Meeting> meetings=new ArrayList<>();
		for(int i=0;i<NumOfMeetings;i++) {
			 m=new Meeting(start[i], end[i], i+1);
			 meetings.add(m);
		}
		System.out.println(meetings);
		Collections.sort(meetings,new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if(o1.end<o2.end)
					return -1;
				else if(o1.end>o2.end)
					return 1;
				else if(o1.pos<o2.pos)
					return -1;
				else
					return 1;
			}
		});
		
		List ans=new ArrayList();
		int lastMeetingEndTime=Integer.MIN_VALUE;
		for(int i=0;i<meetings.size();i++) {
			Meeting k=meetings.get(i);
			if(k.start>lastMeetingEndTime) {
				lastMeetingEndTime=k.end;
				ans.add(k.pos);
			}
		}
		System.out.println(ans);
	}

	/**
	 * Given an array of events where events[i] = [startDayi, endDayi]. Every event
	 * i starts at startDayi and ends at endDayi.
	 * 
	 * You can attend an event i at any day d where startTimei <= d <= endTimei.
	 * Notice that you can only attend one event at any time d.
	 * 
	 * Return the maximum number of events you can attend.
	 * 
	 * Input: events = [[1,2],[2,3],[3,4]] Output: 3 Explanation: 
	 * You can attend all the three events. One way to attend them all is as shown. 
	 * Attend the first event on day 1. 
	 * Attend the second event on day 2. 
	 * Attend the third event on day 3.
	 */
	
	private static int maxEvents(int[] start, int[] end, int NumOfMeetings) { 	
		 int [][] meetings = new int[NumOfMeetings][2];
		 List ans=new ArrayList();
		for(int i=0;i<NumOfMeetings;i++) {
			meetings[i]=new int[] {start[i],end[i]};
		}
		Arrays.sort(meetings,(a,b)->a[1]-b[1]);
		    Map<Integer,Boolean> map=new HashMap();
		        int count=0;
				for(int i=0;i<meetings.length;i++) {
					int[] meet=meetings[i];
					for(int j=meet[0];j<=meet[1];j++){
		                if(map.get(j)==null){
		                	map.put(j,true);
		                    count++;
		                    break;
		                }
		            }
				}
				return count;
		    }

	private static int max_No_of_Meeting(int[] start, int[] end, int NumOfMeetings) {
		
		 int [][] meetings = new int[NumOfMeetings][2];
		 List ans=new ArrayList();
		for(int i=0;i<NumOfMeetings;i++) {
			meetings[i]=new int[] {start[i],end[i]};
		}
		Arrays.sort(meetings,(a,b)->a[1]-b[1]);
		int currTime=meetings[0][1];
		int drop=0;
		for(int i=1;i<meetings.length;i++) {
			int[] meet=meetings[i];
			if(meet[0]<currTime) {
				drop++;
			}else {
				currTime=meet[1];
				ans.add(i);
			}
		}
		return NumOfMeetings-drop;
		
	}
	
}



class Job{
	  char id;
	    int deadline, profit;
	  public Job(char id, int deadline, int profit)
	    {
	        this.id = id;
	        this.deadline = deadline;
	        this.profit = profit;
	    }
}

/**
 * Given an array of jobs where every job has a deadline and associated profit
 * if the job is finished before the deadline. It is also given that every job
 * takes a single unit of time, so the minimum possible deadline for any job is
 * 1. How to maximize total profit if only one job can be scheduled at a time.
 * 
 * @author 
 *
 */
class Job_Scheduling{
	
	public static void main(String[] args) {

        ArrayList<Job> arr = new ArrayList<Job>();
  
        arr.add(new Job('a', 4, 20));
        arr.add(new Job('b', 5, 60));
        arr.add(new Job('c', 6, 70));
        arr.add(new Job('d', 6, 65));
        arr.add(new Job('e', 4, 25));
        arr.add(new Job('f', 3, 80));
        arr.add(new Job('g', 2, 10));
        arr.add(new Job('h', 2, 22));
        
        // Function call
        System.out.println("Following is maximum "
                           + "profit sequence of jobs");
  
  
        
        printJobScheduling(arr, 6);
	}

	private static void printJobScheduling(ArrayList<Job> jobsList, int n) {
		
		Collections.sort(jobsList, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if(o1.profit<o2.profit)
					return 1;
				return -1;
			}
		});
		
		/*Hashing start*/
		int taskDone[]=new int[n+1];		
		Arrays.fill(taskDone, -1);
		taskDone[0]=0;//Task should start from 1. so we are making task[0] as 0 to make that is not available.
		/*Hashing End*/
		
		for(int i=0;i<jobsList.size();i++) {
			Job j=jobsList.get(i);
			for(int k=j.deadline;k>=0;k--) {
		     if(taskDone[k]==-1) {	
				taskDone[k] = 0;
				System.out.println(j.id);
				break;
		     }
			}
			
		}
	}
}

/**
 * Input: Items as (value, weight) pairs 
 * arr[] = {{60, 10}, {100, 20}, {120,30}} Knapsack Capacity, W = 50;
 * 
 * Output: Maximum possible value = 240 by taking items of weight 10 and 20 kg
 * and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240
 * 
 * @author 
 *
 */
class ItemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}
class Item{
	int value;
	int weight;
	Item(int val,int wt){
		this.value=val;
		this.weight=wt;
	}
}
class Knapsack{
    static double fractionalKnapsack(int[] wt, int[] val, int n) {
    	
    	Item[] items=new Item[val.length];
    	for (int i = 0; i < wt.length; i++) 
    		items[i] = new Item(val[i],wt[i]);
        
    	
        Arrays.sort(items, new ItemComparator()); 
        
        int curWeight = 0; 
        double finalvalue = 0.0; 
        
        for (int i = 0; i < n; i++) {
       
            if (curWeight + items[i].weight <= n) {
                curWeight += items[i].weight;
                finalvalue += items[i].value;
            }
     
            else {
                int remain = n - curWeight;
                finalvalue += ((double)items[i].value / (double)items[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }
    
    public static void main(String[] args) {
    	 int[] wt = { 10, 40, 20, 30 };
         int[] val = { 60, 40, 100, 120 };
         int capacity = 50;
   
         double maxValue = fractionalKnapsack(wt, val, capacity);
   
         // Function call
         System.out.println("Maximum value we can obtain = "
                            + maxValue);
	}
}

/**
 * Sort the original array based on rank(another) array
 * 	Input::
 *  int array[] ={1,5,6,3,10};
 *	int	rank[]= {3,1,5,3,2};
 * @author 
 *
 */
class ArrayVal{
	
	int val;
	int rank;
	public ArrayVal(int val, int rank) {
		this.val = val;
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "[val=" + val + ", rank=" + rank + "]";
	}
}

class SortArray{
	
	public static void main(String[] args) {
		int array[] ={1,5,6,3,10};
		int	rank[]= {3,1,5,3,2};
		int n=array.length;
		List<ArrayVal> l=new ArrayList();
		for(int i=0;i<n;i++) 
			l.add(new ArrayVal(array[i],rank[i]));
		Collections.sort(l,new Comparator<ArrayVal>() {

			@Override
			public int compare(ArrayVal o1, ArrayVal o2) {
				
				if(o1.rank>o2.rank)
					return -1;
				else if(o1.rank<o2.rank)
					return 1;
				else if(o1.rank==o2.rank && o1.val>o2.val)
					return -1;
				return 0;
			}
		});
		System.out.println(l);
	}
}
