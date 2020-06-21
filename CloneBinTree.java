/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class CloneBinTree {
    public NodeCopy copyRandomBinaryTree(Node root) {
        
        if(root == null)
            return null;
        
        Map<Node,NodeCopy> map = new HashMap<>();
        NodeCopy newRoot = constructTree(root,map);
        populateRandom(root,newRoot,map);
        return newRoot;
    }
    
    public NodeCopy constructTree(Node node,Map<Node,NodeCopy> map){
        
        if(node == null)
            return null;
        
        NodeCopy newNode = new NodeCopy(node.val);
        map.put(node,newNode);
        
        newNode.left = constructTree(node.left,map);
        newNode.right = constructTree(node.right,map);
        return newNode;  
        
    }
    
    public void populateRandom(Node node, NodeCopy newNode, Map<Node,NodeCopy> map){
        
        if(node == null)
            return;
        
        if(node.random != null){
            newNode.random = map.get(node.random);
        }
        
        populateRandom(node.left,newNode.left,map);
        populateRandom(node.right,newNode.right,map);
        
    }
}
