/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        
        int flag=0;
        if(root==null)
            return null;
        
        while(root!=null){
            
            if(root.val==val){
                flag=1;
                break;
            }
               
                //return root;
            
            else if(val<root.val){
                root=root.left;
                continue;
            }
                
            
            else if(val>root.val){
                root=root.right;
                continue;
            }
                
            
        }
        
        if(flag==1){
            return root;
        }
        else{
            return null;
        }
        
    }
}
