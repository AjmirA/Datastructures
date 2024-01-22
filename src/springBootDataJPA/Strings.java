package springBootDataJPA;

import java.util.*;

public class Strings {
    public static void main(String[] args) {

    }
}


/**
 * Check if a string can be obtained by rotating another string 2 places
 *
 * @author
 */
class StringRoatation {

    public static void main(String[] args) {
        String str = "amazon";
        System.out.println("isString_RotationOfTwo::" + isString_RotationOfTwo(str, "azonam"));
    }

    private static boolean isString_RotationOfTwo(String str, String comparingString) {
        return comparingString.equalsIgnoreCase(str.substring(2, str.length()) + str.substring(0, 2));
    }

}

/**
 * Unique Email Addresses
 */
class Unique_Email_Addresses {
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        for (String email : emails) {
            String[] local = email.split("@");
            String[] name = local[0].split("\\+");
            String val = name[0].replace(".", "") + "@" + local[1];
            set.add(val);
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        String arr[] = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com", "a@leetcode.com"};
        System.out.println("numUniqueEmails::" + numUniqueEmails(arr));
    }
}


class First_Non_Repeated_Character {
    public static void main(String[] args) {
        String str = "asdsdaaftghtghy";
        System.out.println(findNonRepeatedCharacter(str));

    }

    private static Character findNonRepeatedCharacter(String inputStr) {
        for (char i : inputStr.toCharArray()) {

            if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
                return i;
            }
        }
        return null;
    }


}

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 */
class Backspace_String_Compare {
    public static void main(String[] args) {
        String s1 = "ab##";
        String s2 = "c#d#";
        System.out.println(backspaceCompare(s1, s2));
    }

    public static boolean backspaceCompare(String s, String t) {
        if (getString(s).equals(getString(t))) return true;
        return false;
    }

    static String getString(String str) {
        String res = "";
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#') count++;
            else if (count > 0) count--;
            else res = res + str.charAt(i);
        }
        return res;

    }
}

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * Input: s = "aba"
 * Output: true
 * Input: s = "abc"
 * Output: false
 */
class Valid_Palindrome_II {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        int st = 0;
        int end = s.length() - 1;
        while (st < end) {
            if (s.charAt(st) != s.charAt(end)) {
                return isPalindrome(s, st + 1, end) || isPalindrome(s, st, end - 1);
            }
            st++;
            end--;
        }
        return true;
    }

    static boolean isPalindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}

/*
class Solution {
	public static void main(String[] args) {
		 String  s = "abcd", t = "abcde";
		 System.out.println(findTheDifference(s,t));
	}
    public static char findTheDifference(String s, String t) {
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)!=t.charAt(i))
    			return t.charAt(i);
    	}
		return t.charAt(t.length()-1);
       
    }
}*/
class Reverse_String {
    public static void main(String[] args) {
        String s = "a!!!b.c.d,e'f,ghi";
        char[] str = s.toCharArray();

        reverse(str);
        String res = new String(str);
        System.out.println(res);
    }

    private static void reverse(char[] str) {


        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            if (!Character.isAlphabetic(str[left])) left++;
            else if (!Character.isAlphabetic(str[right])) right--;
            else {
                char ch = str[left];
                str[left] = str[right];
                str[right] = ch;
                left++;
                right--;
            }
        }
    }
}

/**
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3.
 *
 * @author
 */

class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {

        String str = "abba";
        System.out.println("lengthOfLongestSubstring::" + lengthOfLongestSubstring(str));
    }

    //Using Set 8ms
    public static int lengthOfLongestSubstring1(String s) {

        int len = 0;
        int left = 0, right = 0;
        Set set = new HashSet();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                int currLen = right - left + 1;
                len = Math.max(len, currLen);
                right++;
            }
        }
        return len;

    }

    //Using Map 7ms
    private static int lengthOfLongestSubstring(String s) {


        int len = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);
                map.remove(ch);
            } else {
                int currLen = 0;
                    map.put(ch, right);
                    currLen = right - left + 1;
                    len = Math.max(len, currLen);
                    right++;
            }
        }
        return len;
    }

}


class Search_Comments {

    public static void main(String[] args) {

        List l = new ArrayList<>(Arrays.asList("mo", "mou", "mous", "mouse"));

        List<String> repository = new ArrayList(Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad"));
        Collections.sort(repository);
        Scanner s = new Scanner(System.in);
        String customerQuery = s.nextLine();
        List m = searchSuggestions(repository, customerQuery);
        System.out.println(m);
    }

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        List res = new ArrayList();
        String cq;
        for (int i = 0; i < customerQuery.length(); i++) {
            cq = customerQuery.substring(0, i + 1);
            if (cq.length() > 1) {
                List l = new ArrayList();
                for (String repo : repository) {
                    if (repo.toLowerCase().startsWith(cq) && l.size() < 3)
                        l.add(repo);
                }
                res.add(l);
            }
        }
        return res;

    }
}

/**
 * Reverse each words
 * Sort the words in ascending order
 * First letter of each word should be in caps
 *
 * @author
 */
class Reverse_Sentence {

    public static void main(String[] args) {
        String str = "Fruits Are Good For Health";
        reverse(str);
    }

    private static void reverse(String str) {
        Stack<Character> s = new Stack();
        String res = "";
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') s.push(str.charAt(i));
            else {
                Boolean first = true;
                while (!s.isEmpty()) {
                    if (first) {
                        res = res + Character.toUpperCase(Character.valueOf(s.pop()));
                        first = false;
                    } else res = res + s.pop();

                }
                res = res + " ";
            }
        }
        Boolean first = true;
        while (!s.isEmpty()) {
            if (first) {
                res = res + Character.toUpperCase(Character.valueOf(s.pop()));
                first = false;
            } else res = res + s.pop();

        }
        //System.out.println(res);
        System.out.println(sort(res.split(" ")));
    }

    private static String sort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        String res = "";
        for (String s : arr)
            res = res + s + " ";
        return res;
    }
}

/**
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * <p>
 * Return a list of integers representing the size of these parts.
 * <p>
 * Input: s = "ababcbacadefegdehijhklij" Output: [9,7,8]
 * Explanation: The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that
 * each letter appears in at most one part. A partition like "ababcbacadefegde",
 * "hijhklij" is incorrect, because it splits s into less parts.
 *
 * @author
 */
class Partition_Labels {
    public static void main(String[] args) {
        System.out.println("Partition_Labels::" + partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] end_ids = new int[26];
        for (int i = 0; i < s.length(); i++)
            end_ids[s.charAt(i) - 'a'] = i;

        List<Integer> ans = new ArrayList();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, end_ids[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}

/**
 * Input: num1 = "11", num2 = "123" Output: "134"
 *
 * @author
 */
class Add_String {

    public static void main(String[] args) {
        System.out.println(addStrings("1", "100000000000"));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = 0, rem = 0;
            if (i >= 0) {
                sum = sum + num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum = sum + num2.charAt(j) - '0';
                j--;
            }
            sum = sum + carry;
            carry = sum / 10;
            rem = sum % 10;
            sb.append(rem);
        }

        return sb.reverse().toString();
    }
}

class Group_Anagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> anagram;

            if (map.containsKey(sorted)) {
                anagram = map.get(sorted);
            } else {
                anagram = new ArrayList<String>();

            }
            anagram.add(s);
            map.put(sorted, anagram);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;

    }
}

/**
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have. Each character in stones is a
 * type of stone you have. You want to know how many of the stones you have are
 * also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone
 * from "A".
 *
 * @author
 */
class Jewel_Stone {
    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
		Set set=new HashSet();
		for(char j:jewels.toCharArray())
			set.add(j);
		int res=0;
		for(char s:stones.toCharArray()){
			if(set.contains(s))
				res+=1;
		}
		return res;
    }
}


/**
 * Input : s = �geeks for geeks contribute practice�, w1 = �geeks�, w2 = �practice�
 * Output : 1
 * There is only one word between the closest occurrences of w1 and w2.
 * <p>
 * Input : s = �the quick the brown quick brown the frog�, w1 = �quick�, w2 = �frog�
 * Output : 2
 *
 * @author
 */
class Max_Dis_Btw_Words {

    public static void main(String[] args) {
        String s = "geeks for geeks contribute practice";
        String w1 = "geeks";
        String w2 = "practice";
        System.out.println(distance(s, w1, w2));
    }

    private static int distance(String s, String w1, String w2) {

        String[] str = s.split(" ");
        int w1Pos = 0;
        int w2Pos = 0;
        Boolean w1Found = false;
        Boolean w2Found = false;
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equalsIgnoreCase(w1)) {
                w1Pos = i;
                w1Found = true;
            }
            if (str[i].equalsIgnoreCase(w2)) {
                w2Pos = i;
                w2Found = true;
            }
            if (w1Found && w2Found) {
                if (dist > Math.abs(w1Pos - w2Pos) - 1)
                    dist = Math.abs(w1Pos - w2Pos) - 1;
            }
        }
        return dist;
    }
}


/**
 * Wayfair
 * We're given categories that are organized hierarchically and a list of coupons where each coupon can be applied to
 * certain categories. Coupons are valid for child categories of categories it can be applied to. :
 * find the coupon for the category passed.
 */
 class CouponManager {

    public static String FindCoupon(String category_name) {
        List<Map<String, String>> coupons = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("category", "Comforter Sets");
                put("coupon", "Comforters Sale");
            }});
            add(new HashMap<String, String>() {{
                put("category", "Bedding");
                put("coupon", "Savings on Bedding");
            }});
            add(new HashMap<String, String>() {{
                put("category", "Bed & Bath");
                put("coupon", "Low price for Bed & Bath");
            }});
        }};

        List<Map<String, String>> categories = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("category", "Comforter Sets");
                put("parent", "Bedding");
            }});
            add(new HashMap<String, String>() {{
                put("category", "Bedding");
                put("parent", "Bed & Bath");
            }});
            add(new HashMap<String, String>() {{
                put("category", "Bed & Bath");
                put("parent", null);
            }});
            add(new HashMap<String, String>() {{
                put("category", "Soap Dispensers");
                put("parent", "Bathroom Accessories");
            }});
            add(new HashMap<String, String>() {{
                put("category", "Bathroom Accessories");
                put("parent", "Bed & Bath");
            }});
            add(new HashMap<String, String>() {{
                put("category", "Toy Organizers");
                put("parent", "Baby And Kids");
            }});
            add(new HashMap<String, String>() {{
                put("category", "Baby And Kids");
                put("parent", null);
            }});
        }};

        String couponName = findCouponForCategory(category_name, coupons, categories);
        return couponName != null ? couponName : "null";
    }

    private static String findCouponForCategory(String category, List<Map<String, String>> coupons,
                                                List<Map<String, String>> categories) {
        for (Map<String, String> coupon : coupons) {
            if (coupon.get("category").equals(category)) {
                return coupon.get("coupon");
            }
        }

        for (Map<String, String> cat : categories) {
            if (cat.get("category").equals(category)) {
                return findCouponForCategory(cat.get("parent"), coupons, categories);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(FindCoupon("Comforter Sets")); // Comforters Sale
        System.out.println(FindCoupon("Bedding")); // Savings on Bedding
        System.out.println(FindCoupon("Bathroom Accessories")); // Low price for Bed & Bath
        System.out.println(FindCoupon("Soap Dispensers")); // Low price for Bed & Bath
        System.out.println(FindCoupon("Toy Organizers")); // null
    }
}
