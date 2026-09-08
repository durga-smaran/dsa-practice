class Solution {
    public String minWindow(String s, String t) 
    {
        int n=s.length();
        int m=t.length();
        int[] need=new int[128];
        int[] window=new int[128];
        for(int i=0;i<m;i++)
        {
            need[t.charAt(i)]++;
        }
        int left=0,count=0,start=0,minLen=Integer.MAX_VALUE;
        for(int right=0;right<n;right++)
        {
            char ch=s.charAt(right);
            window[ch]++;
            if(window[ch]<=need[ch])
            {
                count++;
            }
            while(count==m)
            {
                if(right-left+1<minLen)
                {
                    minLen=right-left+1;
                    start=left;
                }
                window[s.charAt(left)]--;
                if(window[s.charAt(left)]<need[s.charAt(left)])
                {
                    count--;
                }
                left++;
            }
        }
        if(minLen==Integer.MAX_VALUE)
        {
            return "";
        }
        return s.substring(start,start+minLen);
    }
}
