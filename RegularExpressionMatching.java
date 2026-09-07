class Solution {
    public boolean isMatch(String s, String p) 
    {
        return solve(0,0,s,p,s.length(),p.length());
    }
    public static boolean solve(int i,int j,String s,String p,int n,int m)
    {
        if(i==n && j==m)
        {
            return true;
        }
        if(j==m && i!=n)
        {
            return false;
        }
        boolean match=false;
        if(i<n && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'))
        {
            match=true;
        }
        if(j+1<m && p.charAt(j+1)=='*')
        {
            boolean skip=solve(i,j+2,s,p,n,m);
            boolean take=false;
            if(match)
            {
                take=solve(i+1,j,s,p,n,m);
            }
            if(skip || take)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(!match)
            {
                return false;
            }
        }
        return solve(i+1,j+1,s,p,n,m);
    }
}
