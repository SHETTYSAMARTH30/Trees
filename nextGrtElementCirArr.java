class nextGrtElementCirArr {
     public int[] nextGreaterElements(int[] nums) {

         Stack<Integer> stack=new Stack<>();
         int res[]=new int[nums.length];
         
         for(int i=2*nums.length-1;i>=0;i--){
             
             int mod=i%nums.length;
             while(!stack.empty() && nums[stack.peek()]<=nums[mod]){
                 stack.pop();
             }
             
             res[mod]=stack.empty()?-1:nums[stack.peek()];
             stack.push(mod);
         }
         
         return res;
    }
}
