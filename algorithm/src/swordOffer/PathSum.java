package swordOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dy6pt/
 * 来源：力扣（LeetCode）
 *
 *
 */
public class PathSum {


      private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      /*void dfs(Node cur){
        if(cur==null)return;
        dfs(cur.left);
        if(pre!=null) {
            pre.right = cur;
        }
        else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }*/
      LinkedList list = new LinkedList();
    public List<List<Integer>> pathSum(TreeNode root, int target){

        return null;
    }
}
