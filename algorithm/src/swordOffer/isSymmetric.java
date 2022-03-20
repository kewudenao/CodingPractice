package swordOffer;

import swordOffer.utileEntity.TreeNode;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isEquals(root.left,root.right);

    }
    boolean isEquals(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if (left==null||right==null||left.val!=right.val) return false;
        return isEquals(left.left,right.right)&&isEquals(left.right,right.left);
    }
}
