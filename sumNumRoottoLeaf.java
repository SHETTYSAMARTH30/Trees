/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class sumNumRoottoLeaf {
    public int result;
    public int sumNumbers(TreeNode root) {
        
       sumRootLeaf(root,0);
       return result;
    }
    
    public void sumRootLeaf(TreeNode root, int value){
        
        if(root == null)
            return;
        
        value=value*10+root.val;
        if(root.left==null && root.right==null){
            result=result+value;
            return;
        }
            
        sumRootLeaf(root.left,value);
        sumRootLeaf(root.right,value); 
    }
}
