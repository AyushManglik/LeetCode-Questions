class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1= new Stack<>();
        Stack<Character> stack2= new Stack<>();
       

        for(int i=0;i<s.length();i++){
            if (s.charAt(i) != '#') {
                stack1.push(s.charAt(i));
            } 
            else if (!stack1.isEmpty()) {
                stack1.pop();
            }
        }

        for(int i=0;i<t.length();i++){
            if (t.charAt(i) != '#') {
                stack2.push(t.charAt(i));
            }
            else if (!stack2.isEmpty()) {
                stack2.pop();
            }
        }
           
         
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            if(stack1.pop()!=stack2.pop()){
                return false;
            }
        }
        if(stack1.isEmpty()&&stack2.isEmpty()){
            return true;
        }
        return false;
    }
}
