/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class averageLevel {

    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> sum=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        
        averageLevel(root,0,sum,count);
        
        for(int i=0;i<sum.size();i++){
            sum.set(i,sum.get(i) / count.get(i));
        }
        
        return sum;
    }
    
    public void averageLevel(TreeNode root,int level,List<Double> sum,List<Integer> count){
        
        if(root == null)
            return;
        
        if(level<sum.size()){
            sum.set(level,sum.get(level)+root.val);
            count.set(level,count.get(level)+1);
        }
        else{
            sum.add(root.val*1.0);
            count.add(1);
        }
        
        averageLevel(root.left,level+1,sum,count);
        averageLevel(root.right,level+1,sum,count);
    }
}
