/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class UnivaluedBinTree {
    public boolean isUnivalTree(TreeNode root) {
        
        int value=root.val;
        return univalTree(root,value);
    }
    
    public boolean univalTree(TreeNode t,int v){
        
            if(t==null)
                return true;
            
            if(t.left==null && t.right==null)
                return t.val==v?true:false;
        
            
            
           return univalTree(t.left,v) && univalTree(t.right,v) && t.val==v;
            //boolean left=univalTree(t.left,v);
            //boolean right=univalTree(t.right,v);
            //boolean current=t.val==v;
            //return left&&right&&current;
        
        
    }
}
