/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SumLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root==null)
            return 0;
        
        else{
            
            int ans=0;
            if(root.left!=null && root.left.left==null && root.left.right==null)
                ans+=root.left.val;
            else
                ans+=sumOfLeftLeaves(root.left);
           
            
            ans+=sumOfLeftLeaves(root.right);
            return ans;
        }

    }
}
