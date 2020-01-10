/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
 
    int dist=1;
    public int diameterOfBinaryTree(TreeNode root) {
        
        helper(root);
        return dist-1;
    }
    
    public int helper(TreeNode t){

        if(t==null)
            return 0;
        
        else{
            int left=helper(t.left);
            int right=helper(t.right);
            dist=Math.max(left+right+1,dist);
            return 1+Math.max(left,right);
        }
    }
}
