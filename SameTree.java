/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null){

            return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        
        if(p==null && q==null)
            return true;
        else{
            return false;
        }
    }
}
