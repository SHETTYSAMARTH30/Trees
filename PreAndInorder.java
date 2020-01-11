/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PreAndInorder {
    HashMap<Integer,Integer> map=new HashMap<>();
    int idx=0;
    int[] inorder;
    int[] preorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.inorder=inorder;
        this.preorder=preorder;
        int index=0;
        for(Integer i: inorder)
            map.put(i,index++);
    
        return helper(0,inorder.length-1);
    }
    
    public TreeNode helper(int left,int right){
        
        if(left>right)
            return null;
        
        int r_val=preorder[idx++];
        
        TreeNode t=new TreeNode(r_val);
        int mid=map.get(r_val);
        
        t.left=helper(left,mid-1);
        t.right=helper(mid+1,right);
        return t;
    }
    
}
