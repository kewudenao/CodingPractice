package swordOffer;

import swordOffer.utileEntity.TreeNode;

import java.util.LinkedList;

public class mirrorTree {

    public TreeNode methodOne(TreeNode root) {
        TreeNode returnTree = getTreeNode(root);
        return returnTree;
    }
    TreeNode getTreeNode(TreeNode node){
        if(node==null) return null;
        TreeNode pointNode= new TreeNode(node.val);
        if(node.left!=null)pointNode.right= getTreeNode(node.left);
        if(node.right!=null) pointNode.left=getTreeNode(node.right);
        return pointNode;
    }

    TreeNode methodTwo(TreeNode root){
        if(root==null) return null;
        LinkedList<TreeNode> list = new LinkedList(){{add(root);}};
        while(!list.isEmpty()){
            TreeNode node = list.poll();
            if(node.left!=null) list.add(node.left);
            if(node.right!=null) list.add(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
