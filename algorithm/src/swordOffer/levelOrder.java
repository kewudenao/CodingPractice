package swordOffer;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
class levelOrder{
    private class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /** 比较重要的信息： 从左到右（树的广度优先搜索）
     *  需要解决的问题：如何保证元素从左到右的有序性
     *  思路：使用队列的FIFO特性，将元素的子节点从左到右加入队列
     *  可以使用的类：LinkedList 、Queue
     */

    public int[] methodOne(TreeNode root) {
        if(root==null) return new int[0];
        ArrayList<Integer> returnList = new ArrayList<>();
        LinkedList<TreeNode> treeList = new LinkedList(){{add(root);}};
        while(!treeList.isEmpty()){
            TreeNode node = treeList.poll();
            returnList.add(node.val);
            if(node.left!=null) treeList.add(node.left);
            if(node.right!=null) treeList.add(node.right);
        }
        int[] returnInt = new int[returnList.size()];
        for(int i=0;i<returnList.size();i++){
            returnInt[i] = returnList.get(i);
        }
        return returnInt;
    }
}


