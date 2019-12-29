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
class PostOrderNary {
    public List<Integer> postorder(Node root) {
        
       LinkedList<Integer> output=new LinkedList<>();
       LinkedList<Node> stack=new LinkedList<>();
        
        if(root == null){
            return output;
        }
        
        stack.add(root);
        
        while(!stack.isEmpty()){
            Node n=stack.pollLast();
            output.addFirst(n.val);
            
            for(Node n1: n.children){
                if(n1!=null)
                    stack.add(n1);
            }
        }
        return output;
    }
}
