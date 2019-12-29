/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        LinkedList<Integer> output=new LinkedList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        
        if(root == null){
            return output;
        }
        
        stack.add(root);
        
        while(!stack.isEmpty()){
            TreeNode t=stack.pollLast();
            output.addFirst(t.val);
            
            if(t.left!=null)
                stack.add(t.left);
            
            if(t.right!=null)
                stack.add(t.right);
        }
        
        return output;
    }
}
