package springBootDataJPA;

import java.util.*;
import java.util.Map.Entry;


public class Binary_Tree {
    public static void main(String[] args) {

    }
}

//Dummy data getters for trees
class TreeData {
    TreeNode root1;
    TreeNode root2;

    TreeData() {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);
        r1.left.left = new TreeNode(4);
        r1.left.right = new TreeNode(5);
        r1.right.left = new TreeNode(6);
        r1.right.right = new TreeNode(7);

        TreeNode r2 = new TreeNode(20);
        r2.left = new TreeNode(8);
        r2.right = new TreeNode(22);
        r2.left.left = new TreeNode(5);
        r2.left.right = new TreeNode(3);
        r2.right.left = new TreeNode(4);
        r2.right.right = new TreeNode(25);
        r2.left.right.left = new TreeNode(10);
        r2.left.right.right = new TreeNode(14);
        this.setRoot1(r1);
        this.setRoot2(r2);
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

class TreeNode {

    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    int rootVal, level;

    Pair() {
    }

    Pair(int i, int j) {
        rootVal = i;
        level = j;
    }
}

/**
 * 1.Right view
 * 2.Left view
 * 3.Bottom view
 * 4.Bottom left value
 *
 * @author
 */
class Right_Left_View_BT {
    static Map<Integer, Pair> map = new HashMap<>();

    public static void main(String[] args) {
        TreeData td = new TreeData();
        TreeNode root = td.getRoot1();
        TreeNode root2 = td.getRoot2();
        List res1 = new ArrayList<>();
        List res2 = new ArrayList<>();
        TreeNode t = null;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxDiff(root2, res);
        print(res[0], "MaxDiff");
        //System.out.println("printZigZagTraversal::"+zigzagLevelOrder(root));


        print(treePathsSum(root, 0), "TreePathsSum");

        print(findDistance(root2, 10, 4), "FindDistance Btw to Nodes");

        print(countLeafNodes(root), "Leaf_Node_Count");

        print(findMinDepth(root), "Find_Min_Depth");

        rightView(root, 0, res1);
        print(res1, "Rightview");

        leftView(root, 0, res2);
        print(res2, "Leftview");

        bottomView(root, 0, 0);
        print(map, "BottomView");

        topView(root, 0, 0);
        print(map, "TopView");


        print(mergeTrees(root, root2), "mergeTrees");
        int[] lastLevel = new int[1];
        lastLevel[0] = -1;
        int[] res3 = new int[1];
        findBottomLeftValue(root, 0, res3, lastLevel);
        print(res3[0], "FindBottomLeftValue");

        print(height(root), "Height");
        print(diameterOfBinaryTree(root), "Diameter");
        print(isBalancedTree(root), "IsBalancedTree");
        print(lca(root, 4, 6).val, "LCA");
        print(isSameTree(root, root), "IsSameTree");

        TreeNode[] prev = new TreeNode[1];
        prev[0] = null;
        flatten(root, prev);//Root got changed here
        print(root, "Flattern");

        t = removeHalfNodes(root);//Root got changed again
        print(t, "RemoveHalfNodes");

    }


    /*Print method*/
    public static void print(Object obj, String msg) {
        System.out.print(msg + "::");
        if (obj instanceof List)
            System.out.print(obj);
        else if (obj instanceof Map) {
            for (Entry<Integer, Pair> m : map.entrySet())
                System.out.print(m.getValue().rootVal + " ");
        } else if (obj instanceof TreeNode) { //For printing trees
            class Local {
                void printInorder(TreeNode node) {
                    if (node != null) {
                        printInorder(node.left);
                        System.out.print(node.val + " ");
                        printInorder(node.right);
                    }
                }
            }
            new Local().printInorder((TreeNode) obj);
        } else
            System.out.print(obj);
        System.out.println();

    }

    /**
     * find No of leaf nodes
     */
    private static int countLeafNodes(TreeNode root) {
        if (root == null)  return 0;

        if (root.left == null && root.right == null)  return 1;

        int leftLeafNodes = countLeafNodes(root.left);
        int rightLeafNodes = countLeafNodes(root.right);
        return leftLeafNodes + rightLeafNodes;
    }


    private static void rightView(TreeNode root, int level, List res) {
        if (root == null)
            return;
        if (level == res.size())
            res.add(root.val);
        rightView(root.right, level + 1, res);
        rightView(root.left, level + 1, res);

    }

    private static void leftView(TreeNode root, int level, List res) {
        if (root == null)
            return;
        if (level == res.size())
            res.add(root.val);
        leftView(root.left, level + 1, res);
        leftView(root.right, level + 1, res);

    }

    private static void bottomView(TreeNode root, int dist, int level) {
        if (root == null)
            return;
        if (!map.containsKey(dist) || map.get(dist).level < level)
            map.put(dist, new Pair(root.val, level));
        bottomView(root.left, dist - 1, level + 1);
        bottomView(root.right, dist + 1, level + 1);

    }

    private static void topView(TreeNode root, int dist, int level) {
        if (root == null)
            return;
        if (!map.containsKey(dist) || map.get(dist).level > level)
            map.put(dist, new Pair(root.val, level));
        topView(root.left, dist - 1, level + 1);
        topView(root.right, dist + 1, level + 1);

    }

    private static int treePathsSum(TreeNode root, int total) {
        if (root == null)
            return 0;

        total = total + root.val;
        if (root.left == null && root.right == null)
            return total;
        int left = treePathsSum(root.left, total);
        int right = treePathsSum(root.right, total);

        return left + right;

    }

    private static TreeNode removeHalfNodes(TreeNode root) {
        if (root == null)
            return null;
        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);
        if (root.left == null && root.right == null)
            return root;

        if (root.left == null) {
            TreeNode new_node = new TreeNode(root.right.val);
            return new_node;
        }
        if (root.right == null) {
            TreeNode new_node = new TreeNode(root.left.val);
            return new_node;
        }
        return root;
    }


    private static void allLeafNodes(TreeNode root, List res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        allLeafNodes(root.left, res);
        allLeafNodes(root.right, res);

    }

    static int lastLevel = -1;

    private static void findBottomLeftValue(TreeNode root, int level, int[] res, int[] lastLevel) {
        if (root == null)
            return;
        if (lastLevel[0] < level) {
            lastLevel[0] = level;
            res[0] = root.val;
        }
        findBottomLeftValue(root.left, level + 1, res, lastLevel);
        findBottomLeftValue(root.right, level + 1, res, lastLevel);

    }

    /*We can call this as maxDepth of Binary tree */
    private static int height(TreeNode root) {
        return root != null ? Math.max(height(root.left), height(root.right)) + 1 : 0;
    }


    /* The diameter of a binary tree is the length of the longest path between any two nodes in a tree.*/
    int maxDiameter=0;
    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int rootDiameter = leftHeight + rightHeight;

        // Recursively find the diameters in the left and right subtrees
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        // Return the maximum of the three diameters
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }


    public static Boolean isBalancedTree(TreeNode root) {
        if (root == null)
            return true;
        int hl = height(root.left);
        int hr = height(root.right);
        if (Math.abs(hl - hr) > 1) return false;
        Boolean left = isBalancedTree(root.left);
        Boolean right = isBalancedTree(root.right);
        if (left && right)
            return true;
        return false;
    }

    /*Lowest Common Ancestor in a Binary Tree*/
     public static TreeNode lca(TreeNode root, int left, int right) {
        if (root == null) return null;
        if (root.val == left || root.val == right)
            return root;
        TreeNode lf = lca(root.left, left, right);
        TreeNode rf = lca(root.right, left, right);
        if (lf != null && rf != null)
            return root;
        else
            return lf != null ? lf : rf;
    }

    /* The path sum of a path is the sum of the node's values in the path. 
	  Given the root of a binary tree, return the maximum path sum of any path */
    private static int maxPathSum = Integer.MIN_VALUE;
    private static int calculateMaxPathSum(TreeNode root) {

        if (root == null) return 0;
        // Calculate the maximum path sum for the left and right subtrees
        int leftMax = Math.max(0, calculateMaxPathSum(root.left));
        int rightMax = Math.max(0, calculateMaxPathSum(root.right));

        // Update the maximum path sum considering the current node
        maxPathSum = Math.max(maxPathSum, leftMax + rightMax + root.val);

        // Return the maximum sum considering the current node for the upper levels
        return Math.max(leftMax, rightMax) + root.val;
    }

    /*Identical tree start*/
    public static boolean isSameTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (checkIdentical(r1, r2))
            return true;

        return isSameTree(r1.left, r2) || isSameTree(r1.right, r2);
    }

    static Boolean checkIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null)
            return p.val == q.val && checkIdentical(p.left, q.left)
                    && checkIdentical(p.right, q.right);
        return false;
    }
    /*Identical tree end*/

    /* Symmetrical tree - Mirror tree*/
    public boolean isSymmetric(TreeNode root) {
        return checkMirror(root, root);
    }

    static Boolean checkMirror(TreeNode p, TreeNode q) {//same as checkIdentical(), only changes is on Tree1-R vs Tree2-L AND Tree1-L vs Tree2-R
        if (p == null && q == null)
            return true;

        if (p != null && q != null)
            return p.val == q.val && checkMirror(p.left, q.right)
                    && checkMirror(p.right, q.left);
        return false;
    }

    /* Symmetrical tree  end*/
    public static void flatten(TreeNode root, TreeNode[] prev) {
        if (root == null)
            return;
        flatten(root.right, prev);
        flatten(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }

    /**
     * Given a binary tree, we need to find maximum value we can get by subtracting
     * value of node B from value of node A, where A and B are two nodes of the
     * binary tree and A is an ancestor of B. Expected time complexity is O(n).
     */
    private static int maxDiff(TreeNode tr, int[] res) {
        if (tr == null)
            return Integer.MAX_VALUE;
        if (tr.left == null && tr.right == null)
            return tr.val;

        int leftVal = maxDiff(tr.left, res);
        int rightVal = maxDiff(tr.right, res);

        int min = Math.min(leftVal, rightVal);
        res[0] = Math.max(tr.val - min, res[0]);

        return Math.min(tr.val, min);
    }


    /**
     * Find distance between two nodes of a Binary Tree
     * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
     * 'lca' is lowest common ancestor of n1 and n2
     *
     * @author
     */
    private static int findDistance(TreeNode root, int i, int j) {

        TreeNode lca = lca(root, i, j);
        int d1 = dist(root, i, 0);
        int d2 = dist(root, j, 0);
        int lcaDist = dist(root, lca.val, 0);
        int actualDist = d1 + d2 - (2 * lcaDist);
        return actualDist;
    }

    private static int dist(TreeNode root, int key, int level) {
        if (root == null)
            return -1;
        if (root.val == key)
            return level;

        int left = dist(root.left, key, level + 1);
        if (left == -1)
            return dist(root.right, key, level + 1);
        return left;
    }

    /**
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path from the
     * root node down to the nearest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     */
    private static int findMinDepth(TreeNode rootNode) {
        if (rootNode == null) return 0;

        if (rootNode.left == null && rootNode.right == null)
            return 1;

        int left = rootNode.left != null ? findMinDepth(rootNode.left) : Integer.MAX_VALUE;
        int right = rootNode.right != null ? findMinDepth(rootNode.right) : Integer.MAX_VALUE;

        return Math.min(left, right) + 1;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }

    /**
     * Given the root of a binary tree, each node in the tree has a distinct value.
     * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
     * Return the roots of the trees in the remaining forest. You may return the result in any order.
     * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
     * Output: [[1,2,null,4],[6],[7]]
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> remaining = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        delNodesUtils(root, set, remaining);
        if (!set.contains(root.val))
            remaining.add(root);
        return remaining;
    }

    private TreeNode delNodesUtils(TreeNode root, Set<Integer> set, List<TreeNode> remaining) {
        if (root == null) return null;
        root.left = delNodesUtils(root.left, set, remaining);
        root.right = delNodesUtils(root.right, set, remaining);
        if (set.contains(root.val)) {
            if (root.left != null) remaining.add(root.left);
            if (root.right != null) remaining.add(root.right);
            return null;
        }
        return root;
    }

    /**
     * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
     * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * Output: true
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        getLeafString(root1, str1);
        getLeafString(root2, str2);
        if (str1.toString().equals(str2.toString())) return true;
        return false;
    }

    void getLeafString(TreeNode root, StringBuffer str) {

        if (root == null) return;
        if (root.left == null && root.right == null) str.append(root.val + "-");
        getLeafString(root.left, str);
        getLeafString(root.right, str);
    }

    /*********/

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = (Queue) new LinkedList();
        List<List<Integer>> wrapList = new ArrayList<>();

        if (root == null) return wrapList;

        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>(levelNum);
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (flag == true) subList.add(queue.poll().val);
                else
                    subList.add(0, queue.poll().val);//Inserts the specified element at the specified position in this list
                // (optional operation). Shifts the element currently at that position
                // (if any) and any subsequent elements to the right (adds one to their indices)
            }
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;

    }

    /**
     * Delete a Node in Binary Search Tree
     *
     * @author
     */

    class Delete_Node_BST {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                return helper(root);
            }
            TreeNode dummy = root;
            while (root != null) {
                if (root.val > key) {
                    if (root.left != null && root.left.val == key) {
                        root.left = helper(root.left);
                        break;
                    } else {
                        root = root.left;
                    }
                } else {
                    if (root.right != null && root.right.val == key) {
                        root.right = helper(root.right);
                        break;
                    } else {
                        root = root.right;
                    }
                }
            }
            return dummy;
        }

        public TreeNode helper(TreeNode root) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightChild = root.right;
                TreeNode lastRight = findLastRight(root.left);
                lastRight.right = rightChild;
                return root.left;
            }
        }

        public TreeNode findLastRight(TreeNode root) {
            if (root.right == null) {
                return root;
            }
            return findLastRight(root.right);
        }

        /**
         * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
         * Input: root = [3,9,20,null,null,15,7]
         * Output: [[3],[9,20],[15,7]]
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {

            Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList();
            List<List<Integer>> resList = new ArrayList();
            if (root == null) return resList;
            q.offer(root);
            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> val = new ArrayList();
                for (int i = 0; i < levelSize; i++) {
                    if (q.peek().left != null) q.offer(q.peek().left);
                    if (q.peek().right != null) q.offer(q.peek().right);
                    val.add(q.poll().val);
                }
                resList.add(val);
            }
            return resList;
        }
    }
}

class Boundary_Traversal {
    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) res.add(cur.val);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        while (cur != null) {
            if (!isLeaf(cur)) tmp.add(cur.val);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }

        //add right boundary values to the existing list
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    static void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    static ArrayList<Integer> printBoundary(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (!isLeaf(node)) ans.add(node.val);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        ArrayList<Integer> boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }

    }
}


