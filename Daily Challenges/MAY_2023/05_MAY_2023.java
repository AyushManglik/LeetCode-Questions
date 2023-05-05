class Solution {
    public int maxVowels(String s, int k) {
      int count=0,n=s.length(),i=0;
      for(;i<k;i++){
          if(checkVovel(s.charAt(i))){
              count++;
          }
      }
      int ans=count;
      for(;i<n;i++){
          if(checkVovel(s.charAt(i))) count++;
          if(checkVovel(s.charAt(i-k))) count--;
          ans=Math.max(ans,count);
          }
        return ans;
      }
    static boolean checkVovel(char c){
       if(c=='a' || c== 'e' || c== 'i' || c== 'o' || c== 'u')
            return true;
        return false;  
    }
}
