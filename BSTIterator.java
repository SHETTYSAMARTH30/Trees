/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    List<Integer> list=new ArrayList<>();
    int index=-1;
    
    public void inorder(TreeNode root){
        
        if(root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
    
    public BSTIterator(TreeNode root) {
        
        inorder(root);
        
    }
    
    /** @return the next smallest number */
    public int next() {
        
        return list.get(++index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        return index+1<list.size()?true:false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
