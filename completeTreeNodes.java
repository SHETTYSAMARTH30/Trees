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
class Solution {
    
    public int depth(TreeNode node){
        
        int depth = 0;
        
        while(node.left != null){
            node = node.left;
            depth+=1;
        }
        
        return depth;
    }
    
  // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
  // Return True if last level node idx exists. 
  // Binary search with O(d) complexity.
    public boolean exists(int d, int idx, TreeNode node){
        
        int left = 0, right = (int)Math.pow(2,d)-1;
        int pivot;
        
        for(int i=0; i<d; i++){
            
            pivot = left + (right - left)/2;
            
            //If the node we are finding is on left of pivot, we traverse on left else right
            if(idx <= pivot){
                node = node.left;
                right = pivot - 1;
            }
            else{
                node = node.right;
                left = pivot + 1;
            }
            
        }
        
        return node != null;
        
    }
    
    public int countNodes(TreeNode root) {
        // if the tree is empty
        if(root == null)
            return 0;
        
        //Calculate the depth of the tree
        int d = depth(root);
        
        //If there is just root
        if(d == 0)
            return 1;
        
        //Now we need to calculate the no of nodes in last level cuz all the levels above it are complete
        
        int left = 0, right = (int)Math.pow(2,d)-1;
        int pivot;
        
        while(left <= right){
            
            pivot = left + (right - left)/2;
            
            //Check whether the pivot exits in the tree, if it exists we check on right of pivot or we check left
            if(exists(d,pivot,root))
                left = pivot + 1;
            else
                right = pivot - 1;
            
        }
        
        //Number of nodes in complete bin tree = Num of nodes till (d-1) + num of nodes on last level
        //Num of nodes till depth (d-1) = Math.pow(2,d)-1
        return (int)(Math.pow(2,d) - 1 + left);
        
    }
}
