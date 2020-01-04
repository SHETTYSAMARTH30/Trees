/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ReverseLevelOrder {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        levelsBottomUp(root,0,result);
        Collections.reverse(result);
        return result;
    }
    
    public void levelsBottomUp(TreeNode t,int level,List<List<Integer>> result){
        
        if(t == null)
            return;
        
        if(level==result.size()){
            result.add(new LinkedList<Integer>());
        }
        
        result.get(level).add(t.val);
        levelsBottomUp(t.left,level+1,result);
        levelsBottomUp(t.right,level+1,result);
    }
    
}
