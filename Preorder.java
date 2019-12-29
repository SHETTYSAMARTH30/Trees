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
class Preorder {
    public List<Integer> preorder(Node root) {
        
        List<Integer> l=new ArrayList<>();
        
        if(root == null){
            return l;
        }
        
        
        Stack<Node> s=new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            
            root=s.pop();
            l.add(root.val);

            Collections.reverse(root.children);
            for(Node n: root.children){
                    s.push(n);
                }

        }
        
        return l;
    }
}
