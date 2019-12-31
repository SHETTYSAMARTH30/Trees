/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BalancedBinary {
    public boolean isBalanced(TreeNode root) {
        
       if(root == null)
           return true;
        
        else if(root.left==null && root.right==null)
            return true;
        
        else{
            boolean res;
            int ht=Math.abs(height(root.left)-height(root.right));
            if(ht>1)
                res=false;
            else
                res=true;
            
            return res && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    public int height(TreeNode t){
        
        
        if(t==null)
            return 0;
        else if(t.left==null && t.right==null)
            return 1;
        else{
            int l,r;
            l=height(t.left);
            r=height(t.right);
            return Math.max(l,r)+1;
        }
        
    }
    
}
