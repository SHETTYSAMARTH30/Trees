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
class WidthOfTree {
    
    int maxWidth;
    Map<Integer,Integer> leftMost;
    
    public int widthOfBinaryTree(TreeNode root) {
        
        this.maxWidth = 0;
        
        //We will store the leftmost node on each level
        this.leftMost = new HashMap<>();
        
        calculateWidth(root, 0, 1);
        
        return maxWidth;
        
    }
    
    public void calculateWidth(TreeNode t, int level, int nodeIndex){
        
        if(t != null){
            
            //If we have not stored leftmost node on a particular level, put it
            leftMost.putIfAbsent(level, nodeIndex);
            
            Integer leftMostNodeIdx = leftMost.get(level);
            
            //Width = Finding number of nodes between a node and leftmost node inclusive
            maxWidth = Math.max(maxWidth, nodeIndex - leftMostNodeIdx + 1);
            
            //Left child index will be 2*parent and right will be 2*parent+1
            calculateWidth(t.left, level + 1, nodeIndex * 2);
            calculateWidth(t.right, level + 1, nodeIndex * 2 + 1);
            
        }
    }
}
