/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SimilarLeaves {
    List<Integer> list1= new ArrayList<>();
    List<Integer> list2= new ArrayList<>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        inorder(root1,list1);
        inorder(root2,list2);  
        boolean isEqual= list1.equals(list2);
        return isEqual;
    }
    
    public void inorder(TreeNode t,List<Integer> list){
        
        if(t==null){
            return;
        }
        else if(t.left==null && t.right==null){
            list.add(t.val);
        }
        else{
            inorder(t.left,list);
            inorder(t.right,list);
        }
    }
}
