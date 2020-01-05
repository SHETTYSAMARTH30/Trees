class SortedArrBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return binarySearchTree(0,nums.length,nums);
    }
    
    public TreeNode binarySearchTree(int lower, int upper,int[] nums){
        
        if(lower>=upper)
            return null;
        
        int mid= (lower+upper)/2;
        
        TreeNode t=new TreeNode(nums[mid]);
        
        t.left=binarySearchTree(lower,mid,nums);
        t.right=binarySearchTree(mid+1,upper,nums);
        return t;
    }
}
