class Solution 
{
    public int pivotIndex(int[] nums) 
    {
        int left=0,right=0;
        int n=nums.length;
        for(int j=n-1;j>0;j--)
        {
            right+=nums[j];
        }
        for(int i=0;i<n-1;i++)
        {
            if(left==right) return i;
            right-=nums[i+1];
            left+=nums[i];
        }
        if(left==0) return n-1;
        return-1;
    }
}