import java.util.ArrayList;
import java.util.List;

//Time Complexity functions: O(n)
//Space Complexity : O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
 We create a list for the result. We iterate the tree in preorder way. Whenever we visist a node we check if the level
 of that node is equal to size of list, then we add to the list else we move on. We then go to right subtree and then left subtree.
 */
 
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,0,res);
        return res;
    }

    private void dfs(TreeNode root, int level,List<Integer> res){
        //base
        if(root==null){
            return ;
        }
        //logic
        if(level==res.size()){
            res.add(root.val);
        }
        dfs(root.right,level+1,res);
        dfs(root.left,level+1,res);
    }
}