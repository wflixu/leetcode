package base;

import com.sun.org.apache.bcel.internal.generic.NEW;
import myutil.ListNode;
import sun.security.util.Length;

import java.nio.file.Watchable;

public class Base1 {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }

            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode other = l1.val >= l2.val ? l1 : l2;
        ListNode prevHead = head;
        ListNode prevOther = other;
        while (prevHead != null) {
            ListNode next = prevHead.next;
            if (next != null && next.val > prevOther.val) {
                prevHead.next = prevOther;
                prevOther = next;
            }
            if (prevHead.next == null) {
                prevHead.next = prevOther;
                break;
            }
            prevHead = prevHead.next;
        }
        return head;

    }

    /**
     * 删除重复的数组
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag;

    }

    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符
     * 串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (needle == "") {
            return 0;
        }
        if (len2 > len1) {
            return -1;
        }
        for (int i = 0; i <= len1 - len2; i++) {
            String temp = haystack.substring(i, i + len2);
            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
//        int len = nums.length;
//
//        if(target<nums[0]){
//            return 0;
//        }
//        if(target>nums[len-1]){
//            return len;
//        }
//
//        for(int i=0;i<len;i++){
//                System.out.println(i);
//            if(nums[i]==target){
//                return i;
//            }
//            if(i==len-1){
//                break;
//            }
//            if(nums[i]<target&&(nums[i+1]>target)){
//                return i+1;
//            }
//
//        }
//        return  len;

        int i;
        for (i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                break;
            }
        }
        return i;
    }

    //报数
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        char[] cs = s.toCharArray();
        while (i < s.length()) {
            char temp = cs[i++];
            int repeat = 1;
            while (i < cs.length && temp == cs[i]) {
                repeat++;
                i++;
            }
            sb.append("" + repeat + temp);
        }
        return sb.toString();
    }

    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
     * （子数组最少包含一个元素），返回其最大和。
     */

    public int maxSubArray(int[] nums) {
        //暴力解法
//        int maxSum =0;
//        for(int i=0;i<nums.length;i++){
//            int tempSum =0;
//            for (int j=i;j<nums.length;j++){
//                tempSum +=nums[j];
//                if(tempSum>maxSum){
//                    maxSum =tempSum;
//                }
//            }
//        }
//        return maxSum;

        //动态规划
        int maxSum = nums[0];
        int tempSum = 0;
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {

            if (tempSum > 0) {
                tempSum += nums[i];
            } else {
                tempSum = nums[i];
                begin = i;
            }
            if (maxSum < tempSum) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();

        if (len < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                count = 0;
            }
        }

        return count;
    }
    /**
     *
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length - 1;
        while (i >= 0 && carry > 0) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
            -- i;
        }
        if (carry > 0) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = carry;
            return newArray;
        }
        return digits;
    }

    /**
     * 二进制求和
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int alength=a.length();
        int blength=b.length();
        String result="";
        int sum =0;
        while(alength>=1||blength>=1){
            if(alength>=1){
                sum+=Integer.parseInt(a.substring(alength-1,alength));
                alength--;
            }
            if(blength>=1){
                sum+=Integer.parseInt(b.substring(blength-1,blength));
                blength--;
            }
            if(sum==2){
                result="0"+result;
                sum=1;
            }else if(sum==3){
                result="1"+result;
                sum=1;
            }else{
                result=sum+""+result;
                sum=0;
            }
        }
        if(sum==1){
            result="1"+result;
        }
        return result;
    }

    /**
     * x 的平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x<0){
            return 0;
        }
        double err = 1e-15;
        double t =x;
        while(Math.abs(t-x/t)>err*t){
            t=(x/t+t)/2.0;
        }
        return  (int) t;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int result =0;
        if(n==1){
            result =1;
        }
        if(n==2){
            result=2;
        }
        if(n>2){
            int []ways = new int[n];
            ways[0]=1;
            ways[1]=2;
            for(int i=2;i<ways.length;i++){
                ways[i]=ways[i-1]+ways[i-2];
            }
            result = ways[ways.length-1];
        }
        return  result;
    }

    /**
     * 删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
       ListNode current =head;
       while(current!=null&&current.next!=null){
           if(current.val==current.next.val){
                current.next =current.next.next;
           }else{
               current=current.next;
           }

       }
       return head;
    }

    /**
     * 合并两个数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1){
            nums1[k--]= (nums1[i]>nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j>-1)      {
            nums1[k--]=nums2[j--];
        }

    }


}
