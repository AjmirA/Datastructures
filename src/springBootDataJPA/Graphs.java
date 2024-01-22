package springBootDataJPA;

import java.util.*;
import java.util.LinkedList;


public class Graphs {
	public static void main(String[] args) {

	}
}

/**
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise. Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * https://leetcode.com/problems/number-of-provinces/description/
 */
class Number_of_Provinces {
	public int findCircleNum(int[][] M) {

		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<M.length;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0;i<M.length;i++){
			for(int j=0;j<M[0].length;j++){
				if(M[i][j]==1)
					adj.get(i).add(j);
			}
		}

		int[] visited=new int[M.length];
		int count=0;

		for(int i=0;i<M.length;i++){
			if(visited[i]==0){
				dfs(adj,visited,i);
				count++;
			}
		}
		return count;
	}

	private void dfs(List<List<Integer>> adj, int[] visited, int i) {
		visited[i]=1;
		for(int val: adj.get(i)){
			if(visited[val]==0){
				dfs(adj,visited,val);
			}
		}
	}
}



/**
 * Its having 2 problems.
 * 1. No of island
 * 2. Max Area in all islands
 */
class Island {

	/**
	 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
	 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
	 * You may assume all four edges of the grid are all surrounded by water.
	 * Input: grid = [
	 * ["1","1","1","1","0"],
	 * ["1","1","0","1","0"],
	 * ["1","1","0","0","0"],
	 * ["0","0","0","0","0"]
	 * ]
	 * Output: 1
	 */
	public int NumberOfIslands(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int numberOfIslands = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j, row, col);
					numberOfIslands = numberOfIslands + 1;
				}
			}
		}
		return numberOfIslands;
	}

	private void dfs(int[][] grid, int i, int j, int row, int col) {
		if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) return;
		grid[i][j] = 2;
		dfs(grid, i - 1, j, row, col);
		dfs(grid, i + 1, j, row, col);
		dfs(grid, i, j - 1, row, col);
		dfs(grid, i, j + 1, row, col);

	}


	/**
	 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
	 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
	 * The area of an island is the number of cells with a value 1 in the island.
	 * Return the maximum area of an island in grid. If there is no island, return 0.
	 * ISLAND WHICH IS HAVING MAX AREA(MAXIMUM 1)
	 */

	public int maxAreaOfIsland(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int maxAreaOfIsland = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					int curr = dfsMax(grid, i, j, row, col);
					maxAreaOfIsland = Math.max(curr, maxAreaOfIsland);
				}
			}
		}
		return maxAreaOfIsland;
	}

	private int dfsMax(int[][] grid, int i, int j, int row, int col) {
		if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) return 0;
		grid[i][j] = 2;
		return 1 + dfsMax(grid, i - 1, j, row, col) + dfsMax(grid, i + 1, j, row, col) + dfsMax(grid, i, j - 1, row, col) + dfsMax(grid, i, j + 1, row, col);
	}
}

/**
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of
 * the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */
class FloodFill{
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int target = image[sr][sc];
		if(target == newColor){
			return image;
		}
		dfs(sr,sc,target,newColor,image);
		return image;
	}
	private void dfs(int row,int col,int target,int newColor,int[][] image){
		if(row < image.length && row >= 0 && col < image[0].length && col >= 0 && image[row][col] == target) {
			image[row][col] = newColor;
			dfs(row - 1, col, target, newColor, image);
			dfs(row, col - 1, target, newColor, image);
			dfs(row + 1, col, target, newColor, image);
			dfs(row, col + 1, target, newColor, image);
		}
	}
}

class Pairs{
	int child;
    int parent;
  Pairs(int child,int parent){
	  this.child=child;
	  this.parent=parent;
  }
	public int getChild() {
		return child;
	}
	public int getParent() {
		return parent;
	}
}
class IsCyclic_BFS{
	boolean checkCyclicBFS(int src, List<List<Integer>> adj, int[] vis){
		vis[src]=1;
		Queue<Pairs> q=new LinkedList<>();
		q.add(new Pairs(src,-1));

		while(!q.isEmpty()){
			int node=q.peek().getChild();
			int parent=q.peek().getParent();
			q.poll();
			for(int adjNode: adj.get(node)){
				if(vis[adjNode]==0){
					vis[adjNode]=1;
					q.add(new Pairs(adjNode,node));
				}else{
					if(parent!=adjNode) return true;
				}
			}
		}
		return false;
	}

   Boolean isCyclic(int V,List<List<Integer>> adj){
		int[] vis=new int[V];
		Arrays.fill(vis,0);
		for(int i=0;i<V;i++){
			if(vis[i]==0){
				if(checkCyclicBFS(i,adj,vis)==true) return true;
			}
		}
		return false;
   }
}

class IsCyclic_DFS{

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		int vis[] = new int[V];
		Arrays.fill(vis,0);
		for(int i = 0;i<V;i++) {
			if(vis[i] == 0) {
				if(checkCyclicDFS(i, -1, vis, adj) == true) return true;
			}
		}
		return false;
	}
	private boolean checkCyclicDFS(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj) {
		vis[node] = 1;
		for(int adjacentNode: adj.get(node)) {
			if(vis[adjacentNode]==0) {
				if(checkCyclicDFS(adjacentNode, node, vis, adj) ==true) return true;
			}
			else if(adjacentNode != parent) return true;
		}
		return false;
	}
}

class IsCyclic_DFS_Directed {
	public static Boolean isCyclic(int[][] edges, int V, int e)
	{
		int vis[] = new int[V];
		int pathVis[] = new int[V];
		List<List<Integer>> adj = convertArrayToListGraph(edges,e,V);
		for(int i = 0;i<V;i++) {
			if(vis[i] == 0) {
				if(dfsCheck(i, adj, vis, pathVis) == true) return true;
			}
		}
		return false;
	}
	private static boolean dfsCheck(int node, List<List<Integer>> adj, int vis[], int pathVis[]) {
		if(vis[node]==2) return true; //if we get a node which is in progress, then its cyclic
		vis[node]=2; //node is in progress
		for(int it : adj.get(node)) {
				// when the node is not visited
			if(vis[it] == 0 || vis[it] == 2) {
				if(dfsCheck(it, adj, vis, pathVis))
					return true;
			}
		}

		vis[node] = 1; //Mark the node as visited once the dfs call get completed for that node
		return false;
	}

	private static List<List<Integer>> convertArrayToListGraph(int[][] edges,int e,int v) {
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<=v;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++) {
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		return adj;
	}
}

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
class RottingOranges {
	static class Pairs{
		int row;
		int col;
		int tm;
		public Pairs(int row, int col, int tm) {
			this.row = row;
			this.col = col;
			this.tm = tm;
		}
	}
	public static int orangesRotting(int[][] grid) {
		Queue<Pairs> q = new LinkedList<>();
		int row = grid.length;
		int col = grid[0].length;
		int[][] vis = new int[row][col];
		int freshCount = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 2) {
					q.add(new Pairs(i, j, 0));
					vis[i][j] = 2;
				}
				if (grid[i][j] == 1)
					freshCount++;
			}
		}

		int[] delRow = new int[]{-1, 0, 1, 0};
		int[] delCol = new int[]{0, 1, 0, -1};
		int rottenCount = 0;
		int time=0;

		while (!q.isEmpty()) {
			int r = q.peek().row;
			int c = q.peek().col;
			int tm = q.peek().tm;
			q.poll();
			time=Math.max(time,tm);
			for (int i = 0; i < 4; i++) {
				int nRow = r + delRow[i];
				int nCol = c + delCol[i];
				if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col &&
						vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
					vis[nRow][nCol] = 2;
					q.add(new Pairs(nRow, nCol, tm + 1));
					rottenCount++;
				}
			}
		}
		return freshCount == rottenCount ? time : -1;
	}

	public static void main(String[] args) {
		int[][] grid=new int[][]{{2,1,1},{1,1,0},{0,1,1}};
		System.out.println("RottingOranges="+orangesRotting(grid));
	}
}

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
class Surrounded_Regions {
	static int[] delRow = new int[]{-1, 0, 1, 0};
	static int[] delCol = new int[]{0, 1, 0, -1};
	public static void solve(char[][] board) {
		int row=board.length;
		int col=board[0].length;
		int[][] vis=new int[row][col];

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(i==0 || j==0 || i==row-1 || j==col-1 ){
					if(board[i][j]=='O') dfs(board,vis,i,j,row,col);
				}
			}
		}
		//Ans
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(vis[i][j]==0 && board[i][j]=='O') board[i][j]='X';
			}
		}

	}

	private static void dfs(char[][] board, int[][] vis, int r, int c,int row,int col) {

		vis[r][c]=1;
		for(int i=0;i<4;i++){
			int nRow=r+delRow[i];
			int nCol=c+delCol[i];

			if(nRow>=0 && nRow<row && nCol>=0 && nCol<col &&
			   vis[nRow][nCol]==0 && board[nRow][nCol]=='O' ){
				dfs(board,vis,nRow,nCol,row,col);
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(grid);
	}
}

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 *https://leetcode.com/problems/number-of-enclaves/
 */
class Number_Enclaves{
	static int[] delRow = new int[]{-1, 0, 1, 0};
	static int[] delCol = new int[]{0, 1, 0, -1};
	public static int numEnclaves(int[][] grid) {
        int row=grid.length;
		int col=grid[0].length;
		int[][] vis=new int[row][col];

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(i==0 || j==0 || i==row-1 || j==col-1 ){
					if(grid[i][j]==1) dfs(grid,vis,i,j,row,col);
				}
			}
		}

		//Ans
		int count=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j]==1 && vis[i][j]==0) count++;
			}
		}
		return count;
	}

	private static void dfs(int[][] grid, int[][] vis, int r, int c,int row,int col) {

		vis[r][c]=1;
		for(int i=0;i<4;i++){
			int nRow=r+delRow[i];
			int nCol=c+delCol[i];
			if(nRow>=0 && nRow<row && nCol>=0 && nCol<col && grid[r][c]==1 && vis[nRow][nCol]!=1){
				dfs(grid, vis, nRow, nCol, row, col);
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid=new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		System.out.println("numEnclaves="+numEnclaves(grid));
	}
}

 class  Distinct_Islands {
	 static int[] delRow = new int[]{-1, 0, 1, 0};
	 static int[] delCol = new int[]{0, 1, 0, -1};

	 public static int distinctIsland(int[][] grid) {
		 int row = grid.length;
		 int col = grid[0].length;
		 int[][] vis = new int[row][col];

		 Set<List<String>> set = new HashSet<>();
		 for (int i = 0; i < row; i++) {
			 for (int j = 0; j < col; j++) {
				 if (vis[i][j] == 0 && grid[i][j] == 1) {
					 List<String> list = new ArrayList<>();
					 dfs(grid, vis, list, i, j, i, j, row, col);
					 set.add(list);
				 }
			 }
		 }
		 return set.size();
	 }

	 private static void dfs(int[][] grid, int[][] vis, List<String> list, int r, int c, int r0, int c0, int row, int col) {
		 vis[r][c] = 1;
		 list.add(toString(r - r0, c - c0));
		 for (int i = 0; i < 4; i++) {
			 int nRow = r + delRow[i];
			 int nCol = c + delCol[i];
			 if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
				 dfs(grid, vis, list, nRow, nCol, r0, c0, row, col);
			 }
		 }
	 }

	 private static String toString(int r, int c) {
		 return Integer.toString(r) + " " + Integer.toString(c);
	 }
 }


/**
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary.
 * Find the order of characters in the alien language.
 * Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 *
 * Input:
 * N = 5, K = 4
 * dict = {"baa","abcd","abca","cab","cad"}
 * Output:
 * 1
 * Explanation:
 * Here order of characters is
 * 'b', 'd', 'a', 'c' Note that words are sorted
 * and in the given language "baa" comes before
 * "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 */
class Alien_Dictionary {
	public static String findOrder(String[] dict, int e, int v) {
		List<List<Integer>> adj=new ArrayList<>();
			for(int i=0;i<v;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<dict.length-1;i++){
           String s1=dict[i];
		   String s2=dict[i+1];
		   int len=Math.min(s1.length(),s2.length());
		   for(int j=0;j<len;j++){
			   if(s1.charAt(j)!=s2.charAt(j)){
				   adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
				   break;
			   }
		   }
		}

		List<Integer> toposort=topoSort(adj,e,v);
		String ans="";
		for(int i:toposort) ans=ans+ (char)(i + 'a');
		return ans;
	}

	private static List<Integer> topoSort(List<List<Integer>> adj, int e, int v) {
		int[] vis=new int[v];
		Stack<Integer> st=new Stack<>();
		List<Integer> ans=new ArrayList<>();
		for(int i=0;i<v;i++){
			if(vis[i]==0){
				dfs(adj,vis,st,i);
			}
		}
		while(!st.isEmpty()) ans.add(st.pop());
		return ans;
	}

	private static void dfs(List<List<Integer>> adj, int[] vis, Stack<Integer> st, int node) {
		vis[node]=1;

		for(int i:adj.get(node)){
			if(vis[i]==0){
				dfs(adj,vis,st,i);
			}
		}
		st.push(node);
	}

	public static void main(String[] args) {
		int e = 5, v = 4;
		String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
		System.out.println("Alien Dictionary="+findOrder(dict,5,4));
	}
}

/**
 * You are given a directed acyclic graph of 'N'  vertices(0 to 'N' - 1) and 'M' weighted edges.
 * Return an array that stores the distance(sum of weights) of the shortest path from vertex 0 to all vertices,
 * and if it is impossible to reach any vertex, then assign -1 as distance.
 * 'N' = 3, 'M' = 3, 'edges' = [0, 1, 2], [1, 2, 3], [0, 2, 6]].
 * Distance (0 to 0) = 0.
 * Distance (0 to 1) = 2.
 * Distance (0 to 2) = 0->1 + 1->2 = 2+3 = 5.
 * So our answer is [0, 2, 5].
 * shortest path Directed Acyclic graph - vertices and nodes are same.
 */
class Shortest_Path_DAG {
	static class Pair{
		int node;
		int wt;

		public Pair(int node, int wt) {
			this.node = node;
			this.wt = wt;
		}
	}
	public static int[] shortestPathInDAG(int [][]edges,int e,int v) {
		List<List<Pair>> adj=convertArrayToListGraph(edges,e,v);
		List<Integer> toposort=topoSort(adj,e,v);
		return shortestPathInDAGUtil(adj,toposort,e,v);
	}


	private static int[] shortestPathInDAGUtil(List<List<Pair>> adj,List<Integer> toposort,int e,int v) {
		int[] dist=new int[v];
		Arrays.fill(dist,(int)1e9);
		dist[0]=0;
		for(int i=0;i<toposort.size();i++){
			int node=toposort.get(i);
			for(Pair pair:adj.get(node)){
				int nNode=pair.node;
				int wt=pair.wt;
				dist[nNode]=Math.min(dist[node]+wt,dist[nNode]);
			}
		}
		for(int i=0;i<dist.length;i++){
			if(dist[i]==(int)1e9) dist[i]=-1;
		}
		return dist;
	}

	private static List<Integer> topoSort(List<List<Pair>> adj,int e,int v) {

		int[] vis=new int[v];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<v;i++){
			if(vis[i]==0){
				dfs(adj,vis,st,i);
			}
		}
		List<Integer> ans=new ArrayList<>();
		while(!st.isEmpty()) ans.add(st.pop());
		return ans;
	}

	private static void dfs(List<List<Pair>> adj, int[] vis, Stack<Integer> st, int node) {
		vis[node]=1;
		for(Pair pair:adj.get(node)){
			int nNode=pair.node;
			if(vis[nNode]==0){
				dfs(adj,vis,st,nNode);
			}
		}
		st.push(node);
	}

	private static List<List<Pair>> convertArrayToListGraph(int[][] edges, int e, int v) {
		List<List<Pair>> adj=new ArrayList<>();
		for(int i=0;i<v;i++){//Arraylist should be created for no.of nodes/vertices
			adj.add(new ArrayList<Pair>());
		}
		for(int i=0;i<edges.length;i++){
			int parent=edges[i][0];
			int child=edges[i][1];
			int wt=edges[i][2];
			adj.get(parent).add(new Pair(child,wt));
		}
		return adj;
	}

	public static void main(String[] args) {
		int v = 6, e = 7;
		int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
		System.out.println("Shortest_Path_DAG="+Arrays.toString(shortestPathInDAG(edge,e,v)));
	}
}

/**
 * You are given an undirected graph with 'n'  nodes and 'M'  edges. The weight of each edge in the graph is one unit.
 * Given a source vertex 'src' ,you must return an array of length 'N', where 'answer[i]' is the shortest path length between the source vertex 'src' and 'i'th vertex.
 * Input:
 * n=5, M=5, edges=[(0, 1), (1, 4), (2, 3), (2, 4), (3, 4)], src=1
 * Output: 1 0 2 2 1
 * shortest path undirected graph - vertices and nodes are same.
 */
class Shortest_Path_UG {
	public static int[] shortestPath(int n, int [][]edges, int src) {

		List<List<Integer>> adj=convertArrayToListGraph(edges,n);
		int[] dist=new int[n];
		Arrays.fill(dist,(int)1e9);
		dist[src]=0;
		Queue<Integer> q=new LinkedList<>();
		q.add(src);
		while(!q.isEmpty()){
			int node=q.poll();
			for(int i:adj.get(node)){
				int eDist=dist[i];
				int nDist=1+dist[node];
				if(nDist<eDist) {
					dist[i] = nDist;
					q.add(i);
				}
			}
		}
			for(int i=0;i<dist.length;i++){
				if(dist[i]==(int)1e9) dist[i]=-1;
			}
		return dist;
	}

	private static List<List<Integer>> convertArrayToListGraph(int[][] edges, int n) {
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++){ //Arraylist should be created for no.of nodes/vertices
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++){
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		return adj;
	}
	public static void main(String[] args) {
		int[][] edge = {{0,1},{0,3},{2,3}};
		System.out.println("Shortest_Path_UG="+Arrays.toString(shortestPath(4,edge,0)));
	}
}

class Shortest_Path_UG_Using_Set {
	static class Pair implements Comparable<Pair>{
		int node;
		int wt;
		public Pair(int node, int wt) {
			this.node = node;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair p) {
			if(p.wt<wt) return 1;
			else if(p.wt>wt) return -1;
			return 0;
		}
	}
	public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
		List<List<Pair>> adj=convertArrayToListGraph(edge,vertices);
		Integer[] dist=new Integer[vertices];
		Arrays.fill(dist,(int)1e9);
		dist[source]=0;
		Set<Pair> set=new TreeSet<>();
		set.add(new Pair(source,0));
		for(Pair pair:set){
			int node=pair.node;
			set.remove(pair);
			for(Pair p:adj.get(node)){
             int nNode=p.node;
			 int wt=p.wt;
			 int eDist=dist[nNode];
			 int nDist=wt+dist[node];
				if(nDist<eDist) {
					if(eDist!=(int)1e9) set.remove(p);
					dist[nNode] = nDist;
					set.add(new Pair(nNode,nDist));
				}
			}
		}
		List<Integer> ans=new ArrayList<>();
		for(int i=0;i<dist.length;i++){
			if(dist[i]==(int)1e9) ans.add(-1);
			else ans.add(dist[i]);
		}
		return ans;
	}
	private static List<List<Pair>> convertArrayToListGraph(int[][] edges, int vertices) {
		List<List<Pair>> adj=new ArrayList<>();
		for(int i=0;i<vertices;i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++){
			adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
			adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
		}
		return adj;
	}
}

/**
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * https://leetcode.com/problems/path-with-minimum-effort/description/
 * Dijikstra
 */
class  Path_With_Minimum_Effort {

	static int[] delRow = new int[]{-1, 0, 1, 0};
	static int[] delCol = new int[]{0, 1, 0, -1};

	public static int minimumEffortPath(int[][] heights) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		int row=heights.length;
		int col=heights[0].length;
		int[][] dist=new int[row][col];
		for(int[] arr:dist) Arrays.fill(arr,Integer.MAX_VALUE);
		dist[0][0]=0;
		pq.add(new int[]{0,0,0});
		while(!pq.isEmpty()){
			int[] pair=pq.poll();
			int r=pair[0];
			int c=pair[1];
			int dt=pair[2];
			if(r==row-1 && c==col-1) return dt;
			for(int i=0;i<4;i++){
				int nRow=r+delRow[i];
				int nCol=c+delCol[i];
				if(nRow>=0 && nRow<row && nCol>=0 && nCol<col){
					int newEffort= Math.abs(heights[r][c]-heights[nRow][nCol]);
					int maxEffort=Math.max(newEffort,dt);
					if(maxEffort<dist[nRow][nCol]){
						dist[nRow][nCol]=maxEffort;
						pq.add(new int[]{nRow,nCol,maxEffort});
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] height=new int[][]{{1,2,2},{3,8,2},{5,3,5}};
		System.out.println("minimumEffortPath="+minimumEffortPath(height));
	}
}

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */
class Cheapest_Flight {

	static class Pair{
		int child;
		int cost;
		Pair(int child,int cost){
			this.child=child;
			this.cost = cost;

		}
	}
	public static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
		List<List<Pair>> adj=convertArrayToListGraph(n,flights);
		int[] costArray=new int[n];
		Arrays.fill(costArray,(int)1e9);
		costArray[src]=0;
		Queue<int[]> q=new LinkedList();
		q.add(new int[]{0,src,0});
		while(!q.isEmpty()){
			int[] data=q.poll();
			int stop=data[0];
			int node=data[1];
			int cost=data[2];
			if(stop > k) continue;
			for(Pair pair:adj.get(node)){
				int aNode=pair.child;
				int aCost=pair.cost;
				int nCost=aCost+cost;
				if(nCost<costArray[aNode]){
					costArray[aNode]=nCost;
					q.add(new int[]{stop+1,aNode,nCost});
				}
			}
		}
		for(int i=0;i< costArray.length;i++){
		  if(costArray[i]==(int)1e9) costArray[i]=-1;
		}
		return costArray[dest];
	}

	private static List<List<Pair>>  convertArrayToListGraph(int n, int[][] flights) {
		List<List<Pair>> adj=new ArrayList<>();
		for(int i=0;i<n;i++)
			adj.add(new ArrayList<>());

		for(int i=0;i<flights.length;i++)
			adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
		return adj;
	}

	public static void main(String[] args) {
		int n = 2, src = 1, dst = 0, k = 0;
		int[][] flights={{0, 1, 2}};
		System.out.println("findCheapestPrice="+findCheapestPrice(n,flights,src,dst,k));
	}
}

/**
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 */
class Ways_To_Arrive_Destination {
	static class Pair{
		int child;
		int dist;
		Pair(int child,int dist){
			this.child=child;
			this.dist = dist;

		}
	}
	public static int countPaths(int n, int[][] roads) {
		List<List<Pair>> adj=convertArrayToListGraph(n,roads);
		int[] dist=new int[n];
		int[] ways=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		Arrays.fill(ways,0);
		dist[0]=0;
		ways[0]=1;
		int mod = (int)(1e9 + 7);
		PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
		q.add(new int[]{0,0});
		while (!q.isEmpty()){
			int[] data=q.poll();
			int dt=data[0];
			int node=data[1];
			for(Pair pair:adj.get(node)){
				int aNode=pair.child;
				int aDist=pair.dist;
				int nDist=aDist+dt;
				if(nDist<dist[aNode]){
					dist[aNode]=nDist;
					ways[aNode]=ways[node];
					q.add(new int[]{nDist,aNode});
				}else if(nDist==dist[aNode])
					ways[aNode]=(ways[aNode]+ways[node])%mod;
			}
		}
		return ways[n-1]%mod;
	}

	private static List<List<Pair>> convertArrayToListGraph(int n, int[][] roads) {
		List<List<Pair>> adj=new ArrayList<>();
		for(int i=0;i<n;i++){
          adj.add(new ArrayList<>());
		}
		for(int i=0;i<roads.length;i++){
			adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
			adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
		}
		return adj;
	}

	public static void main(String[] args) {
		int[][] roads=new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		System.out.println("countPaths="+countPaths(7,roads));
	}
}
/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words
 * in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 */
class Word_Ladder_I {
	static class Pair{
		String word;
		int level;

		public Pair(String word, int level) {
			this.word = word;
			this.level = level;
		}
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(beginWord,1));
		Set<String> set=new HashSet<>();
		for(String str:wordList) set.add(str);
		set.remove(beginWord);//since its visited
		while(!q.isEmpty()){
			Pair pair=q.poll();
			String word=pair.word;
			int level=pair.level;

			if(word.equals(endWord)) return level;

			for(int i=0;i<word.length();i++){
				for(char ch='a';ch<='z';ch++){
					char[] nWordArray=word.toCharArray();
					nWordArray[i]=ch;
					String nWord=new String(nWordArray);
					if(set.contains(nWord)){
						q.add(new Pair(nWord,level+1));
						set.remove(word);
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String startWord = "der", targetWord = "dfs";
		String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
		int ans = ladderLength(startWord, targetWord, Arrays.asList(wordList));
		System.out.print(ans);
	}
}

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
 * Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 */
class Word_LadderII {
	public static void main(String[] args) {
		String startWord = "der", targetWord = "dfs";
		String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
		List<List<String>>  ans = findLadders(startWord, targetWord, Arrays.asList(wordList));
		System.out.print(ans);
	}
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> set=new HashSet<>();
		for(String str:wordList) set.add(str);
		Queue<List<String>> q=new LinkedList<>();
		List<List<String>> ans=new ArrayList<>();
		List<String> usedOnLevel=new ArrayList<>();
		q.add(Arrays.asList(beginWord));
        int level=0;
		while(!q.isEmpty()){
			List<String> list=q.poll();
			if(list.size()>level){
				level++;
				for(String str:usedOnLevel) set.remove(str);
			}
			String word=list.get(list.size()-1);
			if(word.equals(endWord)){
				if(ans.size()==0) ans.add(list);
				else if(ans.get(0).size()>=list.size()) ans.add(list);
			}

			for(int i=0;i<word.length();i++){
				for(char ch='a';ch<='z';ch++){
					char[] nWordArray=word.toCharArray();
					nWordArray[i]=ch;
					String nWord=new String(nWordArray);
					if(set.contains(nWord)){
						List<String> nWordList=new ArrayList<>(list);
						nWordList.add(nWord);
						q.add(nWordList);
						usedOnLevel.add(nWord);
					}
				}
			}
		}
		return ans;
	}
}

/**
 * https://leetcode.com/problems/course-schedule/description/
 */
class Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; i++)
			adj.add(i, new ArrayList<Integer>());
		for (int i = 0; i < prerequisites.length; i++)
			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

		int[] visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++){
			if (visited[i] == 0 && isCyclicDFS(i, adj, visited))
				return false;
		}
		return true;


	}

	static boolean isCyclicDFS(int i, List<List<Integer>> adj, int[] visited) {
		if (visited[i] == 2)//processing node.
			return true;//if it's reaching the node which is in processing,then there is a cycle. Found cycle

		if (visited[i] == 1)//processed node.
			return false;
		visited[i] = 2; //make the node is in processing mode

		for (int val : adj.get(i)) {
			if (isCyclicDFS(val, adj, visited))
				return true;
		}

		visited[i] = 1;//processed node
		return false;//no cycle
	}
}
/**
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output:[0,2,1,3] Explanation: There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * 
 * @author 
 *
 */
class Topological_Sort {
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] res = findOrder(numCourses, prerequisites);
		for (int i : res)
			System.out.print(i + " ");
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; i++)
			adj.add(i, new ArrayList<Integer>());
		for (int i = 0; i < prerequisites.length; i++)
			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

		int[] visited = new int[numCourses];
		Stack<Integer> stack = new Stack<>();// push the resultant element in the stack
		for (int i = 0; i < numCourses; i++) {
			if (isCyclicDFS(i, adj, visited, stack))
				return new int[0];
		}

		// Answer preparations
		int[] result = new int[numCourses];
		int i = 0;
		while (!stack.isEmpty()) {
			result[i++] = stack.pop();
		}
		return result;

	}
	static boolean isCyclicDFS(int i, List<List<Integer>> adj, int[] visited, Stack<Integer> stack) {
		if (visited[i] == 2)//processing node.
			return true;//if it's reaching the node which is in processing,then there is a cycle. Found cycle
		if (visited[i] == 1)//processed node.
			return false;
		visited[i] = 2; //make the node is in processing mode

		for (int val : adj.get(i)) {
			if (isCyclicDFS(val, adj, visited, stack))
				return true;
		}

		visited[i] = 1;//processed node
		stack.add(i); //to find the order of adj nodes
		return false;//no cycle
	}
}


//Java program to find the size
//of the largest tree in the forest
class LargestTree {

	static int vertices;
	static LinkedList<Integer>[] adj_list;
	static int[] visited;
	LargestTree(int v){
		vertices=v;
		adj_list=new LinkedList[vertices+1];
		for(int i=0;i<vertices+1;i++)
			adj_list[i]=new LinkedList<>();
		visited=new int[vertices+1];
	}
	//A utility function to add
	//an edge in an undirected graph.
	private static void add_an_edge(int i, int j) {
		adj_list[i].add(j);
		adj_list[j].add(i);
	}
	


//A utility function to perform DFS of a
//graph recursively from a given vertex u
//and returns the size of the tree formed by u
	static int DFSUtil(int u) {
		visited[u]=1;
		int sz = 1;

//Iterating through all the nodes
		for (int i = 0; i < adj_list[u].size(); i++)
			if (visited[adj_list[u].get(i)] == 0)

				// Perform DFS if the node is
				// not yet visited
				sz += DFSUtil(adj_list[u].get(i));
		return sz;
	}

//Function to return the size of the
//largest tree in the forest given as
//the adjacency list
	static int largestTree(int V) {
		int answer = 0;

//Iterating through all the vertices
		for (int u = 0; u < V; u++) {
			if (visited[u] == 0) {
				// Find the answer
				answer = Math.max(answer, DFSUtil(u));
			}
		}
		return answer;
	}

//Driver code
	public static void main(String[] args) {
		int V = 5;
		LargestTree graph=new LargestTree(V);
		
		add_an_edge( 0, 1);
		add_an_edge(0, 2);
		add_an_edge(3, 4);
		System.out.print(largestTree(V));
	}
}

class LargestTreeInForest {
	int find(int a, int[] parent) {
		if (parent[a] == -1) {
			return a;
		}
		parent[a] = find(parent[a], parent);
		return parent[a];
	}

	public int countComponents(int n, int[][] edges) {
		int count = n;
		int parent[] = new int[n + 1];
		Arrays.fill(parent, -1);
		for (int i = 0; i < edges.length; i++) {
			int x = find(edges[i][0], parent);
			int y = find(edges[i][1], parent);
			//System.out.println(x+"  "+y);
			if (x != y) {
				parent[x] = y;
				count--;
			}
		}

		for (int i = 1; i <= n; i++) {
			find(i, parent);
		}

		HashMap<Integer, Integer> h = new HashMap<>();
		int NoOfChildrean = 0;
		int root = 0;
		for (int i = 1; i <= n; i++) {
			int max = h.getOrDefault(parent[i], 0);
			h.put(parent[i], max + 1);
			if (NoOfChildrean < (max + 1)) {
				NoOfChildrean = max + 1;
				root = parent[i];
			}
		}
		System.out.println(root);
		return root;
	}
}


/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */

class WordSearch {
	public boolean exist(char[][] board, String word) {
		int row=board.length;
		int col=board[0].length;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]==word.charAt(0) && dfs(board,i,j,0,word)){
					return true;
				}
			}
		}
		return false;

	}

	private boolean dfs(char[][] board, int i, int j,int count, String word) {
		if(count==word.length()) return true;

		if(i>=board.length || i<0 || j>=board[i].length || j<0 || word.charAt(count)!=board[i][j])
			return false;
		char temp=board[i][j];
		board[i][j]=' ';/*The same letter cell may not be used more than once.*/

		boolean found= dfs(board, i-1, j, count+1, word)
				    || dfs(board, i+1, j, count+1, word)
		            || dfs(board, i, j-1, count+1, word)
				    || dfs(board, i, j+1, count+1, word);
			board[i][j]=temp;
		return found;
	}
}