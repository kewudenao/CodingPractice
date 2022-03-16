package swordOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
public class levelOrderII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** 重要的信息 1.从左到右(广度优先) 2.每一层打印一行
     *
     *  从左到右可以用LinkedList 、Queue 保证，
     *  此时只需要保证将每一行的元素以List的形式加入returnList中
     *      1.使用辅助队列
     *          每当原队列A,元素出队之后，将出队元素加入集合中，
     *          且将出队元素的left、right节点加入辅助队列，直到原队列为空
     *          将辅助队列B中的元素出队,加入A中
     *          当AB均为空时，说明全部元素已经出队
     *      2. 不使用辅助队列
     *          队列元素未出队列A前，队列中有size()=B个元素。
     *          利用这一特性，循环出队B次
     *          将出队元素的left、right节点加入队列A中
     *
     */
    public List<List<Integer>> methodOne(TreeNode root) {
        if(root == null) return new ArrayList();
        LinkedList<TreeNode> a = new LinkedList(){{add(root);}};
        List<List<Integer>> returnList = new ArrayList();
        LinkedList<TreeNode> b = new LinkedList();
        while(!a.isEmpty()||!b.isEmpty()){
            ArrayList<Integer> temp  = new ArrayList();
            TreeNode node = a.poll();
            temp.add(node.val);
            if(node.left!=null) b.add(node.left);
            if(node.right!=null) b.add(node.right);
            if(a.isEmpty()){
                returnList.add(temp);
                while(!b.isEmpty()){
                    a.add(b.poll());
                }
            }
        }
        return returnList;
    }
    public List<List<Integer>> methodTwo(TreeNode root) {
        if(root == null) return new ArrayList();
        LinkedList<TreeNode> a = new LinkedList(){{add(root);}};
        List<List<Integer>> returnList = new ArrayList();
        while(!a.isEmpty()){
            ArrayList<Integer> temp  = new ArrayList();
            for(int i= a.size();i>0;i--){
                TreeNode node = a.poll();
                temp.add(node.val);
                if(node.left!=null) a.add(node.left);
                if(node.right!=null) a.add(node.right);
            }
            returnList.add(temp);
        }
        return returnList;
    }
}
