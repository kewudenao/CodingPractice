package swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
public class levelOrderIII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 解题思路：使用count作为计数工具，count%2 == 1 说明此时是奇数层，否则是偶数层
     * 使用的类 ：LinkedList
     *       ！判断链表是否为空
     *          链表元素循环出队
     *          判断是奇数层还是偶数层
     *              当是奇数层时，从链表尾获取元素 放入集合A中
     *              当是偶数层时，从链表头部获取元素 放入集合A中
     *       层数计数器+1
     *       将集合A中元素加入返回集合R中
     */
    public List<List<Integer>> methodOne(TreeNode root) {
        if(root == null) return new ArrayList();
        LinkedList<TreeNode> list = new LinkedList(){{add(root);}};
        List<List<Integer>> returnList = new ArrayList();
        int count = 1;
        while(!list.isEmpty()){
            LinkedList<Integer> temp = new LinkedList();
            for(int i = list.size();i>0;i--){
                TreeNode node = list.poll();
                if(node.right!=null) list.add(node.right);
                if(node.left!=null) list.add(node.left);
                if(count%2==1){
                    temp.addFirst(node.val);
                }else{
                    temp.addLast(node.val);
                }
            }
            count++;
            returnList.add(temp);
        }
        return returnList;
    }
}
