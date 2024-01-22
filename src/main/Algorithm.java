package main;

public class Algorithm {
	public static void main(String[] args) {

	}
}


class Prims_Algorithm{
	
	static int I=32767;

	public static void main(String[] args) {
	    int[][] cost ={
            {I, I, I, I, I, I, I, I},
            {I, I, 25, I, I, I, 5, I},
            {I, 25, I, 12, I, I, I, 10},
            {I, I, 12, I, 8, I, I, I},
            {I, I, I, 8, I, 16, I, 14},
            {I, I, I, I, 16, I, 20, 18},
            {I, 5, I, I, I, 20, I, I},
            {I, I, 10, I, 14, 18, I, I},
    };
 
    int n =cost[0].length;
 
   int[][] t= PrimsMST(cost, n);
   System.out.println("Min cost spanning tree is::");
     for(int i=0;i<t[0].length;i++) 
    		 System.out.println(t[0][i]+","+t[1][i]);
    	 
	}
	
	private static int[][] PrimsMST(int[][] cost, int n) {
		int min = I;
		int u = 0, v = 0;

		int[] near = { I, I, I, I, I, I, I, I };
		int[][] t = new int[2][6];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (cost[i][j] < min) {
					min = cost[i][j];
					u = i;
					v = j;
				}
			}
		}
		near[u] = near[v] = 0;
		t[0][0] = u;
		t[1][0] = v;
		for (int i = 1; i < n; i++) {
			if (near[i] != 0)
				if (cost[i][u] < cost[i][v])
					near[i] = u;
				else
					near[i] = v;
		}
		// ---------End of initialization-----------
		int index = 1;
		while (index < n - 2) { // spanning tree edges= no.of vertices-1. There are 7 vertices/nodes,For making spanning
								// tree, we need n-1, 7-1, 6 nodes
								// one node was found and remaining 5 nodes are there. so we written condition
								// for 5 iterations.
			min = I;

			for (int i = 1; i < n; i++) {
				if (near[i] != 0 && cost[i][near[i]] < min) {
					min = cost[i][near[i]];
					u = i;
					v = near[i];
				}
			}
			t[0][index] = u;
			t[1][index] = v;
			index++;
			near[u] = 0;
			near[v] = 0;
			for (int i = 1; i < n; i++) {
				if (near[i] != 0 && cost[u][i] < cost[i][near[i]]) {
					near[i] = u;
				}
			}
		}

		return t;

	}
}

class Kruskal_Algorithm{
	
	static int I=32767;
	static int[] set;
	public static void main(String[] args) {
		int[][] edges = {{ 1, 1,  2,  2, 3,  4,  4,  5,  5},
                         { 2, 6,  3,  7, 4,  5,  7,  6,  7},
                         {25, 5, 12, 10, 8, 16, 14, 20, 18}};

        int t[][]=KruskalsMCST(edges);
        System.out.println("Min cost spanning tree is::");
        for(int i=0;i<t[0].length;i++) 
       		 System.out.println(t[0][i]+","+t[1][i]);
       	 
   	
	}
	
	private static int[][] KruskalsMCST(int[][] edges) {
		set=new int[edges[0].length];
		int[] included=new int[9];
		int[][] t = new int[2][6];
		int u=0,v=0,k=0;
		
		int e=9;
		int index=0;
		while(index<6){
			int min=I;
		for(int i=0;i<e;i++) {
			if(included[i]==0 && edges[2][i]<min) {
				min=edges[2][i];
				u=edges[0][i];
				v=edges[1][i];
				k=i;
			}
		}
		if(find(u)!=find(v)) {
			t[0][index]=u;
			t[1][index]=v;
			index++;
			union(find(u),find(v));
		}
		included[k]=1;
	}
		return t;
	}

	public static void union(int u, int v) {
		if(set[u]<set[v]) {
			set[u]=set[u]+set[v];
			set[v]=u;
		}else {
			set[v]=set[u]+set[v];
			set[u]=v;
		}
	}
	
	public static int find(int x) {
		
		while(set[x]>0)
			x=set[x];
		
		return x;
	}
}
