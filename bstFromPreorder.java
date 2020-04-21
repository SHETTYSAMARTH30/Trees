/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class bstFromPreorder {
    
    int idx = 0;
    int preorder[]=null;
    
    public TreeNode helper(int lower,int upper){
        
        if(idx == preorder.length)
            return null;
        
        int val = preorder[idx];
        
        if(val < lower || val > upper)
            return null;
        
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lower,val);
        root.right= helper(val,upper);
        return root;
        
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        this.preorder = preorder;
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
