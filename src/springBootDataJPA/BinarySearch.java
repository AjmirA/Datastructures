package springBootDataJPA;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {

    }
}

/**
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 */
class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("searchInsert::" + searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;

        }
        return low;
    }
}

/**
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 * <p>
 * Follow up: Your solution should run in O(log n) time and O(1) space.
 * <p>
 * Input: nums = [1,1,2,3,3,4,4,8,8] Output: 2
 *
 * @author
 */
class Single_NonDuplicate_In_SortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        singleNonDuplicate(nums);
    }

    public static int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int mid;
        if (high == 0) return nums[0];
        if (nums[low] != nums[low + 1]) return nums[low];
        if (nums[high] != nums[high - 1]) return nums[high];

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1])
                    || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return nums[low];
    }
}

/**
 * 1. You are a in-flight movie service provider. You are given a list of movie
 * lengths and the duration of the flight. Return a pair of (2) movies whose
 * combined length is the highest and is less than or equal to flight duration.
 * If maurn the pair which has the
 * movie of longer longest duration.
 * <p>
 * Ex :MovieLenghts : {27, 1,10, 39, 12, 52, 32, 67, 76}
 * <p>
 * Flight Duration : 77.
 * <p>
 * The 2 possible pairs are (1,76) and (10,67), The answer is (1,76) as per the
 * last constraint.
 *
 * @author
 */


class FindPair {

    public static void main(String[] args) {

        int arr[] = {27, 1, 10, 39, 12, 52, 32, 67, 76};
        int target = 77;
        findPair(arr, target);
    }

    private static void findPair(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, h = arr.length - 1;
        int sum = 0;
        int u = 0, v = 0, lastAdded = 0;
        while (l < h) {
            sum = arr[l] + arr[h];
            if (sum < target) {
                if (lastAdded < sum) {
                    u = arr[l];
                    v = arr[h];
                    lastAdded = sum;
                }
                l++;
            } else if (sum > target)
                h--;
            else if (sum == target) {
                u = arr[l];
                v = arr[h];
                break;
            }

        }
        System.out.println(u + "," + v);
    }
}


/**
 * Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
 *
 * @author
 */
class Find_NoOf_Occurance { //we can use binary search as this is the sorted array
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2};
        int[] temp = new int[arr.length];
        int key = 2;
        System.out.println("Find First and Last Position of Element in Sorted Array::" + find_First_Last(arr, key));
        System.out.println("Find_Count_Of_Digit_In_Array using BS " + key + " is ::" + Find_Count_Of_Digit_In_Array_BS(arr, key));
        for (int i = 0; i < arr.length; i++)
            temp[arr[i]]++;
        System.out.println("Find_Count_Of_Digit_In_Array using Hash " + key + " is ::" + Find_Count_Of_Digit_In_Array(temp, key));

    }

    static int Find_Count_Of_Digit_In_Array(int[] tempArr, int k) {

        return tempArr[k];
    }

    //Optimal Approach
    static int Find_Count_Of_Digit_In_Array_BS(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int count = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] < k)
                low = mid + 1;
            else if (arr[mid] > k)
                high = mid - 1;
            else {
                if (mid > 0 && arr[mid - 1] == k)
                    high = mid - 1;
                else {
                    while (mid < arr.length && arr[mid++] == k)
                        count++;
                    break;
                }
            }

        }

        return count;
    }

    /*. Find First and Last Position of Element in Sorted Array
     * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
     */
    static int[] find_First_Last(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int[] res = new int[2];
        int start, end;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] < k)
                low = mid + 1;
            else if (arr[mid] > k)
                high = mid - 1;
            else {
                if (mid > 0 && arr[mid - 1] == k)
                    high = mid - 1;
                else {
                    start = mid;
                    int count = 0;
                    while (mid < arr.length && arr[mid++] == k) count++;
                    end = start + count - 1;
                    res[0] = start;
                    res[1] = end;
                    break;
                }
            }
        }
        return res;
    }
}

/**
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 *
 * @author
 */
class Rotated_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;

            //Left Sorted portion
            if (arr[low] <= arr[mid]) {
                if (target < arr[low] || target > arr[mid]) //if target is out any of these ranges, then it ll be in right array
                    low = mid + 1;
                else
                    high = mid - 1;
            } else { // Right sorted portion
                if (target < arr[mid] || target > arr[high])//if target is out any of these ranges, then it ll be in left array
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}

/**
 * https://leetcode.com/problems/boats-to-save-people/description/
 */
class NumRescueBoats {
    public static void main(String[] args) {

    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0, high = people.length - 1;
        int boatRequired = 0;
        while (low <= high) {
            int sum = people[low] + people[high];
            if (limit < sum) {
                boatRequired += 1;
                high--;
            } else {//for both equal and limit>sum (Though sum is less than limit,we can add only 2.
                boatRequired += 1;
                low++;
                high--;
            }
        }
        return boatRequired;
    }
}

/**
 *https://leetcode.com/problems/trapping-rain-water/
 * @author
 */
class Trapping_Rain_Water {

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        trap(arr);
    }

    public static int trap(int[] height) {


        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {

                if (height[left] >= maxleft) maxleft = height[left];
                else res += maxleft - height[left];

                left++;
            } else {

                if (height[right] >= maxright) maxright = height[right];
                else res += maxright - height[right];

                right--;
            }
        }
        return res;
    }

}

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
class Container_With_Most_Water {

    public static int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int maxContainerTillNow = 0;
        while (left <= right) {

            int cap = Math.min(height[left], height[right]);
            int width = right - left;
            int maxContainer = cap * width;
			maxContainerTillNow = Math.max(maxContainerTillNow,maxContainer) ;

            if (height[left] <= height[right])
                left++;
            else
                right--;
        }
        return maxContainerTillNow;
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = maxArea(arr);
        System.out.println(res);
    }
}

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */
class Furthest_Building_You_Can_Reach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); //Max heap

        for(int i=0;i<heights.length-1;i++){

            if(heights[i+1]<=heights[i]) continue;

            int brickSpent=heights[i+1]-heights[i];
            pq.add(brickSpent);
            bricks=bricks-brickSpent;
            if(bricks<0){
                if(ladders>0){
                    bricks=bricks+pq.poll();
                    ladders--;
                }else return i;
            }
        }
        return heights.length-1;
    }
}
/**
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * <p>
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * @author
 */
class Count_of_Smaller_Numbers {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = insert(list, nums[i]);
        }
        list.clear();
        for (int i = 0; i < res.length; i++) {
            list.add(res[i]);
        }
        return list;
    }

    // binary insert
    private static int insert(List<Integer> list, int num) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int M = list.get(mid);
            if (M >= num) {
                r = mid - 1;
            } else if (M < num) {
                l = mid + 1;
            }
        }
        list.add(l, num);
        return l;
    }
}

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
 * [1,2,3] and median is 2. Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * @author Todo
 */
class Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        int nums1[] = {1, 3}, nums2[] = {2, 4};
        System.out.println("Median::" + findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);//ensuring that binary search happens on minimum size array
        int low = 0, high = m, medianPos = ((m + n) + 1) / 2;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = medianPos - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 > r2) high = cut1 - 1;
            else if (l2 > r1) low = cut1 + 1;
            else {
                if ((m + n) % 2 != 0)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
        }
        return -1;
    }
}

/**
 * This question is similar with find the kth smallest number in two sorted array.
 *
 * @author Todo
 */
class Kth_Element_Of_Two_SortedArray {
    public static void main(String[] args) {
        int nums1[] = {1, 6, 10}, nums2[] = {2, 4};
        int target = 4;
        System.out.println("findKthElement::" + findKthElement(nums1, nums2, target));
    }

    private static int findKthElement(int[] nums1, int[] nums2, int target) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 > n1)
            return findKthElement(nums2, nums1, target);
        int low = Math.max(0, target - n2), high = Math.min(target, n1);

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = target - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }
        return -1;
    }
}

/**
 * Input : pages[] = {12, 34, 67, 90}
 * m = 2
 * Output : 113
 * Explanation:
 * There are 2 number of students. Books can be distributed
 * in following fashion :
 * 1) [12] and [34, 67, 90]
 * Max number of pages is allocated to student
 * 2 with 34 + 67 + 90 = 191 pages
 * 2) [12, 34] and [67, 90]
 * Max number of pages is allocated to student
 * 2 with 67 + 90 = 157 pages
 * 3) [12, 34, 67] and [90]
 * Max number of pages is allocated to student
 * 1 with 12 + 34 + 67 = 113 pages
 * <p>
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 *
 * @author
 */
class Allocate_Minimum_Number_of_Pages {
    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};

        int m = 2; //No. of students

        System.out.println("Minimum number of pages = " +
                findPages(arr, m));
    }

    private static int findPages(int[] arr, int targetStudent) {

        int low = arr[0];//12
        int high = 0, mid, res = 0;
        for (int i : arr)
            high = high + i;//203  //12<=answer<=203. We need to do BS btw first index(Min) and sum of all(Max)

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isAllocated(arr, mid, targetStudent)) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return res;
    }

    private static boolean isAllocated(int[] arr, int barrier, int targetStudent) {
        int pages = 0, allocated_Studenets = 1;

        for (int i = 0; i < arr.length; i++) {
            if (barrier < arr[i]) return false;
            if (pages + arr[i] > barrier) {
                allocated_Studenets += 1;
                pages = arr[i];
            } else
                pages = pages + arr[i];
        }

        return allocated_Studenets == targetStudent;
    }
}


/**
 * Given an int array wood representing the length of n pieces of wood and an
 * int k. It is required to cut these pieces of wood such that more or equal to
 * k pieces of the same length len are cut. What is the longest len you can get?
 * <p>
 * Input: wood = [5, 9, 7], k = 3
 * Output: 5
 * Explanation:
 * 5 -> 5
 * 9 -> 5 + 4
 * 7 -> 5 + 2
 *
 * @author
 */
class WoodCutter {
    // check whether woods can be cut into at least k pieces with length  cutLength
    public static boolean isValid(int[] wood, int cutLength, int k) {
        int count = 0;
        for (int w : wood) {
            int cutted = w / cutLength;
            if (cutted > 0) count = count + cutted;
        }
        return count >= k;
    }

    public static int cutWood(int[] wood, int k) {
        // corner cases:
        if (wood.length == 0 || k == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        int res = 0;
        if (!isValid(wood, left, k)) return 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean valid = isValid(wood, mid, k);
            if (valid) {
                left = mid + 1;
                res = mid;
            } else
                right = mid;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] testcases_wood = {{5, 9, 7}, {5, 9, 7}};
        int[] testcases_k = {3, 4};
        for (int i = 0; i < testcases_wood.length; ++i)
            System.out.println(cutWood(testcases_wood[i], testcases_k[i]));
    }
}


/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 *
 * @author
 */
class KoKo_Banana_Eating {

    static Boolean isValid(int[] piles, int K, int H) {
        int time = 0;
        for (int p : piles) {
            time += p / K; // Get the number of hours not accounting for leftover hours
            time += (p % K == 0) ? 0 : 1; // Now account for leftover hours here.
        }
        return time <= H;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        if (piles.length == 0 || h == 0)
            return 0;
        int left = 1;
        int right = Integer.MAX_VALUE;

        int mid, res = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isValid(piles, mid, h)) {
                res = mid;
                right = mid;
            } else
                left = mid + 1;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int res = minEatingSpeed(piles, h);
        System.out.println(res);
    }
}

/**
 * Uber has several cabs. The ith cab takes cabTripTime[i] minutes to complete any trip. Your task is to find the minimum time
 * it will take Uber to get n trips completed with these cabs.You can assume that there is no waiting time in-between the trips.
 * <p>
 * For n = 3 and cabTripTime = [1, 2], the output should be solution(n, cabTripTime) = 2.
 * <p>
 * Trips can be managed like this:
 * <p>
 * Trip 1: first cab from t = 0 to t = 1;
 * Trip 2: second cab from t = 0 to t = 2;
 * Trip 3: first cab from t = 1 to t = 2.
 * All the trips can be completed in 2 minutes, so the answer is 2.
 */
class MinTimeForNTrip {
    static int minTimeForNTrip(int n, int[] cabTripTime) {
        int minTimeTakenByCab = cabTripTime[0];
        for (int i : cabTripTime) {
            minTimeTakenByCab = Math.min(minTimeTakenByCab, i);
        }
        if (cabTripTime.length == 1) return n * cabTripTime[0];
        if (cabTripTime.length < 1) return -1;

        int low = minTimeTakenByCab;
        int high = minTimeTakenByCab * n;
        int res = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(cabTripTime, mid, n)) {
                high = mid;
                res = mid;
            } else low = mid + 1;
        }
        return res;
    }

    static boolean isValid(int[] arr, int barrierTime, int noOfTrips) {
        int tripCompleted = 0;
        for (int cabTripTime : arr) {
            tripCompleted = tripCompleted + barrierTime / cabTripTime;
        }
        return tripCompleted >= noOfTrips;
    }

    public static void main(String[] args) {
        int[] cabTripTime = {1, 2};
        System.out.println("MinTimeForNTrip=" + minTimeForNTrip(3, cabTripTime));
    }

}

