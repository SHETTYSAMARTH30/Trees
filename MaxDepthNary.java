/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class MaxDepthNary {
    
    public int maxDepth(Node root) {

        if(root==null)
            return 0;
        
        else if(root.children.isEmpty())
            return 1;
        else{
            LinkedList<Integer> list=new LinkedList<>();
            for(Node n: root.children){
                list.add(maxDepth(n));
            }
            return Collections.max(list)+1;
        }
        
    }
    
}
