/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        //We will store all the nodes in a particular column in a map, where key = column no and value = list of nodes in that column
        Map<Integer, ArrayList> columnTable = new HashMap<>();
        
        //We will perform BFS instead of DFS because, we want all the nodes in a particular column from top to bottom. If we do dfs we might get bottom node before top node in output as we traverse depth first.
        
        //We need a queue for DFS, queue will store node and column number we need to check next
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        
        //The root will be col=0. If we go left then do -1 and right then +1
        int column = 0;
        
        //Max column on right
        int maxCol = 0;
        
        //Min col on left
        int minCol = 0;
        
        queue.add(new Pair(root, column));
        
        while(!queue.isEmpty()){
            
            Pair<TreeNode, Integer> p = queue.poll();
            
            root = p.getKey();
            column = p.getValue();

            //If there isnt an entry for a particular column then create a list
            if(!columnTable.containsKey(column)){
                
                columnTable.put(column, new ArrayList());
            }
            
            //Add the node value to its column list
            columnTable.get(column).add(root.val);
                        
            minCol = Math.min(minCol, column);
            maxCol = Math.max(maxCol, column);
            
            //Add the left child to queue
            if(root.left != null)
                queue.add(new Pair(root.left, column - 1));
            
            //Add the right child to queue
            if(root.right != null)
                queue.add(new Pair(root.right, column + 1));
            
        }
        
        //Since we want the columns list from left to right ie from minCol to maxCol. We iterate through it
        for(int i = minCol; i<= maxCol; i++){
            
            result.add(columnTable.get(i));
        }
        
        return result;
        
    }
}
