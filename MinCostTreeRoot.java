class MinCostTreeRoot {
    public int mctFromLeafValues(int[] arr) {
        
        Stack<Integer> stack=new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res=0;
        
        for(Integer i:arr){
            
            while(stack.peek()<=i){
                int mid=stack.pop();
                res+=mid*Math.min(stack.peek(),i);
            }
            stack.push(i);
        }
        
        while(stack.size()>2){
            res+=stack.pop()*stack.peek();
        }
        return res;
    }
}
