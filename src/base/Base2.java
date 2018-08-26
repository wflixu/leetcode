package base;
import  myutil.TreeNode;

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

}
