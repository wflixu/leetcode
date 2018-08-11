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

}
