class SumFour {
    public boolean findTarget(TreeNode root, int k) {
        
        Set<Integer> set=new HashSet<>();
        return findSum(root,k,set);
    }
    
    public boolean findSum(TreeNode root, int k, Set<Integer> set){
        
        if(root == null)
            return false;
        
        if(set.contains(k-root.val))
            return true;
        set.add(root.val);
        
        return findSum(root.left,k,set) || findSum(root.right,k,set);
    }
}
