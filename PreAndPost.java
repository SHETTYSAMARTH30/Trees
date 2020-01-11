/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PreAndPost {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        
        int N=pre.length;
        
        if(N==0)
            return null;
              
        TreeNode t=new TreeNode(pre[0]);
        
        if(N==1)
            return t;

        int L=0;
        for(int i=0;i<post.length;i++){
            if(pre[1]==post[i]){
                L=i+1;
                break;
            }
        }
        
        int a[]=Arrays.copyOfRange(pre,1,L+1);
        int b[]=Arrays.copyOfRange(post,0,L);
        int c[]=Arrays.copyOfRange(pre,L+1,N);
        int d[]=Arrays.copyOfRange(post,L,N-1);
        
        t.left=constructFromPrePost(a,b);
        t.right=constructFromPrePost(c,d);
        
        return t;
    }
}
