/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MinDistBST {
    TreeNode prev=null;
    int diff=Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        
        if(root!=null){
            minDiffInBST(root.left);
            
            if(prev!=null)
                diff=Math.min(diff,root.val-prev.val);
            
            prev=root;
            
            minDiffInBST(root.right);
        }
        return diff;
        
    }
    
}
