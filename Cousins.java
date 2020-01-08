/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Cousins {
    ArrayList<Integer> lev=new ArrayList<>();
    ArrayList<TreeNode> par=new ArrayList<>();
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        findCousin(root,null,0,x,y);
        
        if(lev.get(0)==lev.get(1) && par.get(0)!=par.get(1))
            return true;
        else
            return false;
    }
    
    public void findCousin(TreeNode t,TreeNode prev,int levels,int x,int y){
        
        if(t==null)
            return;
        else{
            
            if(t.val==x || t.val==y){
                lev.add(levels);
                par.add(prev);
            }
            
            findCousin(t.left,t,levels+1,x,y);
            findCousin(t.right,t,levels+1,x,y);
        }
    }
}
