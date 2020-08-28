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
class RightSideTree {
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return new ArrayList<Integer>();
        
        //It is used to store the nodes during BFS
        ArrayDeque<TreeNode> queue = new ArrayDeque(){
            {
                add(root);
            }
        };
        
        //To store all the elements on right side of tree
        List<Integer> rightSide = new ArrayList();
        
        while(!queue.isEmpty()){
            
            int levelSize = queue.size();
            
            for(int i = 0; i < levelSize; i++){
                
                TreeNode curr = queue.poll();
                
                //If we are at last element of a particular level, that means it is right side element
                if(i == levelSize - 1)
                    rightSide.add(curr.val);
                
                //Add the left and thr right child elements of node to queue
                if(curr.left != null)
                    queue.add(curr.left);
                
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        
        return rightSide;
        
    }
}
