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
    public int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        
         inorder(root,L,R);
         return sum;
    }
    
    public void inorder(TreeNode t, int l, int r){
        
        if(t!= null){
            
            if(t.val>=l && t.val<=r){
                sum+=t.val;
            }
            if(t.val>l){
                inorder(t.left,l,r);
            }
            if(t.val<r){
                inorder(t.right,l,r);
            }
        }
    }
}
