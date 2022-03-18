package swordOffer;

import swordOffer.utileEntity.TreeNode;

public class isSubStructure {
    public boolean methodOne(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null)&&(checkSubTree(A,B)||methodOne(A.left,B)||
                methodOne(A.right,B));
    }

    boolean checkSubTree(TreeNode a,TreeNode b){
        if(b==null) return true;
        if(a==null||a.val!=b.val) return false;
        return checkSubTree(a.left,b.left)&&checkSubTree(a.right,b.right);
    }
}
