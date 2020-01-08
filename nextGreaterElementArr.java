class nextGreaterElementArr {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int res[]=new int[nums1.length];
        
        for(int i=0;i<nums2.length;i++){
            
            while(!stack.empty() && stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        if(!stack.empty()){
            for(Integer i1:stack){
                map.put(i1,-1);
            }
        }
        
        for(int j=0;j<nums1.length;j++){
            res[j]=map.get(nums1[j]);
        }
       
        return res;
        
        
    }
}
