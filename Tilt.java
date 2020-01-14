/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Tilt {
    public int result;
    public int findTilt(TreeNode root) {
        
        helper(root);
        return result;
    }
    
    public int helper(TreeNode root){
        
         if(root==null)
            return 0;
        else
        {
            int left=helper(root.left);
            int right=helper(root.right);
            result+=Math.abs(left-right);
            return left+right+root.val;
        }
    }
}
