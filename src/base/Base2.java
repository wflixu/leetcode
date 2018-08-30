package base;
import  myutil.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Base2 {
    public int reverse(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&& q==null){
            return true;
        }
        if(p==null&&q!=null || p!=null&&q==null){
            return false;
        }
        if(p.val!=q.val){
            return  false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }else{
            return isSameTree(root.left,root.right);
        }
    }

    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1+Math.max(left,right);
        }
    }

    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> ll=new LinkedList<>();
        ll.add(root);
        while (!ll.isEmpty()){
            int size  = ll.size();
            List<Integer> sub=new LinkedList<>();
            for(int i=0; i<size;i++){
                TreeNode node = ll.remove();
                sub.add(node.val);
                if(node.left!=null){
                    ll.add(node.left);
                }
                if(node.right!=null){
                    ll.add(node.right);
                }
            }
            res.add(0,sub);
        }
       return  res;
    }
}
