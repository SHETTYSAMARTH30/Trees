class BSTGreaterTree {
    public int sum;
    public TreeNode convertBST(TreeNode root) {
        
        if(root == null)
            return null;
        
        convertBST(root.right);
        root.val=root.val+sum;
        sum=root.val;
        convertBST(root.left);
        return root;
    }
}
