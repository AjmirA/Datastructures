package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Graph_Practice {
	public static void main(String[] args) {

	}
}


class Breadth_First_Search{
	
	public static void main(String[] args) {
		
	int[][] A = {{0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 0, 1, 1, 1, 0, 0, 0},
                 {0, 1, 0, 1, 0, 0, 0, 0},
                 {0, 1, 1, 0, 1, 1, 0, 0},
                 {0, 1, 0, 1, 0, 1, 0, 0},
                 {0, 0, 0, 1, 1, 0, 1, 1},
                 {0, 0, 0, 0, 0, 1, 0, 0},
                 {0, 0, 0, 0, 0, 1, 0, 0}};
	
	int[] visited = new int[128];

	System.out.println("BFS::");
	BFS(1, A, visited);
	int[] visitedDFS = new int[128];

	System.out.println("DFS::");
	DFS(1, A, visitedDFS);
}
	
	static void BFS(int i,int[][] A,int[] visited) {
		int v=A.length;
		System.out.println(i);
		visited[i]=1;
		QueueImpl q=new QueueImpl();
		q.enqueue(i);
		
		while(!q.isEmpty()) {
			
			int n=(int) q.dequeue();
				for(int j=1;j<v;j++) {
					if(A[n][j]==1 && visited[j]==0) {
						System.out.println(j);
						visited[j]=1;
						q.enqueue(j);
					}
				}
		}
	}
	
	static void DFS(int i,int[][] A,int[] visited ) {
		int v=A.length;
		if (visited[i] == 0) {
			visited[i] = 1;
			System.out.println(i);
			for (int j = 1; j < v; j++) {
				if (A[i][j] == 1 && visited[j] == 0) {
					DFS(j, A,visited);
				}
			}
		}
	}
}


class Graph1{
	
	static int vertices;
	static LinkedList<Integer>[] adj_list;
	static int[] visited;
	Graph1(int v){
		vertices=v;
		adj_list=new LinkedList[vertices+1];
		for(int i=0;i<vertices+1;i++)
			adj_list[i]=new LinkedList<>();
		visited=new int[vertices+1];
	}
	private void add_an_edge(int i, int j) {
		adj_list[i].add(j);
		//adj_list[j].add(i);
	}

	public static void main(String[] args) {
		Graph1 g = new Graph1(200);
		g.add_an_edge(1, 2);
		g.add_an_edge(1, 3);
		g.add_an_edge(1, 4);
		g.add_an_edge(2, 3);
		g.add_an_edge(2, 1);
		g.add_an_edge(3, 1);
		g.add_an_edge(3, 1);
		g.add_an_edge(3, 4);
		g.add_an_edge(3, 5);
		g.add_an_edge(4, 1);
		g.add_an_edge(4, 3);
		g.add_an_edge(4, 5);

		g.add_an_edge(5, 3);
		g.add_an_edge(5, 4);
		g.add_an_edge(5, 6);
		g.add_an_edge(5, 7);

		g.add_an_edge(6, 5);
		g.add_an_edge(7, 5);
		
		g.add_an_edge(7, 200);
		g.add_an_edge(200, 7);
		DFS(1);

	}
	private static void BFS(int i) {
		Queue<Integer> q=new LinkedList<Integer>();
		System.out.println(i);
		visited[i]=1;
		q.add(i);
		while(!q.isEmpty()) {
			int index=q.remove();
			LinkedList l= adj_list[index];
			for(int j=0;j<l.size();j++) {
				int val=(int) l.get(j);
				if(visited[val]!=1) {
					System.out.println(val);
					visited[val]=1;
					q.add(val);
				}
			}
		}
		
	}

	
	static void DFS(int i) {
		
		if (visited[i] != 1) {
			visited[i]=1;
			System.out.println(i);
			LinkedList l= adj_list[i];
			for (int j = 0; j < l.size(); j++) {
				int val=(int) l.get(j);
				if(visited[val]!=1)
				DFS(val);
			}
		}
	
	}

}

/**
 * Design an algorithm to find whether there is a routes between the nodes.
 * @author 
 *
 */
class Graph2{
	
	static int vertices;
	static LinkedList<Integer>[] adj_list;
	static int[] visited;
	Graph2(int v){
		vertices=v;
		adj_list=new LinkedList[vertices+1];
		for(int i=0;i<vertices+1;i++)
			adj_list[i]=new LinkedList<>();
		visited=new int[vertices+1];
	}
	void addEdge(int i, int j) {
		adj_list[i].add(j);
		//adj_list[j].add(i);
	}

	public static void main(String[] args) {
		Graph2 g = new Graph2(4);
		 g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	       List res=new ArrayList();
		System.out.println(isReachable_Using_DFS( 3,1,3));
		System.out.println(isReachable_Using_DFS(1,3,1));
		//System.out.println(isReachable( 3,1));
	//	System.out.println(isReachable(1,3));

	}
	private static boolean isReachable(int start,int end) {
		Queue<Integer> q=new LinkedList<Integer>();
		visited[start]=1;
		q.add(start);
		while(!q.isEmpty()) {
			int index=q.remove();
			LinkedList l= adj_list[index];
			for(int j=0;j<l.size();j++) {
				int val=(int) l.get(j);
				if(val==end)
					return true;
				else if (visited[val]!=1) {
					visited[val]=1;
					q.add(val);
				}
			}
		}
		return false;
		
	}
	
	private static boolean isReachable_Using_DFS(int start, int end,int i) {
		if (visited[i] != 1) {
			visited[i] = 1;
			LinkedList l = adj_list[i];
			for (int j = 0; j < l.size(); j++) {
				int val = (int) l.get(j);
				if (end == val)
					return true;
				else
				  if(isReachable_Using_DFS(start, end,val))
					  return true;

			}
		}
		return false;

	}
}