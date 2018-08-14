package base;

import com.sun.org.apache.bcel.internal.generic.NEW;
import myutil.ListNode;

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
            if(prevHead.next==null){
                prevHead.next=prevOther;
                break;
            }
            prevHead=prevHead.next;
        }
        return head;

    }

    /**
     * 删除重复的数组
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
         if(nums.length==0){
             return 0;
         }
         if(nums.length==1){
            return  1;
        }
         int k=0;
         for (int i =1;i<nums.length;i++){
              if(nums[i]!=nums[k]){
                  nums[++k]=nums[i];
              }
         }
        return k+1;
    }
    public int removeElement(int[] nums, int val) {
        int flag =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                continue;
            }else{
                nums[flag]=nums[i];
                flag++;
            }
        }
        return flag;

    }
    /**
     * 实现 strStr() 函数。
     *给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符
     *串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 =needle.length();
        if(needle==""){
            return 0;
        }
        if(len2>len1){
            return -1;
        }
        for(int i =0;i<=len1-len2;i++){
             String temp = haystack.substring(i,i+len2);
             if(temp.equals(needle)){
                 return i;
             }
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
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
          for(i=0;i<nums.length;i++){
              if(target<=nums[i]){
                  break;
              }
          }
          return  i;
    }


}
