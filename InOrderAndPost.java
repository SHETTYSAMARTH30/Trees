/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InOrderAndPost {
    
    int idx;
    HashMap<Integer,Integer> map=new HashMap<>();
    int[] inorder;
    int[] postorder;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.inorder=inorder;
        this.postorder=postorder;
        
        idx=postorder.length-1;
        
        int index=0;
        for(Integer i:inorder)
            map.put(i,index++);
        
        return helper(0,inorder.length-1);
    }
    
    public TreeNode helper(int left,int right){
        
        if(left > right)
            return null;
        
        int r_val=postorder[idx];
        idx--;
        TreeNode t=new TreeNode(r_val);
        
        int mid=map.get(r_val);
        t.right=helper(mid+1,right);
        t.left=helper(left,mid-1);
        
        return t;
    }
}
