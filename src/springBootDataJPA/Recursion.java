package springBootDataJPA;

import java.util.*;

public class Recursion {
    public static void main(String[] args) {

    }
}

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author
 */
class Permutation {
    public static void main(String[] args) {
        int set[] = {1, 2, 3};
        System.out.println("Subset_Generate::" + permute(set));
    }

    private static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> resList = new ArrayList();
        func(0, arr, resList);
        return resList;
    }

    private static void func(int index, int[] arr, List<List<Integer>> resList) {

        if (index == arr.length) {
            List path = new ArrayList();
            for (int i : arr)
                path.add(i);

            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            func(index + 1, arr, resList);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


class Permutation_String {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("abc");
        System.out.println("Subset_Generate::" + permuteString(str));
    }

    private static List<String> permuteString(StringBuffer str) {
        List<String> resList = new ArrayList();
        strFunc(0, str, resList);
        return resList;
    }

    private static void strFunc(int index, StringBuffer str, List<String> resList) {
        if (index == str.length()) {
            resList.add(new String(str));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            swapString(str, index, i);
            strFunc(index + 1, str, resList);
            swapString(str, index, i);
        }
    }

    private static void swapString(StringBuffer str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }
}

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
class LetterCombinationsPhoneNumber {
    static String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        letterCombinationsUtil(digits, 0, "", resList);
        return resList;
    }

    private static void letterCombinationsUtil(String digits, int index, String res, List<String> resList) {
        if (digits.length() == index) {
            resList.add(res);
            return;
        }

        String str = KEYS[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            letterCombinationsUtil(digits, index + 1, res + str.charAt(i), resList);
        }
    }
}

/**
 * Subset_Generate::[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
 *
 * @author
 */
class Subset_Generate {
    public static void main(String[] args) {
        int set[] = {1, 2, 3};
        System.out.println("Subset_Generate::" + subset_Generate(set));
    }

    private static List<List> subset_Generate(int[] arr) {
        List<List> resList = new ArrayList();
        func(0, arr, new ArrayList<>(), resList);
        return resList;
    }

    private static void func(int index, int[] arr, ArrayList subset, List<List> resList) {
        resList.add(new ArrayList<>(subset));

        for (int i = index; i < arr.length; i++) {
            subset.add(arr[i]);
            func(i + 1, arr, subset, resList);
            subset.remove(subset.size() - 1);
        }

    }

    //using recursions
    private static void func2(int index, int[] arr, ArrayList subset, List<List> resList) {
        if (index == arr.length) {
            resList.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[index]);
        func2(index + 1, arr, subset, resList);
        subset.remove(subset.size() - 1);
        func2(index + 1, arr, subset, resList);
    }
}


/**
 * Split a String Into the Max Number of Unique Substrings
 * Input: s = "aba"
 * Output: 2
 * Explanation: One way to split maximally is ['a', 'ba'].
 */
class Max_Unique_String {
    public static void main(String[] args) {
        String str = "aba";
        System.out.println("maxUniqueSplitUtil::" + maxUniqueSplitUtil(str, new HashSet(), 0));
    }

    private static int maxUniqueSplitUtil(String s, Set<String> set, int index) {
        if (index == s.length()) {
            return set.size();
        }
        int max = 0;
        for (int i = index; i < s.length(); i++) {
            String word = s.substring(index, i + 1);
            System.out.println("word=" + word);
            if (!set.contains(word)) {
                set.add(word);
                max = Math.max(max, maxUniqueSplitUtil(s, set, i + 1));
                set.remove(word);
            }
        }
        return max;
    }
}

class Palindrome_Partitioning {
    public static void main(String[] args) {
        String s = "aabbb";
        partition(s);
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> resList = new ArrayList();
        func(0, s, new ArrayList<>(), resList);
        System.out.println(resList);
        return resList;
    }

    private static void func(int index, String s, List<String> path, List<List<String>> resList) {

        if (index == s.length()) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPolindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                func(i + 1, s, path, resList);
                path.remove(path.size() - 1);
            }
        }
    }

    static Boolean isPolindrome(String s, int st, int end) {
        while (st <= end) {
            if (s.charAt(st++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

/**
 * Subset Sum Equal To K. Return true if any of the subset is having sum equals to K.
 */
class Subset_Generate_K_Sum_Recursion {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int k = 4;
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][k + 1];
        if (subsetSumToK(n - 1, k, arr)) System.out.println("Subset with given target found");
        else System.out.println("Subset with given target not found");
    }

    //Recursion
    private static boolean subsetSumToK(int index, int target, int[] arr) {

        if (target == 0) return true;
        if (index == 0) return arr[index] == target;
        boolean notTaken = subsetSumToK(index - 1, target, arr);

        boolean taken = false;
        if (target >= arr[index]) taken = subsetSumToK(index - 1, target - arr[index], arr);

        return notTaken || taken;
    }

    //Memorization
    private static boolean subsetSumToKMemorization(int i, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == 0) return arr[i] == target;
        if (dp[i][target] != null) return dp[i][target];

        boolean notTaken = subsetSumToKMemorization(i - 1, target, arr, dp);

        boolean taken = false;
        if (target >= arr[i]) taken = subsetSumToKMemorization(i - 1, target - arr[i], arr, dp);

        return dp[i][target] = notTaken || taken;
    }

    //DP
    public boolean subsetSumToKDP(int[] arr, int K) {
        boolean[][] dp = new boolean[arr.length][K + 1];
        for (int i = 0; i < arr.length; i++)
            dp[i][0] = true;
        if (arr[0] <= K) dp[0][arr[0]] = true;

        for (int index = 1; index < arr.length; index++) {
            for (int target = 1; target <= K; target++) {
                boolean notTaken = dp[index - 1][target];
                boolean taken = false;
                if (target >= arr[index]) taken = dp[index - 1][target - arr[index]];
                dp[index][target] = taken || notTaken;
            }
        }
        return dp[arr.length - 1][K];
    }
}

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements
 * in both subsets is equal or false otherwise.
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */
class EqualPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) sum += i;
        int target = 0;
        if (sum % 2 == 0) target = sum / 2;
        else return false;

        Boolean[][] dp = new Boolean[n][target + 1];

        //return partitionUtil(n-1,target,nums,dp);
        return partitionUtilDP(target, nums);
    }

    private Boolean partitionUtil(int index, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) return true;
        if (index == 0) return arr[index] == target;
        if (dp[index][target] != null) return dp[index][target];
        boolean notTaken = partitionUtil(index - 1, target, arr, dp);
        boolean taken = false;
        if (target >= arr[index]) taken = partitionUtil(index - 1, target - arr[index], arr, dp);
        return dp[index][target] = notTaken || taken;
    }

    private boolean partitionUtilDP(int K, int[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][K + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (arr[0] <= K) dp[0][arr[0]] = true;
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= K; target++) {
                boolean notTaken = dp[index - 1][target];
                boolean taken = false;
                if (target >= arr[index]) taken = dp[index - 1][target - arr[index]];
                dp[index][target] = notTaken || taken;
            }
        }
        return dp[n - 1][K];
    }
}

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum.
 */
class MinSubsetSumDifference {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int i : arr) totalSum += i;
        int[][] dp = new int[n][totalSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        for (int target = 0; target <= totalSum; target++)// Here the target sum vary from 0 to totalSum. This will create dp array
            subsetSumUtil(n - 1, target, arr, dp);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum; i++) {
            if (dp[n - 1][i] == 1) {
                int currDiff = Math.abs(i - (totalSum - i));
                minDiff = Math.min(minDiff, currDiff);
            }
        }
        return minDiff;
    }

    private static int subsetSumUtil(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return dp[index][target] = 1;
        if (index == 0) return dp[index][target] = arr[index] == target ? 1 : 0;
        if (dp[index][target] != -1) return dp[index][target];

        int notTaken = subsetSumUtil(index - 1, target, arr, dp);
        int taken = 0;
        if (target >= arr[index]) taken = subsetSumUtil(index - 1, target - arr[index], arr, dp);

        int res = taken == 1 || notTaken == 1 ? 1 : 0;
        return dp[index][target] = res;
    }

    public static void main(String[] args) {
        int arr[] = {36, -36};
        int n = arr.length;
        System.out.println("minSubsetSumDifference::" + minSubsetSumDifference(arr, n));
    }

}

/**
 * Find the number Of Subsets with K sum
 */

class SubsetCount_With_KSum {

    public static void main(String[] args) {
        int arr[] = {3, 2, 7};
        System.out.println("SubsetCount_With_KSum::" + findWays(arr, 5));
    }

    public static int findWays(int arr[], int tar) {
        int n = arr.length;
        int[][] dp = new int[n][tar + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return findWaysUtil(arr, n - 1, tar, dp);
    }

    private static int findWaysUtil(int[] arr, int index, int target, int[][] dp) {

        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTaken = findWaysUtil(arr, index - 1, target, dp);
        int taken = 0;
        if (target >= arr[index]) taken = findWaysUtil(arr, index - 1, target - arr[index], dp);
        return dp[index][target] = notTaken + taken;
    }

    private static int findWaysUtilDP(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= K) dp[0][arr[0]] = 1;
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= K; target++) {
                int notTaken = dp[index - 1][target];
                int taken = 0;
                if (target >= arr[index]) taken = dp[index - 1][target - arr[index]];
                dp[index][target] = notTaken + taken;
            }
        }
        return dp[n][K];
    }
}


/**
 * Partitions With Given Difference
 * Given a difference ‘D’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’
 * and the difference between ‘S1’ and ‘S2’ is equal to ‘D’.
 * Since the answer may be too large, return it modulo ‘10^9 + 7’.
 */
class Subset_Count_With_Difference_d {
    static int mod = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        int arr[] = {3, 2, 7};
        int n = arr.length;
        System.out.println("countPartitions with difference d::" + countPartitions(n, 2, arr));
    }

    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int totalSum = 0;
        for (int i : arr) totalSum += i;
        return countPartitionsUtil(n, d, arr, totalSum);

    }

    private static int countPartitionsUtil(int n, int d, int[] arr, int totalSum) {

        if (totalSum - d < 0) return 0;
        if ((totalSum - d) % 2 != 0) return 0;
        int target = (totalSum - d) / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return findWays(arr, n - 1, target, dp);

    }

    private static int findWays(int[] arr, int index, int target, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTaken = findWays(arr, index - 1, target, dp);
        int taken = 0;
        if (target >= arr[index]) taken = findWays(arr, index - 1, target - arr[index], dp);

        return dp[index][target] = (taken + notTaken) % mod;
    }
}

/**
 * A thief wants to rob a store. He is carrying a bag of capacity W. The store has ‘n’ items.
 * Its weight is given by the ‘wt’ array and its value by the ‘val’ array. He can either include an item in its knapsack
 * or exclude it but can’t partially have it as a fraction. We need to find the maximum value of items that the thief can steal.
 */
class Knapsack_Problem {
    public static void main(String[] args) {
        int[] weight = {3, 2, 4};
        int[] value = {30, 40, 60};
        int maxWt = 6;
        int n = weight.length;
        System.out.println("knapsack::" + knapsack(weight, value, n, maxWt));
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return knapsackUtil(weight, value, n - 1, maxWeight, dp);

    }

    static int knapsackUtil(int[] weight, int[] value, int index, int maxWeight, int[][] dp) {

        if (index == 0) {
            if (maxWeight >= weight[0]) return value[0];
            else return 0;
        }

        if (dp[index][maxWeight] != -1) return dp[index][maxWeight];

        int notTaken = 0 + knapsackUtil(weight, value, index - 1, maxWeight, dp);
        int taken = Integer.MIN_VALUE;
        if (maxWeight >= weight[index])
            taken = value[index] + knapsackUtil(weight, value, index - 1, maxWeight - weight[index], dp);

        return dp[index][maxWeight] = Math.max(notTaken, taken);
    }

    static int knapsackUtilDP(int[] weight, int[] value, int maxWeight) {

        int[][] dp = new int[weight.length][maxWeight + 1];
        for (int i = weight[0]; i <= maxWeight; i++) {
            if (value[0] <= maxWeight) {
                dp[0][i] = value[0];
            }
        }


        for (int index = 1; index < weight.length; index++) {
            for (int cap = 0; cap <= maxWeight; cap++) {
                int notTaken = dp[index - 1][cap];
                int taken = Integer.MIN_VALUE;
                if (cap >= weight[index]) taken = value[index] + dp[index - 1][cap - weight[index]];
                dp[index][cap] = Math.max(notTaken, taken);

            }
        }
        return dp[weight.length - 1][maxWeight];
    }
}


/**
 * You are given an array of ‘N’ distinct integers and an integer ‘X’ representing the target sum.
 * You have to tell the minimum number of elements you have to take to reach the target sum ‘X’.
 * <p>
 * If N=3 and X=7 and array elements are [1,2,3].
 * Way 1 - You can take 4 elements  [2, 2, 2, 1] as 2 + 2 + 2 + 1 = 7.
 * Way 2 - You can take 3 elements  [3, 3, 1] as 3 + 3 + 1 = 7.
 * Here, you can see in Way 2 we have used 3 coins to reach the target sum of 7.
 * Hence the output is 3.
 * <p>
 * You have an infinite number of elements of each type.(We can add one element many times)
 */

class Minimum_Elements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Minimum_Elements required to create target::" + minimumElements(arr, 7));
    }

    public static int minimumElements(int num[], int x) {
        int n = num.length;
        int[][] dp = new int[n][x + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return minimumElementsUtil(num, n - 1, x, dp);
    }

    private static int minimumElementsUtil(int[] arr, int index, int target, int[][] dp) {

        if (index == 0) {
            if (target % arr[0] == 0) return target / arr[0];
            else return Integer.MAX_VALUE;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTaken = minimumElementsUtil(arr, index - 1, target, dp);
        int taken = Integer.MAX_VALUE;
        if (target >= arr[index]) taken = 1 + minimumElementsUtil(arr, index, target - arr[index], dp);

        return dp[index][target] = Math.min(notTaken, taken);
    }

    private static int minimumElementsUtilDP(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];

        for (int i = 0; i <= K; i++) {
            if (i % arr[0] == 0) dp[0][i] = i / arr[0];
            else dp[0][i] = (int) Math.pow(10, 9);
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= K; target++) {

                int notTaken = dp[index - 1][target];
                int taken = Integer.MAX_VALUE;
                if (target >= arr[index]) taken = 1 + dp[index][target - arr[index]];
                dp[index][target] = Math.min(notTaken, taken);

            }
        }
        int ans = dp[n - 1][K];
        if (ans >= (int) Math.pow(10, 9)) return -1;
        return ans;
    }
}

/**
 * You are given an array ‘ARR’ of ‘N’ integers and a target number, ‘TARGET’.
 * Your task is to build an expression out of an array by adding one of the symbols '+' and '-' before each integer in an array,
 * and then by concatenating all the integers, you want to achieve a target.
 * You have to return the number of ways the target can be achieved.
 */

class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int target = 3;
        int n = arr.length;
        System.out.println("Target sum::" + targetSum(n, target, arr));
    }

    public static int targetSum(int n, int target, int[] arr) {
        // Write your code here.
        return targetSumUtil(arr, n - 1, target, 0);
    }

    public static int targetSumUtil(int[] arr, int index, int target, int currSum) {

        if (index == 0) {
            if (arr[0] == 0 && currSum == target) return 2;
            if (currSum + arr[0] == target) return 1;
            if (currSum - arr[0] == target) return 1;
            return 0;
        }

        int add = targetSumUtil(arr, index - 1, target, currSum + arr[index]);
        int sub = targetSumUtil(arr, index - 1, target, currSum - arr[index]);

        return add + sub;
    }
}

/**
 * You are given an infinite supply of coins of each of denominations D = {D0, D1, D2, D3, ...... Dn-1}.
 * You need to figure out the total number of ways W, in which you can make a change for value V using coins of denominations from D.
 * Print 0, if a change isn't possible.
 */
class CoinChange {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("countWaysToMakeChange::" + countWaysToMakeChange(arr, 4));
    }

    public static long countWaysToMakeChange(int denominations[], int value) {
        int n = denominations.length;
        long[][] dp = new long[n][value + 1];
        for (long[] row : dp)
            Arrays.fill(row, -1);
        return countWaysToMakeChangeUtil(denominations, n - 1, value, dp);
    }

    private static long countWaysToMakeChangeUtil(int[] arr, int index, int target, long[][] dp) {
        //there won't be any coin with value 0. No of ways means, return 1 and no.of coins,means target/arr[0]
        if (index == 0) {
            if (target % arr[0] == 0) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        long notTaken = countWaysToMakeChangeUtil(arr, index - 1, target, dp);
        long taken = 0;
        if (target >= arr[index]) taken = countWaysToMakeChangeUtil(arr, index, target - arr[index], dp);

        return dp[index][target] = notTaken + taken;
    }

    private static long countWaysToMakeChangeDP(int[] arr, int K) {
        //there won't be any coin with value 0. No of ways means, return 1 and no.of coins,means target/arr[0]
        int n = arr.length;
        long[][] dp = new long[n][K + 1];
        for (int i = 0; i <= K; i++) {
            if (i % arr[0] == 0) dp[0][i] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= K; target++) {
                long notTaken = dp[index - 1][target];
                long taken = 0;
                if (target >= arr[index]) taken = dp[index][target - arr[index]];
                dp[index][target] = notTaken + taken;
            }
        }
        return dp[n - 1][K];
    }

    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount
     * representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     * Input: coins = [1,2,5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     */
    private int coin_Change_rec(int[] arr, int index, int target, int[][] dp) {

        if (index == 0) {
            if (target % arr[index] == 0) return target / arr[index];
            else return (int) Math.pow(10, 9);
        }
        if (dp[index][target] != -1) return dp[index][target];
        int notTaken = coin_Change_rec(arr, index - 1, target, dp);
        int taken = (int) Math.pow(10, 9);
        if (target >= arr[index]) taken = 1 + coin_Change_rec(arr, index, target - arr[index], dp);
        return dp[index][target] = Math.min(notTaken, taken);

    }

    private int coinChange_DP(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < K; i++) {
            if (i % arr[0] == 0) dp[0][i] = i / arr[0];
            else dp[0][i] = (int) Math.pow(10, 9);
        }

        for (int index = 1; index < arr.length; index++) {
            for (int target = 0; target <= K; target++) {
                int notTaken = dp[index - 1][target];
                int taken = (int) Math.pow(10, 9);
                if (target >= arr[index]) taken = 1 + dp[index][target - arr[index]];

                dp[index][target] = Math.min(notTaken, taken);
            }
        }
        int ans = dp[n - 1][K];
        if (ans >= (int) Math.pow(10, 9)) return -1;
        return ans;
    }

}

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col - 1] == 1) return 0;
        int[][] dp = new int[row][col];
        for (int[] dpRow : dp)
            Arrays.fill(dpRow, -1);
        return uniquePathsWithObstaclesRec(obstacleGrid, row - 1, col - 1, dp);
    }

    int uniquePathsWithObstaclesRec(int[][] obstacleGrid, int i, int j, int[][] dp) {
        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int up = uniquePathsWithObstaclesRec(obstacleGrid, i - 1, j, dp);
        int down = uniquePathsWithObstaclesRec(obstacleGrid, i, j - 1, dp);
        return dp[i][j] = up + down;
    }

    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[row - 1][col - 1] == 1) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                int up = dp[i - 1][j];
                int down = dp[i][j - 1];
                dp[i][j] = up + down;
            }
        }
        return dp[row - 1][col - 1];
    }
}
/**
 * DP on String
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 */

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 */

/**
 * �ABCDGH� and �AEDFHR�
 */
class Longest_common_subsequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println("Length of Longest Common Subsequence:" + LCS(s1, s2, s1.length() - 1, s2.length() - 1, dp));
        System.out.println("Print LCS(Reverse it as we are taking from n-1)::" + new StringBuilder(LCS_Print(s1, s2, s1.length() - 1, s2.length() - 1)).reverse());
        System.out.println("Length of Longest Common Substring:" + LCSubstring(s1, s2, s1.length() - 1, s2.length() - 1, 0));
        System.out.println("Print Longest Common Substring(Reverse it as we are taking from n-1)::" + new StringBuilder(LCSubstring_Print(s1, s2, s1.length() - 1, s2.length() - 1, new String())).reverse());
        System.out.println("Length of Longest Palindromic Subsequence::" + longestPalindromeSubsequence(s1));
        System.out.println("Print Longest Palindromic Subsequence::" + longestPalindromeSubsequence_Print(s1));
        System.out.println("Minimum Insertions required to create Palindrome::" + minInsertionsToMakePalindrome(s1));
        System.out.println("shortestCommonSupersequence::" + shortestCommonSuperSequence(s1, s2));

        //longestCommonSubsequence(s1,s2);
    }

    //Recursive method with memorization
    //https://leetcode.com/problems/longest-common-subsequence/
    private static int LCS(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + LCS(s1, s2, i - 1, j - 1, dp);
        else return dp[i][j] = Math.max(LCS(s1, s2, i - 1, j, dp), LCS(s1, s2, i, j - 1, dp));
    }

    private static int LCS_DP(String s1, String s2) {
        s1 = " " + s1;
        s2 = " " + s2;
        int[][] dp = new int[s1.length()][s2.length()];

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

    /* print longest common subsequence*/
    private static String LCS_Print(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return "";

        if (s1.charAt(i) == s2.charAt(j)) return s1.charAt(i) + LCS_Print(s1, s2, i - 1, j - 1);
        else {
            String n = LCS_Print(s1, s2, i - 1, j);
            String m = LCS_Print(s1, s2, i, j - 1);
            return n.length() > m.length() ? n : m;
        }
    }

    /**
     * If 'STR1' = “abcjklp” and 'STR2' = “acjkp”  then the output will be 3.x
     * Explanation: The longest common substring is “cjk” which is of length 3.
     */
    static int LCSubstring(String s1, String s2, int i, int j, int count) {

        if (i < 0 || j < 0) return count;

        if (s1.charAt(i) == s2.charAt(j)) count = LCSubstring(s1, s2, i - 1, j - 1, count + 1);

        count = Math.max(count, Math.max(LCSubstring(s1, s2, i, j - 1, 0), LCSubstring(s1, s2, i - 1, j, 0)));

        return count;
    }

    static int LCSubstring_DP(String s1, String s2) {
        s1 = " " + s1;
        s2 = " " + s2;
        int[][] dp = new int[s1.length()][s2.length()];
        int maxLength = 0; // Variable to track the maximum length of common substring

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]); // Update maxLength
                } else {
                    dp[i][j] = 0; // Reset the length if characters don't match
                }
            }
        }
        return maxLength;
    }

    /**
     * Print the longest common substring
     */
    static String LCSubstring_Print(String s1, String s2, int i, int j, String res) {

        if (i < 0 || j < 0) return res;

        if (s1.charAt(i) == s2.charAt(j)) res = LCSubstring_Print(s1, s2, i - 1, j - 1, res + s1.charAt(i));

        String n = LCSubstring_Print(s1, s2, i, j - 1, new String());
        String m = LCSubstring_Print(s1, s2, i - 1, j, new String());
        String val = n.length() > m.length() ? n : m;

        return val.length() > res.length() ? val : res;
    }


    /**
     * Maximum Length of Repeated Subarray
     * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * Output: 3
     * Explanation: The repeated subarray with maximum length is [3,2,1].
     */
    static int LCSubarray(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];

        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;  // If elements are not equal, reset the length of common subarray
                }
            }
        }

        return maxLength;

    }

    /**
     * Maximum Subarray
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    public int maxSubArray(int[] nums) {//Kadane's Algorithm
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            max = Math.max(sum, max);
            if (sum < 0) sum = 0;
        }
        return max;
    }


    /**
     * Given a string s, find the longest palindromic subsequence's length in s.
     * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
     * changing the order of the remaining elements.
     * Input: s = "bbbab"
     * Output: 4
     * Explanation: One possible longest palindromic subsequence is "bbbb".
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubsequence(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();//reverse the array and find LCS
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return LCS(s1, s2, n - 1, m - 1, dp);
    }

    public static String longestPalindromeSubsequence_Print(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();//reverse the array and find LCS
        int n = s1.length();
        int m = s2.length();
        return LCS_Print(s1, s2, n - 1, m - 1);
    }

    /**
     * Given a string s, return the longest
     * palindromic substring in s.
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     */
    public String longestPalindromeSubstring(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String n = extend(s, i, i);
            String m = extend(s, i, i + 1);
            String val = n.length() > m.length() ? n : m;
            res = res.length() > val.length() ? res : val;
        }
        return res;
    }

    String extend(String str, int i, int j) {
        for (; j < str.length() && i >= 0; i--, j++) {
            if (str.charAt(i) != str.charAt(j)) break;
        }
        return str.substring(i + 1, j);
    }


    class Polindrome_Pair {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i], i);
            }
            //case1
            if (map.containsKey("")) {
                int blankId = map.get("");
                for (int i = 0; i < words.length; i++) {
                    if (i != blankId && isPolindrome(words[i])) {
                        res.add(Arrays.asList(blankId, i));
                        res.add(Arrays.asList(i, blankId));
                    }
                }
            }
            //case2
            for (int i = 0; i < words.length; i++) {
                String reversed = new StringBuffer(words[i]).reverse().toString();
                if (map.containsKey(reversed)) {
                    int reverseId = map.get(reversed);
                    if (i != reverseId) res.add(Arrays.asList(i, reverseId));
                }
            }
            //case3
            for (int i = 0; i < words.length; i++) {
                String currString = words[i];
                for (int j = 1; j < currString.length(); j++) {
                    String first = currString.substring(0, j);
                    String second = currString.substring(j);
                    if (isPolindrome(first)) {
                        String reversedSecond = new StringBuffer(second).reverse().toString();
                        if (map.containsKey(reversedSecond)) {
                            int reversedSecondId = map.get(reversedSecond);
                            res.add(Arrays.asList(reversedSecondId, i));
                        }
                    }
                    if (isPolindrome(second)) {
                        String reversedFirst = new StringBuffer(first).reverse().toString();
                        if (map.containsKey(reversedFirst)) {
                            int reversedFirstId = map.get(reversedFirst);
                            res.add(Arrays.asList(i, reversedFirstId));
                        }
                    }

                }
            }
            return res;
        }

        boolean isPolindrome(String str) {
            int i = 0, j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i++) != str.charAt(j--)) return false;
            }
            return true;
        }
    }

    /**
     * Given a string s. In one step you can insert any character at any index of the string.
     * Return the minimum number of steps to make s palindrome.
     * A Palindrome String is one that reads the same backward as well as forward.
     * <p>
     * Input: s = "mbadm"
     * Output: 2
     * Explanation: String can be "mbdadbm" or "mdbabdm".
     */
    //find the longestPalindromeSubsequence from the given string and since which is already inorder,No need of movement and
    //remaining character in string S needs to be added to make the string as palindrome.
    public static int minInsertionsToMakePalindrome(String s) {
        return s.length() - longestPalindromeSubsequence(s);
    }

    /**
     * You are given 2 non-empty strings “str” and “ptr” consisting of lowercase English alphabets only.
     * Your task is to convert string “str” into string “ptr”.
     * In one operation you can do either of the following on “str”:
     * Remove a character from any position in “str”.
     * Add a character to any position in “str”.
     *
     * @param str
     * @param ptr
     * @return
     */
    public static int minInsert_DeletionFor_Two_StingEqual(String str, String ptr) {
        int[][] dp = new int[str.length()][ptr.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int lcs = LCS(str, ptr, str.length() - 1, ptr.length() - 1, dp);
        int deletion = str.length() - lcs;
        int insertions = ptr.length() - lcs;
        return deletion + insertions;
    }


    //Dynamic Programming
    private static void longestCommonSubsequence(String n1, String n2) {
        n1 = " " + n1;
        n2 = " " + n2;
        int T[][] = new int[n1.length()][n2.length()];

        for (int i = 1; i < n1.length(); i++) {
            char c = n1.charAt(i);
            for (int j = 1; j < n2.length(); j++) {
                if (c != ' ' && c == n2.charAt(j)) T[i][j] = T[i - 1][j - 1] + 1;
                else T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
            }
        }
        System.out.println(T[n1.length() - 1][n2.length() - 1]);//length of the longest common sequence
        String res = "";
        int i = n1.length() - 1;
        int j = n2.length() - 1;

        while (j >= 1 && i >= 1) {
            int k = T[i][j];
            if (k == T[i - 1][j - 1] + 1) {
                res = res + n1.charAt(i);
                i = i - 1;
                j = j - 1;
            } else {
                if (k == T[i - 1][j]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                }
            }
        }
        System.out.println(res); //longest common subsequence
    }

    /**
     * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
     * If there are multiple valid strings, return any of them.
     * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
     * <p>
     * Input: str1 = "abac", str2 = "cab"
     * Output: "cabac"
     * Explanation:
     * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
     * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
     * The answer provided is the shortest such string that satisfies these properties.
     */
    public static String shortestCommonSuperSequence(String n1, String n2) {
        n1 = " " + n1;
        n2 = " " + n2;
        int T[][] = new int[n1.length()][n2.length()];

        for (int i = 1; i < n1.length(); i++) {
            char c = n1.charAt(i);
            for (int j = 1; j < n2.length(); j++) {
                if (c != ' ' && c == n2.charAt(j)) T[i][j] = T[i - 1][j - 1] + 1;
                else T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);

            }
        }
        int i = n1.length() - 1;
        int j = n2.length() - 1;
        StringBuilder lcs = new StringBuilder();

        while (j >= 1 && i >= 1) {
            if (n1.charAt(i) == n2.charAt(j)) {
                lcs = lcs.append(n1.charAt(i));
                i = i - 1;
                j = j - 1;
            } else {
                if (T[i - 1][j] > T[i][j - 1]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                }
            }
        }
        lcs = lcs.reverse();
        System.out.println(lcs);
        StringBuilder sb = new StringBuilder();
        // merge s1 and s2 with the LCS
        int p1 = 1, p2 = 1;
        for (int k = 0; k < lcs.length(); k++) {
            char ch = lcs.charAt(k);
            while (p1 < n1.length() && ch != n1.charAt(p1)) {
                sb.append(n1.charAt(p1++));
            }
            while (p2 < n2.length() && ch != n2.charAt(p2)) {
                sb.append(n2.charAt(p2++));
            }
            sb.append(ch);
            p1++;
            p2++;


        }

        if (p1 < n1.length()) sb.append(n1.substring(p1, n1.length()));
        if (p2 < n2.length()) sb.append(n2.substring(p2, n2.length()));
        return sb.toString();
    }
}


/********DP on LIS***********/

/**
 * https://www.codingninjas.com/codestudio/problems/longest-increasing-subsequence_630459
 * For a given array with N elements, you need to find the length of the longest subsequence from the array
 * such that all the elements of the subsequence are sorted in strictly increasing order.
 * <p>
 * Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
 * <p>
 * [1, 2, 3, 4] is a strictly increasing array, while [2, 1, 4, 3] is not.
 */

class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("longestIncreasingSubsequence::" + longestIncreasingSubsequence(arr));
    }

    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return longestIncreasingSubsequenceUtil(arr, 0, -1, dp);
    }

    private static int longestIncreasingSubsequenceUtil(int[] arr, int index, int prev_ind, int[][] dp) {

        if (index == arr.length) return 0;

        //prev_ind+1 since the initial prev_ind+1 is -1. so create a dp array dp[n][n+1]
        if (dp[index][prev_ind + 1] != -1) return dp[index][prev_ind + 1];

        int notTaken = 0 + longestIncreasingSubsequenceUtil(arr, index + 1, prev_ind, dp);
        int taken = 0;
        if (prev_ind == -1 || arr[prev_ind] < arr[index])
            taken = 1 + longestIncreasingSubsequenceUtil(arr, index + 1, index, dp);

        return dp[index][prev_ind + 1] = Math.max(notTaken, taken);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        // Initialize dp array with 1 as the minimum length for any subsequence is 1
        Arrays.fill(dp, 1);

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If the current element is greater than the previous element
                if (nums[i] > nums[j]) {
                    // Update the longest increasing subsequence length at the current index
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the maximum length if needed
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

}


/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * @author
 */
class Subset_Without_Duplicates {
    public static void main(String[] args) {
        int set[] = {1, 2, 2};
        subsetList(set);
    }

    private static List subsetList(int[] arr) {

        List res = new ArrayList();
        Arrays.sort(arr);
        func1(0, arr, new ArrayList<>(), res);
        System.out.println(res);
        return res;
    }

    private static List<List> func1(int index, int[] arr, List ds, List ansList) {
        ansList.add(new ArrayList<>(ds));
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            func1(i + 1, arr, ds, ansList);
            ds.remove(ds.size() - 1);
        }
        return ansList;
    }
}


/**
 * Subset Sums
 *
 * @author
 */
class Subset_Sums {
    public static void main(String[] args) {
        int set[] = {1, 2, 3};
        System.out.println("subsetSums::" + subsetSums(set));
    }

    private static ArrayList subsetSums(int[] arr) {

        ArrayList sumset = new ArrayList();
        func1(0, 0, arr, sumset);
        return sumset;
    }

    private static void func1(int index, int sum, int[] arr, ArrayList<Integer> sumset) {
        sumset.add(sum);
        for (int i = index; i < arr.length; i++) {
            sum = sum + arr[i];
            func1(i + 1, sum, arr, sumset);
            sum = sum - arr[i];
        }

    }

    //recursive
    private static void func(int index, int sum, int[] arr, ArrayList<Integer> sumset) {
        if (arr.length == index) {
            sumset.add(sum);
            return;
        }
        func(index + 1, sum + arr[index], arr, sumset);
        func(index + 1, sum, arr, sumset);

    }
}

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times.
 * candidates[] = {2,3,6,7}, target = 7;
 * <p>
 * output::[[2, 2, 3], [7]]
 *
 * @author
 */

class Combination_Sum_With_Repeated_index {
    public static void main(String[] args) {
        int candidates[] = {2, 3, 6, 7}, target = 7;
        System.out.println("combinationSum::" + combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List resList = new ArrayList();
        func(0, candidates, target, new ArrayList(), resList);
        return resList;

    }

    //Method 1:
    private static void func(int index, int[] arr, int target, ArrayList ds, List resList) {
        if (target == 0) {
            resList.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (target >= arr[i]) {
                ds.add(arr[i]);
                func(i, arr, target - arr[i], ds, resList);
                ds.remove(ds.size() - 1);
            }
        }
    }

    //Method 2:
    //Using complete Recusrion
    private static void func2(int index, int[] arr, int target, ArrayList ds, List resList) {


        if (index == arr.length) {
            if (target == 0) resList.add(new ArrayList<>(ds));
            return;
        }

        if (target >= arr[index]) {
            ds.add(arr[index]);
            func(index, arr, target - arr[index], ds, resList);//adding same element instead of  next element
            ds.remove(ds.size() - 1);
        }
        func(index + 1, arr, target, ds, resList);

    }
}

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target. Each number in candidates may only be used once in the
 * combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
class Combination_Sum_WithOut_Repeated_index {

    public static void main(String[] args) {
        int candidates[] = {10, 1, 2, 7, 6, 1, 5}, target = 8;
        System.out.println("combinationSum::" + combinationSum2(candidates, target));
    }

    private static List<List> combinationSum2(int[] candidates, int target) {

        List<List> resList = new ArrayList();
        Arrays.sort(candidates);
        func(0, candidates, target, new ArrayList<>(), resList);
        return resList;
    }

    private static void func(int index, int[] arr, int target, ArrayList ds, List<List> resList) {

        if (target == 0) {
            resList.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            if (arr[i] <= target) {
                ds.add(arr[i]);
                func(i + 1, arr, target - arr[i], ds, resList); // adding next element instead of same dupl element
                ds.remove(ds.size() - 1);
            }

        }
    }
}

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]]
 *
 * @author
 */


class Interleaving_String {
    public static void main(String[] args) {
        String s1 = "aaaa", s2 = "aa", s3 = "aaa";
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) {
            System.out.println(false);
        } else {
            Boolean[][][] dp = new Boolean[n1 + 1][n2 + 1][n3 + 1];
            System.out.println(isInterleave(s1, 0, s2, 0, s3, 0));
        }
    }

    private static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i1 == s1.length()) return s3.substring(i3).equals(s2.substring(i2));
        if (i2 == s2.length()) return s3.substring(i3).equals(s1.substring(i1));
        if (s3.charAt(i3) == s1.charAt(i1) && isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1) || s3.charAt(i3) == s2.charAt(i2) && isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1))
            return true;

        return false;
    }

    private static boolean isInterleaveMem(String s1, int i1, String s2, int i2, String s3, int i3, Boolean[][][] dp) {
        if (i1 == s1.length()) return s3.substring(i3).equals(s2.substring(i2));
        if (i2 == s2.length()) return s3.substring(i3).equals(s1.substring(i1));
        if (dp[i1][i2][i3] != null) return dp[i1][i2][i3];
        if (s3.charAt(i3) == s1.charAt(i1) && isInterleaveMem(s1, i1 + 1, s2, i2, s3, i3 + 1, dp) || s3.charAt(i3) == s2.charAt(i2) && isInterleaveMem(s1, i1, s2, i2 + 1, s3, i3 + 1, dp))
            return dp[i1][i2][i3] = true;
        return dp[i1][i2][i3] = false;
    }
}

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 */
class Greatest_Common_Divisor_of_Strings {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) return str1;
        if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);

        if (str1.substring(0, str2.length()).equals(str2)) return gcdOfStrings(str1.substring(str2.length()), str2);
        else return "";
    }
}

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 */
class Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return isMatchUtils(s, n - 1, p, m - 1);
    }

    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*') return false;
        }
        return true;
    }

    private boolean isMatchUtils(String s1, int i, String s2, int j) {
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) return isAllStars(s2, j);


        if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?') return isMatchUtils(s1, i - 1, s2, j - 1);

        if (s2.charAt(j) == '*') { // isMatchUtils(including empty) [OR] isMatchUtils(include any seq)
            return (isMatchUtils(s1, i, s2, j - 1) || isMatchUtils(s1, i - 1, s2, j));
        }

        return false;
    }
}

/**
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
class Word_Break {

    public static void main(String[] args) {
        String s = "neetcode";
        List wordDict = new ArrayList<>(Arrays.asList("neet", "leet", "code"));
        System.out.println("wordBreak::" + wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

/**
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 */
class Word_Break_II {
    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> resList = new ArrayList<>();
        if (wordDict.contains(s)) {
            resList.add(s);
        }

        for (int i = 1; i < s.length() + 1; i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left)) {
                List<String> result = wordBreak(s.substring(i), wordDict);
                for (String str : result)
                    resList.add(left + " " + str);
            }
        }
        return resList;

    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println("wordBreak::" + wordBreak(s, wordDict));
    }
}

class Space_btw_string {
    private static List<String> spaceString(String str) {

        List<String> strs = new ArrayList<>();
        if (str.length() == 1) {
            strs.add(str);
            return strs;
        }

        List<String> tempStrs = spaceString(str.substring(1)); //recursive call
        for (String tempStr:tempStrs) {
            strs.add(str.charAt(0) + tempStr);
            strs.add(str.charAt(0) + " " + tempStr);
        }
        return strs;
    }

    public static void main(String args[]) {
        List<String> patterns = spaceString("ABCD");
        for (String s : patterns) {
            System.out.println(s);
        }
    }
}




