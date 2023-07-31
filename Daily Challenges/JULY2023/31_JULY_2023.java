class Solution {
    public int minimumDeleteSum(String string1, String string2) {
        if(string1.length()<string2.length()) return minimumDeleteSum(string2,string1);
        char[] s1=string1.toCharArray(), s2=string2.toCharArray();
        int[] memo=new int[s2.length];
        memo[memo.length-1]=s2[s2.length-1];
        for(int i=memo.length-2;i>-1;i--) memo[i]+=memo[i+1]+s2[i];
        int[] ps=new int[s1.length];
        ps[ps.length-1]=s1[s1.length-1];
        for(int i=s1.length-2;i>-1;i--) ps[i]+=ps[i+1]+s1[i];
        for(int i=s1.length-1;i>-1;i--) {
            int last=ps[i],prevLast=i<s1.length-1?ps[i+1]:0;
            for(int j=s2.length-1;j>-1;j--) {
                int tmp=memo[j];
                if(s1[i]==s2[j]) last=memo[j]=prevLast;
                else last=memo[j]=Math.min(memo[j]+s1[i],last+s2[j]);
                prevLast=tmp;
            }
        }
        return memo[0];
    }
}
