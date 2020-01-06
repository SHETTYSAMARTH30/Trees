class SumOfDeepLeaves {
    
    public int deepestLeavesSum(TreeNode root) {
        
        int depth= calDepth(root);
        return inorder(root,0,depth);
    }
    
    public int inorder(TreeNode t,int level,int depth){
        
        if(t!=null){
            
            if(depth==level)
                return t.val;
            
            return inorder(t.left,level+1,depth)+inorder(t.right,level+1,depth);    
        }
        else{
            return 0;
        }
    }
    
    public int calDepth(TreeNode t){
        
        if (t==null)
            return 0;
        else if (t.left==null && t.right==null)
            return 0;
        else{
            return 1+Math.max(calDepth(t.left),calDepth(t.right));
        } 
    }
}
