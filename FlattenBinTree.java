/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FlattenBinTree {
    
    public TreeNode flattenTree(TreeNode node){
        
        if(node == null)
            return null;
        
        //if a node is leaf node
        if(node.left == null && node.right == null)
            return node;
        
        //Flattening the left subtree
        TreeNode leftTail = flattenTree(node.left);
        
        //Flattening the right subtree
        TreeNode rightTail = flattenTree(node.right);
        
        //If there is a left subtree, we shuffle the connections so nothing is present on the left side of node
        if(leftTail != null){
            
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        //Since the rightTail is the last node we return that else leftTail
        //We need to return the rightmost node after we are done wiring the new connections.
        return rightTail == null ? leftTail : rightTail;
    }
    
    public void flatten(TreeNode root) {
        
        flattenTree(root);
        
    }
}
