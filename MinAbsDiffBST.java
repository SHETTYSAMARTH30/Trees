/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MinAbsDiffBST {
    public int getMinimumDifference(TreeNode root) {
        
        int a[]={-1,Integer.MAX_VALUE};
        inorder(root,a);
        return a[1];
    }
    
    public int[] inorder(TreeNode t,int a[]){
        
        if(t==null)
            return a;
        
        else{
            int pre=a[0];
            int res=a[1];
            
            int left[]=inorder(t.left,a);
            if(left[0]!=-1)
                res=Math.min(left[1],t.val-left[0]);
            
            a[0]=t.val;
            a[1]=res;
            return inorder(t.right,a);
        }
    }
}
