//student-attendance-record-ii
class Solution {
    int M=1000000007;
    public int checkRecord(int n) {
        int[] f =new int[n+1];
        f[0]=1;
        for(int i=1;i<=n;i++)
            f[i]=func(i);
        int sum=func(n);
        for(int i=1;i<=n;i++){
            sum+=(f[i-1]*f[n-i])%M;
        }
        return sum%M;
    }
   public int func(int n)
   {    
       if(n==0)
            return 1;
        if(n==1)
            return 2;
        if(n==2)
            return 4;
        if(n==3)
            return 7;
        return (2*func(n-1) - func(n-4))%M;
   }
}