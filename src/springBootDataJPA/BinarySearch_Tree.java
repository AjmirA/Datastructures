package springBootDataJPA;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BinarySearch_Tree {
	public static void main(String[] args) {

	}
}

class BSTData{
	TreeNode root1;
	TreeNode root2;

	BSTData() {
		TreeNode r1 = new TreeNode(4);
		r1.left = new TreeNode(2);
		r1.right = new TreeNode(6);
		r1.left.left = new TreeNode(1);
		r1.left.right = new TreeNode(3);
		r1.right.left = new TreeNode(5);
		r1.right.right = new TreeNode(7);

		this.setRoot1(r1);
	}
        
	public TreeNode getRoot1() {
		return root1;
	}
	public void setRoot1(TreeNode root1) {
		this.root1 = root1;
	}
	public TreeNode getRoot2() {
		return root2;
	}
	public void setRoot2(TreeNode root2) {
		this.root2 = root2;
	}
}

class SearchKey_in_BST {
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		searchBST(root, 5);
	}

	public static TreeNode searchBST(TreeNode root, int val) {
		
		while(root!=null) {
			if(val<root.val)
				root=root.left;
			else if(val>root.val)
				root=root.right;
			else if(root.val==val)
				return root;
		}
		
		return null;

	}
}

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * 
 * A height-balanced binary tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one.
 * 
 * Input: nums = [-10,-3,0,5,9] 
 * Output: [0,-3,9,-10,null,5] 
 * Explanation:[0,-10,5,null,-3,null,9] is also accepted:
 * 
 * @author 
 *
 */
class Convert_Sorted_Array_to_BST {

	public static void main(String[] args) {

		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode t=sortedArrayToBST(nums);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {

		return func(nums, 0, nums.length - 1);
	}

	private static TreeNode func(int[] nums, int low, int high) {
		if (low > high)
			return null;
		int mid =low +(high-low)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = func(nums, low, mid - 1);
		node.right = func(nums, mid + 1, high);
		return node;
	}
}

/**
 * A valid BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. 
 * The right subtree of a node contains only nodes with keys greater than
 * the node's key.
 * Both the left and right subtrees must also be binary search
 * trees.
 * 
 * @author 
 *
 */

class Validate_BST {
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		isValidBST(root);
	}

	public static boolean isValidBST(TreeNode root) {

		Boolean left = checkBST(root.left, Integer.MIN_VALUE, root.val);
		Boolean right = checkBST(root.right, root.val, Integer.MAX_VALUE);
		if (left && right)
			return true;
		return false;
	}

	public static boolean checkBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val > min && root.val < max)
			return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);

		return false;

	}
}

class LCA {
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		System.out.println("LCA::"+lowestCommonAncestor(root,5,3));
	}
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
          if(p<root.val && q<root.val)
             return func(root.left,p,q);
         else if(p>root.val && q>root.val)
             return func(root.right,p,q);
        else return func(root,p,q);
    }
    public static TreeNode func(TreeNode root, int p, int q) {
        
        if(root==null) return null;
        if(root.val==q || root.val==p) return root;
       TreeNode left=  func(root.left,p,q);
        TreeNode right=  func(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        if(left!=null) return left;
        else return right;
    }
}

class NextRight_Node {
	public int val;
	public NextRight_Node left;
	public NextRight_Node right;
	public NextRight_Node next;

	public NextRight_Node() {
	}

	public NextRight_Node(int _val) {
		val = _val;
	}

	public NextRight_Node(int _val, NextRight_Node _left, NextRight_Node _right, NextRight_Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
class NextRight_Pointers {
	public static void main(String[] args) {
		NextRight_Node r1 = new NextRight_Node(1);
		r1.left = new NextRight_Node(2);
		r1.right = new NextRight_Node(3);
		r1.left.left = new NextRight_Node(4);
		r1.left.right = new NextRight_Node(5);
		r1.right.left = new NextRight_Node(6);
		r1.right.right = new NextRight_Node(7);
		NextRight_Node res=connect(r1);
		Queue<NextRight_Node> q=new LinkedList();
		q.add(res);
		while(!q.isEmpty()) {
			NextRight_Node n = q.poll();
			if (n != null) {
				if (n.next != null)
					System.out.println(n.val + "->" + n.next.val);
				else
					System.out.println(n.val + "->" + n.next);
				q.add(n.left);
				q.add(n.right);
		}
			
			
		}
	}

	public static NextRight_Node connect(NextRight_Node root) {
		Queue<NextRight_Node> q = new LinkedList();
		Queue<NextRight_Node> q2 = new LinkedList();
		q.add(root);
		while (!q.isEmpty() || !q2.isEmpty()) {
			NextRight_Node prev = null;
			while (!q.isEmpty()) {
				NextRight_Node n = q.poll();
				if (n != null) {
					n.next = prev;
					q2.add(n.right);
					q2.add(n.left);
					prev = n;
				}
			}
			prev = null;
			while (!q2.isEmpty()) {
				NextRight_Node n = q2.poll();
				if (n != null) {
					n.next = prev;
					q.add(n.right);
					q.add(n.left);
					prev = n;
				}
			}
		}

		return root;

	}
}
class Predecessor_Successor{
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		findPreSuc(root,3);
		System.out.println(pre.val);
		System.out.println(suc.val);
	}

static TreeNode pre = null;
static TreeNode suc = null;

	static void findPreSuc(TreeNode root, int key) {
		if(root==null) return;
		if(root.val==key) {
			
			if(root.left!=null) {
				TreeNode tmp=root.left;
				while(tmp.right!=null)
					tmp=tmp.right;
				pre=tmp;
			}
			
			if(root.right!=null) {
				TreeNode tmp=root.right;
				while(tmp.left!=null)
					tmp=tmp.left;
				suc=tmp;
			}
			
		}
		
		if(root.val>key)
			findPreSuc(root.left,key);
		else
			findPreSuc(root.right,key);
	}
}
/**
 * Find K-th smallest and K-th largest element in BST (2 different Questions) 
 * @author 
 *
 */
class Kth_Smallest_Element{
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		int[] k= {1};
		System.out.println("findKthSmallest::"+ findKthSmallest(root,k));
		int[] n= {8};
		System.out.println("findKthLargest::"+ findKthLargest(root,n));
	}

	private static int findKthSmallest(TreeNode root, int[] k) {
		if(root==null) return 0;		
		int left=findKthSmallest(root.left,k);
		k[0]=k[0]-1;
		if(k[0]==0) return root.val;
		int right=findKthSmallest(root.right,k);
		
		if(left!=0) return left;
		else return right;
	}
	
	private static int findKthLargest(TreeNode root, int[] k) {
		if(root==null) return 0;		
		int right=findKthLargest(root.right,k);
		k[0]=k[0]-1;
		if(k[0]==0) return root.val;
		int left=findKthLargest(root.left,k);
		
		if(left!=0) return left;
		else return right;
	}
}

/**
 * Given the root of a Binary Search Tree and a target number k, return true if
 * there exist two elements in the BST such that their sum is equal to the given
 * target.
 * 
 * @author 
 *
 */
class Find_Sum {
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		System.out.println("findTarget::" + findTarget(root, 10));
	}

	static Set<Integer> collection = new HashSet<>();

	public static boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		if (collection.contains(k - root.val))
			return true;
		collection.add(root.val);
		return (findTarget(root.left, k) || findTarget(root.right, k));
	}
}

/**
 * Convert Sorted Array to Binary Search Tree/ Given an integer array nums
 * where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 * 
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * 
 * @author 
 *
 */
class S_Array_BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        	return func(nums, 0, nums.length - 1);
    }
    private static TreeNode func(int[] nums, int low, int high) {
		if (low > high)
			return null;
		int mid =low +(high-low)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = func(nums, low, mid - 1);
		node.right = func(nums, mid + 1, high);
		return node;
	}
}

/**
 * Implement the BSTIterator class that represents an iterator over the in-order
 * traversal of a binary search tree (BST):
 * 
 * 1) BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor. The pointer should
 * be initialized to a non-existent number smaller than any element in the BST.
 * 2) boolean hasNext() Returns true if there exists a number in the traversal to
 * the right of the pointer, otherwise returns false. 
 * 3) int next() Moves the pointer to the right, then returns the number at the pointer.
 * 
 * @author 
 *
 */
class BST_Iterator{
	  Stack<TreeNode> s=new Stack();
	    int index=0;
	    public BST_Iterator(TreeNode root) {
	        partialInorder(root);
	    }
	    
	    public int next() {
	        TreeNode n=s.pop();
	        partialInorder(n.right);
	        return n.val;
	    }
	    
	    public boolean hasNext() {
	        return !s.isEmpty();
	    }
	    
	    public void partialInorder(TreeNode root){
	        while(root!=null){
	        s.push(root);
	            root=root.left;
	        }
	       
	    }
	    public static void main(String[] args) {
	    	BSTData t = new BSTData();
			TreeNode root = t.getRoot1();
			BST_Iterator obj=new BST_Iterator(root);
			System.out.println("Next::"+obj.next());
			System.out.println("hasNext::"+obj.hasNext());
			System.out.println("Next::"+obj.next());
			System.out.println("hasNext::"+obj.hasNext());
			System.out.println("Next::"+obj.next());
			System.out.println("hasNext::"+obj.hasNext());
		}

}


class Serialize{
	
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		String serialize=serialize(root);
		TreeNode deSerialize=deserialize(serialize);
		System.out.println("serialize::"+serialize);
		Right_Left_View_BT bt=new Right_Left_View_BT();
		bt.print(deSerialize, "Deserialize"); //print method in BT class. Just calling to print values
	}


	private static String serialize(TreeNode root) {
		 
		Queue<TreeNode> q=new LinkedList<>();
		String res="";
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode n=q.poll();
			if(n!=null) {
			res=res+n.val+",";
			q.add(n.left);
		    q.add(n.right);
			}
			else res=res+"#,";
		}
		return res;
	}
	
static int i=0;

private static TreeNode deserialize(String str) {
	Queue<TreeNode> q=new LinkedList<>();
	String[] values=str.split(",");
	TreeNode root=new TreeNode(Integer.parseInt(values[0]));
	q.add(root);
	for (int index = 1; index < values.length; index++) {
		TreeNode t=q.poll();
		if(!values[index].equalsIgnoreCase("#")){
			TreeNode left=new TreeNode(Integer.parseInt(values[index]));
			t.left=left;
			q.add(left);
		}
		if(!values[++index].equalsIgnoreCase("#")){
			TreeNode right=new TreeNode(Integer.parseInt(values[index]));
			t.right=right;
			q.add(right);
		}
	}
	return root;
	
}
		
}

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range
 * [low, high].
 * 
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * @author 
 *
 */
class RangeSumBST {
	public static void main(String[] args) {
		BSTData t = new BSTData();
		TreeNode root = t.getRoot1();
		System.out.println("rangeSumBST::"+rangeSumBST(root,3,6));
	}

	public static int rangeSumBST(TreeNode root, int low, int high) {
		
		if(root==null) return 0;
		if(root.val<low) return rangeSumBST(root.right,low,high);
		if(root.val>high)return rangeSumBST(root.left,low,high);
		return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);

	}
}