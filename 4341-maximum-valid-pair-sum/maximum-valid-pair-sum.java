class Solution {
    public int maxValidPairSum(int[] nums, int k) 
    {
        int n=nums.length-1;
        int max=nums[n],maxSum=0;
        for(int i=n-k;i>=0;i--)
        {
            max=Math.max(max,nums[i+k]);
            maxSum=Math.max(maxSum,max+nums[i]);
        }
        return maxSum;
    }
}