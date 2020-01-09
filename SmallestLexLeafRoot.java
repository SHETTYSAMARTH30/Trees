/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SmallestLexLeafRoot {
    public String smallestFromLeaf(TreeNode root) {
        
        return helper(root,"","~");
    }
    
    public String helper(TreeNode t,String s,String ans){
        
        if(t==null)
            return ans;
        
        else if(t.left==null && t.right==null){

            s=(char)('a' + t.val)+s;
            ans=s.compareTo(ans)<0?s:ans;
            return ans;
        }
        else{
            s=(char)('a' + t.val)+s;
            ans=helper(t.left,s,ans);
            ans=helper(t.right,s,ans);
            return ans;
        }
                
    }
}
