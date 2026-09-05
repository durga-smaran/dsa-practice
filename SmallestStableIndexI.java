class Solution {
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        int[] max=new int[n];
        int[] min=new int[n];
        max[0]=nums[0];
        min[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
        {
            max[i]=Math.max(max[i-1],nums[i]);
        }
        for(int j=n-2;j>=0;j--)
        {
            min[j]=Math.min(min[j+1],nums[j]);
        }
        for(int i=0;i<n;i++)
        {
            int is=max[i]-min[i];
            if(is<=k)
            {
                return i;
            }
        }
        return -1;
    }
}
