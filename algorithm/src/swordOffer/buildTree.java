package swordOffer; /**
 * @author kewudenao 2022-04-05 20:55
 **/

import javax.swing.tree.TreeNode;
import java.util.HashMap;


// 没理解
class BuildTree {
	int[] preorder;
	HashMap<Integer,Integer> s= new HashMap();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		for(int i=0;i<inorder.length;i++){
			s.put(inorder[i],i);
		}
		return build(0,0,inorder.length-1);
	}

	public TreeNode build(int root,int left,int right){
		if(left>right) return null;
		TreeNode node = new TreeNode(preorder[root]);
		int i = s.get(preorder[root]);
		node.left = build(root+1,left,i-1);
		node.right = build(i-left+root+1,i+1,right);
		return node;
	}
}