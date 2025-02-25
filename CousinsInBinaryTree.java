import java.util.Queue;

//Time Complexity functions: O(n)
//Space Complexity : O(n)
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
 I create 2 queues to store nodes and their parents.Using BFS I go through all the nodes. I check at each level, if I find
 x and y. If I find them then I compare their parent. So, if same level but different parent then return true. Else false.
 BFS
 */
class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> node=new LinkedList<>();
        Queue<TreeNode> parent=new LinkedList<>();

        node.add(root);
        parent.add(null);
        while(!node.isEmpty()){
            int size=node.size();
            boolean xfound=false;
            boolean yfound=false;
            TreeNode xparent=null;
            TreeNode yparent=null;
            for(int i=0;i<size;i++){
                TreeNode p=node.remove();
                TreeNode pp=parent.remove();
                if(p.val==x){
                    xfound=true;
                    xparent=pp;
                }
                if(p.val==y){
                    yfound=true;
                    yparent=pp;
                }
                if(p.left!=null){
                    node.add(p.left);
                    parent.add(p);
                }
                if(p.right!=null){
                    node.add(p.right);
                    parent.add(p);
                }
            }
            if(xfound && yfound){
                return xparent!=yparent;
            }
            if(xfound || yfound){
                return false;
            }
        } 
        return false;
    }
}
/*
//BFS
//Another approach to check the parents while inserting in queue.
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            boolean xfound=false;
            boolean yfound=false;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.val==x){
                    xfound=true;
                }
                if(curr.val==y){
                    yfound=true;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y){
                        return false;
                    }
                    if(curr.left.val==y && curr.right.val==x){
                        return false;
                    }
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(xfound && yfound){
                return true;
            }
            if(xfound || yfound){
                return false;
            }
        }
        return false;
    }
}

//DFS
class Solution {
    boolean flag;
    int xdepth;
    int ydepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.flag=true;
        dfs(root,0,x,y);
        if(!flag) return false;
        return xdepth==ydepth;
    }

    private void dfs(TreeNode root, int depth, int x, int y){
        //base
        if(root==null){
            return ;
        }
        if(root.val==x){
            xdepth=depth;
        }
        if(root.val==y){
            ydepth=depth;
        }
        if(root.left!=null && root.right!=null){
            if(root.left.val==x && root.right.val==y){
                this.flag=false;
            }
            if(root.left.val==y && root.right.val==x){
                this.flag=false;
            }
        }
        if(flag){
            dfs(root.left,depth+1,x,y);
        }
        if(flag){
            dfs(root.right,depth+1,x,y);
        }
    }
}
*/
