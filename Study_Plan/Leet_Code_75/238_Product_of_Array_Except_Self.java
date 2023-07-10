class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        //left product from the ith element at the ith index
        
        for (int i=1; i<nums.length; i++){
            result[i] = nums[i-1] * result[i-1];
        }


        int rightProduct = 1;
        //right product fromm the ith element at the ith index
        for (int i=nums.length-1; i>=0; i--){
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return result;
    }
}
