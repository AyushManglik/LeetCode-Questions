class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> li=new ArrayList<String>();
        if(digits.length()==0){
            return li;
        }
        String []arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
    int f=digits.length();
    cmb(digits,li,f,arr,"");
    return li;
    }
    public static void cmb(String digits,List<String> li,int f,String[]arr,String ans){
        if(ans.length()==f){
            li.add(ans);
            return;
        }
        int fchar=digits.charAt(0)-'0';
        String st=arr[fchar];
        for(int i=0;i<st.length();i++){
            cmb(digits.substring(1),li,f,arr,ans+st.charAt(i));
        }
    }
}
