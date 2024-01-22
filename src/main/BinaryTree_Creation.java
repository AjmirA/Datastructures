package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


class TreeNode {
	
	TreeNode leftChild;
	TreeNode rightChild;
	int data;
	int distFromRoot;//This field (height) is for AVL tree only
	public TreeNode(int data) {
		this.data = data;
	}
}

class Queue{
	 Object data;
	 Queue next;
	 public Queue(Object data) {
		this.data = data;
	}	 
}

class QueueImpl{
	 Queue front;
	 Queue rear;
	void enqueue(Object d) {
		Queue q=new Queue(d);
		if(front==null) front=q;
		if(rear==null) 
			rear=front;
		else
			rear.next=q;
		rear=q;
	}
	
	Object dequeue() {
		Object data = 0;
		if (front != null) {
			data = front.data;
			front = front.next;
		}
		return data;
	}
	
	Object poll() {
		if (front != null) 
			return front.data;
		return 0;	
	}
	
	void print() {
		 Queue f=front;
		 System.out.println("\nPrint::");
		 while(f!=null) {
			 System.out.print(f.data+",");
			 f=f.next;
		 }
		}
	Boolean isEmpty() {
		return front==null;
	}
	}
 class QueueDriver{
	public static void main(String[] args) {
		QueueImpl q=new QueueImpl();
	    q.enqueue(10); 
        q.enqueue(30); 
        q.enqueue(50); 
        q.enqueue(70); 
        q.print();
        q.dequeue();
        q.print();
        System.out.println("\nPoll="+q.poll());
        q.dequeue();
        q.print();
        System.out.println("\nPoll="+q.poll());
        q.enqueue(701);
        q.enqueue(702); 
        q.dequeue();
        q.print();
   	}
 }
	
public class BinaryTree_Creation{
	
	public static void main(String[] args) {
		TreeNode tr=create();
		System.out.println("\nPreOrder::");
		preOrderPrint(tr);
		System.out.println("\nPostOrder::");
		postOrderPrint(tr);
		System.out.println("\nInOrder::");
		inOrderPrint(tr);
		int noOfNodes=countNode(tr);
		System.out.println("\nNo of nodes::"+noOfNodes);
		int countNode_BothMandaory=countNode_BothMandaory(tr);
		System.out.println("\nNo of nodes who are having both left and right child::"+countNode_BothMandaory);
		ArrayList<Integer> array=new ArrayList<>();
		serialize(tr,array);
		System.out.println("Serialized Array::"+array);
		TreeNode de_Root= deserialization(array);
		System.out.println("PreOrder After Deserialized::");
		preOrderPrint(de_Root);
		verticalOrderTraversal(tr);
		System.out.println("\nLevel Order Traversal::");
		levelOrder(tr);
		convertToBinarySearchTree(tr);
		System.out.println("\nPreOrder For BST::");
		preOrderPrint(tr);
	}

	private static void convertToBinarySearchTree(TreeNode tr) {
		int[] array = new int[countNode(tr)];
		storeNodeIn_InOrderForm(tr, array);

		System.out.println("\nSORTED INORDER ARRAY::");
		Arrays.sort(array);

		for (int i : array)
			System.out.print(i + ",");
		create_Binary_Search_Tree(tr, array);
	}
	static int indexJ=0;
	private static void create_Binary_Search_Tree(TreeNode tr, int[] array) {
		
		if(tr==null) {
			return;
		}
		
			create_Binary_Search_Tree(tr.leftChild,array);
			System.out.println("indexJ="+indexJ);
			tr.data=array[indexJ];
			indexJ++;
			create_Binary_Search_Tree(tr.rightChild,array);
		
		
	}
	static int i=0;
	private static void storeNodeIn_InOrderForm(TreeNode tr,int[] array) {
		if (tr != null) {
			storeNodeIn_InOrderForm(tr.leftChild, array);
			array[i] = tr.data;
			i++;
			storeNodeIn_InOrderForm(tr.rightChild, array);
		}

	}
	private static int countNode(TreeNode tr) {
		while(tr!=null) {
			int x=countNode(tr.leftChild);
			int y=countNode(tr.rightChild);
			return x+y+1;
		}
		return 0;
	}
	private static int countNode_BothMandaory(TreeNode tr) {
		while (tr != null) {
			int x = countNode(tr.leftChild);
			int y = countNode(tr.rightChild);
			if (tr.leftChild != null && tr.rightChild != null && tr.leftChild.data != -1 && tr.rightChild.data != -1)
				return x + y + 1;
			else
				return x + y;
		}
		return 0;
	}
	static void preOrderPrint(TreeNode t) {
		if(t!=null) {
			System.out.print(t.data+",");
			preOrderPrint(t.leftChild);
			preOrderPrint(t.rightChild);
		}
	}
	
	static void postOrderPrint(TreeNode t) {
		if(t!=null) {
			postOrderPrint(t.leftChild);
			postOrderPrint(t.rightChild);
			System.out.print(t.data+",");
		}
	}
	
	static void inOrderPrint(TreeNode t) {
		if(t!=null) {
			inOrderPrint(t.leftChild);
			System.out.print(t.data+",");
			inOrderPrint(t.rightChild);
		}
	}
	
	static TreeNode create() {
		QueueImpl q=new QueueImpl();
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Root:");
		int val=sc.nextInt();
		TreeNode root=new TreeNode(val);
		root.leftChild=null;
		root.rightChild=null;
		root.distFromRoot=0;
		q.enqueue(root);
		while(!q.isEmpty()) {
			TreeNode m=(TreeNode)q.dequeue();
			System.out.print("Enter left child of "+m.data+"-->");
			int left=sc.nextInt();
			if(left!=-1) {
				TreeNode newNode=new TreeNode(left);
				newNode.leftChild=null;
				newNode.rightChild=null;
				newNode.distFromRoot=m.distFromRoot-1;
				m.leftChild=newNode;
				q.enqueue(newNode);
			}
			
			System.out.print("\nEnter Right child "+m.data+"-->");
			int right=sc.nextInt();
			if(right!=-1) {
				TreeNode newNode=new TreeNode(right);
				newNode.leftChild=null;
				newNode.rightChild=null;
				newNode.distFromRoot=m.distFromRoot+1;
				m.rightChild=newNode;
				q.enqueue(newNode);
			}
		}
		return root;
	}
	
	//Have to write in PREORDER way
	static void serialize(TreeNode root,ArrayList<Integer> array) {
		if(root==null || root.data==-1) {
			array.add(-1);
			return;
		}
		
		array.add(root.data);
		serialize(root.leftChild, array);
		serialize(root.rightChild, array);
		
	}
	
	static int index=0;
	static TreeNode deserialization(ArrayList<Integer> array) {
		
		if(index==array.size() || array.get(index)==-1) {
			index=index+1;
			return null;
		}
		
		TreeNode root=new TreeNode(array.get(index));
		index=index+1;
		root.leftChild=deserialization(array);
		root.rightChild=deserialization(array);
		
		return root;
	}
	
	static TreeMap<Integer, List<TreeNode>> verticalOrderTraversal(TreeNode root){
		QueueImpl q=new QueueImpl();
		TreeMap <Integer, List<TreeNode>>  res=new TreeMap <>();
		List<TreeNode> data;
		q.enqueue(root);
		while(!q.isEmpty()) {
			TreeNode m=(TreeNode)q.dequeue();
			
			if(res.containsKey(m.distFromRoot))
			      data=res.get(m.distFromRoot);
			else
				data= new ArrayList<TreeNode>();
			
			data.add(m);
			res.put(m.distFromRoot, data);
			if(m.leftChild!=null) 
				q.enqueue(m.leftChild);
			if(m.rightChild!=null) 
				q.enqueue(m.rightChild);
			
		}
		System.out.println("\nVertical Order Traversal::");
		for(Entry<Integer, List<TreeNode>> entry : res.entrySet()) {
			  List<TreeNode> value = entry.getValue();
			  for(TreeNode tr:value)
			    System.out.print(tr.data+" ");
			}
		return res;
		
	} 
	
	static void levelOrder(TreeNode tr) {
		QueueImpl q=new QueueImpl();
		q.enqueue(tr);
		while(!q.isEmpty()) {
		 TreeNode m=(TreeNode) q.dequeue();
		 System.out.print(m.data+",");
		 if(m.leftChild!=null && m.leftChild.data!=-1)
			 q.enqueue(m.leftChild);
		 if(m.rightChild!=null && m.rightChild.data!=-1)
			 q.enqueue(m.rightChild);
		}
	}
}

class Binary_Search_Tree{
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(30);
		insert(root,15);
		insert(root,50);
		insert(root,10);
		insert(root,20);;
		insert(root,40);
		insert(root,60);
		
		insert(root,16);
		insert(root,19);
		insert(root,13);
		insert(root,8);
		insert(root,22);

		
		System.out.println("\nInorder::");
		inOrderPrint(root);
		System.out.println("\nPreorder::");
		preOrderPrint(root);
		delete(root, 30);
		System.out.println("\n---After 30 DELETED---");
		System.out.println("\nInorder::");
		inOrderPrint(root);
		System.out.println("\nPreorder::");
		preOrderPrint(root);
	}
	
	TreeNode search(TreeNode root, int key) {
		while (root != null) {
			if (root.data == key)
				return root;
			else if (root.data < key)
				root = root.rightChild;
			else
				root = root.leftChild;
		}
		return null;
	}
	
	static void insert(TreeNode root,int key) {
		
		TreeNode t=root;
		TreeNode r=root;
		
		/*Iteration to find current and prev node*/
		while (t != null) {
			 if (t.data < key) {
				r=t;
				t=t.rightChild;
			}
			else {
				r=t;
				t=t.leftChild;
			}
		}
		
		TreeNode newNode=new TreeNode(key);
		if(key<r.data) 
			r.leftChild=newNode;
		else
			r.rightChild=newNode;
	}
	
	static void delete(TreeNode root,int key) {
		
		TreeNode t=root;
		TreeNode r=root;
		while (t != null) {
			if (t.data < key) {
				r = t;
				t = t.rightChild;
			}else if(t.data>key) {
				r=t;
				t=t.leftChild;
				
			}else { //when key got found
				if(t.leftChild==null && t.rightChild==null) { //leaf node
					if (r.data < key) {
						r.rightChild = null;
						t=null;
					}
					else {
						r.leftChild = null;
						t=null;
					}
				}else if(t.leftChild==null ^ t.rightChild==null){ //Node which is o be deleted is having one child
					
					if (r.data < key) {
						  if(t.rightChild!=null) {
						    r.rightChild = t.rightChild;
						    t=null;
						  }
						  else {
							  r.rightChild=t.leftChild;
							  t=null;
						  }
					}
					else {
						if (t.rightChild != null)
							r.leftChild = t.rightChild;
						else
							r.leftChild = t.leftChild;
					}
				}
				else {
					TreeNode q=InPre(t.leftChild);
					t.data=q.data;
					delete(t.leftChild,q.data);
				}
			}
		}
	}
	
	static TreeNode InPre(TreeNode p) {
	    while (p!=null && p.rightChild != null){
	        p=p.rightChild;
	    }
	    return p;
	}
	
	/*Inorder traversal will give sorted order*/
	static void inOrderPrint(TreeNode t) {
		if(t!=null) {
			inOrderPrint(t.leftChild);
			System.out.print(t.data+",");
			inOrderPrint(t.rightChild);
		}
	}
	static void preOrderPrint(TreeNode t) {
		if(t!=null) {
			System.out.print(t.data+",");
			preOrderPrint(t.leftChild);
			preOrderPrint(t.rightChild);
		}
	}
}

class AVL_Tree{
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
		insert(root,5);
		insert(root,2);
		System.out.println("\nPreorder::");
		preOrderPrint(root);
		root=avlLogic(root);
		System.out.println("\nPreorder::");
		preOrderPrint(root);
	}
static void insert(TreeNode root,int key) {
		
		TreeNode t=root;
		TreeNode r=root;
		/*Iteration to find current and prev node*/
		while (t != null) {
			 if (t.data < key) {
				r=t;
				t=t.rightChild;
			}
			else {
				r=t;
				t=t.leftChild;
			}
		}
		
		TreeNode newNode=new TreeNode(key);
		if(key<r.data) 
			r.leftChild=newNode;
		else
			r.rightChild=newNode;
		

	}

private static TreeNode avlLogic(TreeNode r) {
    // Balance Factor and Rotation
    if (balanceFactor(r) == 2 && balanceFactor(r.leftChild) == 1) {
        return LLRotation(r,r);
    } else if (balanceFactor(r) == 2 && balanceFactor(r.leftChild) == -1){
        return LRRotation(r);
    } else if (balanceFactor(r) == -2 && balanceFactor(r.rightChild) == -1){
        return RRRotation(r);
    } else if (balanceFactor(r) == -2 && balanceFactor(r.rightChild) == 1){
        return RLRotation(r);
    }
	return r;
}

private static TreeNode RLRotation(TreeNode r) {
	// TODO Auto-generated method stub
	return null;
}
private static TreeNode RRRotation(TreeNode r) {
	// TODO Auto-generated method stub
	return null;
}
private static TreeNode LRRotation(TreeNode r) {
	// TODO Auto-generated method stub
	return null;
}
private static TreeNode LLRotation(TreeNode p,TreeNode root) {
	TreeNode pl=p.leftChild;
	TreeNode pll=pl.leftChild;
	
	pl.rightChild=p;
	pl.leftChild=pll;
	p.leftChild=null;
	p.rightChild=null;
	if(p==root)
		root=pl;
	return root;
}
private static int balanceFactor(TreeNode r) {
	
	return height(r.leftChild)-height(r.rightChild);
}
static private int height(TreeNode t) {
    return t == null ? -1 : 1 + Math.max(height(t.leftChild), height(t.rightChild));
}

/*Inorder traversal will give sorted order*/
static void inOrderPrint(TreeNode t) {
	if(t!=null) {
		inOrderPrint(t.leftChild);
		System.out.print(t.data+",");
		inOrderPrint(t.rightChild);
	}
}
static void preOrderPrint(TreeNode t) {
	if(t!=null) {
		System.out.print(t.data+",");
		preOrderPrint(t.leftChild);
		preOrderPrint(t.rightChild);
	}
 }
}

