/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SumPath2 {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> output=new LinkedList<List<Integer>>();
        List<Integer> result=new LinkedList<>();
        
        paths(root,sum,result,output);
        return output;
    }
    
    public void paths(TreeNode t, int sum, List<Integer> result,List<List<Integer>> output){
        
        if(t == null)
            return;
        
        sum=sum-t.val;
        result.add(t.val);
        
        if(t.left==null && t.right==null && sum==0){
                output.add(new LinkedList<>(result));
                result.remove(result.size()-1);
                return;
        }
        else{
            
            paths(t.left,sum,result,output);
            paths(t.right,sum,result,output);
            result.remove(result.size()-1);
        }
        
    }
    
}
