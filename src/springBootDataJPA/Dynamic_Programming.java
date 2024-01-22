package springBootDataJPA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Dynamic_Programming {
    public static void main(String[] args) {

    }
}

/**
 * Count ways to reach the n�th stair
 * There are n stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either 1 stair or 2 stairs at a time. Count the number of ways,
 * the person can reach the top.
 * <p>
 * Input: n = 1
 * Output: 1
 * There is only one way to climb 1 stair
 * <p>
 * Input: n = 2
 * Output: 2
 * There are two ways: (1, 1) and (2)
 * <p>
 * Input: n = 4
 * Output: 5
 * (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
 *
 * @author
 */
class fib {
    public static void main(String[] args) {
        int s = 2;
        System.out.println("Number of ways = " + countWays1(s + 1));
    }

    private static int countWays(int s) {
        if (s == 1)
            return 1;
        if (s < 1)
            return 0;
        return countWays(s - 1) + countWays(s - 2);
    }

    //Efficient method- memorization
    private static int countWays1(int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s; i++)
            dp[i] = dp[i - 2] + dp[i - 1];
        return dp[s];
    }
}

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 *
 * @author
 */
class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

/**
 * Given a number of stairs and a frog, the frog wants to climb from the 0th
 * stair to the (N-1)th stair. At a time the frog can climb either one or two
 * steps. A height[N] array is also given. Whenever the frog jumps from a stair
 * i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
 * where abs() means the absolute difference. We need to return the minimum
 * energy that can be used by the frog to jump from stair 0 to stair N-1.
 *
 * @author
 */
class Frog {
    public static void main(String args[]) {

        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);
            if (ind > 1)
                jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind - 2]);

            dp[ind] = Math.min(jumpOne, jumpTwo);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n - 1]);
    }
}

/**
 * This is a follow-up question to �Frog Jump� discussed in the previous
 * article. In the previous question, the frog was allowed to jump either one or
 * two steps at a time. In this question, the frog is allowed to jump up to �K�
 * steps at a time. If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 *
 * @author
 */

class Frog_II {
    static int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];

    }

    static int solve(int n, int[] height, int k) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solveUtil(n, height, dp, k);
    }

    public static void main(String args[]) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k));
    }
}

/**
 * Maximum sum of non-adjacent elements
 * [5, 20, 15, -2, 18] => 20 + 18 = 38
 * [4, 1, 6, 3, 2] => 4 + 6 + 2 = 12
 */
class Sum_Non_Adjacent {
    static int solveUtil(int n, int[] arr, int[] dp) {

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {

            int pick = arr[i] + dp[i - 2];
            int nonPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, nonPick);
        }

        return dp[n - 1];
    }

    static int solve(int n, int[] arr) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solveUtil(n, arr, dp);
    }

    public static void main(String args[]) {

        int arr[] = {2, 1, 4, 9};
        int n = arr.length;
        System.out.println(solve(n, arr));
    }
}

/**
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 * Input: n = 4 Output: 4
 * Explanation: T_3 = 0 + 1 + 1 = 2 T_4 = 1 + 1 + 2 = 4
 *
 * @author
 */
class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }

    public static int tribonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i < 3) dp[i] = 1;
            else dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}

/**
 * Given an integer n, return the number of strings of length n that consist
 * only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * <p>
 * A string s is lexicographically sorted if for all valid i, s[i] is the same
 * as or comes before s[i+1] in the alphabet.
 * <p>
 * <p>
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 *
 * @author
 */
class CountVowelStrings {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
    }

    public static int countVowelStrings(int n) {

        int[] dp = new int[]{0, 1, 1, 1, 1, 1};
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) { //a,e,i,o,u is 5 char. so we are running for 5 times(1->5)
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[5]; //5th index is the overall sum
    }
}

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * <p>
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 *
 * @author
 */
class Count_Squares {
    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] A) {

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i != 0 && j != 0 && A[i][j] != 0) {
                    A[i][j] = Math.min(Math.min(A[i - 1][j - 1], A[i - 1][j]), A[i][j - 1]) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }
}


class NumTeams {
    public static void main(String[] args) {
        int[] ratings = new int[]{2, 5, 3, 4, 1};
        System.out.println(numTeams(ratings));
    }

    public static int numTeams(int[] A) {
        int len = A.length;
        int numTeams = 0;

        for (int i = 1; i < len; i++) {
            int leftLesser = 0;
            int leftGreater = 0;
            int rightLesser = 0;
            int rightGreater = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) leftLesser++;
                else leftGreater++;
            }
            for (int k = i + 1; k < len; k++) {
                if (A[i] < A[k]) rightGreater++;
                else rightLesser++;
            }
            numTeams = numTeams + (leftLesser * rightGreater) + (leftGreater * rightLesser);
        }
        return numTeams;
    }
}

/**
 * You are given a string s, a split is called good if you can split s into 2
 * non-empty strings p and q where its concatenation is equal to s and the
 * number of distinct letters in p and q are the same.
 * <p>
 * Return the number of good splits you can make in s.
 * <p>
 * Input: s = "aacaba"
 * Output: 2
 * Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 *
 * @author
 */
class NumSplits {

    public static void main(String[] args) {
        String s = "aacaba";
        System.out.println(numSplits_2(s));
    }

    public static int numSplits(String s) {
        int[] left = new int[128];
        int[] right = new int[128];
        for (int i = 0; i < s.length(); i++)
            right[s.charAt(i)]++;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            right[s.charAt(i)]--;
            left[s.charAt(i)]++;
            if (compare(left, right))
                ans++;
        }
        return ans;

    }

    private static boolean compare(int[] left, int[] right) {

        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < 128; i++) {
            if (left[i] != 0)
                leftCount++;
            if (right[i] != 0)
                rightCount++;
        }
        if (leftCount == rightCount) return true;

        return false;
    }

    //Efficient Method -Easy
    public static int numSplits_2(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            left[i] = set.size();
        }
        set.clear();
        for (int i = n - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            right[i] = set.size();
        }

        for (int i = 0; i < n - 1; i++) {
            if (left[i] == right[i + 1])
                ans++;
        }

        return ans;

    }
}


/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time. Dynamic
 * Programming
 *
 * @author
 */
class Min_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        if (rows == 0)
            return 0;
        int cols = grid[0].length;
        int dp[][] = new int[rows][cols];
        int i, j;

        dp[0][0] = grid[0][0];  //1st element is starting point
        //Fill 1st row
        for (i = 1; i < cols; ++i)
            dp[0][i] = dp[0][i - 1] + grid[0][i];

        //Fill 1st Col
        for (i = 1; i < rows; ++i)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        //Now fill the rest of the cell
        for (i = 1; i < rows; ++i) {
            for (j = 1; j < cols; ++j)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
        return dp[rows - 1][cols - 1];
    }
}

/**
 * A 2D array 'arr' was given with m rows and n columns. arr[i][j] represents
 * the amount of gold present in the cell. I needed to find the maximum gold
 * that can be collected while going from the bottom-left cell (arr[m-1][0]) to
 * the top-right cell (arr[0][n-1]).
 * <p>
 * We can only travel in the top and the right direction.
 * <p>
 * Input: [[0,0,0,0,5]] [[0,1,1,1,0]] [[2,0,0,0,0]]
 * <p>
 * Output: 10
 *
 * @author
 */
class Gold {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}};
        System.out.println("goldCollected::" + goldCollected(arr));
    }

    private static int goldCollected(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][0] = arr[row - 1][0];
        //fill first col
        for (int i = row - 2; i >= 0; i--) {
            dp[i][0] = dp[i + 1][0] + arr[i][0];
        }
        //fill last row
        for (int i = 1; i < col; i++) {
            dp[row - 1][i] = dp[row - 1][i - 1] + arr[row - 1][i];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][col - 1];
    }
}

/**
 * You have planned some train traveling one year in advance.
 * The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 * <p>
 * Train tickets are sold in three different ways:
 * <p>
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 * <p>
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 */
class Minimum_Cost_For_Tickets {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(minCost(days, costs));
    }

    public static int minCost(int[] days, int[] costs) {
        int max = days[days.length - 1];
        Set<Integer> set = new HashSet<>();
        for (int i : days)
            set.add(i);
        int[] dp = new int[max + 1];
        for (int i = 1; i < dp.length; i++) {
            int c1 = dp[i - 1];
            int c2 = i - 7 > 0 ? dp[i - 7] : 0;
            int c3 = i - 30 > 0 ? dp[i - 30] : 0;
            if (set.contains(i))
                dp[i] = Math.min(Math.min(c1 + costs[0], c2 + costs[1]), c3 + costs[2]);
            else
                dp[i] = dp[i - 1];
            // System.out.println(dp[i]);

        }

        return dp[dp.length - 1];

    }
}

class LargestTree_1 {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        HashMap<Integer, Integer> forest = new HashMap<Integer, Integer>();
        forest.put(2, 10);
        forest.put(3, 2);
        forest.put(4, 3);
        forest.put(6, 5);
        forest.put(7, 6);
        System.out.println(largestTree(forest));
    }

    public static int largestTree(HashMap<Integer, Integer> forest) {
// Create a variable to keep track of largest element in the forest
        int maxElement = -1;
// Map to store all the unique parents as key in the given forest with value as
// number of childrenF
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int key : forest.keySet()) {
            if (!forest.keySet().contains(forest.get(key))) {
                map.put(forest.get(key), 0);
            }
            maxElement = Math.max(maxElement, Math.max(key, forest.get(key)));
        }
// Parent Array to store the address of the immediate parent of the ith node
        int[] parent = new int[maxElement + 1];
        Arrays.fill(parent, -1);
// Assigning the value
        for (int key : map.keySet()) {
            parent[key] = key;
        }
        for (int key : forest.keySet()) {
            parent[key] = forest.get(key);
        }
        int max = 0;
        for (int i = 0; i <= maxElement; i++) {
            if (parent[i] != -1) {
                parent[i] = getParent(i, parent);
                map.put(parent[i], map.get(parent[i]) + 1);
                max = Math.max(max, map.get(parent[i]));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                res = Math.min(res, key);
            }
        }
        return res;
    }

    // Method to get the parent for a given node
    public static int getParent(int x, int[] parent) {
        if (parent[x] != x) {
            return getParent(parent[x], parent);
        }
        return x;
    }
}

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected, and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * <p>
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * @author
 */

class House_Robber {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else if (nums.length == 3) return Math.max(nums[1], nums[0] + nums[2]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int p = nums[i] + dp[i - 2];
            int np = 0 + dp[i - 1];
            dp[i] = Math.max(p, np);
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("rob::" + rob(nums));
    }
}

/*********************DP STOCKS*****************/

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * @author
 */
class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Best_Time_to_Buy_and_Sell_Stock::" + maxProfit(prices));
        System.out.println("maxProfit with Multi-transaction::" + maxProfit_Multi_Transaction(prices));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int soFarMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (soFarMin < prices[i])
                max = Math.max(max, prices[i] - soFarMin);
            else
                soFarMin = prices[i];
        }
        return max;
    }

    /**
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
     * However, you can buy it then immediately sell it on the same day.
     * Find and return the maximum profit you can achieve.
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     */

    public static int maxProfit_Multi_Transaction(int[] prices) {
        return maxProfitIIUtils_DP(prices);
    }

    //Recursion
    private int maxProfitIIUtils_Recursion(int[] prices, int index, boolean doBuy) {
        if (index == prices.length) return 0;

        int profit = 0;

        if (doBuy) {
            int buy = -prices[index] + maxProfitIIUtils_Recursion(prices, index + 1, false);
            int notBuy = 0 + maxProfitIIUtils_Recursion(prices, index + 1, true);
            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + maxProfitIIUtils_Recursion(prices, index + 1, true);
            int notSell = 0 + maxProfitIIUtils_Recursion(prices, index + 1, false);
            profit = Math.max(sell, notSell);
        }
        return profit;
    }

    public int maxProfit_DP_I(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        int profit = 0;
        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    int doBuy = -prices[index] + dp[index + 1][1];
                    int notBuy = 0 + dp[index + 1][0];
                    profit = Math.max(doBuy, notBuy);
                } else {
                    int sell = prices[index] + dp[index + 1][0];
                    int notSell = 0 + dp[index + 1][1];
                    profit = Math.max(sell, notSell);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][0];
    }

    //DP
    private static int  maxProfitIIUtils_DP(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    /**
     * Allowed to do two transaction
     */
    public int maxProfit_with_limited_Transaction(int[] prices) {
        return maxProfitIIItils_Recursion(prices, 0, 0, 2);
    }

    private int maxProfitIIItils_Recursion(int[] prices, int index, int doBuy, int cap) {
        if (index == prices.length) return 0;
        if (cap == 0) return 0;

        int profit = 0;

        if (doBuy == 0) {
            int buy = -prices[index] + maxProfitIIItils_Recursion(prices, index + 1, 1, cap);
            int notBuy = 0 + maxProfitIIItils_Recursion(prices, index + 1, 0, cap);
            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + maxProfitIIItils_Recursion(prices, index + 1, 0, cap - 1);
            int notSell = 0 + maxProfitIIItils_Recursion(prices, index + 1, 1, cap);
            profit = Math.max(sell, notSell);
        }
        return profit;
    }

    public int maxProfitIIItils_DP(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        int profit = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 0) {
                        int doBuy = -prices[index] + dp[index + 1][1][cap];
                        int notBuy = 0 + dp[index + 1][0][cap];
                        profit = Math.max(doBuy, notBuy);
                    } else {
                        int sell = prices[index] + dp[index + 1][0][cap - 1];
                        int notSell = 0 + dp[index + 1][1][cap];
                        profit = Math.max(sell, notSell);
                    }
                    dp[index][buy][cap] = profit;
                }
            }
        }
        return dp[0][0][2];
    }
}



