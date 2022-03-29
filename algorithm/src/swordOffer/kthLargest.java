package swordOffer;

import swordOffer.utileEntity.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 难度：6
 *  1.二叉搜索书是一颗有序的树，左节点》根节点》右节点
 *  2. 遍历顺序为右根左
 *  3.找出迭代树的方式
 *  时间复杂度 o(N) 需要遍历所有的节点
 *  空间复杂度，
 */
public class kthLargest {

    int res,count;
    void methodOne(TreeNode root, int k){
        this.count = k;

    }
    void dfs(TreeNode cur){
        if(cur==null||count<0) return;
        dfs(cur.right);
        count -= 1;
        if(count==0){
            res = cur.val;
        }
        dfs(cur.left);
    }
}
